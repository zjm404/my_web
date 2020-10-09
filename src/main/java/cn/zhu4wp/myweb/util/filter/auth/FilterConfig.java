package cn.zhu4wp.myweb.util.filter.auth;

import cn.zhu4wp.myweb.util.filter.auth.AuthenticationFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author zhu4wp
 * @Date 2020/2/10
 * @Description TODO
 * @Version 1.0
 */
@Configuration
public class FilterConfig{
//    @Bean
//    public FilterRegistrationBean registrationBean(){
//        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
//        registrationBean.setFilter(new AuthenticationFilter());
//        registrationBean.addUrlPatterns("/like");
//        registrationBean.addUrlPatterns("/comment");
//        registrationBean.setName("AuthenticationFilter");
//        registrationBean.setOrder(1);
//        return registrationBean;
//    }
}
