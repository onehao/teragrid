/**
 * 
 */
package cn.ibm.onehao.dao.refactor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.ibm.onehao.JdbcUtils;
import cn.ibm.onehao.dao.DaoException;

/**
 * @author onehao
 *
 */
public class AbstractDao {
	
	/**
	 * @author onehao
	 * @since 2011-05-20
	 * @param sql,args
	 */
	public int update(String sql,Object[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement  ps = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection(); //ÍÆ¼ö ´úÂë²»ÂÞàÂ
			ps = conn.prepareStatement(sql);
			for(int i = 0; i < args.length; i++)
				ps.setObject(i + 1, args[i]);
			return ps.executeUpdate();
		} catch(SQLException e){
			throw new DaoException(e.getMessage(),e);
		}finally {
			JdbcUtils.free(rs, ps, conn);
		}
	}
}
