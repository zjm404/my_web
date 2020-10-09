package cn.zhu4wp.myweb.service;

import cn.zhu4wp.myweb.model.Comment;
import org.springframework.data.domain.Page;

/**
 * @Author zhu4wp
 * @Date 2020/3/4
 * @Description TODO
 * @Version 1.0
 */
public interface CommentService {
    public Comment addMsg(Comment comment) throws Exception;

    public void deleteByCommentId(Integer commentId) throws Exception;

    public Comment updateMsg(Comment comment) throws Exception;

    public Page<Comment> selectAllByCommentLeadId(Integer commentLeadId,Integer  page,Integer size);

    public Page<Comment> selectAllByEssayNameAndCommentLeadId(String essayName,Integer commentLeadId,Integer page,Integer size);

    public Page<Comment> selectAllByEssayName(String essayName,Integer page,Integer size);
}
