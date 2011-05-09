/**
 * 
 */
package cn.ibm.onehao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * @author onehao
 *
 */
public class ClobTest {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException, IOException {
		// TODO Auto-generated method stub
//		create();
		read(2);
	}
	
	static Date read(int id) throws SQLException, IOException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Date birthday = null;
		try {
			//2.��������
			conn = JdbcUtils.getConnection(); //�Ƽ� ���벻����
			//conn = JdbcUtilsSingleton.getInstance().getConnection();//����ģʽʵ��
			
			//3.�������
			String sql = "select big_text from clob_test where id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			//4.ִ�����
			rs = ps.executeQuery();
			
			//5.������
			while(rs.next()){
				Clob clob = rs.getClob(1);
				Reader reader = clob.getCharacterStream();
//				reader = rs.getCharacterStream(1);//��һ�ַ�ʽ
//				String s = rs.getString(1);
				File file = new File("JdbcUtils_bak.java");
				Writer writer = new BufferedWriter(new FileWriter(file));
				char[] buff = new char[1024];
				for(int i=0;(i=reader.read(buff))>0;){
					writer.write(buff, 0, i);
				}
				writer.close();
				reader.close();
			}
			
		} finally {
			JdbcUtils.free(rs, ps, conn);
		}
		return birthday;
	}
	
	static void create() throws SQLException, IOException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			//2.��������
			conn = JdbcUtils.getConnection(); //�Ƽ� ���벻����
			//conn = JdbcUtilsSingleton.getInstance().getConnection();//����ģʽʵ��
			
			//3.�������
			String sql = "insert into clob_test(big_text) values(?)";
			
			ps = conn.prepareStatement(sql);
			File file = new File("src/cn/ibm/onehao/JdbcUtils.java");
			Reader reader = new BufferedReader(new FileReader(file));
			
			ps.setCharacterStream(1, reader, (int)file.length());//�ص��ע
			
//			ps.setString(1, x)
			
			
			//4.ִ�����
			int i = ps.executeUpdate();
			reader.close();
			System.out.println("i = " + i);
		} finally {
			JdbcUtils.free(rs, ps, conn);
		}
	}

}
