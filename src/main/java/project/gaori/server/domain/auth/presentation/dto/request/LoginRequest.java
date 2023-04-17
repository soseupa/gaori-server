package project.gaori.server.domain.auth.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
public class LoginRequest {
    @NotBlank
    private String email;

}
