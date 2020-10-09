package cn.zhu4wp.myweb.service.impl;

import cn.zhu4wp.myweb.model.Image;
import cn.zhu4wp.myweb.repository.ImageRepository;
import cn.zhu4wp.myweb.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @Author zjm
 * @Date 2020/3/19
 * @Description TODO
 * @Version 1.0
 */
@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    private ImageRepository imageRepository;
    @Override
    public List<Image> selectAllByEssayName(String essayName) {
        return imageRepository.findAllByEssayName(essayName);
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public void deleteByImageId(String imageId) throws Exception{
        imageRepository.deleteByImageId(imageId);
    }
}
