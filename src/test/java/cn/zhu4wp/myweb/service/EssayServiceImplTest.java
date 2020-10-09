package cn.zhu4wp.myweb.service;

import cn.zhu4wp.myweb.model.Essay;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

/**
 * @Author zhu4wp
 * @Date 2019/8/4 15:11
 * @Description TODO
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EssayServiceImplTest {
    @Autowired
    public EssayService essayService;

    @Test
    public void add(){
//        System.out.println(new Date());
        Essay essay = new Essay();
        essay.setEssayAuthorId(2);
        essay.setEssayContent("this is the first essay !!!just for test");
        essay.setEssayName("HelloWorldTest");
        essay.setTime(new Date());
        essay.setFolder("默认");
        try {
            essayService.add(essay);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void selectEssayByEssayName(){
        System.out.println(essayService.selectEssayByEssayName("test"));
    }
    @Test
    public void selectAll(){
        List<Essay> essays = essayService.selectAll();
        for (Essay essay : essays) {
            System.out.println(essay);
        }
    }
    @Test
    public void deleteEssayByEssayName(){
        try {
            essayService.deleteEssayByEssayName("test");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void update(){
        Essay essay = new Essay();
        essay.setEssayName("test");
        essay.setEssayContent("hello");
        try {
            essayService.add(essay);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void pageSelect(){
        Page<Essay> essays = essayService.selectAll(11,3);
        for (Essay essay : essays) {
            System.out.println("第0页,数据:"+essay);
        }
    }
    @Test
    public void pageSelectByEssayNameLike(){
        Page<Essay> essays = essayService.selectAllByEssayNameLike("Hell",0,0);
        for (Essay essay : essays) {
            System.out.println(essay);

        }
    }

}
