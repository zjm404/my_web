package cn.zhu4wp.myweb.service.impl;

import cn.zhu4wp.myweb.model.OpenUser;
import cn.zhu4wp.myweb.repository.OpenUserRespository;
import cn.zhu4wp.myweb.service.OpenUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class OpenUserServiceImpl implements OpenUserService {

    @Autowired
    private OpenUserRespository openUserRespository;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public OpenUser add(OpenUser openUser) throws Exception {
        return openUserRespository.saveAndFlush(openUser);
    }

    @Override
    public OpenUser getOpenUserById(long id) {

        return openUserRespository.findById(id);
    }

    @Override
    public OpenUser getOpenUserByOpenId(String openId) {
        return openUserRespository.findByOpenID(openId);
    }
}
