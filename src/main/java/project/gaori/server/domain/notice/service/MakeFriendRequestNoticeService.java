package project.gaori.server.domain.notice.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.gaori.server.domain.notice.entity.FcmMessage;
import project.gaori.server.domain.user.entity.User;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class MakeFriendRequestNoticeService {
    private final ObjectMapper objectMapper;
    private final SendMessageService sendMessageService;

    public void execute(User sender, User receiver) throws IOException {
        FcmMessage fcmMessage = FcmMessage.builder()
                .message(FcmMessage.Message.builder()
                        .token(receiver.getTargetToken().getToken())
                        .notification(FcmMessage.Notification.builder()
                                .title("가오리")
                                .body(sender.getNickname() + "님이 친구요청을 보냈습니다.")
                                .build())
                        .build()).validateOnly(false).build();

        String message = objectMapper.writeValueAsString(fcmMessage);
        sendMessageService.execute(message);
    }
}
