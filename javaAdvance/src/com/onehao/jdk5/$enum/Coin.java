package com.onehao.jdk5.$enum;

/**
 * ö�٣�Enum���������������ÿ��ö�����Ͷ��̳���java.lang.Enum�࣬
 * ö���е�ÿ����ԱĬ�϶���public static final�ġ�
 * 
 * 
 * ��ÿ��ö�ٵĳ�Ա��ʵ�����������ö�����͵�һ��ʵ����Instance����
 * ���仰˵����������һ��ö�����ͺ��ڱ���ʱ�̾���ȷ����ö�������м���ʵ�����ֱ���ʲô��
 * �������ڼ������޷���ʹ�ø�ö�����ʹ����µ�ʵ���ˣ���Щʵ���ڱ����ڼ���Ѿ���ȫȷ�������ˡ�
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
