package com.website.dao;

import com.website.domain.LoginLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface LoginLogDao {
	@Insert(value = "insert into t_login_log(user_id,ip,login_datetime) values(#{loginLog.userId},#{loginLog.ip},#{loginLog.loginDate,jdbcType=DATE,javaType=date})")
	void insertLoginLog(@Param("loginLog") LoginLog loginLog);
}
