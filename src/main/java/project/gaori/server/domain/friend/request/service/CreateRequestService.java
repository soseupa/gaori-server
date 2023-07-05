package project.gaori.server.domain.friend.request.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.gaori.server.domain.friend.request.entity.repository.FriendRequestRepository;
import project.gaori.server.domain.friend.request.exception.FriendRequestForbiddenException;
import project.gaori.server.domain.friend.request.exception.FriendSelfRequestForbiddenException;
import project.gaori.server.domain.friend.request.presentation.dto.request.CreateFriendRequest;
import project.gaori.server.domain.user.entity.User;
import project.gaori.server.domain.user.facade.UserFacade;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class CreateRequestService {
    private final UserFacade userFacade;
    private final FriendRequestRepository friendRequestRepository;

    @Transactional
    public void execute(CreateFriendRequest request) throws IOException {
        User sender = userFacade.getCurrentUser();
        User receiver = userFacade.findUserByEmail(request.getEmail());
        if (sender.getId().equals(receiver.getId())) throw FriendSelfRequestForbiddenException.EXCEPTION;
        if (friendRequestRepository.existsFriendRequestBySenderAndReceiver(sender, receiver))
            throw FriendRequestForbiddenException.EXCEPTION;
        friendRequestRepository.save(request.toEntity(sender, receiver));
    }
}
