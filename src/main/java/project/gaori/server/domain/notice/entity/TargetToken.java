package project.gaori.server.domain.notice.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.gaori.server.domain.user.entity.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table( name = "tbl_target_token")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class TargetToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String token;
   @OneToOne(fetch = FetchType.LAZY)
    private User user;

    @Builder
    public TargetToken(String token, User user) {
        this.token = token;
        this.user = user;
    }
}
