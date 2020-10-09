package cn.zhu4wp.myweb.service.impl;

import cn.zhu4wp.myweb.model.Folder;
import cn.zhu4wp.myweb.service.FolderService;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

/**
 * FolderServiceImpl Tester.
 *
 * @author zjm
 * @version 1.0
 * @since <pre>4月 1, 2020</pre>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FolderServiceImplTest {
    @Autowired
    private FolderService folderService;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: add(Folder folder)
     */
    @Test
    public void testAdd(){
//TODO: Test goes here...
        Folder folder = new Folder();
        folder.setFolderName("HelloWorld");
        try {
            folderService.add(folder);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Method: deleteByFolderName(String folderName)
     */
    @Test
    public void testDeleteByFolderName() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: selectAll()
     */
    @Test
    public void testSelectAll() throws Exception {
//TODO: Test goes here... 
    }


} 
