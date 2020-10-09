package cn.zhu4wp.myweb.controller;

import cn.zhu4wp.myweb.model.*;
import cn.zhu4wp.myweb.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import static cn.zhu4wp.myweb.util.session.SessionUtil.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author zhu4wp
 * @Date 2019/8/6 16:41
 * @Description TODO
 * @Version 1.0
 */
@Controller
public class BlogController {
    @Autowired
    private EssayService essayService;
    @Autowired
    private FolderService folderService;
    @Autowired
    private FolderEssayService folderEssayService;
    @Autowired
    private LikeService likeService;
    @Autowired
    private UserRoleService userRoleService;


    @RequestMapping("/to_blog_edit")
    /**
     * @apiNote 为前台提供的数据：文件夹、用户
     */
    public ModelAndView toBlogEdit(ModelAndView modelAndView) {
        User user = (User) getSession().getAttribute("user");
        if (user == null) {
            modelAndView.setViewName("ERROR_NO_AUTHORITY");
            return modelAndView;
        } else {
            UserRole userRole = userRoleService.selectByUserIdAndRoleName(user.getId(), "admin");
            if (userRole == null) {
                modelAndView.setViewName("ERROR_NO_AUTHORITY");
                return modelAndView;
            } else {
                modelAndView.setViewName("blog_edit");
                List<Folder> folders = folderService.selectAll();
                List<FolderEssay> list = folderEssayService.selectAll();
                modelAndView.addObject("folders", folders);
                modelAndView.addObject("folderEssay", list);
                modelAndView.addObject("user", user);
                return modelAndView;
            }
        }

    }

    @RequestMapping("/edit_essay")
    @ResponseBody
    public Map<String, Object> editEssay(ModelAndView modelAndView,
                                         @RequestParam(value = "essayName") String essayName) {
        Essay essay = essayService.selectEssayByEssayName(essayName);
        Map map = new HashMap();
        map.put("folder", essay.getFolder());
        map.put(("essayName"), essayName);
        map.put("content", essay.getEssayContent());
        return map;
    }

    @RequestMapping("/save_blog")
    @ResponseBody
    public Map<String, Object> saveBlog(Model model,
                                        @RequestParam(value = "text") String text,
                                        @RequestParam(value = "title") String title,
                                        @RequestParam(value = "folder") String folderName) throws Exception {
        Map map = new HashMap<String, Object>();
        //注：目前前端水平太烂，只能先这样写了，文件夹相关的增加应是另一个表单处理
        //创建文件夹
        Folder folder = new Folder();
        folder.setFolderName(folderName);

        folderService.add(folder);

        //添加文件
        Essay essay = new Essay();
        essay.setFolder(folderName);
        essay.setTime(new Date());
        essay.setEssayAuthorId(1);
        essay.setEssayName(title);
        essay.setEssayContent(text);

        essayService.add(essay);



        if (folderEssayService.selectAllByEssayNameAndFolderName(title,folderName) == null){
            //FolderEssay 中间表添加数据
            FolderEssay folderEssay = new FolderEssay();
            folderEssay.setEssayName(title);
            folderEssay.setFolderName(folderName);
            folderEssayService.add(folderEssay);
        }


        map.put("data", "成功");
        return map;

    }

    @RequestMapping("/show_essays")
    public ModelAndView showEssays(ModelAndView modelAndView,
                                   @RequestParam(value = "page") Integer page) throws Exception {
        //载入文件信息
        Page<Essay> pagesEssay = essayService.selectAll(page, 0);
        List<Essay> pages = pagesEssay.getContent();
        int pageNum = pagesEssay.getNumber();
        int pageNumEnd = pagesEssay.getTotalPages();
        modelAndView.addObject("pages", pages);
        modelAndView.addObject("pageNum", pageNum);
        modelAndView.addObject("pageNumEnd", pageNumEnd);
        //载入文件夹信息
        List<Folder> folders = folderService.selectAll();
        List<FolderEssay> list = folderEssayService.selectAll();
        modelAndView.addObject("folders", folders);
        modelAndView.addObject("folderEssay", list);
        List<Essay> essays = essayService.selectAll();
        modelAndView.addObject("essays", essays);
        //载入用户信息
        User user = (User) getSession().getAttribute("user");
        if (user != null) {
            modelAndView.addObject("user", user);
        }
        modelAndView.setViewName("blogs");
        return modelAndView;
    }

