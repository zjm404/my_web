package cn.zhu4wp.myweb.service.impl;

import cn.zhu4wp.myweb.model.FolderEssay;
import cn.zhu4wp.myweb.repository.FolderEssayRepository;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * FolderEssayServiceImpl Tester.
 *
 * @author zjm
 * @version 1.0
 * @since <pre>4月 3, 2020</pre>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FolderEssayServiceImplTest {
    @Autowired
    private FolderEssayRepository folderEssayRepository;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: add(FolderEssay folderEssay)
     */
    @Test
    public void testAdd() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: selectAll()
     */
    @Test
    public void testSelectAll() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: selectAllByEssayNameAndFolderName(String essayName, String folderName)
     */
    @Test
    public void testSelectAllByEssayNameAndFolderName() throws Exception {
//TODO: Test goes here...
        System.out.println(folderEssayRepository.findAllByEssayNameAndAndFolderName("test4","测试"));
    }

    /**
     * Method: selectAllByFolderName(String folderName)
     */
    @Test
    public void testSelectAllByFolderName() throws Exception {
//TODO: Test goes here... 
    }


} 
