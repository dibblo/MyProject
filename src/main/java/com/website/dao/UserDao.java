package com.website.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.website.domain.User;

@Repository
public class UserDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public int getMatchCount(String userName, String password){
		String sqlStr = "select count(1) from t_user where user_name=?";
		return jdbcTemplate.queryForObject(sqlStr, int.class, userName);
	}
	public User findUserByUserName(final String userName){
		String sqlStr = "select * from t_user where user_name = ? ";
		return  jdbcTemplate.queryForObject(sqlStr, new RowMapper<User>(){
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				return User.initUser(rs);
			}
		}, userName);
	}
	public void updateLoginInfo(User user){
		String sqlStr="update t_user set last_visit=?,last_ip=?,credits=? where user_id=?";
		jdbcTemplate.update(sqlStr,user.getLasstVist(),user.getLastIp(),user.getCredits(),user.getUserId());
	}
	
	public User userLogin(final String userName, final String password){
		String sqlStr = "select * from t_user where user_name = ? and password = ?";
		return  jdbcTemplate.queryForObject(sqlStr, new RowMapper<User>(){
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				return User.initUser(rs);
			}
		}, userName, password);
	}
	
	public void register(User user){
		String sqlStr = "insert into t_user(user_name,password) values('"+user.getUserName()+"','"+user.getPassword() +"','"+ user.getPrimaryKey()+"','"+user.getPublicKey() + "')";
		jdbcTemplate.execute(sqlStr);
	}
	
	public boolean hasRegister(String userName){
		String sqlStr = "select count(1) from t_user where user_name = ?";
		return jdbcTemplate.queryForObject(sqlStr, int.class, userName) != 0;
	}
}
