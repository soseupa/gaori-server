package project.gaori.server.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import project.gaori.server.domain.user.entity.Role;
import project.gaori.server.domain.user.entity.User;
import project.gaori.server.domain.user.entity.repository.UserRepository;
import project.gaori.server.domain.user.facade.UserFacade;
import project.gaori.server.domain.user.presentation.dto.request.SignUpRequest;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class SignUpService {
    private final UserRepository userRepository;
    private final UserFacade userFacade;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void execute(SignUpRequest request) {
        userFacade.checkEmail(request.getEmail());
        userRepository.save(
                User.builder()
                        .email(request.getEmail())
                        .password(passwordEncoder.encode(request.getPassword()))
                        .nickname(request.getNickname())
                        .role(Role.USER)
                        .build()
        );
    }
}
