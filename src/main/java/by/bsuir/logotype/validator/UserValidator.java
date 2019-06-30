package by.bsuir.logotype.validator;

public interface UserValidator {
    String validateUserData(String email,
                            String password,
                            String confirmPassword,
                            String firstName,
                            String secondName,
                            String phone);

    String validateUserUpdateData(String oldEmail,
                                  String newEmail,
                                  String firstName,
                                  String secondName,
                                  String phone);

    String validateOldAndNewPasswords(String oldPasswordFromUser,
                                      String oldPassword,
                                      String password,
                                      String confirmPassword);
}
