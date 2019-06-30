package by.bsuir.logotype.controller;

import by.bsuir.logotype.entity.User;
import by.bsuir.logotype.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping( value = "/fields")
public class FieldsController {
    private static final String FIELDS_PAGE = "fields";

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String getFieldsPage(HttpSession httpSession, Model model) {
        User user = (User)httpSession.getAttribute("user");
        model.addAttribute("firstAndSecondName", userService.getFirstAndSecondName(user));
        return FIELDS_PAGE;
    }

}
