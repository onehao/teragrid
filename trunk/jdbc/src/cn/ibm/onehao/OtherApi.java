/**
 * 
 */
package cn.ibm.onehao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author onehao
 *
 */
public class OtherApi {

	/**
	 * @param args
	 * @throws SQLException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws SQLException, InterruptedException {
//		int id = create();//test1
//		System.out.println("id: " + id);
//		read();//test2
		read2();//test3
	}

	
	static void read2() throws SQLException, InterruptedException{
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			//2.建立连接
			conn = JdbcUtils.getConnection(); //推荐 代码不罗嗦
			//conn = JdbcUtilsSingleton.getInstance().getConnection();//单例模式实现
			
			//3.创建语句
			st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			
			//4.执行语句
			rs = st.executeQuery("select id,username,birthday,money from user");
			
			//5.处理结果
			while(rs.next()){
				int id = rs.getInt("id");//有些数据库调用第二次getXXX 同一字段会报错。
				System.out.println("show " + id);
				Thread.sleep(2000);
				System.out.println("id: " + id + "..." 
						+ "\tusername: " + rs.getString("username") 
						+ "\tbirthday: " + rs.getDate("birthday")
						+ "\tmoney: " + rs.getFloat("money"));
				String name = rs.getString("username");
				if("otherapi1".equals(name)){
					rs.updateFloat("money", 300f);
					rs.updateRow();
				}
			}
		} finally {
			JdbcUtils.free(rs, st, conn);
		}
	}
	
	
	//创建后返回主键
	static int create() throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			//2.建立连接
			conn = JdbcUtils.getConnection(); //推荐 代码不罗嗦
			//conn = JdbcUtilsSingleton.getInstance().getConnection();//单例模式实现
			String sql = "insert into user(username,birthday,money) values('name2 gk','1983-08-29',400)";
			
			ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			ps.executeUpdate();
			
			rs = ps.getGeneratedKeys();//可能主键不是整数，或者复合主键，所以返回rs
			int id = 0;
			if(rs.next()){
				id = rs.getInt(1);
			}
			return id;
		} finally {
			JdbcUtils.free(rs, ps, conn);
		}
	}
	
	static void read() throws SQLException{
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			//2.建立连接
			conn = JdbcUtils.getConnection(); //推荐 代码不罗嗦
			//conn = JdbcUtilsSingleton.getInstance().getConnection();//单例模式实现
			
			//3.创建语句
			st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			
			//4.执行语句
			rs = st.executeQuery("select id,username,birthday,money from user");
			
			//5.处理结果
			while(rs.next()){
				System.out.println("id: "+rs.getInt("id") 
						+ "\tusername: " + rs.getString("username") 
						+ "\tbirthday: " + rs.getDate("birthday")
						+ "\tmoney: " + rs.getFloat("money"));
				String name = rs.getString("username");
				if("otherapi1".equals(name)){
					rs.updateFloat("money", 300f);
					rs.updateRow();
				}
			}
		} finally {
			JdbcUtils.free(rs, st, conn);
		}
	}
}
