package com.ibm.googlemap;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;

import com.ibm.googlemap.lib.GLatLng;
import com.ibm.googlemap.lib.GMap2;
import com.ibm.googlemap.lib.GMarker;
import com.ibm.googlemap.lib.GPolyline;
import com.ibm.googlemap.lib.IListener;

public class View extends ViewPart {
	public static final String ID = "com.ibm.googlemap.view";

	private Text latlng = null;

	private Text mark = null;

	private Text info = null;

	private Text polyline = null;

	private Button latlngBtn = null;

	private Button markBtn = null;

	private Button infoBtn = null;

	private Button polylineBtn = null;

	public void createPartControl(Composite parent) {
		Composite parent2 = new Composite(parent, SWT.NONE);
		parent2.setLayout(new GridLayout(3, true));

		Composite leftCom = new Composite(parent2, SWT.NONE);
		GridData leftData = new GridData(GridData.FILL_BOTH);
		leftData.horizontalSpan = 2;
		leftCom.setLayoutData(leftData);
		leftCom.setLayout(new FillLayout());

		Composite rightCom = new Composite(parent2, SWT.NONE);

		final GMap2 map2 = new GMap2(leftCom, null);
		map2.addListener(GMap2.CLICK, new IListener() {
			public Object function(Object[] arguments) {
				double lat = ((Double) arguments[0]).doubleValue();
				double lng = ((Double) arguments[1]).doubleValue();
				GLatLng center = new GLatLng(lat, lng);
				map2.fromLatLngToDivPixel(center);
				map2.addOverlay(new GMarker(center));
				return null;
			}
		});
		map2.invoke(new IInvoke() {
			public void invoke() {
				map2.setCenter(new GLatLng(39.917, 116.397), 14);
			}
		});

		initRight(map2, rightCom);
	}

	private void initRight(final GMap2 map2, Composite rightCom) {
		rightCom.setLayout(new GridLayout(1, true));
		rightCom.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		latlng = new Text(rightCom, SWT.BORDER);
		latlng.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		latlngBtn = new Button(rightCom, SWT.NONE);
		latlngBtn.setText("设置中心点");
		latlngBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				String text = latlng.getText();
				String[] split = text.split(",");
				if (split != null && split.length == 2) {
					map2.setCenter(new GLatLng(Double.parseDouble(split[0]),
							Double.parseDouble(split[1])), 14);
				}
			}
		});


		mark = new Text(rightCom, SWT.BORDER);
		mark.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		markBtn = new Button(rightCom, SWT.NONE);
		markBtn.setText("设置标记");
		markBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				String text = mark.getText();
				String[] split = text.split(",");
				if (split != null && split.length == 2) {
					map2.addOverlay(new GMarker(new GLatLng(Double
							.parseDouble(split[0]), Double
							.parseDouble(split[1]))));
				}
			}
		});


		info = new Text(rightCom, SWT.BORDER);
		info.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		infoBtn = new Button(rightCom, SWT.NONE);
		infoBtn.setText("弹出信息");
		infoBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				String text = info.getText();
				String[] split = text.split(",");
				if (split != null && split.length == 3) {
					map2.openInfoWindow(new GLatLng(Double
							.parseDouble(split[0]), Double
							.parseDouble(split[1])), split[2]);
				}
			}
		});


		polyline = new Text(rightCom, SWT.BORDER);
		polyline.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		polylineBtn = new Button(rightCom, SWT.NONE);
		polylineBtn.setText("绘画直线");
		polylineBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				String text = polyline.getText();
				String[] split = text.split(",");
				if (split != null && split.length == 6) {
					map2.addOverlay(new GPolyline(new GLatLng(Double
							.parseDouble(split[0]), Double
							.parseDouble(split[1])), new GLatLng(Double
							.parseDouble(split[2]), Double
							.parseDouble(split[3])), split[4], Integer
							.parseInt(split[5])));
				}
			}
		});
	}

	public void setFocus() {
	}
}