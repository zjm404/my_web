package cn.zhu4wp.myweb.repository;

import cn.zhu4wp.myweb.model.FolderEssay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author zhu4wp
 * @Date 19-9-5
 * @Description TODO
 * @Version 1.0
 */
@Repository
public interface FolderEssayRepository  extends JpaRepository<FolderEssay,String> {
    List<FolderEssay> findAllByFolderName(String folderName);

    FolderEssay findAllByEssayNameAndAndFolderName(String essayName,String folderName);
}
