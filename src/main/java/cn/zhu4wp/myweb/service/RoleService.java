package cn.zhu4wp.myweb.service;

import cn.zhu4wp.myweb.model.Role;

/**
 * @Author zhu4wp
 * @Date 19-9-27
 * @Description TODO
 * @Version 1.0
 */
public interface RoleService {
    public Role add(Role role) throws Exception;

    public void deleteByRoleName(String roleName) throws Exception;
}
