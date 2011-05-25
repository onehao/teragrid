/**
 * 
 */
package cn.ibm.onehao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

/**
 * @author onehao
 *
 */
public class DateTest {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
//		create("dateTest1","pass","g5",new Date(),500.0f);
		Date d = read(11);
		System.out.println(d);
	}
	
	static Date read(int id) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Date birthday = null;
		try {
			//2.建立连接
			conn = JdbcUtils.getConnection(); //推荐 代码不罗嗦
			//conn = JdbcUtilsSingleton.getInstance().getConnection();//单例模式实现
			
			//3.创建语句
			String sql = "select birthday from user where id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			//4.执行语句
			rs = ps.executeQuery();
			
			//5.处理结果
			while(rs.next()){
				birthday = rs.getDate("birthday"); //子类传到父类 也可以不转换。
//				birthday = new Date(rs.getDate("birthday").getTime());
			}
			
		} finally {
			JdbcUtils.free(rs, ps, conn);
		}
		return birthday;
	}
	
	static void create(String username,String password, String groups, Date birthday,float money) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			//2.建立连接
			conn = JdbcUtils.getConnection(); //推荐 代码不罗嗦
			//conn = JdbcUtilsSingleton.getInstance().getConnection();//单例模式实现
			
			//3.创建语句
			String sql = "insert into user(username,password,groups,birthday,money) values(?,?,?,?,?)";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3, groups);
			ps.setDate(4, new java.sql.Date(birthday.getTime()));
			ps.setFloat(5, money);
			
			
			//4.执行语句
			int i = ps.executeUpdate();
			System.out.println("i = " + i);
		} finally {
			JdbcUtils.free(rs, ps, conn);
		}
	}

}
