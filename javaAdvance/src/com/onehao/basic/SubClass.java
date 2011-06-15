package com.onehao.basic;

/**
 * ����������⣺ 
 * ��󶨣�
 * �ڱ����ʱ����Ѿ�ȷ���˽����������е��ǻ��໹����������ĸ��������ڱ�������ʱ������������;;��������и����������ж���ķ�����
 * ������ķ��������ַ�������Ч�ʸ�
 * ��java�еı������Ǿ�̬�󶨵�,�����Ļ�ֻ��static��final(����privateĬ����final��)�Ǿ�̬�󶨵�. 
 * 
 * ��󶨣�
 * ֻ�������е�ʱ����ܾ������л�������������е��ĸ�����
 * �����е�ʱ�򽫸��ݸ�ʵ�����Ͷ���������������������ط�������ȡ��������new��ʲô������Ҳ���Ǽ�ʹ����newһ��Father�������Son��ʵ��
 * ����������������Father�������ָ�����Son��ʵ�����������õ�ʱ����Ȼ�ǵ���Son�ķ�����������Father���ͬ��������
 * Java��һ�з��������鷽��
 * ��Ҳ���������е�ʱ��JVM���Զ��������õ�������ʵ�������Ƿ�һ�£�������Σ�������������ʵ������֮���������Ȼ��߼̳й�ϵ��
 * ����������is
 * a�Ĺ�ϵ����
 * ���һ�¾���Ȼִ�и������ж���ķ����������һ�����������õ�ʵ�������Ƿ����ͬ��ͬ�η���������������и�ʵ�����͵�ͬ��ͬ�η�����
 * ���������һ������
 * ��ÿ�����е�ʱ�򶼻�������ͼ�飬���������һ�����������ġ�
 * 
 * @author onehao
 * 
 */
class SuperClass {
	int i = 5;
	static int j = 15;

	static void method1() {
		System.out.println("SuperClass.method1()");
		System.out.println("SuperClass1->j:" + j);
	}

	void method2() {
		System.out.println("SuperClass.method2()");
		System.out.println("SuperClass2->i:" + i);
		System.out.println("SuperClass1->j:" + j);
	}
}

public class SubClass extends SuperClass {
	int i = 10;
	static int j = 20;

	// will not override SuperClass.method1()
	static void method1() {
		System.out.println("SubClass.method1()");
		System.out.println("SubClass1->j:" + j);
	}

	// will override the SuperClass.method2()
	void method2() {
		System.out.println("SubClass.method2()");
		System.out.println("SubClass2->i:" + i);
		System.out.println("SubClass1->j:" + j);
	}

	public static void main(String[] args) {
		SuperClass parent = new SubClass();
		parent.method1();
		// ��ΪSuperClass�����method1��static,����ʱ�;�̬����,������� SuperClass.method1()
		// j=15
		parent.method2();
		// ��method2()����static����,parent����SubClass
		// new������,ִ�е�ʱ���ִ��new�����Ǹ����method2()����,
		// �������SubClass.method2() i=10 j=20,����java�Ķ�̬��

	}
}