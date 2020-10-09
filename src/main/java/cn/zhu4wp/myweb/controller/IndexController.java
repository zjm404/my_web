package cn.zhu4wp.myweb.controller;

import static cn.zhu4wp.myweb.util.session.SessionUtil.*;

import cn.zhu4wp.myweb.model.Essay;
import cn.zhu4wp.myweb.model.Folder;
import cn.zhu4wp.myweb.model.FolderEssay;
import cn.zhu4wp.myweb.model.User;
import cn.zhu4wp.myweb.service.EssayService;
import cn.zhu4wp.myweb.service.FolderEssayService;
import cn.zhu4wp.myweb.service.FolderService;
import cn.zhu4wp.myweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author ZJM
 * @date 2019.07.28
 */
@Controller
public class IndexController {
   @Autowired
   private EssayService essayService;
   @Autowired
   private FolderEssayService folderEssayService;
   @Autowired
   private FolderService folderService;

    @Autowired
    private UserService userService;
    @RequestMapping("/")
    public ModelAndView toBlog(ModelAndView modelAndView) throws Exception{
        User user =  (User)getSession().getAttribute("user");
        //载入文件信息
        Page<Essay> pagesEssay =  essayService.selectAll(0,0);
        List<Essay> pages = pagesEssay.getContent();
        int pageNum = pagesEssay.getNumber();
        int pageNumEnd = pagesEssay.getTotalPages();
        modelAndView.addObject("pages",pages);
        modelAndView.addObject("pageNum",pageNum);
        modelAndView.addObject("pageNumEnd",pageNumEnd);
        //载入文件夹信息
        List<Folder> folders = folderService.selectAll();
        List<FolderEssay> list = folderEssayService.selectAll();
        modelAndView.addObject("folders",folders);
        modelAndView.addObject("folderEssay",list);
        List<Essay> essays = essayService.selectAll();
        Essay essay = essayService.selectEssayByEssayName("Test");
        modelAndView.addObject("essays",essays);

        modelAndView.setViewName("blogs");
        return modelAndView;
    }
}
