package project.gaori.server.domain.friend.presentation.response;

import lombok.Builder;
import lombok.Getter;
import project.gaori.server.domain.user.entity.User;

@Getter
@Builder
public class FriendResponse {
    private String nickname;
    private String email;

    public static FriendResponse of(User user) {
        return FriendResponse.builder()
                .nickname(user.getNickname())
                .email(user.getEmail())
                .build();
    }
}
