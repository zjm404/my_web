package cn.zhu4wp.myweb.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Author zhu4wp
 * @Date 19-9-11
 * @Description TODO
 * @Version 1.0
 */
@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "essay_like")
public class Like implements Serializable {
    @Id
    @Column(name = "essay_like_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "essay_name")
    private String essayName;
}

