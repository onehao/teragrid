/**
 * 
 */
package cn.ibm.onehao.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.ibm.onehao.JdbcUtils;
import cn.ibm.onehao.domain.User;

/**
 * @author onehao
 *
 */
public class UserDaoJdbcImpl implements UserDao {

	/* (non-Javadoc)
	 * @see cn.ibm.onehao.Dao.UserDao#addUser(cn.ibm.onehao.domain.User)
	 */
	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection(); //ÍÆ¼ö ´úÂë²»ÂÞàÂ
			String sql = "insert into user(username,password,groups,birthday,money) values(?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getGroups());
			ps.setDate(4, new java.sql.Date(user.getBirthday().getTime()));
			ps.setFloat(5, user.getMoney());
			int i = ps.executeUpdate();
		} catch(SQLException e){
			throw new DaoException(e.getMessage(),e);
		}finally {
			JdbcUtils.free(rs, ps, conn);
		}
	}

	/* (non-Javadoc)
	 * @see cn.ibm.onehao.Dao.UserDao#getUser(int)
	 */
	@Override
	public User getUser(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see cn.ibm.onehao.Dao.UserDao#findUser(java.lang.String, java.lang.String)
	 */
	@Override
	public User findUser(String loginName, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see cn.ibm.onehao.Dao.UserDao#update(cn.ibm.onehao.domain.User)
	 */
	@Override
	public void update(User user) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see cn.ibm.onehao.Dao.UserDao#delete(cn.ibm.onehao.domain.User)
	 */
	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub

	}

}
