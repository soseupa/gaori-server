package project.gaori.server.domain.user.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
public class SignUpRequest {
    @NotBlank
    private String nickname;
    @NotBlank
    private String password;
    @NotBlank
    private String email;

}
