package com.onehao;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class HelloWorld {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("Hello World");
		shell.setBounds(100, 100, 200, 50);
		shell.setLayout(new FillLayout());
		Label label = new Label(shell,SWT.CENTER);
		label.setText("Hello World");
		Color red = new Color(display,255,0,0);
		label.setForeground(red);
		shell.open();
		while(!shell.isDisposed()){
			if(!display.readAndDispatch())display.sleep();
		}
		red.dispose();
		display.dispose();
	}

}
