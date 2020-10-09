package cn.zhu4wp.myweb.service.impl; 

import cn.zhu4wp.myweb.model.Essay;
import cn.zhu4wp.myweb.service.EssayService;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.awt.print.Pageable;
import java.util.List;

/** 
* EssayServiceImpl Tester. 
* 
* @author zjm 
* @since <pre>3月 17, 2020</pre> 
* @version 1.0 
*/ 
@RunWith(SpringRunner.class)
@SpringBootTest
public class EssayServiceImplTest {
    @Autowired
    EssayService essayService;

@Before
public void before() throws Exception {
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: selectAllByKeyWords(String keywords, Integer page, Integer size) 
* 
*/ 
@Test
public void testSelectAllByKeyWords() throws Exception { 
//TODO: Test goes here...
    List<Essay> essays = essayService.selectAllByKeyWords("test",0,0).getContent();
    for (Essay essay : essays) {
        System.out.println(essay);
    }
} 

/** 
* 
* Method: update(Essay essay) 
* 
*/ 
@Test
public void testUpdate() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: add(Essay essay) 
* 
*/ 
@Test
public void testAdd() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: deleteEssayByEssayName(String essayName) 
* 
*/ 
@Test
public void testDeleteEssayByEssayName() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: selectEssayByEssayName(String essayName) 
* 
*/ 
@Test
public void testSelectEssayByEssayName() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: selectAll() 
* 
*/ 
@Test
public void testSelectAll() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: selectAll(Integer page, Integer size) 
* 
*/ 
@Test
public void testSelectAllForPageSize() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: selectAllByEssayNameLike(String essayNameLike, Integer pageNum, Integer pageSize) 
* 
*/ 
@Test
public void testSelectAllByEssayNameLike() throws Exception { 
//TODO: Test goes here... 
} 


} 
