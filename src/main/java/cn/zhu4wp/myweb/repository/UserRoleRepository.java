package cn.zhu4wp.myweb.repository;

import cn.zhu4wp.myweb.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author zhu4wp
 * @Date 19-9-27
 * @Description TODO
 * @Version 1.0
 */
@Repository
public interface UserRoleRepository extends JpaRepository<UserRole,Long> {
    public UserRole findByUserIdAndAndRoleName(long userId,String roleName);

}
