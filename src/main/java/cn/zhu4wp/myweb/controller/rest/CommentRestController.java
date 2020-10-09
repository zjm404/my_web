package cn.zhu4wp.myweb.controller.rest;

import cn.zhu4wp.myweb.model.Comment;
import cn.zhu4wp.myweb.model.User;
import cn.zhu4wp.myweb.service.CommentService;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static cn.zhu4wp.myweb.util.session.SessionUtil.getSession;

/**
 * @Author zjm
 * @Date 2020/3/5
 * @Description TODO
 * @Version 1.0
 */
@RestController
public class CommentRestController {
    @Autowired
    CommentService commentService;

    @GetMapping("comments")
    public List<Comment> selectAllLead(@RequestParam(value = "essayName") String essayName,
                                       @RequestParam(value = "commentLeadId") Integer commentLeadId,
                                       @RequestParam(value = "page") Integer page) throws Exception {
        Integer size = 0;
        List<Comment> comments = commentService.selectAllByEssayNameAndCommentLeadId(essayName, commentLeadId, page, size).getContent();
        return comments;
    }
    @GetMapping("/all/comments")
    public List<Comment> selectAll(@RequestParam(value = "essayName") String essayName,
                                   @RequestParam(value = "page") Integer page) throws Exception{
        Integer size = 0;
        List<Comment> comments = commentService.selectAllByEssayName(essayName,page, size).getContent();
        return comments;
    }
    @DeleteMapping("comment")
    public int deleteByCommentId(@RequestParam(value = "commentId") Integer commentId) throws Exception {
        commentService.deleteByCommentId(commentId);
        return 1;
    }

    @PostMapping(value = "/comment")
    public String addComment(@RequestParam(value = "commentContent") String commentContent,
                             @RequestParam(value = "commentLeadId") Integer commentLeadId,
                             @RequestParam(value = "essayName") String essayName) throws Exception {
        User user = (User) getSession().getAttribute("user");
        if (user == null) {
            return "请登录！";
        }
        Comment comment = new Comment();
        comment.setCommentContent(commentContent);
        comment.setCommentLeadId(commentLeadId);
        comment.setEssayName(essayName);
        comment.setUserId(user.getId());
        comment.setUserName(user.getNickname());

        if (commentService.addMsg(comment) != null) {
            return "评论成功！";
        }

        return "评论失败！";
    }

}
