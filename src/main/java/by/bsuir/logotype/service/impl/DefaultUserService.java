package by.bsuir.logotype.service.impl;

import by.bsuir.logotype.creator.UserCreator;
import by.bsuir.logotype.dao.UserDao;
import by.bsuir.logotype.entity.User;
import by.bsuir.logotype.service.MailService;
import by.bsuir.logotype.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class DefaultUserService implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private MailService mailService;

    @Autowired
    private UserCreator userCreator;

    @Override
    public User createUser(String mail, String password, String firstName, String secondName, String phone) {
        User user = userCreator.createUserWithoutPassword(mail, firstName, secondName, phone);
        user.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));

        userDao.save(user);
        mailService.sendRegistrationMessage(mail, password);

        return user;
    }

    @Override
    public String getFirstAndSecondName(User user) {
        StringBuilder firstAndSecondName = new StringBuilder(user.getFirstName());
        if (user.getLastName() != null) {
            firstAndSecondName.append(" ").append(user.getLastName());
        }
        return String.valueOf(firstAndSecondName);
    }

    @Override
    public User login(String email, String password) {
        User user = userDao.findOne(email);
        if (user != null) {
            if (!user.getPassword().equals(DigestUtils.md5DigestAsHex(password.getBytes()))) {
                user = null;
            }
        }
        return user;
    }

    @Override
    public User updateUser(String oldMail, String newMail, String firstName, String secondName, String phone) {
        User oldUser = userDao.findOne(oldMail);
        userDao.delete(oldUser);
        User newUser = userCreator.createUserWithoutPassword(newMail, firstName, secondName, phone);
        newUser.setPassword(oldUser.getPassword());
        userDao.save(newUser);
        return newUser;
    }

    @Override
    public User updatePassword(String mail, String password) {
        User user = userDao.findOne(mail);
        user.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));
        userDao.save(user);
        mailService.sendEditPasswordMessage(mail, password);
        return user;
    }
}
