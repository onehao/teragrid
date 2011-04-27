package onehao.vo.test;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Table(name="user")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String group;

	private String password;

	private String username;

    public User() {
    }
    public User(String username,String password,String group){
    	this.username = username;
    	this.password = password;
    	this.group = group;
    	
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGroup() {
		return this.group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}