package cn.ibm.onehao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * @author onehao
 * @since 2011-05-04
 * @see 不会产生实例的类
 */

public final class JdbcUtils {
	private static String url = "jdbc:mysql://localhost:3306/test";
	private static String user = "root";
	private static String password = "123456";
	
	private JdbcUtils(){
		
	}
	
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new ExceptionInInitializerError(e);
		}
	}
	
	public static Connection getConnection() throws SQLException{
		//建立连接
		return DriverManager.getConnection(url, user, password);
	}
	
	public static void free(ResultSet rs,Statement st,Connection conn){
		try{if(rs != null)
			rs.close(); //避免抛出异常其他语句不执行。所以单独放在try finally 其他两个类似
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
		
			try{
				if(st != null)
					st.close();
			}catch(SQLException e){
				e.printStackTrace();
			}finally{
				if(conn != null){
					try{
						conn.close();
					}catch(SQLException e){
						e.printStackTrace();
					}
				}
			}
		}
		
	}
}
