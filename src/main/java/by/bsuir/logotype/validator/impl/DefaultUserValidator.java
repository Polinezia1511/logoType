package by.bsuir.logotype.validator.impl;

import by.bsuir.logotype.dao.UserDao;
import by.bsuir.logotype.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class DefaultUserValidator implements UserValidator {
    private static final String NO_ERROR_MESSAGE = "";
    private static final String PASSWORDS_NOT_EQUALS = "passwords not equals";
    private static final String EMPTY_FIELD = "field with * should be not empty";
    private static final String MAIL_IN_USE = "this mail in use";
    private static final String OLD_PASSWORD_INCORRECT = "old password incorrect";

    @Autowired
    private UserDao userDao;

    @Override
    public String validateUserData(String email, String password, String confirmPassword, String firstName, String secondName, String phone) {
        if (email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            return EMPTY_FIELD;
        }
        if (!password.equals(confirmPassword)) {
            return PASSWORDS_NOT_EQUALS;
        }
        if (userDao.findOne(email) != null) {
           return MAIL_IN_USE;
        }
        return NO_ERROR_MESSAGE;
    }

    @Override
    public String validateUserUpdateData(String oldEmail, String newEmail, String firstName, String secondName, String phone) {
        if (newEmail.isEmpty()) {
            return EMPTY_FIELD;
        }

        if (userDao.findOne(newEmail) != null && !oldEmail.equals(newEmail)) {
            return MAIL_IN_USE;
        }
        return NO_ERROR_MESSAGE;
    }

    @Override
    public String validateOldAndNewPasswords(String oldPasswordFromUser, String oldPassword, String password, String confirmPassword) {
        System.out.println(oldPasswordFromUser);
        System.out.println(oldPassword);
        System.out.println(DigestUtils.md5DigestAsHex(oldPasswordFromUser.getBytes()));
        if (!oldPasswordFromUser.equals(DigestUtils.md5DigestAsHex(oldPassword.getBytes()))) {
            return OLD_PASSWORD_INCORRECT;
        }
        if (!password.equals(confirmPassword)) {
            return PASSWORDS_NOT_EQUALS;
        }
        return NO_ERROR_MESSAGE;
    }
}
