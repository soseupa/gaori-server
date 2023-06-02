package project.gaori.server.domain.auth.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.gaori.server.domain.auth.presentation.dto.response.FindUserByEmailResponse;
import project.gaori.server.domain.friend.facade.FriendFacade;
import project.gaori.server.domain.user.entity.User;
import project.gaori.server.domain.user.facade.UserFacade;

@Service
@RequiredArgsConstructor
public class FindUserByEmailService {
    private final UserFacade userFacade;
    private final FriendFacade friendFacade;

    public FindUserByEmailResponse execute(String email) {
        User me = userFacade.getCurrentUser();
        User friend = userFacade.findUserByEmail(email);
        return FindUserByEmailResponse.builder()
                .email(email)
                .nickname(friend.getNickname())
                .isFriend(friendFacade.isFriend(me.getId(), friend.getId()))
                .build();
    }
}
