/**
 * 
 */
package cn.ibm.onehao.dao.refactor;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author onehao
 *
 */
public interface RowMapper {
	public Object mapRow(ResultSet rs) throws SQLException;
}
