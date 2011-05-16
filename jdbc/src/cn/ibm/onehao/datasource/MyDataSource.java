/**
 * 
 */
package cn.ibm.onehao.datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 * @author onehao
 *
 */
public class MyDataSource {
	private static String url = "jdbc:mysql://localhost:3306/jdbc";
	private static String user = "root";
	private static String password = "123456";
	
	
	private LinkedList<Connection> connectionsPool = new LinkedList<Connection>();
	
	public MyDataSource(){
		try {
			for(int i=0;i<5;i++)
				this.connectionsPool.addLast(this.createConnection());
			} catch (SQLException e) {
				throw new ExceptionInInitializerError(e);
			}
	}
	
	public Connection getConnection(){
		return this.connectionsPool.removeFirst();
	}
	
	public void free(Connection conn){
		this.connectionsPool.addLast(conn);
	}
	
	private Connection createConnection() throws SQLException{
		return DriverManager.getConnection(url,user,password);
	}
}
