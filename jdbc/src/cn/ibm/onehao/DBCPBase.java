package cn.ibm.onehao;

import java.sql.*;



public class DBCPBase {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

//		template();
		
		for(int i=0;i<10;i++){
			Connection conn = DBCPJdbcUtils.getConnection();
			System.out.println(conn.getClass().getName());
			DBCPJdbcUtils.free(null, null, conn);
		}
	}
	
	static void template() throws Exception{
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			//2.��������
			conn = DBCPJdbcUtils.getConnection(); //�Ƽ� ���벻����
			//conn = DBCPJdbcUtilsSingleton.getInstance().getConnection();//����ģʽʵ��
			
			//3.�������
			st = conn.createStatement();
			
			//4.ִ�����
			rs = st.executeQuery("select * from user");
			
			//5.������
			while(rs.next()){
				System.out.println("id: "+rs.getInt("id") 
						+ "\tusername: " + rs.getString("username") 
						+ "\tpassword: " + rs.getString("password")
						+ "\tgroups: " + rs.getString("groups"));
			}
			
		} finally {
			DBCPJdbcUtils.free(rs, st, conn);
		}
		
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
		String url = "jdbc:mysql://localhost:3306/jdbc";
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
		
		//6.�ͷ���Դ  ���ȡ���ͷ�
		//��󴴽����ȹر�
		rs.close();
		st.close();
		conn.close();
	}

}
