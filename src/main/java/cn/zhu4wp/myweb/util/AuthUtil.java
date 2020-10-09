package cn.zhu4wp.myweb.util;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ZJM
 * @apiNote 第三方登陆
 */
@Setter
@Getter
public class AuthUtil {
    private String accessToken;
    private String openID;
    private String tokenExpire;

}
