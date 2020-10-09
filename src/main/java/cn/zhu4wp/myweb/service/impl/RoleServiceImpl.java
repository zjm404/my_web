package cn.zhu4wp.myweb.service.impl;

import cn.zhu4wp.myweb.model.Role;
import cn.zhu4wp.myweb.repository.RoleRepository;
import cn.zhu4wp.myweb.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @Author zhu4wp
 * @Date 19-9-27
 * @Description TODO
 * @Version 1.0
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Transactional(rollbackOn = Exception.class)
    @Override
    public Role add(Role role) throws Exception {
        return roleRepository.save(role);
    }

    @Transactional(rollbackOn = Exception.class)
    @Override
    public void deleteByRoleName(String roleName) throws Exception {
        roleRepository.deleteByRoleName(roleName);
    }
}
