package project.gaori.server.domain.user.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import project.gaori.server.domain.user.entity.User;
import project.gaori.server.domain.user.entity.repository.UserRepository;
import project.gaori.server.domain.user.exception.PasswordMismatchException;
import project.gaori.server.domain.user.exception.UserAlreadyExistsException;
import project.gaori.server.domain.user.exception.UserNotFoundException;
import project.gaori.server.global.security.auth.AuthDetails;

@Component
@RequiredArgsConstructor
public class UserFacade {
    private final UserRepository userRepository;

    @Transactional
    public User getCurrentUser() {
        AuthDetails auth = (AuthDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return auth.getUser();
    }

    @Transactional
    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }

    @Transactional
    public boolean isUserExistByNickName(String nickname) {
        return userRepository.existsUserByNickname(nickname);
    }

    @Transactional
    public User findUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }

    @Transactional
    public void checkPassword(String password, User user) {
        if (!user.getPassword().equals(password))
            throw PasswordMismatchException.EXCEPTION;
    }

    @Transactional
    public void checkEmail(String email) {
        if (userRepository.existsUserByEmail(email))
            throw UserAlreadyExistsException.EXCEPTION;
    }
}