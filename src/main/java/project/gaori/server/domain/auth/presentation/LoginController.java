package project.gaori.server.domain.auth.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.gaori.server.domain.auth.presentation.dto.request.LoginRequest;
import project.gaori.server.domain.auth.presentation.dto.response.TokenResponse;
import project.gaori.server.domain.auth.service.LoginService;

import javax.validation.Valid;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {
    private final LoginService loginService;

    @PostMapping
    public TokenResponse Login(@RequestBody @Valid LoginRequest request) {
        return loginService.execute(request);
    }

}
