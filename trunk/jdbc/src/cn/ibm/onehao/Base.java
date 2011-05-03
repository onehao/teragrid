package cn.ibm.onehao;

import java.sql.*;

import com.mysql.jdbc.Driver;


public class Base {

	/**
	 * @param args
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub

		Base.test();
	}
	static void test() throws SQLException, ClassNotFoundException{
//		Class.forName(className)
		//1.ע������
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());//��������һ�������� staticһ�� newһ��
																  //������ import com.mysql.jdbc.Driver; ������������ͨ������
		System.setProperty("jdbc.drivers", "com.mysql.jdbc.Driver:com.oracle.Driver");//��һ�ַ�ʽ,ð�ŷ����driver
		Class.forName("com.mysql.jdbc.Driver");//�Ƽ��������ַ�ʽ ��һ������ʵ������classpath����װ�ص�������
											   //��װ���Զ�����static����顣
		/**
		 * in com.mysql.jdbc.Driver
		 * static {
				try {
					java.sql.DriverManager.registerDriver(new Driver());
					} catch (SQLException E) {
				throw new RuntimeException("Can't register driver!");
					}
				  }
		 */
		
		//2.��������
		//url��ʽ��JDBC:��Э��:������//������:�˿�/���ݿ���?������=����ֵ&
		//jdbc:mysql:///jdbc ���ӱ������˿ں���ȱʡ�Ķ˿ں�
		String url = "jdbc:mysql://localhost:3306/test";
		String user = "root";
		String password = "123456";
		Connection conn = DriverManager.getConnection(url, user, password);
	
		//3.�������
		Statement st = conn.createStatement();
		
		//4.ִ�����
		ResultSet rs = st.executeQuery("select * from user");
		
		//5.������
		while(rs.next()){
			System.out.println("id: "+rs.getInt("id") 
					+ "\tusername: " + rs.getString("username") 
					+ "\tpassword: " + rs.getString("password")
					+ "\tgroups: " + rs.getString("groups"));
		}
		
		//6.�ͷ���Դ
		rs.close();
		st.close();
		conn.close();
	}

}
