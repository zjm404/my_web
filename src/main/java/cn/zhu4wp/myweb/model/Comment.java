package cn.zhu4wp.myweb.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Author zjm
 * @Date 2020/3/4
 * @Description TODO
 * @Version 1.0
 */
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "comment")
public class Comment implements Serializable {
    @Id
    @Column(name = "comment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentId;

    @Column(name = "comment_content")
    private String commentContent;

    @Column(name = "comment_lead_id")
    private Integer commentLeadId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "essay_name")
    private String essayName;

}
