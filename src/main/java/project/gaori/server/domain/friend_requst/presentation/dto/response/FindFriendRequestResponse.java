package project.gaori.server.domain.friend_requst.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import project.gaori.server.domain.user.entity.User;

@Getter
@Builder
@AllArgsConstructor
public class FindFriendRequestResponse {
    private Long id;
    private String nickname;
    private String email;

    public static FindFriendRequestResponse of(User user) {
        return FindFriendRequestResponse.builder()
                .id(user.getId())
                .nickname(user.getNickname())
                .email(user.getEmail())
                .build();
    }
}
