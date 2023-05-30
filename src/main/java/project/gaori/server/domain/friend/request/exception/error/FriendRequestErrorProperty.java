package project.gaori.server.domain.friend.request.exception.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import project.gaori.server.global.error.exception.ErrorProperty;

@Getter
@RequiredArgsConstructor
public enum FriendRequestErrorProperty implements ErrorProperty {
    FRIEND_SELF_REQUEST_FORBIDDEN(HttpStatus.FORBIDDEN, "자기 자신에게 친구 요청을 보낼 수 없습니다."),
    FRIEND_REQUEST_FORBIDDEN(HttpStatus.FORBIDDEN, "이미 친구 요쳥을 보냈습니다."),
    FRIEND_REQUEST_NOT_FOUND(HttpStatus.NOT_FOUND, "친구 요청을 찾을 수 없습니다.");
    private final HttpStatus status;
    private final String message;
}
