package project.gaori.server.domain.friend.presentation.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class FriendListResponse {
    private List<FriendResponse> friendList;
}
