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
public class ORMTestWithAlias{

	/**
	 * @param args
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws SQLException 
	 * @throws IllegalArgumentException 
	 * @throws InstantiationException 
	 */
	public static void main(String[] args) throws IllegalArgumentException, SQLException, IllegalAccessException, InvocationTargetException, InstantiationException {
		String sql = "select id as Id, username as Username, password as Password," +
		"groups as Groups, birthday as Birthday, money as Money from user where id=1";
		User user = getUser(sql);
		System.out.println(user);
		
		User user2 = (User)getObject(sql, User.class);
		System.out.println(user2);
		
		Bean bean = (Bean)getObject(sql, Bean.class);
		System.out.println(bean);
	}

	static Object getObject(String sql, Class clazz) throws SQLException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, InstantiationException{
		Connection conn = null;
		PreparedStatement ps = null;//预处理（消除SQL注入），特殊字符的过滤，性能优化（执行很多次时）
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection(); //推荐 代码不罗嗦 这个动作比较占时间
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int count = rsmd.getColumnCount();
			String[] colNames = new String[count];
			for(int i=1;i<=count;i++){
				colNames[i-1] = rsmd.getColumnName(i);
			}
			
			Object obj = null;
			Method[] ms = clazz.getMethods();
			while(rs.next()){
				obj = clazz.newInstance();
				for(int i=0;i<colNames.length;i++){
					String colName = colNames[i];
					String methodName = "set" + colName;//使用別名
					System.out.println(methodName);
					for(Method m : ms){
						if(methodName.equals(m.getName())){
							m.invoke(obj, rs.getObject(colName));
						}
					}
				}
			}
			return obj;
		} finally {
			JdbcUtils.free(rs, ps, conn);
		}
	}
	
	
	static User getUser(String sql) throws SQLException, IllegalArgumentException, IllegalAccessException, InvocationTargetException{
		Connection conn = null;
		PreparedStatement ps = null;//预处理（消除SQL注入），特殊字符的过滤，性能优化（执行很多次时）
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection(); //推荐 代码不罗嗦 这个动作比较占时间
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int count = rsmd.getColumnCount();
			String[] colNames = new String[count];
			for(int i=1;i<=count;i++){
				colNames[i-1] = rsmd.getColumnName(i);
//				System.out.println("getColumnName:" + rsmd.getColumnName(i));
//				System.out.println("getColumnLabel:" + rsmd.getColumnLabel(i));
			}
			
			User user = new User();
			Method[] ms = user.getClass().getMethods();
			while(rs.next()){
				for(int i=0;i<colNames.length;i++){
					String colName = colNames[i];
					String methodName = "set" + colName;//使用別名
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
