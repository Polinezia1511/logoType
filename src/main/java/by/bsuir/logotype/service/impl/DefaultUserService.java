package by.bsuir.logotype.service.impl;

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

    @Override
    public User createUser(String email, String password, String firstName, String secondName, String phone) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));
        user.setFirstName(firstName);
        user.setLastName(secondName);
        user.setPhone(phone);

        userDao.save(user);

        mailService.sendRegistrationMessage(user);

        return user;
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
}
