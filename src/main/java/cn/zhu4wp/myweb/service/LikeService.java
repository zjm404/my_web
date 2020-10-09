package cn.zhu4wp.myweb.service;

import cn.zhu4wp.myweb.model.Like;

import java.util.List;

/**
 * @Author zhu4wp
 * @Date 19-9-11
 * @Description TODO
 * @Version 1.0
 */
public interface LikeService {
    /**
     * 增加喜欢
     * @param like
     * @return
     */
    public Like add(Like like) throws Exception;

    public Like selectByUserIdAndEssayName(long userId,String essayName);

    /**
     * 查询与该用户相关的所有喜欢内容
     * @param userId
     * @return
     */
    public List<Like> selectAllByUserId(long userId);

    public void deleteById(long id);
}
