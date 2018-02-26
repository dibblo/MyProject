package com.rbac.iservice;

import com.rbac.bean.UserInf;
import com.rbac.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserService implements com.rbac.service.UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public UserInf get(String id) {
        return userDao.get(id);
    }

    @Override
    public List<UserInf> getUsersByRoleId(String roleId) {
        return userDao.getUsersByRoleId(roleId);
    }
}
