package com.example.take.home.page.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import com.example.take.home.page.exception.SpringStudentException;
import com.example.take.home.page.model.NotificationEmail;

import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
class MailService {

    private final JavaMailSender mailSender;

    @Async
    void sendMail(NotificationEmail notificationEmail) {
        MimeMessagePreparator messagePreparator = mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setFrom("springstudentskasluzba@email.com");
            messageHelper.setTo(notificationEmail.getRecipient());
            messageHelper.setSubject(notificationEmail.getSubject());
            messageHelper.setText(notificationEmail.getBody());
        };
        try {
            mailSender.send(messagePreparator);
            log.info("Aktivacijski mail poslan");
        } catch (MailException e) {
            log.error("Greška se desila kod slanja maila", e);
            throw new SpringStudentException("Greška se desila kod slanja maila na : " + notificationEmail.getRecipient(), e);
        }
    }

}