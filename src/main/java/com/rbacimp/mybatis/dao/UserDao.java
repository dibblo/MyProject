package com.rbacimp.mybatis.dao;

import com.rbac.bean.UserInf;
import com.rbacimp.mybatis.sqlprovider.UserSqlProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("mybatisUserDao")
public interface UserDao extends com.rbac.dao.UserDao {

    /*    @SelectProvider(type = UserSqlProvider.class, method = "getMatchCount")
        @Options(useCache = true, flushCache = Options.FlushCachePolicy.FALSE, timeout = 10000)
        @ResultType(value = Integer.class)
        int getMatchCount(@Param("userName") String userName);

        @SelectProvider(type = UserSqlProvider.class, method = "getMatchUser")
        @Options(useCache = true, flushCache = Options.FlushCachePolicy.FALSE, timeout = 10000)
        @ResultMap(value = "User")
        UserInf getMatchUser(@Param("userName")String userName,@Param("password") String passWord);

        @UpdateProvider(type = UserSqlProvider.class, method = "updateLoginInfo")
        void updateLoginInfo(@Param("user") UserInf user);

        @InsertProvider(type = UserSqlProvider.class, method = "register")
        void register(@Param("user") UserInf user);*/
    @SelectProvider(type = UserSqlProvider.class, method = "get")
    @Options(useCache = true, flushCache = Options.FlushCachePolicy.FALSE, timeout = 10000)
    @ResultMap(value = "User")
    UserInf get(String id);

    @SelectProvider(type = UserSqlProvider.class, method = "getUsersByRoleId")
    @Options(useCache = true, flushCache = Options.FlushCachePolicy.FALSE, timeout = 10000)
    @ResultMap(value = "User")
    List<UserInf> getUsersByRoleId(String roleId);
}
