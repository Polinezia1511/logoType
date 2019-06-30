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
@RequestMapping( value = "/editProfile")
public class EditProfileController {
    private final static String EDIT_PROFILE_PAGE = "editProfile";
    private static final String UPDATE_SUCCESS_MESSAGE = "Update success";

    @Autowired
    private UserService userService;

    @Autowired
    private UserValidator userValidator;

    @RequestMapping(method = RequestMethod.GET)
    public String getEditProfilePage(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        setAttributes(user, model);
        return EDIT_PROFILE_PAGE;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String editProfile(@ModelAttribute("email") String email,
                              @ModelAttribute("firstName") String firstName,
                              @ModelAttribute("secondName") String secondName,
                              @ModelAttribute("phoneNumber") String phoneNumber,
                              Model model,
                              HttpSession session) {
        User oldUser = (User) session.getAttribute("user");
        String validateResult = userValidator.validateUserUpdateData(oldUser.getEmail(),
                email,
                firstName,
                secondName,
                phoneNumber);
        if (validateResult.isEmpty()) {
            User newUser = userService.updateUser(oldUser.getEmail(),
                    email,
                    firstName,
                    secondName,
                    phoneNumber);
            model.addAttribute("successMessage", UPDATE_SUCCESS_MESSAGE);
            session.setAttribute("user", newUser);
            setAttributes(newUser, model);
        } else {
            model.addAttribute("errorMessage", validateResult);
            setAttributes(oldUser, model);
        }
        return EDIT_PROFILE_PAGE;
    }

    private void setAttributes(User user, Model model) {
        model.addAttribute("firstAndSecondName", userService.getFirstAndSecondName(user));
        model.addAttribute("firstName", user.getFirstName());
        model.addAttribute("secondName", user.getLastName());
        model.addAttribute("email", user.getEmail());
        model.addAttribute("phoneNumber", user.getPhone());
    }
}
