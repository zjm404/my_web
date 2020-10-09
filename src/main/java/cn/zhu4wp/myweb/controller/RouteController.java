package cn.zhu4wp.myweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author zhu4wp
 * @Date 2020/2/12
 * @Description TODO
 * @Version 1.0
 */
@Controller
public class RouteController{
    @RequestMapping(value = "to_essay_list")
    public String toListEssay() throws Exception {
            return "blogs_demo";
    }
    @RequestMapping(value = "to_admin_index")
    public String toAdmin() throws Exception{
        return "admin/essay_edit";
    }
    @RequestMapping(value = "admin/essay/list")
    public String essayList() throws Exception{
        return "admin/list_essay";
    }
}
