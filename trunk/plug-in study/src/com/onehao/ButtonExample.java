package com.onehao;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
/**
 * 
 * @author onehao
 *
 */
public class ButtonExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("Button Example");
		shell.setBounds(100, 100, 200, 100);
		shell.setLayout(new FillLayout());
		final Button button = new Button(shell,SWT.PUSH);
		button.setText("Click Me Now");
		button.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent event){
				button.setText("I Was Clicked");
//				button.addSelectionListener(new SelectionAdapter(){
//					public void widgetSelect(SelectionEvent event){
//						button.setText("I clicked twice");
//					}
//				});
			}
		});
		shell.open();
		while(!shell.isDisposed()){
			if(!display.readAndDispatch())display.sleep();
		}
		display.dispose();
	}

}
