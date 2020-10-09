package cn.zhu4wp.myweb.service;

import cn.zhu4wp.myweb.model.OpenUser;

import java.util.Optional;

public interface OpenUserService {
    /**
     * 增加
     * @param openUser
     * @return
     */
    public OpenUser add(OpenUser openUser) throws Exception;

    /**
     * 根据ID查找
     * @param id
     * @return
     */
    public OpenUser getOpenUserById(long id);

    public OpenUser getOpenUserByOpenId(String openId);
}
