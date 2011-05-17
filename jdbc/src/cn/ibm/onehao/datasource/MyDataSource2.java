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
public class MyDataSource2 {
	private static String url = "jdbc:mysql://localhost:3306/jdbc";
	private static String user = "root";
	private static String password = "123456";
	
	private static int initCount = 1;
	private static int maxCount = 1;
	int currentCount = 0;
	
	
	LinkedList<Connection> connectionsPool = new LinkedList<Connection>();
	
	public MyDataSource2(){
		try {
			for(int i=0;i<initCount;i++)
				this.connectionsPool.addLast(this.createConnection());
				this.currentCount++;
			} catch (SQLException e) {
				throw new ExceptionInInitializerError(e);
			}
	}
	
	public Connection getConnection() throws SQLException{
		synchronized (connectionsPool) { //�������
			if(this.connectionsPool.size() > 0 )
				return this.connectionsPool.removeFirst();
			if(this.currentCount < maxCount){
				this.currentCount++;
				return this.createConnection();
			}
			
			throw new SQLException("��û������");
		}
	}
	
	public void free(Connection conn){
			this.connectionsPool.addLast(conn);
	}
	
	private Connection createConnection() throws SQLException{
		Connection realConn = DriverManager.getConnection(url,user,password);
		MyConnection myConnection = new MyConnection(realConn,this);
		return myConnection;
	}
}