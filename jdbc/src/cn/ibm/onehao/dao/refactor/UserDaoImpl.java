/**
 * 
 */
package cn.ibm.onehao.dao.refactor;

import cn.ibm.onehao.domain.User;

/**
 * @author onehao
 * 
 */
public class UserDaoImpl extends AbstractDao {

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
