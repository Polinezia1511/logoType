package by.bsuir.logotype.service;

public interface MailService {
    void sendRegistrationMessage(String mail, String password);

    void sendEditPasswordMessage(String mail, String password);
}
