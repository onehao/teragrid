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
 * @see �������ʵ������
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
		//��������
		return DriverManager.getConnection(url, user, password);
	}
	
	public static void free(ResultSet rs,Statement st,Connection conn){
		try{if(rs != null)
			rs.close(); //�����׳��쳣������䲻ִ�С����Ե�������try finally ������������
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
