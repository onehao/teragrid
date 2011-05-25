/**
 * 
 */
package cn.ibm.onehao;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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
		Class clazz2 = User.class;
		Object obj = create(clazz2);
		System.out.println(obj);
		
		System.out.println("------invoke1------");
		invoke1(obj,"showUserName");
		
		System.out.println("------field------");
		field(clazz);
	}
	
	static Object create(Class clazz) throws Exception{
//		clazz.newInstance();//类必须有不带参数的构造方法
		
		//构造器有参数时
		Constructor con = clazz.getConstructor(String.class);
		Object obj = con.newInstance("test name");
		return obj;
	}
	
	static void invoke1(Object obj, String methodName) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, SecurityException, NoSuchMethodException{
		Method[] ms = obj.getClass().getDeclaredMethods();//类中多有方法，不包含父类
		ms.getClass().getMethods();//可以打出超类中的方法，但没有private方法
		for(Method m : ms){
//			System.out.println(m.getName());
			if(methodName.equals(m.getName()))//方法名可以重载， 不精确
				m.invoke(obj, null);
		}
		
		Method m = obj.getClass().getMethod(methodName, null);
		m.invoke(obj, null);
	}
	
	static void field(Class clazz) throws Exception{
		Field[] fs = clazz.getDeclaredFields();//不建议使用Filed类
//		fs = clazz.getFields();//得到public
		for(Field f : fs){
			System.out.println(f.getName());
		}
	}
	
	static void annon(Class clazz) throws Exception{
		Annotation[] as = clazz.getAnnotations();
	}

}
