package cn.zhu4wp.myweb.service.impl;

import cn.zhu4wp.myweb.model.Essay;
import cn.zhu4wp.myweb.repository.EssayRepository;
import cn.zhu4wp.myweb.service.EssayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static cn.zhu4wp.myweb.util.paging.GetPageable.*;
import java.util.List;

/**
 * @Author zhu4wp
 * @Date 2019/8/2 11:32
 * @Description TODO
 * @Version 1.0
 */
@Service
public class EssayServiceImpl implements EssayService {

    @Autowired
    private EssayRepository essayRepository;

    @Override
    public Page<Essay> selectAllByKeyWords(String keywords,Integer page,Integer size) {
        Pageable pageable = getPageableByPageAndSize(page,size);
        return essayRepository.findAllByEssayNameUseFulltext(keywords,pageable);
    }



    @Transactional(rollbackOn = Exception.class)
    @Override
    public Essay update(Essay essay) throws Exception {
        return essayRepository.saveAndFlush(essay);
    }



    @Transactional(rollbackOn = Exception.class)
    @Override
    public Essay add(Essay essay) throws Exception {
        return essayRepository.saveAndFlush(essay);
    }

    @Transactional(rollbackOn = Exception.class)
    @Override
    public void deleteEssayByEssayName(String essayName) throws Exception {
        essayRepository.deleteByEssayName(essayName);
    }

    @Override
    public Essay selectEssayByEssayName(String essayName) {
        return essayRepository.findByEssayName(essayName);
    }

    @Override
    public List<Essay> selectAll() {
        return essayRepository.findAll();
    }

    @Override
    public Page<Essay> selectAll(Integer page, Integer size) {
        if (size == 0){
            //默认设置为4
            size = 4;
        }
        //貌似可以改用注解的方式,之后再尝试改动,先开发着
        Pageable pageable = new PageRequest(page,size) ;
        return essayRepository.findAll(pageable);
    }
    @Override
    public Page<Essay> selectAllByEssayNameLike(String essayNameLike, Integer pageNum,Integer pageSize) {
        if(pageSize == 0){
            pageSize = 4;
        }
        Pageable pageable1 = PageRequest.of(pageNum,pageSize);
        return essayRepository.findAllByEssayNameLike(essayNameLike,pageable1);
    }
}
