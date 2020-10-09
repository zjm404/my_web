package cn.zhu4wp.myweb.repository;

import cn.zhu4wp.myweb.model.Essay;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author zhu4wp
 * @Date 2019/8/2 10:45
 * @Description TODO
 * @Version 1.0
 */
@Repository
public interface EssayRepository extends JpaRepository<Essay,String> {
    public Essay findByEssayName(String essayName);

    public Page<Essay> findAllByEssayNameLike(String essayNameLike,Pageable pageable);

    public void deleteByEssayName(String essayName);
    @Query(nativeQuery = true,value = "SELECT * FROM essay WHERE MATCH (essay_name) AGAINST(?1)")
    public Page<Essay> findAllByEssayNameUseFulltext(String essayName,Pageable pageable);

}
