package com.onehao;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;

public class ListExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("List Example");
		shell.setBounds(100, 100, 200, 100);
		shell.setLayout(new FillLayout());
		final List list = new List(shell,SWT.SINGLE);
		list.setItems(new String[]{"First","Second","Third"
	});
		list.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent Event){
				String[] selected = list.getSelection();
				if(selected.length > 0)
					System.out.println("Selected:"+selected[0]);
			}
			public void widgetDefaultSelected(SelectionEvent event){
				String[] selected = list.getSelection();
				if(selected.length > 0)
					System.out.println("Default Selected:"+selected[0]);
			}
		});
		shell.open();
		while(!shell.isDisposed()){
			if(!display.readAndDispatch())display.sleep();
		}
		display.dispose();
	}
}
