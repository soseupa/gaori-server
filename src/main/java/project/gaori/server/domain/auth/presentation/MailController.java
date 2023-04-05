package project.gaori.server.domain.auth.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.gaori.server.domain.auth.presentation.dto.request.MailRequest;
import project.gaori.server.domain.auth.service.MailSendService;

import javax.mail.MessagingException;
import javax.validation.Valid;

@RestController
@RequestMapping("/email")
@RequiredArgsConstructor
public class MailController {
    private final MailSendService mailSendService;

    @PostMapping("/signup")
    public String GetEmail(@RequestBody @Valid MailRequest request) throws MessagingException {
        return mailSendService.execute(request);
    }
}
