package by.bsuir.logotype.service;

import by.bsuir.logotype.entity.User;

public interface MailService {
    void sendRegistrationMessage(User user);
}
