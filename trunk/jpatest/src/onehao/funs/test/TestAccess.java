package onehao.funs.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import onehao.vo.test.User;

public class TestAccess {
	private Connection conn = null;
	private Statement stmt = null;
	private PreparedStatement prepstmt = null;
	private static BeansConstants CONST = BeansConstants.getInstance();

	// ����һ��ȫ����,����������ݿ�Ĳ���,�����ݿ����� �����û��� �����

	/**
	 * �������ݿ�����Ӻͷ�����
	 */
	public TestAccess() throws Exception {
		Class.forName(CONST.dbdriver);
		conn = DriverManager.getConnection(CONST.dburl,CONST.dbuser,CONST.dbpass);
		stmt = conn.createStatement();
	}

	public TestAccess(String sql) throws Exception {
		Class.forName(CONST.dbdriver);
		conn = DriverManager.getConnection(CONST.dburl,CONST.dbuser,CONST.dbpass);
		
		this.prepareStatement(sql);
	}

	/**
	 * ��������
	 * 
	 * @return Connection ����
	 */
	public Connection getConnection() {
		return conn;
	}

	/**
	 * PreparedStatement
	 * 
	 * @return sql Ԥ��SQL���
	 */
	public void prepareStatement(String sql) throws SQLException {
		prepstmt = conn.prepareStatement(sql);
	}

	/**
	 * ����Ԥ��״̬
	 */
	public PreparedStatement getPreparedStatement() {
		return prepstmt;
	}

	/**
	 * ����״̬
	 * 
	 * @return Statement ״̬
	 */
	public Statement getStatement() {
		return stmt;
	}

	/**
	 * ִ��SQL��䷵���ֶμ�
	 * 
	 * @param sql
	 *            SQL���
	 * @return ResultSet �ֶμ�
	 */
	public ResultSet executeQuery(String sql) throws SQLException {
		if (stmt != null) {
			return stmt.executeQuery(sql);
		} else
			return null;
	}

	public ResultSet executeQuery() throws SQLException {
		if (prepstmt != null) {
			return prepstmt.executeQuery();
		} else
			return null;
	}

	/**
	 * ִ��SQL���
	 * 
	 * @param sql
	 *            SQL���
	 */
	public void executeUpdate(String sql) throws SQLException {
		if (stmt != null)
			stmt.executeUpdate(sql);
	}

	public void executeUpdate() throws SQLException {
		if (prepstmt != null)
			prepstmt.executeUpdate();
	}

	/**
	 * �ر�����
	 */
	public void close() throws Exception {
		if (stmt != null) {
			stmt.close();
			stmt = null;
		}
		if (prepstmt != null) {
			prepstmt.close();
			prepstmt = null;
		}
		conn.close();
		conn = null;
	}
	void Add(User user){
		String sql = "insert into user(username,password,groups) values('" 
			+ user.getUsername() + "','"
			+ user.getPassword() + "','"
			+ user.getGroup() + "')";
		System.out.println(sql);
		try {
			stmt.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	};
	public static void main(String[] args) throws Exception{
		Map<Integer, User> map = new HashMap();
		List<User> list = new ArrayList<User>();
		String sql = "select * from user";
		TestAccess ta = new TestAccess(sql);
		ResultSet rs = ta.executeQuery();
		while(rs.next()){
			String s = rs.getString("username");
			System.out.println(s);
			User u = new User();
			u.setId(rs.getInt("id"));
			u.setUsername(rs.getString("username"));
			u.setPassword(rs.getString("password"));
			u.setGroup(rs.getString("groups"));
			int uid = rs.getInt("id");
				map.put(uid, u);
//				list = new ArrayList<User>();
				list.add(u);
				uid = rs.getInt("id");
//		TestAccess tan = new TestAccess();
//		User user = new User("onehao","pass","g3");
//		tan.Add(user);	
		
		
	}
		System.out.println(map.size());
		Iterator<User> keyValuepairs = map.values().iterator();
		while(keyValuepairs.hasNext()){
			User ul = keyValuepairs.next();
			System.out.println(ul.getUsername()+"------");
			
		}
		
		for(int i=1;i<=map.size();i++){
		System.out.println(map.get(i).getUsername()+"******");
		}
}
}
