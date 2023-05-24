package project.gaori.server.domain.auth.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.gaori.server.domain.auth.presentation.dto.response.FindUserByEmailResponse;
import project.gaori.server.domain.user.entity.User;
import project.gaori.server.domain.user.entity.repository.UserRepository;
import project.gaori.server.domain.user.exception.UserNotFoundException;

@Service
@RequiredArgsConstructor
public class FindUserByEmailService {
    private final UserRepository userRepository;

    public FindUserByEmailResponse execute(String email) {
        User user = userRepository.findUserByEmail(email)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
        return FindUserByEmailResponse.builder()
                .email(email)
                .nickname(user.getNickname())
                .build();
    }
}
