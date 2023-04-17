package project.gaori.server.domain.auth.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import project.gaori.server.domain.auth.presentation.dto.request.MailRequest;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@RequiredArgsConstructor
public class SendMailService {
    private final JavaMailSender mailSender;
    private final CreateEmailKeyService createEmailKeyService;
    private final LoadHtmlService loadHtmlService;
    @Value("${spring.mail.username}")
    private String FROM_ADDRESS;

    public String execute(MailRequest request) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        String key = createEmailKeyService.execute();
        message.addRecipients(Message.RecipientType.TO, request.getEmail());
        message.setFrom(FROM_ADDRESS);
        message.setSubject("가오리 인증 이메일 입니다!");
        String msgg = loadHtmlService.execute(key);
        message.setText(msgg, "utf-8", "html");
        mailSender.send(message);
        return key;
    }
}
