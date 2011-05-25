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
//		clazz.newInstance();//������в��������Ĺ��췽��
		
		//�������в���ʱ
		Constructor con = clazz.getConstructor(String.class);
		Object obj = con.newInstance("test name");
		return obj;
	}
	
	static void invoke1(Object obj, String methodName) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, SecurityException, NoSuchMethodException{
		Method[] ms = obj.getClass().getDeclaredMethods();//���ж��з���������������
		ms.getClass().getMethods();//���Դ�������еķ�������û��private����
		for(Method m : ms){
//			System.out.println(m.getName());
			if(methodName.equals(m.getName()))//�������������أ� ����ȷ
				m.invoke(obj, null);
		}
		
		Method m = obj.getClass().getMethod(methodName, null);
		m.invoke(obj, null);
	}
	
	static void field(Class clazz) throws Exception{
		Field[] fs = clazz.getDeclaredFields();//������ʹ��Filed��
//		fs = clazz.getFields();//�õ�public
		for(Field f : fs){
			System.out.println(f.getName());
		}
	}
	
	static void annon(Class clazz) throws Exception{
		Annotation[] as = clazz.getAnnotations();
	}

}
