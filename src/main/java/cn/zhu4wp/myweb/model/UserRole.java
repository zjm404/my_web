package cn.zhu4wp.myweb.model;

import lombok.*;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Author zhu4wp
 * @Date 19-9-27
 * @Description TODO
 * @Version 1.0
 */
@Table(name = "user_role")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserRole implements Serializable {
    @Id
    @Column(name = "user_role_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userRoleId;

    @Column(name = "userId")
    private Long userId;

    @Column(name = "role_name")
    private String roleName;
}
