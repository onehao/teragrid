/**
 * 
 */
package cn.ibm.onehao.Dao;

import java.util.Date;

import cn.ibm.onehao.domain.User;

/**
 * @author onehao
 *
 */
public class UserDaoTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDao userDao = new UserDaoJdbcImpl();
		User user = new User();
		user.setBirthday(new Date());
		user.setUsername("dao name1");
		user.setPassword("dao pass");
		user.setGroups("dao g");
		user.setMoney(1000.0f);
		
//		userDao.addUser(user);
		
//		User u = userDao.findUser(user.getUsername(), null);
//		System.out.println(u.getId());
		
		User u = userDao.getUser(14);
//		u.setMoney(20000.1f);
//		userDao.update(u);
		
		User u1 = userDao.getUser(14);
		userDao.delete(u1);
	}

}
