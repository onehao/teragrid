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
			//2.建立连接
			conn = DBCPJdbcUtils.getConnection(); //推荐 代码不罗嗦
			//conn = DBCPJdbcUtilsSingleton.getInstance().getConnection();//单例模式实现
			
			//3.创建语句
			st = conn.createStatement();
			
			//4.执行语句
			rs = st.executeQuery("select * from user");
			
			//5.处理结果
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
		//1.注册驱动
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());//产生两个一样的驱动 static一个 new一个
																  //依赖于 import com.mysql.jdbc.Driver; 更改驱动不能通过编译
		System.setProperty("jdbc.drivers", "com.mysql.jdbc.Driver:com.oracle.Driver");//另一种方式,冒号风格多个driver
		Class.forName("com.mysql.jdbc.Driver");//推荐：第三种方式 不一定会有实例。从classpath将类装载到虚拟机里。
											   //类装载自动调用static代码块。
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
		
		//2.建立连接
		//url格式：JDBC:子协议:子名称//主机名:端口/数据库名?属性名=属性值&
		//jdbc:mysql:///jdbc 连接本机，端口号是缺省的端口号
		String url = "jdbc:mysql://localhost:3306/jdbc";
		String user = "root";
		String password = "123456";
		Connection conn = DriverManager.getConnection(url, user, password);
	
		//3.创建语句
		Statement st = conn.createStatement();
		
		//4.执行语句
		ResultSet rs = st.executeQuery("select * from user");
		
		//5.处理结果
		while(rs.next()){
			System.out.println("id: "+rs.getInt("id") 
					+ "\tusername: " + rs.getString("username") 
					+ "\tpassword: " + rs.getString("password")
					+ "\tgroups: " + rs.getString("groups"));
		}
		
		//6.释放资源  晚获取早释放
		//最后创建的先关闭
		rs.close();
		st.close();
		conn.close();
	}

}
