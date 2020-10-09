package cn.zhu4wp.myweb.controller;

import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Author zjm
 * @Date 2020/4/24
 * @Description TODO
 * @Version 1.0
 */
@RestController
public class CookieDemoController {
    @RequestMapping("/test/cookie")
    public String cookie(@RequestParam("browser") String browser,
                         HttpServletRequest request, HttpSession session){
        Object sessionBrowser = session.getAttribute("browser");
        if(sessionBrowser == null){
            System.out.println("不存在session,设置browser = " + browser);
            session.setAttribute("browser",browser);
        }else{
            System.out.println("存在session,browser = " + sessionBrowser.toString());
        }
        Cookie[] cookies = request.getCookies();
        if(cookies != null && cookies.length > 0){
            for (Cookie cookie : cookies) {
                System.out.println(cookie.getName() + " : " + cookie.getValue());
            }
        }
        return "Hello World";
    }
}
