package com.rbacimp.mybatis.dao;

import com.rbacimp.mybatis.bean.LoginLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface LoginLogDao {
	@Insert(value = "insert into loginLog(user_id,ip,login_datetime) values(#{loginLog.userId},#{loginLog.ip},#{loginLog.loginDate,jdbcType=DATE,javaType=date})")
	void insertLoginLog(@Param("loginLog") LoginLog loginLog);
}
