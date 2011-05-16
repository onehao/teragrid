/**
 * 
 */
package cn.ibm.onehao;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import cn.ibm.onehao.domain.User;

/**
 * @author onehao
 *
 */
public class ORMTest {

	/**
	 * @param args
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws SQLException 
	 * @throws IllegalArgumentException 
	 */
	public static void main(String[] args) throws IllegalArgumentException, SQLException, IllegalAccessException, InvocationTargetException {
		User user = getUser("select * from user where id=1");
		System.out.println(user);
	}

	static User getUser(String sql) throws SQLException, IllegalArgumentException, IllegalAccessException, InvocationTargetException{
		Connection conn = null;
		PreparedStatement ps = null;//Ԥ��������SQLע�룩�������ַ��Ĺ��ˣ������Ż���ִ�кܶ��ʱ��
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection(); //�Ƽ� ���벻���� ��������Ƚ�ռʱ��
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int count = rsmd.getColumnCount();
			String[] colNames = new String[count];
			for(int i=1;i<=count;i++){
				colNames[i-1] = rsmd.getColumnName(i);
			}
			
			User user = null;
			while(rs.next()){
				user = new User();
				for(int i=0;i<colNames.length;i++){
					String colName = colNames[i];
					String methodName = "set" + colName.replace(colName.charAt(0), colName.toUpperCase().charAt(0));//����ʹ�Äe��
					//���ݿ����������xxx_sss
					Method[] ms = user.getClass().getMethods();
					for(Method m : ms){
						if(methodName.equals(m.getName())){
							m.invoke(user, rs.getObject(colName));
						}
					}
				}
			}
			return user;
		} finally {
			JdbcUtils.free(rs, ps, conn);
		}
	}
}
