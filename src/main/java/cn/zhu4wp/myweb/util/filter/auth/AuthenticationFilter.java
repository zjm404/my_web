package cn.zhu4wp.myweb.util.filter.auth;

import javax.servlet.*;
import javax.servlet.FilterConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author zhu4wp
 * @Date 2020/2/10
 * @Description TODO
 * @Version 1.0
 */
public class AuthenticationFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest)servletRequest).getSession();
        if(session.getAttribute("username") == null){
//            ((HttpServletResponse)servletResponse).sendRedirect("/to_login");
//            PrintWriter writer = ((HttpServletResponse)servletResponse).getWriter();
//            writer.write("请登录！");
//            writer.close();
//            System.out.println("过滤器拦截中" );
            HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
            httpServletResponse.setHeader("content-type","text/html;charset=utf-8");
            PrintWriter writer = httpServletResponse.getWriter();
            writer.write("请登录！");
            writer.close();
        }else {
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
