/**
 * 
 */
package cn.ibm.onehao.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import cn.ibm.onehao.JdbcUtils;
import cn.ibm.onehao.dao.DaoException;
import cn.ibm.onehao.dao.UserDao;
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
		//模板或策略模式进行优化
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection(); //推荐 代码不罗嗦
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
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		try {
			conn = JdbcUtils.getConnection(); //推荐 代码不罗嗦
			String sql = "select id, username, password, groups, birthday, money from user where id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			rs = ps.executeQuery();
			while(rs.next()){
				user = mappingUser(rs);
			}
		}catch(SQLException e){
			throw new DaoException(e.getMessage(),e);
		}finally {
			JdbcUtils.free(rs, ps, conn);
		}
	return user;
	}

	/* (non-Javadoc)
	 * @see cn.ibm.onehao.Dao.UserDao#findUser(java.lang.String, java.lang.String)
	 */
	@Override
	public User findUser(String loginName, String password) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		try {
			conn = JdbcUtils.getConnection(); //推荐 代码不罗嗦
			String sql = "select id, username, password, groups, birthday, money from user where username=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, loginName);
			rs = ps.executeQuery();
			while(rs.next()){
				user = mappingUser(rs);
			}
		}catch(SQLException e){
			throw new DaoException(e.getMessage(),e);
		}finally {
			JdbcUtils.free(rs, ps, conn);
		}
	return user;
	}

	/**
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	private User mappingUser(ResultSet rs) throws SQLException {
		User user = new User();
		user.setId(rs.getInt("id"));
		user.setUsername(rs.getString("username"));
		user.setPassword(rs.getString("password"));
		user.setGroups(rs.getString("groups"));
		user.setBirthday(rs.getDate("birthday"));
		user.setMoney(rs.getFloat("money"));
		return user;
	}

	/* (non-Javadoc)
	 * @see cn.ibm.onehao.Dao.UserDao#update(cn.ibm.onehao.domain.User)
	 */
	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement  ps = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection(); //推荐 代码不罗嗦
			String sql = "update user set username=?, password=?, groups=?, birthday=?, money=? where id=?" ;
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getGroups());
			ps.setDate(4, new java.sql.Date(user.getBirthday().getTime()));
			ps.setFloat(5, user.getMoney());
			ps.setInt(6, user.getId());
			int i = ps.executeUpdate();
		} catch(SQLException e){
			throw new DaoException(e.getMessage(),e);
		}finally {
			JdbcUtils.free(rs, ps, conn);
		}
	}

	/* (non-Javadoc)
	 * @see cn.ibm.onehao.Dao.UserDao#delete(cn.ibm.onehao.domain.User)
	 */
	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection(); //推荐 代码不罗嗦
			st = conn.createStatement();
			String sql = "delete from user where id=" + user.getId();
			int i = st.executeUpdate(sql);
		} catch(SQLException e){
			throw new DaoException(e.getMessage(),e);
		}finally {
			JdbcUtils.free(rs, st, conn);
		}
	}

}
