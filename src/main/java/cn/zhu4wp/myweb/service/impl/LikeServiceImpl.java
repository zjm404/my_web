package cn.zhu4wp.myweb.service.impl;

import cn.zhu4wp.myweb.model.Like;
import cn.zhu4wp.myweb.repository.LikeRepository;
import cn.zhu4wp.myweb.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @Author zhu4wp
 * @Date 19-9-11
 * @Description TODO
 * @Version 1.0
 */
@Service
@Transactional
public class LikeServiceImpl implements LikeService {
    @Autowired
    private LikeRepository likeRepository;

    @Override
    public Like selectByUserIdAndEssayName(long userId, String essayName) {
        return likeRepository.findByUserIdAndEssayName(userId,essayName);
    }

    @Transactional(rollbackOn = Exception.class)
    @Override
    public Like add(Like like) throws Exception {
        return likeRepository.save(like);
    }

    @Override
    public List<Like> selectAllByUserId(long userId) {
        List<Like> list = likeRepository.findAllByUserId(userId);
        return list;
    }

    @Transactional(rollbackOn = Exception.class)
    @Override
    public void deleteById(long id) {
        likeRepository.deleteById(id);
    }
}
