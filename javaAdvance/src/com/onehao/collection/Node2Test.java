package com.onehao.collection;

public class Node2Test {

	public static void main(String[] args) {
		
		Node2 n1 = new Node2("node1");
		Node2 n2 = new Node2("node2");
		Node2 n3 = new Node2("node3");
		
//		n1.previous = n3;
//		n2.previous = n1;
//		n3.previous = n2;
//		
//		n1.next = n2;
//		n2.next = n3;
//		n3.next = n1;
		
		n1.next = n2;
		n2.previous = n1;
		
		n2.next = n3;
		n3.previous = n2;
		
		n3.next = n1;
		n1.previous = n3;
		
		System.out.println("-------------");
		
		Node2 n4 = new Node2("node4");
		
		n1.next = n4;
		n4.previous = n1;
		n4.next = n2;
		n2.previous = n4;
		
		System.out.println("-------------");
		
		n4.previous = null;
		n4.next = null;
		
		n1.next = n2;
		n2.previous = n1;
		
	}
}
