package cn.zhu4wp.myweb.repository;

import cn.zhu4wp.myweb.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

/**
 * @Author zhu4wp
 * @Date 19-9-11
 * @Description TODO
 * @Version 1.0
 */
@Repository
public interface LikeRepository extends JpaRepository<Like,Long> {

    public Like findByUserIdAndEssayName(long userId,String essayName);

    public List<Like> findAllByUserId(long userId);

    public void deleteById(long id);
}
