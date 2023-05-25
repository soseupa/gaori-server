package project.gaori.server.domain.friend_requst.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class FindFriendRequestListResponse {
    private List<FindFriendRequestResponse> findFriendRequestResponseList;
}
