package cn.zhu4wp.myweb;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyWebApplicationTests {

    @Test
    public void contextLoads() {
    }

    private static final Logger logger = LoggerFactory.getLogger(MyWebApplicationTests.class);
    @Test
    public void test1(){
        logger.info("Current Time:{}",System.currentTimeMillis());
        logger.trace("trace log");
        logger.warn("warn log");
        logger.debug("debug log");
        logger.info("info log");
        logger.error("error log");
    }

}
