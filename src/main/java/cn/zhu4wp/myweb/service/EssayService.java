package cn.zhu4wp.myweb.service;

import cn.zhu4wp.myweb.model.Essay;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @Author zhu4wp
 * @Date 2019/8/2 10:49
 * @Description TODO
 * @Version 1.0
 */
public interface EssayService {
    /**
     * 增加文章
     * @param essay
     * @return
     */
    public Essay add(Essay essay) throws Exception;

    /**
     * 通过essayId删除文章
     * @param essayName
     */
    public void deleteEssayByEssayName(String essayName) throws Exception;

    public Essay selectEssayByEssayName(String essayName);

    public Essay update(Essay essay) throws Exception;

    public List<Essay> selectAll();

    public Page<Essay> selectAll(Integer page,Integer size);

    public Page<Essay> selectAllByEssayNameLike(String essayNameLike, Integer pageNum,Integer pageSize);

    public Page<Essay> selectAllByKeyWords(String keywords,Integer page,Integer size);

}
