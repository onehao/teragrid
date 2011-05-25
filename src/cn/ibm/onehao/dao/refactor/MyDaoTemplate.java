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
import cn.ibm.onehao.domain.User;

/**
 * @author onehao
 *
 */
public class MyDaoTemplate {
	public Object find(String sql,Object[] args, RowMapper rowMapper){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection(); //ÍÆ¼ö ´úÂë²»ÂÞàÂ
			ps = conn.prepareStatement(sql);
			for(int i = 0; i < args.length; i++)
				ps.setObject(i + 1, args[i]);
			rs = ps.executeQuery();
			Object obj = null;
			while(rs.next()){
				obj = rowMapper.mapRow(rs);
			}
			return obj;
		}catch(SQLException e){
			throw new DaoException(e.getMessage(),e);
		}finally {
			JdbcUtils.free(rs, ps, conn);
		}
	}
	
}
