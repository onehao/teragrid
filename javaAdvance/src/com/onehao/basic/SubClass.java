package com.onehao.basic;

/**
 * 基本概念理解： 
 * 早绑定：
 * 在编译的时候就已经确定了将来程序运行的是基类还是派生类的哪个方法。在编译代码的时候根据引用类型就决定了运行该引用类型中定义的方法，
 * 即基类的方法。这种方法运行效率高
 * 。java中的变量都是静态绑定的,方法的话只有static和final(所有private默认是final的)是静态绑定的. 
 * 
 * 晚绑定：
 * 只有在运行的时候才能决定运行基类或者派生类中的哪个方法
 * 。运行的时候将根据该实际类型而不是引用类型来调用相关方法，即取决于我们new了什么样对象。也就是即使我们new一个Father类的子类Son的实例
 * ，而不管我们是用Father类的引用指向这个Son的实例，方法调用的时候依然是调用Son的方法，而不是Father类的同名方法。
 * Java中一切方法都是虚方法
 * ，也就是在运行的时候，JVM会自动检测该引用的类型与实际类型是否一致（无论如何，该引用类型与实际类型之间存在着相等或者继承关系，
 * 这样才满足is
 * a的关系），
 * 如果一致就自然执行该类型中定义的方法；如果不一致则会检查该引用的实际类型是否具有同名同参方法，如果有则运行该实际类型的同名同参方法。
 * 这样会带来一个问题
 * ：每次运行的时候都会进行类型检查，这样会带来一定的性能消耗。
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
		// 因为SuperClass里面的method1是static,编译时就静态绑定了,所以输出 SuperClass.method1()
		// j=15
		parent.method2();
		// 而method2()不是static方法,parent是由SubClass
		// new出来的,执行的时候会执行new它的那个类的method2()方法,
		// 所以输出SubClass.method2() i=10 j=20,这是java的多态性

	}
}