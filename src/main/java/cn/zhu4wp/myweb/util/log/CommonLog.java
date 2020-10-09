package cn.zhu4wp.myweb.util.log;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author zjm
 * @Date 2020/4/2
 * @Description 通用异常处理
 * @Version 1.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CommonLog {
//    String value()default "";
}
