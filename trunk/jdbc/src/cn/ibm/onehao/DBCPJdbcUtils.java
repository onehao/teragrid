package cn.ibm.onehao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

import cn.ibm.onehao.datasource.MyDataSource2;

/**
 * 
 * @author onehao
 * @since 2011-05-04
 * @see 不会产生实例的类
 */

public final class DBCPJdbcUtils {
	private static String url = "jdbc:mysql://localhost:3306/jdbc";
	private static String user = "root";
	private static String password = "123456";

	private static DataSource myDataSource = null;

	private DBCPJdbcUtils() {

	}

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			 myDataSource = new MyDataSource2();
			// Properties prop = new Properties();
			// prop.setProperty("driverClassName", "com.mysql.jdbc.Driver");
			Properties prop = new Properties();
			InputStream is = DBCPJdbcUtils.class.getClassLoader()
					.getResourceAsStream("dbcpconfig.properties");
			prop.load(is);
			myDataSource = BasicDataSourceFactory.createDataSource(prop);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ExceptionInInitializerError(e);
		}
	}

	public static Connection getConnection() throws SQLException {
		// 建立连接
		// return DriverManager.getConnection(url, user, password);
		return myDataSource.getConnection();
	}

	public static void free(ResultSet rs, Statement st, Connection conn) {
		try {
			if (rs != null)
				rs.close(); // 避免抛出异常其他语句不执行。所以单独放在try finally 其他两个类似
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if (st != null)
					st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (conn != null) {
					try {
						 conn.close();
//						myDataSource.free(conn);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
