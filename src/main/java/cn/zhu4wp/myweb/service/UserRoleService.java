package cn.zhu4wp.myweb.service;

import cn.zhu4wp.myweb.model.UserRole;

/**
 * @Author zhu4wp
 * @Date 19-9-27
 * @Description TODO
 * @Version 1.0
 */
public interface UserRoleService {

    public UserRole add(UserRole userRole) throws Exception;

    public UserRole selectByUserIdAndRoleName(long userId,String roleName);
}
