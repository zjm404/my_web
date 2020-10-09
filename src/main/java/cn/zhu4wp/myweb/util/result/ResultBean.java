package cn.zhu4wp.myweb.util.result;

import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

/**
 * @Author zjm
 * @Date 2020/4/2
 * @Description TODO
 * @Version 1.0
 */
@Setter
@Getter
public class ResultBean<T> {
    private int code;
    private String msg;
    private Collection<T> data;

    private ResultBean(){}

    public static ResultBean error(String msg){
        ResultBean resultBean = new ResultBean();
        resultBean.setCode(-1);
        resultBean.setMsg(msg);
        return resultBean;
    }
    public static ResultBean success(){
        ResultBean resultBean = new ResultBean();
        resultBean.setCode(0);
        resultBean.setMsg("success");
        return resultBean;
    }
    public static <V> ResultBean<V> success(Collection<V> data){
        ResultBean resultBean = new ResultBean();
        resultBean.setCode(0);
        resultBean.setMsg("success");
        resultBean.setData(data);
        return resultBean;
    }
}
