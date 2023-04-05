package project.gaori.server.domain.user.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import project.gaori.server.domain.user.entity.User;
import project.gaori.server.domain.user.entity.repository.UserRepository;
import project.gaori.server.domain.user.exception.UserNotFoundException;

@Component
@RequiredArgsConstructor
public class UserFacade {
    private final UserRepository userRepository;

    @Transactional
    public User getCurrentUser(long id){
        return userRepository.findById(id)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }
    @Transactional
    public User findUserByEmail(String userId){
        return userRepository.findUserByEmail(userId)
                .orElseThrow(() ->UserNotFoundException.EXCEPTION);
    }
    @Transactional
    public boolean isUserExistByNickName(String nickname) {
        return userRepository.existsUserByNickname(nickname);
    }

    public boolean existsUserByEmail(String userId) {
        if(!userRepository.existsUserByEmail(userId)){
            throw UserNotFoundException.EXCEPTION;
        }
        return true;
    }
}