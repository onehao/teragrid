/**
 * 
 */
package cn.ibm.onehao.dao.impl;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import cn.ibm.onehao.JdbcUtils;
import cn.ibm.onehao.dao.UserDao;
import cn.ibm.onehao.domain.User;

/**
 * @author onehao
 *
 */
public class UserDaoSpringImpl implements UserDao {

	private SimpleJdbcTemplate simpleJdbcTemplate = new SimpleJdbcTemplate(
			JdbcUtils.getDataSource());

	@Override
	public void addUser(User user) {
		String sql = "insert into user(username, money, birthday) " +
				"values(:username, :money, :birthday)";
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(user);
		KeyHolder keyHolder = new GeneratedKeyHolder();
		this.simpleJdbcTemplate.getNamedParameterJdbcOperations().update(sql,
				paramSource, keyHolder);
		user.setId(keyHolder.getKey().intValue());
	}

	@Override
	public User getUser(int userId) {
		String sql = "select id, username, money, birthday from user where id=?";
		return this.simpleJdbcTemplate.queryForObject(sql, 
				ParameterizedBeanPropertyRowMapper.newInstance(User.class), 
				userId);
	}

	@Override
	public User findUser(String loginName, String password) {
		String sql = "select id, username, money, birthday from user where username=?";
		return this.simpleJdbcTemplate.queryForObject(sql, 
				ParameterizedBeanPropertyRowMapper.newInstance(User.class), 
				loginName);
	}

	@Override
	public void update(User user) {
		String sql = "update user set username=?, password=?, " +
				"groups=?, birthday=?, money=? " +
				"where id=?" ;
		this.simpleJdbcTemplate.update(sql, user.getUsername(), user.getPassword(),
				user.getGroups(), user.getBirthday(), user.getMoney(), user.getId());
		
		sql = "update user set username=:username, password=:password, " +
		"groups=:groups, birthday=:birthday, money=:money " +
		"where id=:id" ;
		this.simpleJdbcTemplate.update(sql, 
		new BeanPropertySqlParameterSource(user));
	}

	@Override
	public void delete(User user) {
		String sql = "delect from user where id=?";
		this.simpleJdbcTemplate.update(sql, user.getId());
	}

}
