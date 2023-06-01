package project.gaori.server.domain.auth.presentation;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.gaori.server.domain.auth.presentation.dto.request.MailRequest;
import project.gaori.server.domain.auth.presentation.dto.response.FindUserByEmailResponse;
import project.gaori.server.domain.auth.service.FindUserByEmailService;
import project.gaori.server.domain.auth.service.SendMailService;

import javax.mail.MessagingException;
import javax.validation.Valid;

@RestController
@RequestMapping("auth/email")
@RequiredArgsConstructor
@Tag(name = "이메일 서버")
public class MailController {
    private final SendMailService mailSendService;
    private final FindUserByEmailService findUserByEmailService;

    @Operation(summary = "이메일 인증")
    @PostMapping("/check")
    public String GetEmail(@RequestBody @Valid MailRequest request) throws MessagingException {
        return mailSendService.execute(request);
    }

    @Operation(summary = "이메일로 검색")
    @GetMapping("/{email}")
    public FindUserByEmailResponse FindUserByEmail(@PathVariable String email) {
        return findUserByEmailService.execute(email);
    }
}
