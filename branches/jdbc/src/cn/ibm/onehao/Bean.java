package cn.ibm.onehao;
/**
 * 
 */

/**
 * @author onehao
 *
 */
public class Bean {
	private String username;
	public Bean(String n){
		this.username = n;
	}
	
	public Bean(){
		
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

	@Override
	public String toString() {
		return this.username;
	}
	
private void test(){
		
	}

}
