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

	@Override
	public String toString() {
		return this.username;
	}

}
