package cn.zhu4wp.myweb.service;

import cn.zhu4wp.myweb.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author zhu4wp
 * @Date 2019/8/4 15:10
 * @Description TODO
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {
    @Autowired
    public UserService userService;

    @Test
    public void add(){

        User user = new User();
        user.setNickname("test");
        user.setAvatar("test");
        try {
            user = userService.regist(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(user);
    }
    @Test
    public void select(){
        System.out.println(userService.selectUserByID(2));
    }

    @Test
    public void sayHi(){
        System.out.println(123^123);
    }
}
