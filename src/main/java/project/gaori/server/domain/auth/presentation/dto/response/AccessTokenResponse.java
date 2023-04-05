package project.gaori.server.domain.auth.presentation.dto.response;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AccessTokenResponse {

    private String accessToken;
}