package cn.zhu4wp.myweb.repository;

import cn.zhu4wp.myweb.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author zhu4wp
 * @Date 19-9-27
 * @Description TODO
 * @Version 1.0
 */
@Repository
public interface RoleRepository  extends JpaRepository<Role,String> {
    public void deleteByRoleName(String roleName);
}
