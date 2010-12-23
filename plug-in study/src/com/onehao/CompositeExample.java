package com.onehao;


import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
/**
 * 
 * @author onehao
 *
 */
public class CompositeExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("Composite Example");
		shell.setBounds(100,100,200,200);
		Composite composite = new Composite(shell,SWT.BORDER);
		composite.setBounds(25,25,150,125);
		final Button button = new Button(composite,SWT.PUSH);
		button.setBounds(25,25,100,25);
		button.setText("Click Me Now");
		button.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent event){
				button.setText("I was Clicked");
			}
		});
		//add by onehao to test
		final Button button2 = new Button(composite,SWT.PUSH);
		button2.setBounds(25,75,100,25);
		button2.setText("Click Me2 Now");
		button2.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent event){
				button2.setText("I was Clicked");
			}
		});
		shell.open();
		while(!shell.isDisposed()){
			if(!display.readAndDispatch())display.sleep();
		}
		display.dispose();
	}

}
