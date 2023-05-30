package project.gaori.server.domain.user.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.gaori.server.domain.friend.entity.Friendship;
import project.gaori.server.domain.friend.request.entity.FriendRequest;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "tbl_user")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
    private List<Friendship> friendList;


    @OneToMany(mappedBy = "sender")
    private List<FriendRequest> sentFriendRequests;

    @OneToMany(mappedBy = "receiver")
    private List<FriendRequest> receivedFriendRequests;

    @Builder
    public User(String email, String nickname, String password, Role role) {
        this.email = email;
        this.nickname = nickname;
        this.password = password;
        this.role = role;
    }
}
