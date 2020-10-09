package cn.zhu4wp.myweb.util.session;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Author zjm
 * @Date 2020/3/16
 * @Description Session工具类
 * @Version 1.0
 */
@Component
public class SessionUtil {
    /**
     * 获取HttpServletRequest
     * @return
     */
    public static HttpServletRequest getRequest(){
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return servletRequestAttributes.getRequest();
    }
    public static HttpSession getSession(){
        HttpSession httpSession = null;
        try{
            httpSession = getRequest().getSession();
        }catch (Exception e){

        }
        return httpSession;
    }
}
