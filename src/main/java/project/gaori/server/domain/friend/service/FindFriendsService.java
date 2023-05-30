package project.gaori.server.domain.friend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.gaori.server.domain.friend.presentation.response.FriendListResponse;
import project.gaori.server.domain.friend.presentation.response.FriendResponse;
import project.gaori.server.domain.user.entity.User;
import project.gaori.server.domain.user.entity.repository.UserRepository;
import project.gaori.server.domain.user.facade.UserFacade;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FindFriendsService {
    private final UserFacade userFacade;
    private final UserRepository userRepository;

    @Transactional
    public FriendListResponse execute() {
        User user = userFacade.getCurrentUser();
        List<User> friends = userRepository.findAllByFriendships(user);
        return FriendListResponse.builder().
                friendList(friends.stream().map(FriendResponse::of).collect(Collectors.toList()))
                .build();
    }
}
