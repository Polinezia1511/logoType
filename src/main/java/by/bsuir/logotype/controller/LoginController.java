package by.bsuir.logotype.controller;

import by.bsuir.logotype.entity.User;
import by.bsuir.logotype.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    private static final String LOGIN_PAGE = "login";
    private static final String FIELDS_PAGE = "redirect:/fields";
    public static final String INVALID_DATA_MESSAGE = "invalid data";

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String home() {
        return "redirect:/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLoginPage(Model model) {
        return LOGIN_PAGE;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute("email") String email,
                        @ModelAttribute("password") String password,
                        Model model,
                        HttpSession session) {
        User user = userService.login(email, password);
        String page;
        if (user != null) {
            session.setAttribute("user", user);
            page = FIELDS_PAGE;
        } else {
            model.addAttribute("errorMessage", INVALID_DATA_MESSAGE);
            page = LOGIN_PAGE;
        }
        return page;
    }
}
