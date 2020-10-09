package cn.zhu4wp.myweb.repository;

import cn.zhu4wp.myweb.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String> {

    public User findById(Long id);
}
