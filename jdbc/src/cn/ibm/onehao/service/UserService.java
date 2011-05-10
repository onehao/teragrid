/**
 * 
 */
package cn.ibm.onehao.service;

import cn.ibm.onehao.dao.UserDao;

/**
 * @author onehao
 *
 */
public class UserService {
	private UserDao userDao;
	
	public void register(cn.ibm.onehao.domain.User user){
		this.userDao.addUser(user);
	}
}
