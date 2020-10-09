package cn.zhu4wp.myweb.repository;

import cn.zhu4wp.myweb.model.Folder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author zhu4wp
 * @Date 19-9-4
 * @Description TODO
 * @Version 1.0
 */
@Repository
public interface FolderRepository  extends JpaRepository<Folder,String> {
    void deleteFolderByFolderName(String folderName);
}
