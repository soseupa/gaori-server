package project.gaori.server.domain.friend_requst.presentation.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.gaori.server.domain.friend_requst.domain.FriendRequest;
import project.gaori.server.domain.user.entity.User;


@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CreateFriendRequest {
    private String email;

    public FriendRequest toEntity(User sender, User receiver) {
        return FriendRequest.builder()
                .sender(sender)
                .receiver(receiver)
                .build();
    }
}