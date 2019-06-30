package by.bsuir.logotype.validator;

public interface UserValidator {
    String validateUserData(String email,
                             String password,
                             String confirmPassword,
                             String firstName,
                             String secondName,
                             String phone);
}
