/**
 * 
 */
package cn.ibm.onehao.spring;

import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import cn.ibm.onehao.JdbcUtils;
import cn.ibm.onehao.domain.User;

/**
 * @author onehao
 *
 */
public class NamedJdbcTemplate {
	static NamedParameterJdbcTemplate named = new NamedParameterJdbcTemplate(
			JdbcUtils.getDataSource());
	
	public static void main(String[] args){
		User user = new User();
		user.setMoney(10);
		user.setId(12);
		System.out.println(findUser1(user));//得到多个值会报错
	}
	
	static void addUser(User user){
		String sql = "insert into user(username, birthday, money) " +
				"values(:username,:birthday,:money)";
		SqlParameterSource ps = new BeanPropertySqlParameterSource(user);
		KeyHolder keyHolder = new GeneratedKeyHolder();
		named.update(sql, ps, keyHolder);
		int id = keyHolder.getKey().intValue();
		user.setId(id);
//		Map map = keyHolder.getKeys();//多个主键
	}
	
	static User findUser(User user){
		String sql = "select id, username, birthday, money from user " +
				"where money>:m and id<:id";
		Map<String, Object> params = new HashMap<String, Object>();
//		params.put("n", user.getUsername());
		params.put("m", user.getMoney());
		params.put("id", user.getId());
		Object u = named.queryForObject(sql, params, new BeanPropertyRowMapper<User>(
				User.class));
		return (User)u;
	}
	
	static User findUser1(User user){
		String sql = "select id, username, birthday, money from user " +
				"where money>:money and id<:id";// :para para 要和java类中的名字一样
		Map<String, Object> params = new HashMap<String, Object>();
		SqlParameterSource ps = new BeanPropertySqlParameterSource(user);
		Object u = named.queryForObject(sql, ps, new BeanPropertyRowMapper<User>(
				User.class));
		return (User)u;
	}
}
