/**
 * 
 */
package cn.ibm.onehao.domain;

import java.util.Date;

/**
 * @author onehao
 *
 */
public class User {
	private int id;
	private String username;
	private String password;
	private String groups;
	private Date birthday;
	private float money;
	
	public User(){
		
	}
	public User(String username){
		this.username = username;
	}
	
	public User(float money){
		this.money = money;
	}
	
	public void showUserName(){
		System.out.println(this.username);
	}
	
	@Override
	public String toString() {
		return "id=" + this.id + " username=" +this.username + " password=" + this.password +
		" groups" + this.groups + " birthday" + this.birthday + " money" + this.money;
	}
	
	private void test(){
		
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the groups
	 */
	public String getGroups() {
		return groups;
	}
	/**
	 * @param groups the groups to set
	 */
	public void setGroups(String groups) {
		this.groups = groups;
	}
	/**
	 * @return the birthday
	 */
	public Date getBirthday() {
		return birthday;
	}
	/**
	 * @param birthday the birthday to set
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	/**
	 * @return the money
	 */
	public float getMoney() {
		return money;
	}
	/**
	 * @param money the money to set
	 */
	public void setMoney(float money) {
		this.money = money;
	}

}
