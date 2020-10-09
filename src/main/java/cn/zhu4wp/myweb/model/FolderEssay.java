package cn.zhu4wp.myweb.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Author zhu4wp
 * @Date 19-9-4
 * @Description TODO
 * @Version 1.0
 */
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "folder_essay")
public class FolderEssay implements Serializable {
    @Id
    @Column(name = "folder_essay_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long folderEssayId;
    @Column(name = "folder_name")
    private String folderName;
    @Column(name = "essay_name")
    private String essayName;

}
