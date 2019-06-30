package by.bsuir.logotype.controller;

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
@RequestMapping( value = "/editPassword")
public class EditPasswordController {
    private static final String EDIT_PASSWORD_PAGE = "editPassword";
    private final static String EDIT_PROFILE_PAGE = "editProfile";
    private static final String UPDATE_SUCCESS_MESSAGE = "Update success";

    @Autowired
    private UserService userService;

    @Autowired
    private UserValidator userValidator;

    @RequestMapping( method = RequestMethod.GET)
    public String getEditPasswordPage(HttpSession session, Model model) {
        model.addAttribute("firstAndSecondName", userService.getFirstAndSecondName((User) session.getAttribute("user")));
        return EDIT_PASSWORD_PAGE;
    }

    @RequestMapping( method = RequestMethod.POST)
    public String editPassword(@ModelAttribute("password") String password,
                               @ModelAttribute("confirmPassword") String confirmPassword,
                               @ModelAttribute("oldPassword") String oldPassword,
                               Model model,
                               HttpSession session) {
        User user = (User) session.getAttribute("user");
        String validateResult = userValidator.validateOldAndNewPasswords(user.getPassword(),
                oldPassword,
                password,
                confirmPassword);
        if (validateResult.isEmpty()) {
            User newUser = userService.updatePassword(user.getEmail(), password);
            session.setAttribute("user", newUser);
            model.addAttribute("successMessage", UPDATE_SUCCESS_MESSAGE);
        } else {
            model.addAttribute("errorMessage", validateResult);
        }
        model.addAttribute("firstAndSecondName", userService.getFirstAndSecondName(user));
        return EDIT_PASSWORD_PAGE;
    }
}
