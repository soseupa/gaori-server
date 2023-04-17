package project.gaori.server.domain.auth.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.gaori.server.domain.auth.presentation.dto.request.MailRequest;
import project.gaori.server.domain.auth.service.SendMailService;

import javax.mail.MessagingException;
import javax.validation.Valid;

@RestController
@RequestMapping("auth/email")
@RequiredArgsConstructor
public class MailController {
    private final SendMailService mailSendService;

    @PostMapping("/check")
    public String GetEmail(@RequestBody @Valid MailRequest request) throws MessagingException {
        return mailSendService.execute(request);
    }
}
