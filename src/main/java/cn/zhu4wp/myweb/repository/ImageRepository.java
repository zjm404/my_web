package cn.zhu4wp.myweb.repository;

import cn.zhu4wp.myweb.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author zjm
 * @Date 2020/3/19
 * @Description TODO
 * @Version 1.0
 */
@Repository
public interface ImageRepository extends JpaRepository<Image,String> {
    List<Image> findAllByEssayName(String essayName);
    void deleteByImageId(String imageId);
}
