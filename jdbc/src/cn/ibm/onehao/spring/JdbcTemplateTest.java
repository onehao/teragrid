/**
 * 
 */
package cn.ibm.onehao.spring;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import cn.ibm.onehao.JdbcUtils;
import cn.ibm.onehao.domain.User;

/**
 * @author onehao
 *
 */
public class JdbcTemplateTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		User user = findUser("onehao");
		System.out.println(user);
	}
	
	static User findUser(String username){
		JdbcTemplate jdbc = new JdbcTemplate(JdbcUtils.getDataSource());
		String sql = "select id, username, birthday, money from user where username=?";
		Object[] args = new Object[]{username};
		@SuppressWarnings("unchecked")
		
		// µœ÷¿€ ¿ORMTest.java
		Object user = jdbc.queryForObject(sql, args, new BeanPropertyRowMapper<User>(User.class));
		return (User)user;
	}
	
	static User findUser1(String username){
		JdbcTemplate jdbc = new JdbcTemplate(JdbcUtils.getDataSource());
		String sql = "select id, username, birthday, money from user where username=?";
		Object[] args = new Object[]{username};
		@SuppressWarnings("unchecked")
		Object user = jdbc.queryForObject(sql, args, new RowMapper(){
			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setBirthday(rs.getDate("birthday"));
				user.setMoney(rs.getFloat("money"));
				return user;
			}});
		return (User)user;
	}

}
