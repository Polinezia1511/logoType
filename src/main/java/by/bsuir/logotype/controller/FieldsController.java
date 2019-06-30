package by.bsuir.logotype.controller;

import by.bsuir.logotype.entity.FieldType;
import by.bsuir.logotype.entity.User;
import by.bsuir.logotype.service.FieldService;
import by.bsuir.logotype.service.UserService;
import by.bsuir.logotype.validator.FieldValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping( value = "/fields")
public class FieldsController {
    private static final String FIELDS_PAGE = "fields";

    @Autowired
    private UserService userService;

    @Autowired
    private FieldService fieldService;

    @Autowired
    private FieldValidator fieldValidator;

    @RequestMapping(method = RequestMethod.GET)
    public String getFieldsPage(HttpSession httpSession, Model model) {
        addAttributes(model, httpSession);
        return FIELDS_PAGE;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addField(@ModelAttribute("label") String label,
                           @ModelAttribute("options") String options,
                           @ModelAttribute("type") String type,
                           @ModelAttribute("required") String required,
                           @ModelAttribute("isActive") String isActive,
                           HttpSession session,
                           Model model) {
        String validateResult = fieldValidator.validateFieldData(label, options, type, required, isActive);
        if (validateResult.isEmpty()) {
            fieldService.createField(label, options, type, required, isActive);
        } else {
            model.addAttribute("errorMessage",validateResult);
        }
        addAttributes(model, session);
        return "redirect:/fields";
    }

    private void addAttributes(Model model, HttpSession session) {
        User user = (User)session.getAttribute("user");
        model.addAttribute("firstAndSecondName", userService.getFirstAndSecondName(user));
        model.addAttribute("fields", fieldService.getAllFields());
        model.addAttribute("fieldTypes", fieldService.getAllFieldTypes());
    }

}
