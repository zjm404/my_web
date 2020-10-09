package cn.zhu4wp.myweb.service;

import cn.zhu4wp.myweb.model.User;

public interface UserService {
    public User regist(User user) throws Exception;
    public User selectUserByID(long id);

}
