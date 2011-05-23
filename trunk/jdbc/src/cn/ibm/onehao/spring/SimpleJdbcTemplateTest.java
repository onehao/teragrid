/**
 * 
 */
package cn.ibm.onehao.spring;

import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import cn.ibm.onehao.JdbcUtils;
import cn.ibm.onehao.domain.User;

/**
 * @author onehao
 *
 */
public class SimpleJdbcTemplateTest {

	//°üº¬
	static SimpleJdbcTemplate simple = new SimpleJdbcTemplate(
			JdbcUtils.getDataSource());
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static User findUser(String name){
		String sql = "select id, username, birthday, money from user " +
				"where name=?";
		@SuppressWarnings("deprecation")
		User user = simple.queryForObject(sql, 
				ParameterizedBeanPropertyRowMapper.newInstance(User.class),
				name,100f);
		return user;
	}

}
