package project.gaori.server.domain.notice.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.gaori.server.domain.notice.service.CreateTargetTokenService;

@RestController
@RequestMapping("/fcm")
@RequiredArgsConstructor
public class FcmController {
    private final CreateTargetTokenService createTargetTokenService;


    @PostMapping("/token/{targetToken}")
    public void updateToken(@PathVariable String targetToken) {
        createTargetTokenService.execute(targetToken);
    }
}
