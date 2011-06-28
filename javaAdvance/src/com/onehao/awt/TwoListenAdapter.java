package com.onehao.awt;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TwoListenAdapter
{
	private Frame frame;
	
	private TextField textField;
	
	public void go()
	{
		frame = new Frame("Two Listeners Example");
		
		frame.add(new Label("click"), BorderLayout.NORTH);
		
		textField = new TextField(30);
		
		frame.add(textField, BorderLayout.SOUTH);
		
		frame.addMouseListener(new MyAdapter());
		
		frame.setSize(300, 200);
		
		frame.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		TwoListenAdapter two = new TwoListenAdapter();
		two.go();
	}
}

class MyAdapter extends MouseAdapter
{
	@Override
	public void mouseEntered(MouseEvent e)
	{
		String str = "The mouse has enterd the Frame";
		
		System.out.println(str);
	}
}
