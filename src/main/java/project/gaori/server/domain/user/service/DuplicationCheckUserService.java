package project.gaori.server.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.gaori.server.domain.user.exception.UserAlreadyExistsException;
import project.gaori.server.domain.user.facade.UserFacade;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class DuplicationCheckUserService {
    private final UserFacade userFacade;

    @Transactional
    public boolean execute(String nickname) {
        boolean user = userFacade.isUserExistByNickName(nickname);
        if (user) {
            throw UserAlreadyExistsException.EXCEPTION;
        }
        return false;
    }
}
