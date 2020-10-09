package cn.zhu4wp.myweb.service.impl;

import cn.zhu4wp.myweb.model.Comment;
import cn.zhu4wp.myweb.repository.CommentRepository;
import cn.zhu4wp.myweb.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import static cn.zhu4wp.myweb.util.paging.GetPageable.getPageableByPageAndSize;

import javax.transaction.Transactional;

/**
 * @Author zjm
 * @Date 2020/3/4
 * @Description TODO
 * @Version 1.0
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Transactional(rollbackOn = Exception.class)
    @Override
    public Comment addMsg(Comment comment) throws Exception {
        return commentRepository.save(comment);
    }

    @Transactional(rollbackOn = Exception.class)
    @Override
    public void deleteByCommentId(Integer commentId) throws Exception {
        commentRepository.deleteByCommentId(commentId);
    }
    @Transactional(rollbackOn = Exception.class)
    @Override
    public Comment updateMsg(Comment comment) throws Exception {
        return commentRepository.save(comment);
    }

    @Override
    public Page<Comment> selectAllByCommentLeadId(Integer commentLeadId, Integer page, Integer size) {
        if(page == null || page < 0){
            page = 0;
        }
        if(size == null || size < 1){
            size = 6;
        }
        Pageable pageable = PageRequest.of(page,size);
        return commentRepository.findAllByCommentLeadId(commentLeadId,pageable);
    }

    @Override
    public Page<Comment> selectAllByEssayNameAndCommentLeadId(String essayName, Integer commentLeadId, Integer page, Integer size) {
        Pageable pageable = getPageableByPageAndSize(page,size);
//        commentRepository.findAllByEssayNameAndCommentLeadId(essayName,commentLeadId,pageable);
        return commentRepository.findAllByEssayNameAndCommentLeadId(essayName,commentLeadId,pageable);
    }

    @Override
    public Page<Comment> selectAllByEssayName(String essayName, Integer page, Integer size) {
        Pageable pageable = getPageableByPageAndSize(page,size);
        return commentRepository.findAllByEssayName(essayName,pageable);
    }
}
