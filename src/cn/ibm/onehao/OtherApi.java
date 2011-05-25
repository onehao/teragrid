/**
 * 
 */
package cn.ibm.onehao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author onehao
 *
 */
public class OtherApi {

	/**
	 * @param args
	 * @throws SQLException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws SQLException, InterruptedException {
//		int id = create();//test1
//		System.out.println("id: " + id);
//		read();//test2
		read2();//test3
	}

	
	static void read2() throws SQLException, InterruptedException{
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			//2.��������
			conn = JdbcUtils.getConnection(); //�Ƽ� ���벻����
			//conn = JdbcUtilsSingleton.getInstance().getConnection();//����ģʽʵ��
			
			//3.�������
			st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			
			//4.ִ�����
			rs = st.executeQuery("select id,username,birthday,money from user");
			
			//5.������
			while(rs.next()){
				int id = rs.getInt("id");//��Щ���ݿ���õڶ���getXXX ͬһ�ֶλᱨ��
				System.out.println("show " + id);
				Thread.sleep(2000);
				System.out.println("id: " + id + "..." 
						+ "\tusername: " + rs.getString("username") 
						+ "\tbirthday: " + rs.getDate("birthday")
						+ "\tmoney: " + rs.getFloat("money"));
				String name = rs.getString("username");
				if("otherapi1".equals(name)){
					rs.updateFloat("money", 300f);
					rs.updateRow();
				}
			}
		} finally {
			JdbcUtils.free(rs, st, conn);
		}
	}
	
	
	//�����󷵻�����
	static int create() throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			//2.��������
			conn = JdbcUtils.getConnection(); //�Ƽ� ���벻����
			//conn = JdbcUtilsSingleton.getInstance().getConnection();//����ģʽʵ��
			String sql = "insert into user(username,birthday,money) values('name2 gk','1983-08-29',400)";
			
			ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			ps.executeUpdate();
			
			rs = ps.getGeneratedKeys();//���������������������߸������������Է���rs
			int id = 0;
			if(rs.next()){
				id = rs.getInt(1);
			}
			return id;
		} finally {
			JdbcUtils.free(rs, ps, conn);
		}
	}
	
	static void read() throws SQLException{
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			//2.��������
			conn = JdbcUtils.getConnection(); //�Ƽ� ���벻����
			//conn = JdbcUtilsSingleton.getInstance().getConnection();//����ģʽʵ��
			
			//3.�������
			st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			
			//4.ִ�����
			rs = st.executeQuery("select id,username,birthday,money from user");
			
			//5.������
			while(rs.next()){
				System.out.println("id: "+rs.getInt("id") 
						+ "\tusername: " + rs.getString("username") 
						+ "\tbirthday: " + rs.getDate("birthday")
						+ "\tmoney: " + rs.getFloat("money"));
				String name = rs.getString("username");
				if("otherapi1".equals(name)){
					rs.updateFloat("money", 300f);
					rs.updateRow();
				}
			}
		} finally {
			JdbcUtils.free(rs, st, conn);
		}
	}
}
