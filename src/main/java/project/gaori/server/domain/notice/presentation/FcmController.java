package project.gaori.server.domain.notice.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.gaori.server.domain.notice.service.CreateTargetTokenService;

@RestController
@RequestMapping("/fcm")
@RequiredArgsConstructor
public class FcmController {
    private final CreateTargetTokenService createTargetTokenService;


    @PostMapping("/token")
    public void updateToken(@RequestBody String targetToken) {
        createTargetTokenService.execute(targetToken);
    }
}
