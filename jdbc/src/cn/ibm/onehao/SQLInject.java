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
 *
 */
public class SQLInject {
	public static void main(String[] args) throws SQLException{
//		read("new1");
		read("'or 1 or'");
	}

	static void read(String name) throws SQLException{
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
			String sql = "select id,username,password,groups from user where username='" + name +"'";
			
			System.out.println("SQL: " + sql);
			
			rs = st.executeQuery(sql);
			
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
