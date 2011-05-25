/**
 * 
 */
package cn.ibm.onehao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;

/**
 * @author onehao
 *
 */
public class BatchTest {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		long start = System.currentTimeMillis();
		for(int i = 0;i < 100;i++)
			create(i);
		long end = System.currentTimeMillis();
		System.out.println("create:" + (end-start));
		
		start = System.currentTimeMillis();
		createBatch();
		end = System.currentTimeMillis();
		System.out.println("createBatch:" + (end-start));
	}

	static void create(int i) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			//2.建立连接
			conn = JdbcUtils.getConnection(); //推荐 代码不罗嗦
			//conn = JdbcUtilsSingleton.getInstance().getConnection();//单例模式实现
			String sql = "insert into user(username,birthday,money) values(?,?,?)";
			
			ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, "no batchname" + i);
			ps.setDate(2, new Date(System.currentTimeMillis()));
			ps.setFloat(3, 100f + i);
			ps.executeUpdate();
			
		} finally {
			JdbcUtils.free(rs, ps, conn);
		}
	}
	
	static void createBatch() throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			//2.建立连接
			conn = JdbcUtils.getConnection(); //推荐 代码不罗嗦
			//conn = JdbcUtilsSingleton.getInstance().getConnection();//单例模式实现
			String sql = "insert into user(username,birthday,money) values(?,?,?)";
			
			ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			for(int i = 0;i < 100;i++){
				ps.setString(1, "batchname" + i);
				ps.setDate(2, new Date(System.currentTimeMillis()));
				ps.setFloat(3, 100f + i);
				
				ps.addBatch();
			}
			int [] is = ps.executeBatch();
		} finally {
			JdbcUtils.free(rs, ps, conn);
		}
	}
}
