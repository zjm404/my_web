package cn.zhu4wp.myweb.util.aop;

import org.aopalliance.intercept.Joinpoint;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;;import java.util.Arrays;

import static cn.zhu4wp.myweb.util.session.SessionUtil.getRequest;


/**
 * @Author zjm
 * @Date 2020/3/14
 * @Description TODO
 * @Version 1.0
 */
@Aspect
@Component
public class LogAspect {
    private Logger logger = Logger.getLogger(getClass());
    ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Pointcut("@annotation(cn.zhu4wp.myweb.util.log.CommonLog))")
    public void commonLog(){}

    @Pointcut("@annotation(cn.zhu4wp.myweb.util.log.AnalysisLog)")
    public void analysisLog(){}

    @Pointcut("@annotation(cn.zhu4wp.myweb.util.log.WebAnalysisLog)")
    public void webAnalysisLog(){}

    @Pointcut("execution(public * cn.zhu4wp.myweb.controller.*.*(..))")
    public void webLog(){}


    @Before("analysisLog()")
    public void analysisLogBefore(JoinPoint joinpoint) throws Throwable{
        startTime.set(System.currentTimeMillis());
        logger.info("CLASS_METHOD: " + joinpoint.getSignature().getDeclaringTypeName()+"." + joinpoint.getSignature().getName());
        logger.info("ARGS: " + Arrays.toString(joinpoint.getArgs()));
    }
    @AfterReturning(returning = "ret",pointcut = "analysisLog()")
    public void analysisLogAfterReturning(Object ret) throws Throwable{
        logger.info("return: " + ret);
        logger.info("SPEND TIME: " + (System.currentTimeMillis() - startTime.get()));
    }


    @Before("webAnalysisLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable{
        startTime.set(System.currentTimeMillis());
        HttpServletRequest request = getRequest();
        logger.info("URL: "+request.getRequestURL().toString());
        logger.info("HTTP_METHOD: "+ request.getMethod());
        logger.info("IP: "+ request.getRemoteAddr());
        logger.info("CLASS_METHOD: " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("ARGS: " + Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(returning = "ret",pointcut = "webAnalysisLog()")
    public void doAfterReturning(Object ret) throws Throwable{
        logger.info("RESPONSE: " + ret);
        logger.info("SPEND TIME: "+ (System.currentTimeMillis() - startTime.get()));
    }
}
