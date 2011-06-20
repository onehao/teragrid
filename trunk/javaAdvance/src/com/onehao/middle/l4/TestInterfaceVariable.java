package com.onehao.middle.l4;

 class TestInterfaceVariable implements InterfaceVariable{

	int iv;
	String a = "sss";
	int b;
	
	
	public static void main(String[] args)
	{
		TestInterfaceVariable instance = new TestInterfaceVariable();
		System.out.println(instance.iv);
		
		instance.a = "bbb";
		instance.a = "ccc";
		System.out.println(InterfaceVariable.iv);
	}
	
}

//onehao:非public的类只能在被同一包中的类或者继承类访问
class B
{
	void pt()
	{
		System.out.println("hello from B");
	}
}
