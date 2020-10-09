package cn.zhu4wp.myweb.repository;

import cn.zhu4wp.myweb.model.OpenUser;
import cn.zhu4wp.myweb.model.User;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpenUserRespository extends JpaRepository<OpenUser,Long> {
    public OpenUser findById(long id);

    public OpenUser findByOpenID(String openId);

}
