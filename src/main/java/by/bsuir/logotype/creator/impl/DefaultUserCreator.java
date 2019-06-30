package by.bsuir.logotype.creator.impl;

import by.bsuir.logotype.creator.UserCreator;
import by.bsuir.logotype.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class DefaultUserCreator implements UserCreator {
    @Override
    public User createUserWithoutPassword(String email, String firstName, String secondName, String phone) {
        User user = new User();
        user.setEmail(email);
        if (firstName.isEmpty() && secondName.isEmpty()) {
            user.setFirstName("No name");
        } else {
            user.setFirstName(firstName);
            user.setLastName(secondName);
        }
        user.setPhone(phone);
        return user;
    }
}
