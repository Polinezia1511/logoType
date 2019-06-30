package by.bsuir.logotype.validator.impl;

import by.bsuir.logotype.dao.UserDao;
import by.bsuir.logotype.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultUserValidator implements UserValidator {
    private static final String NO_ERROR_MESSAGE = "";

    @Autowired
    private UserDao userDao;

    @Override
    public String validateUserData(String email, String password, String confirmPassword, String firstName, String secondName, String phone) {
        if (email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            return "field with * should be not empty";
        }
        if (!password.equals(confirmPassword)) {
            return "password not equals";
        }
        if (userDao.findOne(email) != null) {
           return "this mail in use";
        }
        return NO_ERROR_MESSAGE;
    }
}
