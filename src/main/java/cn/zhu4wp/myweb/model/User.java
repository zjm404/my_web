package cn.zhu4wp.myweb.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
@Entity
@ToString
public class User implements Serializable {
    @Column(name = "nickname")
    private String nickname;
    @Column(name = "avatar")
    private String avatar;

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


}
