package cn.zhu4wp.myweb.service;

import cn.zhu4wp.myweb.model.Image;

import java.util.List;

/**
 * @Author zhu4wp
 * @Date 2020/3/19
 * @Description TODO
 * @Version 1.0
 */
public interface ImageService {
    public List<Image> selectAllByEssayName(String essayName);

    public void deleteByImageId(String imageId) throws Exception;
}
