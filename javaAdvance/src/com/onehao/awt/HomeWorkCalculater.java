package com.onehao.awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class HomeWorkCalculater implements ActionListener
{
	private TextField textField;
	
	public void go()
	{
		//创建一个Frame
		Frame frame = new Frame("my calculater");
	
		//为Frame增加监听器， 当点叉号时推出
		frame.addWindowListener(new MyHandler());
		
		//增加一个MenuBar
		MenuBar menuBar = new MenuBar();
		
		Menu m1 = new Menu("m1");
		Menu m2 = new Menu("m2");
		Menu m3 = new Menu("m3");
		
		frame.setMenuBar(menuBar);
		menuBar.add(m1);
		menuBar.add(m2);
		menuBar.add(m3);
		
		frame.setResizable(false);
		
		MenuItem menuItem = new MenuItem("exit");
		m1.add(menuItem);
		
		
		//计算器第一行， 增加一个TextField用于显示输入数字，输出结果和错误信息
		textField = new TextField("0", 100);
		frame.add(textField, BorderLayout.NORTH);
		
		//增加一个5行5列的grid用于放置数字和运算符
		GridLayout gridLayout = new GridLayout(5, 5);
		frame.setLayout(gridLayout);
				
		Button b1 = new Button("7");
		Button b2 = new Button("8");
		Button b3 = new Button("9");
		Button b4 = new Button("/");
		Button b5 = new Button("sqrt");
		Button b21 = new Button("4");
		Button b22 = new Button("5");
		Button b23 = new Button("6");
		Button b24 = new Button("*");
		Button b25 = new Button("%");
		Button b31 = new Button("1");
		Button b32 = new Button("2");
		Button b33 = new Button("3");
		Button b34 = new Button("-");
		Button b35 = new Button("1/x");
		Button b41 = new Button("0");
		Button b42 = new Button("-/+");
		Button b43 = new Button(".");
		Button b44 = new Button("+");
		Button b45 = new Button("=");
		Button b51 = new Button("0");
		Button b52 = new Button("-/+");
		Button b53 = new Button(".");
		Button b54 = new Button("+");
		Button b55 = new Button("=");
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b21.addActionListener(this);
		b22.addActionListener(this);
		b23.addActionListener(this);
		b24.addActionListener(this);
		b25.addActionListener(this);
		b31.addActionListener(this);
		b32.addActionListener(this);
		b33.addActionListener(this);
		b34.addActionListener(this);
		b35.addActionListener(this);
		b41.addActionListener(this);
		b42.addActionListener(this);
		b43.addActionListener(this);
		b44.addActionListener(this);
		b45.addActionListener(this);
		b51.addActionListener(this);
		b52.addActionListener(this);
		b53.addActionListener(this);
		b54.addActionListener(this);
		b55.addActionListener(this);
		
		
		frame.add(b1);
		frame.add(b2);
		frame.add(b3);
		frame.add(b4);
		frame.add(b5);
		frame.add(b21);
		frame.add(b22);
		frame.add(b23);
		frame.add(b24);
		frame.add(b25);
		frame.add(b31);
		frame.add(b32);
		frame.add(b33);
		frame.add(b34);
		frame.add(b35);
		frame.add(b41);
		frame.add(b42);
		frame.add(b43);
		frame.add(b44);
		frame.add(b45);
		frame.add(b51);
		frame.add(b52);
		frame.add(b53);
		frame.add(b54);
		frame.add(b55);
		
		
		
		frame.setSize(300, 300);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		textField.setText(e.getActionCommand());
		
	}
	
	public static void main(String[] args)
	{
		HomeWorkCalculater hwc = new HomeWorkCalculater();
		hwc.go();
	}
}

class ButtonAdapter implements ActionListener
{

	TextField tf;
	public TextField getTf()
	{
		return tf;
	}

	public void setTf(TextField tf)
	{
		this.tf = tf;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		setTextField(getTf(),e);
	}
	
	private void setTextField(TextField tf, ActionEvent e)
	{
		this.tf = tf;
		this.tf.setText(e.getActionCommand());
	}
	
}

class MyHandler extends WindowAdapter
{
	@Override
	public void windowClosing(WindowEvent e)
	{
		System.exit(0);
	}
}
