package com.onehao.basic.lesson3;

public class JLSTest {

	public static void main(String[] args) {
		
		long a = 2147483648L;
		int b = (int)a;
		
		System.out.println(b);
		
		long l = 9223372036854775807L +1;
		long l2 = -9223372036854775808L;
		
		System.out.println(l);
		System.out.println(l == l2);
		
		long d = 0xffffffffffffffffL;
		System.out.println(d);
		
		long t = 0xC0B0L;
		System.out.println(t);
		
		System.out.print('\u03a9');
		System.out.print('\u03a9');
		System.out.println('\u00FF');

	}
}