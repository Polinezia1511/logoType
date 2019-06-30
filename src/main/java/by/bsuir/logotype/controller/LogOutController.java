package by.bsuir.logotype.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping ( value = "/logOut")
public class LogOutController {
    private static final String LOGIN_PAGE = "redirect:/login";
    @RequestMapping( method = RequestMethod.GET)
    public String logOut(HttpSession httpSession) {
        httpSession.removeAttribute("user");
        return LOGIN_PAGE;
    }
}
