package cn.zhu4wp.myweb.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author zhu4wp
 * @Date 2019/8/2 10:34
 * @Description TODO
 * @Version 1.0
 */
@Entity
@Table(name = "essay")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Essay implements Serializable {
    @Id
    @Column(name = "essay_name")
    private String essayName;

    @Column(name = "essay_content")
    private String essayContent;

    @Column(name = "essay_like_num")
    private Long essayLikeNum;

    @Column(name = "author_id")
    private long EssayAuthorId;

    @Column(name = "time")
    private Date time;

    @Column(name = "folder")
    private String folder;
}
