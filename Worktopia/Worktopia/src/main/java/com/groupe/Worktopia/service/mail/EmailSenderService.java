package com.groupe.Worktopia.service.mail;

public interface EmailSenderService {
    void sendEmail(String toEmail, String subject, String body);
}
