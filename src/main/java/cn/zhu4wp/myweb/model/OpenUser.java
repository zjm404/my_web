package cn.zhu4wp.myweb.model;

import lombok.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.io.Serializable;

@Repository
@Entity
@Table(name="open_user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OpenUser  implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "u_id")
    private Long uID;
    @Column(name = "open_id")
    private String openID;
    @Column(name = "access_token")
    private String accessToken;
    @Column(name = "avatar")
    private String avatar;
    @Column(name = "expired_time")
    private Long expiredTime;
    @Column(name = "open_type")
    private String openType;

}
