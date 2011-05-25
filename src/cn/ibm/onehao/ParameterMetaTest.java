/**
 * 
 */
package cn.ibm.onehao;

import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author onehao
 *
 */
public class ParameterMetaTest {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Object[] parms = new Object[]{"otherapi",100f};
		read("select * from user where username=? and money>?",
				parms);
	}
	
	static void read(String sql,Object[] parms) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;//Ԥ��������SQLע�룩�������ַ��Ĺ��ˣ������Ż���ִ�кܶ��ʱ��
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection(); //�Ƽ� ���벻���� ��������Ƚ�ռʱ��
			ps = conn.prepareStatement(sql);
			ParameterMetaData pmd = ps.getParameterMetaData();
			int count = pmd.getParameterCount();
			System.out.println(count);
			for(int i =1;i<=count;i++){
//				System.out.print(pmd.getParameterClassName(i) + "\t");//û���Թ�
//				System.out.print(pmd.getParameterType(i) + "\t");
//				System.out.println(pmd.getParameterTypeName(i));
				ps.setObject(i, parms[i-1]);
			}
			rs = ps.executeQuery();
			while(rs.next()){
				System.out.println("id: "+rs.getInt("id") 
						+ "\tusername: " + rs.getString("username") 
						+ "\tbirthday: " + rs.getDate("birthday")
						+ "\tmoney: " + rs.getFloat("money"));
			}
		} finally {
			JdbcUtils.free(rs, ps, conn);
		}
	}

}
