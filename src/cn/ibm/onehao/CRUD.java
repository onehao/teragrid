/**
 * 
 */
package cn.ibm.onehao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author onehao
 * 2011-05-04
 *
 */
public class CRUD {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
//		update();
//		create();
//		delete();
		read();
	}
	
	static void delete() throws SQLException{
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			//2.建立连接
			conn = JdbcUtils.getConnection(); //推荐 代码不罗嗦
			//conn = JdbcUtilsSingleton.getInstance().getConnection();//单例模式实现
			
			//3.创建语句
			st = conn.createStatement();
			
			String sql = "delete from user where id>2 and id<5 ";
			
			//4.执行语句
			int i = st.executeUpdate(sql);
			System.out.println("i = " + i);
		} finally {
			JdbcUtils.free(rs, st, conn);
		}
	}
	
	static void update() throws SQLException{
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			//2.建立连接
			conn = JdbcUtils.getConnection(); //推荐 代码不罗嗦
			//conn = JdbcUtilsSingleton.getInstance().getConnection();//单例模式实现
			
			//3.创建语句
			st = conn.createStatement();
			
			String sql = "update user set groups='g2' where id=10 ";
			
			//4.执行语句
			int i = st.executeUpdate(sql);
			System.out.println("i = " + i);
		} finally {
			JdbcUtils.free(rs, st, conn);
		}
	}

	
	static void create() throws SQLException{
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			//2.建立连接
			conn = JdbcUtils.getConnection(); //推荐 代码不罗嗦
			//conn = JdbcUtilsSingleton.getInstance().getConnection();//单例模式实现
			
			//3.创建语句
			st = conn.createStatement();
			
			String sql = "insert into user(username,password,groups) values('new2','20110504','g1')";
			
			//4.执行语句
			int i = st.executeUpdate(sql);
			System.out.println("i = " + i);
		} finally {
			JdbcUtils.free(rs, st, conn);
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
			st = conn.createStatement();
			
			//4.执行语句
			rs = st.executeQuery("select id,username,password,groups from user");
			
			//5.处理结果
			while(rs.next()){
				System.out.println("id: "+rs.getInt("id") 
						+ "\tusername: " + rs.getString("username") 
						+ "\tpassword: " + rs.getString("password")
						+ "\tgroups: " + rs.getString("groups"));
			}
			System.out.println("----------------below is using getObject()--------------------");
			rs.beforeFirst();
			while(rs.next()){
				System.out.println("id: "+rs.getObject("id") 
						+ "\tusername: " + rs.getObject("username") 
						+ "\tpassword: " + rs.getObject("password")
						+ "\tgroups: " + rs.getObject("groups"));
			}
			System.out.println("----------------above is using getObject()--------------------");
			
		} finally {
			JdbcUtils.free(rs, st, conn);
		}
	}
}
