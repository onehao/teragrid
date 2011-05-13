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
	 */
	public static void main(String[] args) throws SQLException {
		int id = create();
		System.out.println("id: " + id);
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
}
