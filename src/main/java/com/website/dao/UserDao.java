package com.website.dao;

import com.website.domain.User;
import com.website.sqlprovider.UserSqlProvider;
import org.apache.ibatis.annotations.*;

public interface UserDao {

    @SelectProvider(type = UserSqlProvider.class, method = "getMatchCount")
    @Options(useCache = true, flushCache = Options.FlushCachePolicy.FALSE, timeout = 10000)
    @ResultType(value = Integer.class)
    int getMatchCount(@Param("userName") String userName);

    @SelectProvider(type = UserSqlProvider.class, method = "getMatchUser")
    @Options(useCache = true, flushCache = Options.FlushCachePolicy.FALSE, timeout = 10000)
    @ResultMap(value = "User")
    User getMatchUser(@Param("userName")String userName,@Param("password") String passWord);

    @UpdateProvider(type = UserSqlProvider.class, method = "updateLoginInfo")
    void updateLoginInfo(@Param("user") User user);

    @InsertProvider(type = UserSqlProvider.class, method = "register")
    void register(@Param("user") User user);
}
