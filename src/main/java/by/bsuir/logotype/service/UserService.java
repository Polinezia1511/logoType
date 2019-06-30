package by.bsuir.logotype.service;

import by.bsuir.logotype.entity.User;

public interface UserService {
    User createUser(String mail,
                    String password,
                    String firstName,
                    String secondName,
                    String phone);

    String getFirstAndSecondName(User user);

    User login(String email,
               String password);

    User updateUser(String oldMail,
                    String newMail,
                    String firstName,
                    String secondName,
                    String phone);

    User updatePassword(String mail,
                         String password);
}
