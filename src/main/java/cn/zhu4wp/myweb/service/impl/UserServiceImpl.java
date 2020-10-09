package cn.zhu4wp.myweb.service.impl;

import cn.zhu4wp.myweb.model.User;
import cn.zhu4wp.myweb.repository.UserRepository;
import cn.zhu4wp.myweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public User regist(User user) throws Exception {
        return userRepository.saveAndFlush(user);
    }

    @Override
    public User selectUserByID(long id) {
        return userRepository.findById(id);
    }
}
