package com.base.security.realm;

import com.rbac.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "realmImpl")
public class RealmImpl implements Realm{
    @Autowired
    private UserService userService;

    @Override
    public String getName() {
        return "RealmImpl";
    }

    @Override
    public boolean supports(AuthenticationToken authenticationToken) {
        return authenticationToken instanceof UsernamePasswordToken;
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String)authenticationToken.getPrincipal();  //得到用户名
        String password = new String((char[])authenticationToken.getCredentials()); //得到密码
/*        if(!"zhang".equals(username)) {
            throw new UnknownAccountException(); //如果用户名错误
        }
        if(!"123".equals(password)) {
            throw new IncorrectCredentialsException(); //如果密码错误
        }*/
        //userService.validateSignin(username,password);
        //如果身份认证验证成功，返回一个AuthenticationInfo实现；

        return new SimpleAuthenticationInfo(username, password, getName());
    }
}
