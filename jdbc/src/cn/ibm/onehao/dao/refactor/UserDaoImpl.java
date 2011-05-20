/**
 * 
 */
package cn.ibm.onehao.dao.refactor;

import java.sql.ResultSet;
import java.sql.SQLException;

import cn.ibm.onehao.domain.User;

/**
 * @author onehao
 * 
 */
public class UserDaoImpl extends AbstractDao {
	public User findUser(String loginName, String password) {
		String sql = "select id, username, birthday, money from user where username=?";
		Object[] args = new Object[]{loginName};
		Object user = super.find(sql, args);
		return (User)user;
	}

	@Override
	protected Object rowMapper(ResultSet rs) throws SQLException {
		User user = new User();
		user.setId(rs.getInt("id"));
		user.setUsername(rs.getString("username"));
		user.setBirthday(rs.getDate("birthday"));
		user.setMoney(rs.getFloat("money"));
		return user;
	}

	public void delete(User user) {
		String sql = "elete from user where id=?";
		Object[] args = new Object[] { user.getId() };
		super.update(sql, args);
	}

	public void update(User user) {
		String sql = "update user set username=?, birthday=?, money=? where id=?";
		Object[] args = new Object[] { user.getUsername(), user.getBirthday(),
				user.getMoney(), user.getId() };
		super.update(sql, args);
	}

}
