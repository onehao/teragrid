package com.onehao;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;

public class TabFolderExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("TabFolder Example");
		shell.setBounds(100,100,175,125);
		shell.setLayout(new FillLayout());
		final TabFolder tabFolder = new TabFolder(shell,SWT.BORDER);
		for(int i=1;i<4;i++){
			TabItem tabItem = new TabItem(tabFolder,SWT.NULL);
			tabItem.setText("Tab "+i);
			Composite composite = new Composite(tabFolder,SWT.NULL);
			tabItem.setControl(composite);
			Button button = new Button(composite,SWT.PUSH);
			button.setBounds(25,25,100,25);
			button.setText("Click Me Now");
			button.addSelectionListener(new SelectionAdapter(){
				public void widgetSelected(SelectionEvent event){
					((Button)event.widget).setText("I Was Clicked");
				}
			});
		}
		shell.open();
		while(!shell.isDisposed()){
			if(!display.readAndDispatch())display.sleep();
		}
		display.dispose();
	}

}
