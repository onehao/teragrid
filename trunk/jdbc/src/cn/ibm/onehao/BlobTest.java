/**
 * 
 */
package cn.ibm.onehao;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * @author onehao
 *
 */
public class BlobTest {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException, IOException {
		// TODO Auto-generated method stub
//		create();
		read(1);
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
			String sql = "select big_bit from blob_test where id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			//4.ִ�����
			rs = ps.executeQuery();
			
			//5.������
			while(rs.next()){
				InputStream in = rs.getBinaryStream(1);
				//�ڶ��ַ�ʽ
//				Blob blob = rs.getBlob(1);
//				InputStream in = blob.getBinaryStream();
				File file = new File("src/cn/ibm/onehao/genout/bsd_bak.jpeg");
				OutputStream out = new BufferedOutputStream(new FileOutputStream(file));
				byte[] buff = new byte[1024];
				for(int i=0;(i=in.read(buff))>0;){
					out.write(buff, 0, i);
				}
				out.close();
				in.close();
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
			String sql = "insert into blob_test(big_bit) values(?)";
			
			ps = conn.prepareStatement(sql);
			File file = new File("src/cn/ibm/onehao/pic/bsd.jpg");// 64kb ���µ��ļ�
			InputStream in = new BufferedInputStream(new FileInputStream(file));
			
			ps.setBinaryStream(1, in, (int)file.length());
			
			//4.ִ�����
			int i = ps.executeUpdate();
			in.close();
			System.out.println("i = " + i);
		} finally {
			JdbcUtils.free(rs, ps, conn);
		}
	}

}
