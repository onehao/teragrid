/**
 * 
 */
package cn.ibm.onehao.spring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.ConnectionCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import cn.ibm.onehao.JdbcUtils;
import cn.ibm.onehao.domain.User;

/**
 * @author onehao
 *
 */
public class JdbcTemplateTest {
	
	static JdbcTemplate jdbc = new JdbcTemplate(JdbcUtils.getDataSource());

	/**
	 * @param args
	 * @这个类是线程安全的
	 */
	public static void main(String[] args) {
		User user = findUser("onehao");
		System.out.println(user);
		
		System.out.println("users" + findUsers(20));
		
		System.out.println("user count:" + getUserCount());
		
		System.out.println("user name:" + getUserName(1));
		
		System.out.println("user data:" + getData(1));
		
		System.out.println("user datas" + getDatas());
		
		
	}
	
	static int addUser(final User user){
		jdbc.execute(new ConnectionCallback<Object>(){
			@Override
			public Object doInConnection(Connection con) throws SQLException,
					DataAccessException {
				String sql = "insert into user(username,password,groups,birthday,money) values(?,?,?,?,?)";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, user.getUsername());
				ps.setString(2, user.getPassword());
				ps.setString(3, user.getGroups());
				ps.setDate(4, new java.sql.Date(user.getBirthday().getTime()));
				ps.setFloat(5, user.getMoney());
				int i = ps.executeUpdate();
				
				ResultSet rs = ps.getGeneratedKeys();//拿主键
				if(rs.next())
					user.setId(rs.getInt(1));
				return null;
			}
		});
		return 0;
	}
	
	static List<Map<String,Object>> getDatas(){
		String sql = "select id, username, birthday, money from user where id>0";
		return jdbc.queryForList(sql);
	}
	

	static Map<String,Object> getData(int id){
		String sql = "select id, username, birthday, money from user where id=" + id;
		return jdbc.queryForMap(sql);
	}
	
	static String getUserName(int id){
		String sql = "select username from user where id=" + id;
		Object name = jdbc.queryForObject(sql, String.class);
		return (String)name;
		
	}
	
	static int getUserCount(){
		String sql = "select count(*) from user";
		return jdbc.queryForInt(sql);
		
	}
	
	static List<User> findUsers(int id){
		
		String sql = "select id, username, birthday, money from user where id<?";
		Object[] args = new Object[]{id};
		int[] argTypes = new int[]{Types.INTEGER};//传入参数的类型
		
		@SuppressWarnings("unchecked")
		//实现类似ORMTest.java
		List<User> users = jdbc.query(sql, args, argTypes, new BeanPropertyRowMapper<User>(User.class));
		return users;
	}
	
	
	static User findUser(String username){
		String sql = "select id, username, birthday, money from user where username=?";
		Object[] args = new Object[]{username};
		@SuppressWarnings("unchecked")
		
		//实现累世ORMTest.java
		Object user = jdbc.queryForObject(sql, args, new BeanPropertyRowMapper<User>(User.class));
		return (User)user;
	}
	
	static User findUser1(String username){
		String sql = "select id, username, birthday, money from user where username=?";
		Object[] args = new Object[]{username};
		@SuppressWarnings("unchecked")
		Object user = jdbc.queryForObject(sql, args, new RowMapper<Object>(){
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
