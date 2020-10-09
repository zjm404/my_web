package cn.zhu4wp.myweb.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Author zhu4wp
 * @Date 19-9-27
 * @Description TODO
 * @Version 1.0
 */
@Table(name = "role")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Role implements Serializable {
    @Id
    @Column(name = "role_name")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String roleName;
}
