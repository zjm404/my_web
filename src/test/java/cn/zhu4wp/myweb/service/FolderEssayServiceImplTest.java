package cn.zhu4wp.myweb.service;

import cn.zhu4wp.myweb.model.Folder;
import cn.zhu4wp.myweb.model.FolderEssay;
import cn.zhu4wp.myweb.repository.FolderEssayRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author zhu4wp
 * @Date 19-9-5
 * @Description TODO
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FolderEssayServiceImplTest {
    @Autowired
    FolderEssayService folderEssayService;

    @Test
    public void add(){
        //测试中间表添加数据失败返回值
        FolderEssay folderEssay = new FolderEssay();
        folderEssay.setFolderName("Test");
        folderEssay.setEssayName("Test");
        try {
            System.out.println(folderEssayService.add(folderEssay));
        } catch (Exception e) {
            e.printStackTrace();
        }
        //直接报错，无返回值
    }
}
