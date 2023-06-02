package project.gaori.server.domain.auth.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class FindUserByEmailResponse {
    private String nickname;
    private String email;
    private boolean isFriend;
}
