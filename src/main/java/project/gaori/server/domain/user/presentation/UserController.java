package project.gaori.server.domain.user.presentation;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.gaori.server.domain.user.presentation.dto.request.SignUpRequest;
import project.gaori.server.domain.user.service.DuplicationCheckUserService;
import project.gaori.server.domain.user.service.SignUpService;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Tag(name = "유저 서버")
public class UserController {
    private final DuplicationCheckUserService duplicationCheckUserService;
    private final SignUpService signUpService;

    @Operation(summary = "회원가입")
    @PostMapping("/signup")
    public void SignUp(@RequestBody @Valid SignUpRequest request) {
        signUpService.execute(request);
    }

    @Operation(summary = "닉네임 중복 체크")
    @GetMapping("/check/{nickname}")
    public boolean CheckNickname(@PathVariable String nickname) {
        return duplicationCheckUserService.execute(nickname);
    }
}
