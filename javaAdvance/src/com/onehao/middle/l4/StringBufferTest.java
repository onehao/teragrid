package com.onehao.middle.l4;

public class StringBufferTest {
	/**
	 * ���java language specification ���� $3.10.5
	 * @param args
	 */

	public static void main(String[] args) {
		
		StringBuffer sb = new StringBuffer();
		sb.append("hello").append(" world").append(" welcome!!").append(100);

		String s = sb.toString();
		System.out.println(s);
		
		
		String testEscape = "ss";
	}
}
