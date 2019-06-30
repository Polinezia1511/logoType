package by.bsuir.logotype.controller;

import by.bsuir.logotype.dao.UserDao;
import by.bsuir.logotype.entity.User;
import by.bsuir.logotype.service.UserService;
import by.bsuir.logotype.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/signUp")
public class SignUpController {
    private static final String SIGN_UP_PAGE = "signUp";
    private static final String FIELDS_PAGE = "redirect:/fields";

    @Autowired
    private UserService userService;

    @Autowired
    private UserValidator userValidator;

    @RequestMapping( method = RequestMethod.GET)
    public String getSignUpPage() {
        return SIGN_UP_PAGE;
    }

    @RequestMapping( method = RequestMethod.POST)
    public String signUp(@ModelAttribute("email") String email,
                         @ModelAttribute("password") String password,
                         @ModelAttribute("confirmPassword") String confirmPassword,
                         @ModelAttribute("firstName") String firstName,
                         @ModelAttribute("secondName") String secondName,
                         @ModelAttribute("phoneNumber") String phoneNumber,
                         Model model,
                         HttpSession session) {
        String validateResult = userValidator.validateUserData(email,
                password,
                confirmPassword,
                firstName,
                secondName,
                phoneNumber);
        String page;
        if (validateResult.isEmpty()) {
            User user = userService.createUser(email,
                    password,
                    firstName,
                    secondName,
                    phoneNumber);
            session.setAttribute("user", user);
            page = FIELDS_PAGE;
        } else {
            model.addAttribute("errorMessage", validateResult);
            page = SIGN_UP_PAGE;
        }
        return page;
    }
}
