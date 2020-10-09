package cn.zhu4wp.myweb.util.exception; 

import cn.zhu4wp.myweb.service.TestService;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

/** 
* GlobalExceptionController Tester. 
* 
* @author zjm 
* @since <pre>4月 7, 2020</pre> 
* @version 1.0 
*/ 
@RunWith(SpringRunner.class)
@SpringBootTest
public class GlobalExceptionControllerTest {
    @Autowired
    private JavaMailSender jms;

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: ErrorHandler(HttpServletRequest req, Exception e) 
* 
*/ 
@Test
public void testErrorHandler() throws Exception {

    SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
    simpleMailMessage.setFrom("zhu4wp@163.com");
    simpleMailMessage.setTo("zjm404@foxmail.com");
    try{
        throw new IOException();
    }catch (Exception e){
        simpleMailMessage.setSubject("网站运行出错！");
        simpleMailMessage.setText("网站运行出错，出错信息如下" + e.getMessage());
        jms.send(simpleMailMessage);
        System.out.println("测试");
    }
}

/** 
* 
* Method: QQExceptionHandler(HttpServletRequest req, Exception e) 
* 
*/ 
@Test
public void testQQExceptionHandler() throws Exception { 
//TODO: Test goes here... 
} 


} 
