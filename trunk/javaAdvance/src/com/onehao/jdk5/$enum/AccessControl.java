package com.onehao.jdk5.$enum;
public class AccessControl
{
	public static boolean checkRight(AccessRight accessRight)
	{
		if(accessRight == AccessRight.MANAGER)
		{
			return true;
		}
		else if(accessRight == AccessRight.DEPARTMENT)
		{
			return false;
		}
		return false;
	}
	
	public static void main(String[] args)
	{
		AccessRight accessRight = AccessRight.valueOf("MANAGER");
		
		System.out.println(checkRight(accessRight));
		
		AccessRight accessRight2 = AccessRight.valueOf("MANAGER2");
		
		System.out.println(accessRight2);//java.lang.IllegalArgumentException: No enum const class com.onehao.jdk5.$enum.AccessRight.MANAGER2
		
	}
}
