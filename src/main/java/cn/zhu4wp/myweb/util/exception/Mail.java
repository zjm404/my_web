package cn.zhu4wp.myweb.util.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author zjm
 * @Date 2020/4/7
 * @Description TODO
 * @Version 1.0
 */
@Component
public class Mail {
    @SuppressWarnings("all")
    @Autowired
    private JavaMailSender jms;
    @Value("${sendFromMailAddress}")
    private  String sendFrom;
    @Value("${sendToMailAddress}")
    private  String sendTo;

    public void sendErrorMsg(Exception e){
        System.out.println("hello world");
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("zhu4wp@163.com");
        simpleMailMessage.setTo("zjm404@foxmail.com");
        simpleMailMessage.setSubject("网站出错！！" + new Date());
        simpleMailMessage.setText(e.getMessage());
        this.jms.send(simpleMailMessage);
    }

}
