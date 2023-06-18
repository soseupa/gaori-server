package project.gaori.server.domain.notice.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.gaori.server.domain.notice.entity.FcmMessage;
import project.gaori.server.domain.schedule.entity.Schedule;
import project.gaori.server.domain.user.entity.User;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class MakeInviteScheduleNoticeService {
    private final ObjectMapper objectMapper;
    private final SendMessageService sendMessageService;

    public void execute(User sender, User receiver, Schedule schedule) throws IOException {
        String year = String.valueOf(schedule.getTime().getYear());
        String month = String.valueOf(schedule.getTime().getMonthValue());
        String day = String.valueOf(schedule.getTime().getDayOfMonth());
        FcmMessage fcmMessage = FcmMessage.builder()
                .message(FcmMessage.Message.builder()
                        .token(receiver.getTargetToken().getToken())
                        .notification(FcmMessage.Notification.builder()
                                .title("가오리")
                                .body(sender.getNickname() + "님이 " + year + "년 " + month + "월 " + day + "일에 " + schedule.getTitle() + " 일정에 초대하였습니다.")
                                .build())
                        .build()).validateOnly(false).build();

        String message = objectMapper.writeValueAsString(fcmMessage);
        sendMessageService.execute(message);
    }
}
