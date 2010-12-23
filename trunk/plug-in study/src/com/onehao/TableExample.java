package com.onehao;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

public class TableExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("Table Example");
		shell.setBounds(100, 100, 200, 100);
		shell.setLayout(new FillLayout());
		final Table table = new Table(shell,
				SWT.SINGLE|SWT.BORDER|SWT.FULL_SELECTION);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		TableColumn column1 = new TableColumn(table,SWT.NULL);
		column1.setText("Name");
//		column1.pack();
		column1.setWidth(70);
		TableColumn column2 = new TableColumn(table,SWT.NULL);
		column2.setText("Age");
//		column2.pack();
		column2.setWidth(50);
		TableItem item1 = new TableItem(table,SWT.NULL);
		item1.setText(new String[]{"Onehao","43"});
		TableItem item2 = new TableItem(table,SWT.NULL);
		item2.setText(new String[]{"Michael","44"});
		table.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent event){
				TableItem[] selected = table.getSelection();
				if(selected.length>0){
					System.out.println("Name:"+selected[0].getText(0));
					System.out.println("Age:"+selected[0].getText(1));
				}
			}
		});
		shell.open();
		while(!shell.isDisposed()){
			if(!display.readAndDispatch())display.sleep();
		}
		display.dispose();
	}

}
