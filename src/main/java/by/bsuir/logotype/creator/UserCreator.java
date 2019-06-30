package by.bsuir.logotype.creator;

import by.bsuir.logotype.entity.User;

public interface UserCreator {
    User createUserWithoutPassword(String email, String firstName, String secondName, String phone);
}
