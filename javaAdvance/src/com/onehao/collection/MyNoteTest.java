package com.onehao.collection;

public class MyNoteTest {

	public static void main(String[] args) {
		
		MyNode n1 = new MyNode();
		MyNode n2 = new MyNode();
		MyNode n3 = new MyNode();
		
		n1.next = n2;
		n2.next = n3;
		n3.next = null;
		
	}
}
