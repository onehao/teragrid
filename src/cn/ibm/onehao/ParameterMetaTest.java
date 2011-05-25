/**
 * 
 */
package cn.ibm.onehao;

import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author onehao
 *
 */
public class ParameterMetaTest {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Object[] parms = new Object[]{"otherapi",100f};
		read("select * from user where username=? and money>?",
				parms);
	}
	
	static void read(String sql,Object[] parms) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;//预处理（消除SQL注入），特殊字符的过滤，性能优化（执行很多次时）
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection(); //推荐 代码不罗嗦 这个动作比较占时间
			ps = conn.prepareStatement(sql);
			ParameterMetaData pmd = ps.getParameterMetaData();
			int count = pmd.getParameterCount();
			System.out.println(count);
			for(int i =1;i<=count;i++){
//				System.out.print(pmd.getParameterClassName(i) + "\t");//没调试过
//				System.out.print(pmd.getParameterType(i) + "\t");
//				System.out.println(pmd.getParameterTypeName(i));
				ps.setObject(i, parms[i-1]);
			}
			rs = ps.executeQuery();
			while(rs.next()){
				System.out.println("id: "+rs.getInt("id") 
						+ "\tusername: " + rs.getString("username") 
						+ "\tbirthday: " + rs.getDate("birthday")
						+ "\tmoney: " + rs.getFloat("money"));
			}
		} finally {
			JdbcUtils.free(rs, ps, conn);
		}
	}

}
