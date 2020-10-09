package cn.zhu4wp.myweb.repository;

import cn.zhu4wp.myweb.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author zhu4wp
 * @Date 2020/3/4
 * @Description TODO
 * @Version 1.0
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment,Integer> {
    Page<Comment> findAllByCommentLeadId(Integer commentLeadId, Pageable pageable);
    void deleteByCommentId(Integer commentId);

    Page<Comment> findAllByEssayNameAndCommentLeadId(String essayName,Integer commentLeadId,Pageable pageable);

    Page<Comment> findAllByUserId(Long userId,Pageable pageable);

    Page<Comment> findAllByEssayName(String essayName,Pageable pageable);
}
