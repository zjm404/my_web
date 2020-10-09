package cn.zhu4wp.myweb.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.SpringBootConfiguration;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Author zjm
 * @Date 2020/3/19
 * @Description TODO
 * @Version 1.0
 */
@Entity
@Table(name = "image")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Image implements Serializable {
    @Id
    @Column(name = "image_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String imageId;

    @Column(name = "essay_name")
    private String essayName;
}
