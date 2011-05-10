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
			//2.��������
			conn = JdbcUtils.getConnection(); //�Ƽ� ���벻����
			//conn = JdbcUtilsSingleton.getInstance().getConnection();//����ģʽʵ��
			
			//3.�������
			String sql = "select birthday from user where id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			//4.ִ�����
			rs = ps.executeQuery();
			
			//5.������
			while(rs.next()){
				birthday = rs.getDate("birthday"); //���ഫ������ Ҳ���Բ�ת����
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
			//2.��������
			conn = JdbcUtils.getConnection(); //�Ƽ� ���벻����
			//conn = JdbcUtilsSingleton.getInstance().getConnection();//����ģʽʵ��
			
			//3.�������
			String sql = "insert into user(username,password,groups,birthday,money) values(?,?,?,?,?)";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3, groups);
			ps.setDate(4, new java.sql.Date(birthday.getTime()));
			ps.setFloat(5, money);
			
			
			//4.ִ�����
			int i = ps.executeUpdate();
			System.out.println("i = " + i);
		} finally {
			JdbcUtils.free(rs, ps, conn);
		}
	}

}
