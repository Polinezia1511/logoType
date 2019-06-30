package by.bsuir.logotype.service;

import by.bsuir.logotype.entity.User;

public interface UserService {
    User createUser(String email,
                    String password,
                    String firstName,
                    String secondName,
                    String phone);

    User login(String email,
               String password);
}
