package com.onehao.basic.lesson3;

	public class StringLiterial {
		public static void main(String[] args) {
			String hello = "Hello", lo = "lo";
			System.out.print((hello == "Hello") + " ");
			System.out.print((Other.hello == hello) + " ");
//			System.out.print((other.Other.hello == hello) + " ");//Other in package other
			System.out.print((hello == ("Hel"+"lo")) + " ");
			System.out.print((hello == ("Hel"+lo)) + " ");
			System.out.println(hello == ("Hel"+lo).intern());
		}
	}
	class Other { static String hello = "Hello"; }

