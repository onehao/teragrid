/**
 * 
 */
package cn.ibm.onehao;

import java.lang.reflect.Constructor;

import cn.ibm.onehao.domain.User;

/**
 * @author onehao
 *
 */
public class ReflectTest {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
//		User user = (User)create(User.class);
//		System.out.println(user);
		Class clazz = Bean.class;
		Object obj = create(clazz);
		System.out.println(obj);
	}
	
	static Object create(Class clazz) throws Exception{
//		clazz.newInstance();//������в��������Ĺ��췽��
		
		//�������в���ʱ
		Constructor con = clazz.getConstructor(String.class);
		Object obj = con.newInstance("test name");
		return obj;
	}

}
