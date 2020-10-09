package cn.zhu4wp.myweb.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author zhu4wp
 * @Date 2019-9-4
 * @Description TODO
 * @Version 1.0
 */
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "folder")
public class Folder {
    @Id
    @Column(name = "folder_name")
    private String folderName;
    @Column(name="folder_lead_name")
    private String folderLeadName;
}
