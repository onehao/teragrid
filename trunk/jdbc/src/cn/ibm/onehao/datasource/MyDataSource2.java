/**
 * 
 */
package cn.ibm.onehao.datasource;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.sql.DataSource;

/**
 * @author onehao
 *
 */
public class MyDataSource2 implements DataSource{
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
		synchronized (connectionsPool) { //多个并发
			if(this.connectionsPool.size() > 0 )
				return this.connectionsPool.removeFirst();
			if(this.currentCount < maxCount){
				this.currentCount++;
				return this.createConnection();
			}
			
			throw new SQLException("已没有连接");
		}
	}
	
	public void free(Connection conn){
			this.connectionsPool.addLast(conn);
	}
	
	private Connection createConnection() throws SQLException{
		Connection realConn = DriverManager.getConnection(url,user,password);
//		MyConnection myConnection = new MyConnection(realConn,this);
//		return myConnection;
		
		//****通过代理模式构造****
		MyConnectionHandler proxy = new MyConnectionHandler(this);
		return proxy.bind(realConn);
	}

	/* (non-Javadoc)
	 * @see javax.sql.CommonDataSource#getLogWriter()
	 */
	@Override
	public PrintWriter getLogWriter() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.sql.CommonDataSource#setLogWriter(java.io.PrintWriter)
	 */
	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see javax.sql.CommonDataSource#setLoginTimeout(int)
	 */
	@Override
	public void setLoginTimeout(int seconds) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see javax.sql.CommonDataSource#getLoginTimeout()
	 */
	@Override
	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see java.sql.Wrapper#unwrap(java.lang.Class)
	 */
	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see java.sql.Wrapper#isWrapperFor(java.lang.Class)
	 */
	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see javax.sql.DataSource#getConnection(java.lang.String, java.lang.String)
	 */
	@Override
	public Connection getConnection(String username, String password)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}
