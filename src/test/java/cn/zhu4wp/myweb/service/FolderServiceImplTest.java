package cn.zhu4wp.myweb.service;

import cn.zhu4wp.myweb.model.Folder;
import cn.zhu4wp.myweb.repository.FolderRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author zhu4wp
 * @Date 19-9-6
 * @Description TODO
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FolderServiceImplTest {
    @Autowired
    private FolderService folderService;

    @Test
    public void selectAll(){
        List<Folder> folders = folderService.selectAll();
        System.out.println("查询文件夹中....");
        for (Folder folder : folders) {
            System.out.println("文件夹名："+folder);
        }
    }
}
