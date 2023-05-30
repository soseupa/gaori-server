package project.gaori.server.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.gaori.server.domain.auth.presentation.dto.request.LoginRequest;
import project.gaori.server.domain.user.entity.User;
import project.gaori.server.domain.user.facade.UserFacade;

@Service
@RequiredArgsConstructor
public class CheckUserService {
    private final UserFacade userFacade;

    @Transactional
    public void execute(LoginRequest request) {
        User user = userFacade.findUserByEmail(request.getEmail());
        userFacade.checkPassword(request.getPassword(), user);

    }
}
