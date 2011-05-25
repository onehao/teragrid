/**
 * 
 */
package cn.ibm.onehao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author onehao
 *
 */
public class ResultSetMetadataTest {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		List<Map<String, Object>> data = read("select id,username as n from user");
		System.out.println(data);
	}

	static List<Map<String,Object>> read(String sql) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;//预处理（消除SQL注入），特殊字符的过滤，性能优化（执行很多次时）
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection(); //推荐 代码不罗嗦 这个动作比较占时间
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int count = rsmd.getColumnCount();
			String[] colNames = new String[count];
			for(int i=1;i<=count;i++){
//				System.out.print(rsmd.getColumnClassName(i) + "\t");
//				System.out.print(rsmd.getColumnName(i) + "\t");
//				System.out.println(rsmd.getColumnLabel(i));
				colNames[i-1] = rsmd.getColumnName(i);
			}
			List<Map<String,Object>> datas = new ArrayList<Map<String,Object>>();
			while(rs.next()){
				Map<String,Object> data = new HashMap<String,Object>();
				for(int i=0;i<colNames.length;i++){
				data.put(colNames[i], rs.getObject(colNames[i]));
				}
				datas.add(data);
			}
			return datas;
		} finally {
			JdbcUtils.free(rs, ps, conn);
		}
	}
}
