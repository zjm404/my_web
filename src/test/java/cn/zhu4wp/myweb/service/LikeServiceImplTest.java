package cn.zhu4wp.myweb.service;

import cn.zhu4wp.myweb.model.Like;
import cn.zhu4wp.myweb.repository.LikeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author zhu4wp
 * @Date 19-9-25
 * @Description TODO
 * @Version 1.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class LikeServiceImplTest {
    @Autowired
    private LikeService likeService;
    @Autowired
    private LikeRepository likeRepository;

    @Test
    public void add(){
        Like like = new Like();
        like.setId(1L);
        like.setUserId(1L);
        like.setEssayName("test");
       likeRepository.save(like);
    }
}
