package by.bsuir.logotype.controller;

import by.bsuir.logotype.dto.FieldWithOptions;
import by.bsuir.logotype.facade.FieldFacade;
import by.bsuir.logotype.service.FieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.persistence.Enumerated;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.List;

@Controller
@RequestMapping(value = "/")
public class NewResponseLogin {
    private static final String NEW_RESPONSE_PAGE = "newResponse";

    @Autowired
    private FieldService fieldService;

    @Autowired
    private FieldFacade fieldFacade;

    @RequestMapping(method = RequestMethod.GET)
    public String getNewResponsePage(Model model) {
        List<FieldWithOptions> fieldWithOptionsList =
                fieldFacade.createFieldsWithOption(fieldService.getAllActiveField());
        model.addAttribute("fields", fieldWithOptionsList);
        System.out.println(fieldWithOptionsList);
        return "newResponse";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String send(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("hi");
        System.out.println(request.getAttributeNames());
        Enumeration<String> strings = request.getAttributeNames();
        while (strings.hasMoreElements()) {
            System.out.println(strings.nextElement() + " = " + request.getAttribute("strings"));
        }
        return NEW_RESPONSE_PAGE;
    }
}
