/**
 * 
 */
package cn.ibm.onehao.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author onehao
 *
 */
public class DaoFactory {
	private static UserDao userDao = null;//放在第二位的话会报错 
	private static DaoFactory instance = new DaoFactory();

	private DaoFactory(){
		
		try {
			Properties prop = new Properties();
//			InputStream inStream = new FileInputStream(new File("src/daoconfig.properties"));
			
			//下面代码不需要写入目录
			InputStream inStream = DaoFactory.class.getClassLoader().getResourceAsStream("daoconfig.properties");
			prop.load(inStream);
			String userDaoClass = prop.getProperty("userDaoClass");
			Class clazz = Class.forName(userDaoClass);
			userDao = (UserDao)clazz.newInstance();
		}catch(Throwable e){
			// TODO Auto-generated catch block
			throw new ExceptionInInitializerError(e);
		}
	}
	
	public static DaoFactory getInstance(){
		return instance;
	}
	
	public UserDao getUserDao(){
		return userDao;
	}
}
