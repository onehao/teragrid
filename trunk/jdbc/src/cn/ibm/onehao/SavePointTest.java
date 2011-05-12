/**
 * 
 */
package cn.ibm.onehao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

/**
 * @author onehao
 *
 */
public class SavePointTest {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		test();
	}
	
	static void test() throws SQLException{
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		Savepoint sp = null;
		try {
			conn = JdbcUtils.getConnection();
			conn.setAutoCommit(false);//事务起点  mysql engine 是 InnoDB的时候是支持事务的
			st = conn.createStatement();
			
			String sql = "update user set money=money-10 where id=15";
			st.executeUpdate(sql);
			sp = conn.setSavepoint();
			
			sql = "update user set money=money-10 where id=12";
			st.executeUpdate(sql);
			
			sql = "select money from user where id=13";
			rs = st.executeQuery(sql);
			float money = 0.0f;
			while(rs.next()){
				money = rs.getFloat("money");
			}
			if(money > 1000)
				throw new RuntimeException("已经超过最大值！");
			sql = "update user set money=money+10 where id=13";
			st.executeUpdate(sql);
			conn.commit();//事务终点
		} catch(RuntimeException e){
			if(conn != null&&sp != null){
				conn.rollback(sp);
			conn.commit();
			}
			throw e;
		}catch(SQLException e){
			if(conn != null)
				conn.rollback();
			throw e;
		}finally {
			JdbcUtils.free(rs, st, conn);
		}
	}

}
