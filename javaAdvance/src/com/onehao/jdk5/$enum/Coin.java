package com.onehao.jdk5.$enum;

/**
 * 枚举（Enum）：我们所定义的每个枚举类型都继承自java.lang.Enum类，
 * 枚举中的每个成员默认都是public static final的。
 * 
 * 
 * 而每个枚举的成员其实就是您定义的枚举类型的一個实例（Instance）。
 * 换句话说，当定义了一个枚举类型后，在编译时刻就能确定该枚举类型有几个实例，分别是什么。
 * 在运行期间我们无法再使用该枚举类型创建新的实例了，这些实例在编译期间就已经完全确定下来了。
 * 
 * @author onehao
 *
 */
public enum Coin
{
	penny("hello"), nickel("world"), dime("welcome"), quarter("hello world");
	
	private String value;
	
	public String getValue()
	{
		return value;
	}
	
	Coin(String value)
	{
		this.value = value;
	}
	
	public static void main(String[] args)
	{
		Coin coin = Coin.quarter;
		
		System.out.println(coin.getValue());
	}
}
