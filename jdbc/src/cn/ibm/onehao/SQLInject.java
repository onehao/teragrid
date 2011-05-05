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
public class SQLInject {
	public static void main(String[] args) throws SQLException{
		long start = System.currentTimeMillis();
		read("new1");
		long end = System.currentTimeMillis();
		System.out.println("read:" + (end-start));
		
//		read("'or 1 or'");
		start = System.currentTimeMillis();
		read1("new1");
		end = System.currentTimeMillis();
		System.out.println("read1:" + (end-start));
//		read1("'or 1 or'");
	}

	/**
	 * 
	 * @param name
	 * @throws SQLException
	 * @comment PreparedStatement ��ֹע�룬�������
	 */
	static void read(String name) throws SQLException{
		Connection conn = null;
		Statement st = null;
		PreparedStatement ps = null;//Ԥ��������SQLע�룩�������ַ��Ĺ��ˣ������Ż���ִ�кܶ��ʱ��
		ResultSet rs = null;
		try {
			//2.��������
			conn = JdbcUtils.getConnection(); //�Ƽ� ���벻���� ��������Ƚ�ռʱ��
			//conn = JdbcUtilsSingleton.getInstance().getConnection();//����ģʽʵ��
			
			//3.�������
		
			String sql = "select id,username,password,groups from user where username=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);//1 ��һ���ʺ�
			
			//4.ִ�����
			System.out.println("SQL: " + sql);
			rs = ps.executeQuery();
			
			//������
			long start = System.currentTimeMillis();
			String sql2 = "select id,username,password,groups from user";
			PreparedStatement ps2 = conn.prepareStatement(sql2);
			for(int i=0; i<500; i++){
			rs = ps2.executeQuery();
			};
			long end = System.currentTimeMillis();
			System.out.println("read inside function:" + (end-start));
			
			//5.������
			while(rs.next()){
				System.out.println("id: "+rs.getInt("id") 
						+ "\tusername: " + rs.getString("username") 
						+ "\tpassword: " + rs.getString("password")
						+ "\tgroups: " + rs.getString("groups"));
			}
			System.out.println("----------------below is using getObject()--------------------");
			rs.beforeFirst();
			while(rs.next()){
				System.out.println("id: "+rs.getObject("id") 
						+ "\tusername: " + rs.getObject("username") 
						+ "\tpassword: " + rs.getObject("password")
						+ "\tgroups: " + rs.getObject("groups"));
			}
			System.out.println("----------------above is using getObject()--------------------");
		} finally {
			JdbcUtils.free(rs, ps, conn);
		}
	}
	
	static void read1(String name) throws SQLException{
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			//2.��������
			conn = JdbcUtils.getConnection(); //�Ƽ� ���벻����
			//conn = JdbcUtilsSingleton.getInstance().getConnection();//����ģʽʵ��
			
			//3.�������
			st = conn.createStatement();
			String sql = "select id,username,password,groups from user where username='" + name + "'";
			
			//4.ִ�����
			System.out.println("SQL: " + sql);
			rs = st.executeQuery(sql);
			
			
			//������
			long start = System.currentTimeMillis();
			String sql2 = "select * from user";
			Statement st2 = conn.createStatement();
			for(int i=0; i<500; i++){
			rs = st2.executeQuery(sql2);
			};
			long end = System.currentTimeMillis();
			System.out.println("read1 inside function:" + (end-start));
			
			//5.������
			while(rs.next()){
				System.out.println("id: "+rs.getInt("id") 
						+ "\tusername: " + rs.getString("username") 
						+ "\tpassword: " + rs.getString("password")
						+ "\tgroups: " + rs.getString("groups"));
			}
			System.out.println("----------------below is using getObject()--------------------");
			rs.beforeFirst();
			while(rs.next()){
				System.out.println("id: "+rs.getObject("id") 
						+ "\tusername: " + rs.getObject("username") 
						+ "\tpassword: " + rs.getObject("password")
						+ "\tgroups: " + rs.getObject("groups"));
			}
			System.out.println("----------------above is using getObject()--------------------");
		} finally {
			JdbcUtils.free(rs, st, conn);
		}
	}
}
