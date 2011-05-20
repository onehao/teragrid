/**
 * 
 */
package cn.ibm.onehao.dao;

import java.util.Date;

import cn.ibm.onehao.dao.refactor.UserDaoImpl;
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
//		UserDao userDao = new UserDaoJdbcImpl();//���������ʵ�� �����jdbc����jpa��hibernate �Ķ���
		
		UserDao userDao = DaoFactory.getInstance().getUserDao() ;
		User user = new User();
		user.setBirthday(new Date());
		user.setUsername("otherapi2");
		user.setPassword("dao pass2");
		user.setGroups("dao g2");
		user.setMoney(1000.0f);
		
		userDao.addUser(user);
		
		System.out.println(user.getId());
		
//		User u = userDao.findUser(user.getUsername(), null);
//		System.out.println(u.getId());
		
//		User u = userDao.getUser(14);
//		u.setMoney(20000.1f);
//		userDao.update(u);
		
//		User u1 = userDao.getUser(14);
//		userDao.delete(u1);
		
		UserDaoImpl udi = new UserDaoImpl();
		User u1 = udi.findUser(user.getUsername(), null);
	}

}
