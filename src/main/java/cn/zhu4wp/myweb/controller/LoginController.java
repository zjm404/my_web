package cn.zhu4wp.myweb.controller;

import cn.zhu4wp.myweb.model.OpenUser;
import cn.zhu4wp.myweb.model.User;
import cn.zhu4wp.myweb.service.OpenUserService;
import cn.zhu4wp.myweb.service.UserService;
import com.qq.connect.QQConnectException;
import com.qq.connect.api.OpenID;
import com.qq.connect.api.qzone.UserInfo;
import com.qq.connect.javabeans.AccessToken;
import com.qq.connect.javabeans.qzone.UserInfoBean;
import com.qq.connect.oauth.Oauth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

import static cn.zhu4wp.myweb.util.session.SessionUtil.*;

/**
 * @author ZJM
 */
@Controller
public class LoginController {
    @Autowired
    private OpenUserService openUserService;
    @Autowired
    private UserService userService;

    private String referer;

    @RequestMapping(value = "/to_login")
    public String toLogin(Model model) throws Exception {
        HttpServletRequest request = getRequest();
        this.referer = request.getHeader("Referer");
        String url = "";
        try {
            url = new Oauth().getAuthorizeURL(request);

        } catch (QQConnectException e) {
            throw new QQConnectException("获取request失败");
        }
        return "redirect:" + url;
    }

    @RequestMapping(value = "/qq_login")
    public String qqLogin(Model model) throws Exception {
        //获取Token
        try {
            AccessToken accessTokenObj = (new Oauth()).getAccessTokenByRequest(getRequest());
            String accessToken = null;
            String openID = null;
            long tokenExpireIn = 0L;
            if (accessTokenObj.getAccessToken().equals("")) {
                System.out.println("没有获取到相应参数");
            } else {
                accessToken = accessTokenObj.getAccessToken();
                tokenExpireIn = accessTokenObj.getExpireIn();
                //利用accessToken去获取openid
                OpenID openIDObj = new OpenID(accessToken);
                openID = openIDObj.getUserOpenID();
                UserInfo qzoneUserInfo = new UserInfo(accessToken, openID);
                UserInfoBean userInfoBean = qzoneUserInfo.getUserInfo();
                if (userInfoBean.getRet() == 0) {
                    OpenUser openUser = openUserService.getOpenUserByOpenId(openID);
                    if (openUser != null) {

                        User user = userService.selectUserByID(openUser.getUID());
                        model.addAttribute("user", user);
                        getSession().setAttribute("user", user);
                    } else {
                        //User数据存储
                        User user = new User();
                        user.setAvatar(userInfoBean.getAvatar().getAvatarURL50());
                        user.setNickname(userInfoBean.getNickname());

                        user = userService.regist(user);

                        //OpenUser数据存储
                        openUser = new OpenUser();
                        openUser.setAccessToken(accessToken);
                        openUser.setAvatar(userInfoBean.getAvatar().getAvatarURL50());
                        openUser.setExpiredTime(tokenExpireIn);
                        openUser.setOpenID(openID);
                        openUser.setOpenType("OPEN_TYPE_QQ");
                        openUser.setUID(user.getId());

                        openUser = openUserService.add(openUser);

                        model.addAttribute("user", user);
                        getSession().setAttribute("user", user);
                    }
                } else {
                    //计入日志，为获取到信息
                }
            }
        } catch (QQConnectException e) {
            e.printStackTrace();
        }
        return "redirect:" + this.referer;
    }

}
