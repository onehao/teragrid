/**
 * 
 */
package cn.ibm.onehao.dao.refactor;

import java.sql.ResultSet;
import java.sql.SQLException;

import cn.ibm.onehao.domain.Account;

/**
 * @author onehao
 *
 */
public class AccountDaoImpl extends AbstractDao {
	
	public Account findAccount(int id){
		String sql = "select id, name, money from account where id=?";
		Object[] args = new Object[]{id};
		Object account = super.find(sql, args);
		return (Account)account;
	}

	/* (non-Javadoc)
	 * @see cn.ibm.onehao.dao.refactor.AbstractDao#rowMapper(java.sql.ResultSet)
	 */
	@Override
	protected Object rowMapper(ResultSet rs) throws SQLException {
		Account a = new Account();
		a.setId(rs.getInt("id"));
		//...
		return a;
	}

}
