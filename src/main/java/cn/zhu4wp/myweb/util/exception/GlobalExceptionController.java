package cn.zhu4wp.myweb.util.exception;

import cn.zhu4wp.myweb.util.result.ResultBean;
import cn.zhu4wp.myweb.util.result.ResultCode;
import com.qq.connect.QQConnectException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

/**
 * @Author zjm
 * @Date 2020/4/2
 * @Description 全局异常处理
 * @Version 1.0
 */
@ControllerAdvice
public class GlobalExceptionController {

    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionController.class);
    @Autowired
    private Mail mail;

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ResultCode ErrorHandler(HttpServletRequest req, Exception e) throws Exception{
        logger.error(ResultCode.UNKNOWN_EXCEPTION_ERROR.getMsg(),e);
        mail.sendErrorMsg(e);
        return ResultCode.UNKNOWN_EXCEPTION_ERROR;
    }
    @ExceptionHandler(value = QQConnectException.class)
    public ResultCode QQExceptionHandler(HttpServletRequest req, Exception e) throws Exception{
        logger.error(ResultCode.UNKNOWN_EXCEPTION_ERROR.getMsg(),e);
        mail.sendErrorMsg(e);
        return ResultCode.UNKNOWN_EXCEPTION_ERROR;
    }
}
