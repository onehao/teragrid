/**
 * 
 */
package cn.ibm.onehao.dao;

import cn.ibm.onehao.domain.User;

/**
 * @author onehao
 *
 */
public interface UserDao {
	public void addUser(User user);
	
	public User getUser(int userId);
	
	public User findUser(String loginName,String password);
	
	public void update(User user);
	
	public void delete(User user);
	
}