    @RequestMapping("/selectByKeyword")
    @Scope(value = "request")
    public ModelAndView selectByEssayName(ModelAndView modelAndView,
                                          @RequestParam(value = "selectKeyword") String selectKeyword) throws Exception {
        //载入文件信息
        Page<Essay> pagesEssay = essayService.selectAllByKeyWords(selectKeyword, 0, 0);
        List<Essay> pages = pagesEssay.getContent();
        int pageNum = pagesEssay.getNumber();
        int pageNumEnd = pagesEssay.getTotalPages();
        modelAndView.addObject("pages", pages);
        modelAndView.addObject("pageNum", pageNum);
        modelAndView.addObject("pageNumEnd", pageNumEnd);
        modelAndView.addObject("selectKeyWords", selectKeyword);
        //载入文件夹信息
        List<Folder> folders = folderService.selectAll();
        List<FolderEssay> list = folderEssayService.selectAll();
        modelAndView.addObject("folders", folders);
        modelAndView.addObject("folderEssay", list);
        List<Essay> essays = essayService.selectAll();
        modelAndView.addObject("essays", essays);
        //载入用户信息
        User user = (User) getSession().getAttribute("user");
        if (user != null) {
            modelAndView.addObject("user", user);
        }
        modelAndView.setViewName("filter_blogs");
        return modelAndView;
    }

    @RequestMapping("/nextPage")
    public ModelAndView nextPage(ModelAndView modelAndView,
                                 @RequestParam(value = "selectKeyword") String selectKeyword,
                                 @RequestParam(value = "page") Integer page) throws Exception {
        //载入文件信息
        Page<Essay> pagesEssay = essayService.selectAllByKeyWords(selectKeyword, page, 0);
        List<Essay> pages = pagesEssay.getContent();
        int pageNum = pagesEssay.getNumber();
        int pageNumEnd = pagesEssay.getTotalPages();
        modelAndView.addObject("pages", pages);
        modelAndView.addObject("pageNum", pageNum);
        modelAndView.addObject("pageNumEnd", pageNumEnd);
        modelAndView.addObject("selectKeyWords", selectKeyword);
        //载入文件夹信息
        List<Folder> folders = folderService.selectAll();
        List<FolderEssay> list = folderEssayService.selectAll();
        modelAndView.addObject("folders", folders);
        modelAndView.addObject("folderEssay", list);
        List<Essay> essays = essayService.selectAll();
        modelAndView.addObject("essays", essays);
        //载入用户信息
        User user = (User) getSession().getAttribute("user");
        if (user != null) {
            modelAndView.addObject("user", user);
        }
        modelAndView.setViewName("filter_blogs");
        return modelAndView;
    }

    @RequestMapping("/to_blog")
    public ModelAndView toBlog(ModelAndView modelAndView,
                               @RequestParam(value = "essayName") String essayName) throws Exception {
        //载入文件夹信息
        List<Folder> folders = folderService.selectAll();
        List<FolderEssay> list = folderEssayService.selectAll();
        modelAndView.addObject("folders", folders);
        modelAndView.addObject("folderEssay", list);
        List<Essay> essays = essayService.selectAll();
        modelAndView.addObject("essays", essays);

        Essay essay = essayService.selectEssayByEssayName(essayName);
        modelAndView.addObject("essay", essay);

        //载入点赞信息
        User user = (User) getSession().getAttribute("user");
        //　是否点赞，０为未点赞，１为已点赞．
        int clicked = 0;
        if (user != null) {
            modelAndView.addObject("user", user);
            Like like = likeService.selectByUserIdAndEssayName(user.getId(), essayName);
            if (like != null) {
                clicked = 1;
            }
        }
        modelAndView.addObject("clicked", clicked);
        modelAndView.setViewName("blog");
        return modelAndView;
    }

    @RequestMapping("/like")
    @ResponseBody
    public Map<String, Object> like(@RequestParam(value = "essayName") String essayName) throws Exception {
        Map map = new HashMap();
        User user = (User) getSession().getAttribute("user");
        if (user == null) {
            map.put("data", "请登录！");
        } else {
            Like like = likeService.selectByUserIdAndEssayName(user.getId(), essayName);
            if (like == null) {
                like = new Like();
                like.setEssayName(essayName);
                like.setUserId(user.getId());

                likeService.add(like);

                Essay essay = essayService.selectEssayByEssayName(essayName);
                essay.setEssayLikeNum(essay.getEssayLikeNum() + 1);

                essay = essayService.add(essay);

                map.put("data", "点赞成功！");
                map.put("likeNum", essay.getEssayLikeNum());
            } else {
                Essay essay = essayService.selectEssayByEssayName(essayName);
                essay.setEssayLikeNum(essay.getEssayLikeNum() - 1);
                essay = essayService.add(essay);
                likeService.deleteById(like.getId());
                map.put("data", "取消点赞成功！");
                map.put("likeNum", essay.getEssayLikeNum());
            }
        }
        return map;
    }

    @RequestMapping("/open_folder")
    @ResponseBody
    public List<FolderEssay> openFolder(@RequestParam(value = "folder") String folderName) throws Exception {
        Map map = new HashMap<String, Object>();
        List<FolderEssay> list = folderEssayService.selectAllByFolderName(folderName);
        return list;
    }

    @RequestMapping("/logout")
    public String logout() throws Exception {
        getSession().removeAttribute("user");
        return "index";
    }

}
