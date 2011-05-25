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
 * @see 会产生一个实例
 */

public final class JdbcUtilsSingleton {
	private String url = "jdbc:mysql://localhost:3306/test";
	private String user = "root";
	private String password = "123456";
	
	//private static JdbcUtilsSingleton instance = new JdbcUtilsSingleton();
	private static JdbcUtilsSingleton instance = null;
	
	private JdbcUtilsSingleton(){
		
	}
	
	public static JdbcUtilsSingleton getInstance(){
		if(instance == null){
			synchronized(JdbcUtilsSingleton.class){
				if(instance == null){//多线程这行不能少 JDK1.5以上不会再有问题
					instance = new JdbcUtilsSingleton();
				}
			}
		}
		return instance;
	}
	
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new ExceptionInInitializerError(e);
		}
	}
	
	public Connection getConnection() throws SQLException{
		//建立连接
		return DriverManager.getConnection(url, user, password);
	}
	
	public void free(ResultSet rs,Statement st,Connection conn){
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
