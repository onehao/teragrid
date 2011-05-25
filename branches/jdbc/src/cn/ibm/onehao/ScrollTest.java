/**
 * 
 */
package cn.ibm.onehao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author onehao
 *
 */
public class ScrollTest {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		scroll();
	}

	static void scroll() throws SQLException{
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			//2.��������
			conn = JdbcUtils.getConnection(); //�Ƽ� ���벻����
			st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			
			st = conn.createStatement();
			
			rs = st.executeQuery("select id,username,password,groups from user");
//			rs = st.executeQuery("select id,username,password,groups from user limit 5,3");//mysql ֧�ַ�ҳ
			//5.������
			while(rs.next()){
				System.out.println("id: "+rs.getInt("id") 
						+ "\tusername: " + rs.getString("username") 
						+ "\tpassword: " + rs.getString("password")
						+ "\tgroups: " + rs.getString("groups"));
			}
			System.out.println("------");
			//���ݿⲻ֧�ַ�ҳ��ѯ��ʱ����
			rs.absolute(5);
			int i = 0;
			while(rs.next()&& i<3){
				System.out.println("id: "+rs.getInt("id") 
						+ "\tusername: " + rs.getString("username") 
						+ "\tpassword: " + rs.getString("password")
						+ "\tgroups: " + rs.getString("groups"));
			}
			
		} finally {
			JdbcUtils.free(rs, st, conn);
		}
	}
}
