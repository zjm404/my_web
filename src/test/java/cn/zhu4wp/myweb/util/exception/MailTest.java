package cn.zhu4wp.myweb.util.exception;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class MailTest {

    @Autowired
    private Mail mail;
    @Test
    public void sendErrorMsg() {
        try{
            int n = 10;
            int num = n/0;
        }catch(Exception e){
            mail.sendErrorMsg(e);
            System.out.println(e.getMessage());
        }
    }
}