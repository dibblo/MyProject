package com.rbacimp.mybatis.sqlprovider;

import com.rbacimp.mybatis.commons.TableNames;
import javafx.scene.control.Tab;

import java.util.Map;
import java.util.UUID;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class UserSqlProvider {

    public String getMatchCount(Map<String,Object> params) {
        String userName = params.get("userName").toString();
        return "select count(1) as count from "+ TableNames.USER+" where user_name='"+userName+"'";
    }

    public String updateLoginInfo(){
        BEGIN();
        UPDATE(TableNames.USER);
        SET("last_visit=#{user.lastVisit,javaType=date,jdbcType=DATE}");
        SET("last_ip=#{user.lastIp,javaType=String,jdbcType=VARCHAR}");
        WHERE("id=#{user.id,javaType=String,jdbcType=VARCHAR}");
        return SQL();
    }
    public String getMatchUser(Map<String,Object> params) {
        BEGIN();
        SELECT("*");
        FROM(TableNames.USER);
        WHERE("user_name=#{userName} and password = #{password}");
        return SQL();
    }
    public String register() {
        BEGIN();
        INSERT_INTO(TableNames.USER);
        VALUES("id","'"+ UUID.randomUUID().toString().replaceAll("-", "")+"'");
        VALUES("user_name","#{user.userName}");
        VALUES("password","#{user.password}");
        return SQL();
    }

    public String get(){
        BEGIN();
        SELECT("*");
        FROM(TableNames.USER);
        WHERE("id=#{id}");
        return SQL();
    }

    public String getUsersByRoleId(){
        BEGIN();
        SELECT(" u.*");
        FROM(TableNames.USER + " u " );
        LEFT_OUTER_JOIN(TableNames.USER_ROLE + " ur on ur.role_id=#{roleId} ");
        return SQL();
    }

}
