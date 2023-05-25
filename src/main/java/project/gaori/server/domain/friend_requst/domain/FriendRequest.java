package project.gaori.server.domain.friend_requst.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;
import project.gaori.server.domain.user.entity.User;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name ="tbl_friend_request")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FriendRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private User sender;

    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private User receiver;

    @Builder
    public FriendRequest(User sender, User receiver) {
        this.sender = sender;
        this.receiver = receiver;
    }
}
