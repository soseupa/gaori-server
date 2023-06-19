package project.gaori.server.domain.notice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.gaori.server.domain.notice.entity.TargetToken;
import project.gaori.server.domain.notice.entity.repository.TargetTokenRepository;
import project.gaori.server.domain.user.entity.User;
import project.gaori.server.domain.user.facade.UserFacade;

@Service
@RequiredArgsConstructor
public class CreateTargetTokenService {
    private final UserFacade userFacade;
    private final TargetTokenRepository targetTokenRepository;

    @Transactional
    public void execute(String targetToken) {
        User user = userFacade.getCurrentUser();
        targetTokenRepository.findByUser(user).ifPresentOrElse(
                token -> token.updateToken(targetToken),
                () -> targetTokenRepository.save(
                        TargetToken.builder()
                                .user(user)
                                .token(targetToken)
                                .build()
                )
        );
    }
}
