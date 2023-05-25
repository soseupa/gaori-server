package project.gaori.server.domain.user.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import project.gaori.server.domain.user.entity.User;

@Getter
@Builder
@AllArgsConstructor
public class ScheduleUserResponse {
    private Long userId;
    private String nickname;
    public static ScheduleUserResponse of(User user) {
        return ScheduleUserResponse.builder()
                .userId(user.getId())
                .nickname(user.getNickname())
                .build();
    }
}
