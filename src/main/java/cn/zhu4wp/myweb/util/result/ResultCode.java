package cn.zhu4wp.myweb.util.result;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author zjm
 * @Date 2020/4/2
 * @Description TODO
 * @Version 1.0
 */
public enum ResultCode {
    /**
     * 返回成功
     */
    SUCCESS(200,"成功"),


    UNKNOWN_EXCEPTION_ERROR(500,"未知的异常错误"),
    Login_QQ_ERROR(511,"QQ登录出错"),
    ESSAY_PARAM_ERROR(520,"参数输入错误"),

    FORBIDDEN_ERROR(403,"无权限访问错误");
    private int code;
    private String msg;

    private ResultCode(int code,String msg){
        this.msg = msg;
        this.code = code;
    }

    public String getMsg(){
        return this.msg;
    }
}
