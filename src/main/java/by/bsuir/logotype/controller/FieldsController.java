package by.bsuir.logotype.controller;

import by.bsuir.logotype.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping( value = "/fields")
public class FieldsController {
    private static final String FIELDS_PAGE = "fields";

    @RequestMapping(method = RequestMethod.GET)
    public String getFieldsPage(HttpSession httpSession) {
        User user = (User)httpSession.getAttribute("user");
        System.out.println(user.getEmail());
        return FIELDS_PAGE;
    }

}
