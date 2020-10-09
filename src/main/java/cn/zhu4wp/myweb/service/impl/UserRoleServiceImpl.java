package cn.zhu4wp.myweb.service.impl;

import cn.zhu4wp.myweb.model.UserRole;
import cn.zhu4wp.myweb.repository.UserRoleRepository;
import cn.zhu4wp.myweb.service.UserRoleService;
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
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Transactional(rollbackOn = Exception.class)
    @Override
    public UserRole add(UserRole userRole) throws Exception {
        return userRoleRepository.save(userRole);
    }

    @Override
    public UserRole selectByUserIdAndRoleName(long userId, String roleName) {
        return userRoleRepository.findByUserIdAndAndRoleName(userId,roleName);
    }
}
