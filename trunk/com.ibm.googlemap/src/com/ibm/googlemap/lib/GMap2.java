package com.ibm.googlemap.lib;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.ProgressEvent;
import org.eclipse.swt.browser.ProgressListener;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.widgets.Composite;

import com.ibm.googlemap.IInvoke;

public class GMap2 {

	private Browser browser = null;
	private GLatLng center;
	private IInvoke iinvoke;
	private Map<String, IListener> lis = new HashMap<String, IListener>();

	public static final String CLICK = "NotifyAddMarker";

	public IListener getListener(String key) {
		return lis.get(key);
	}

	public void addListener(String key, IListener l) {
		lis.put(key, l);
	}

	public GMap2(Composite parent, String apiKey) {
		browser = new Browser(parent, SWT.NONE);
		browser.setUrl("E:/com.ibm.googlemap/template/template.html");
		browser.addMouseListener(new MouseListener() {

			public void mouseDoubleClick(MouseEvent arg0) {
			}

			public void mouseDown(MouseEvent event) {
				if (event.button == 3)
					browser
							.execute("document.oncontextmenu = function() {return false;}");
			}

			public void mouseUp(MouseEvent arg0) {

			}
		});
		browser.addControlListener(new ControlListener() {

			public void controlMoved(ControlEvent arg0) {

			}

			public void controlResized(ControlEvent e) {
				browser
						.execute("document.getElementById('map_canvas').style.height="
								+ browser.getClientArea().height);
			}
		});
		browser.addProgressListener(new ProgressListener() {

			public void changed(ProgressEvent arg0) {

			}

			public void completed(ProgressEvent arg0) {
				browser
						.execute("document.getElementById('map_canvas').style.height="
								+ browser.getClientArea().height);
			}
		});
		new InitFunction(this, "InitComplete");
		new AddMarkerFunction(this, CLICK);
	}

	public GLatLng getCenter() {
		return center;
	}

	public void openInfoWindow(GLatLng latlng, String text) {
		browser.execute("map.openInfoWindow(new GLatLng(" + latlng.getLat()
				+ ", " + latlng.getLng() + "),document.createTextNode('" + text
				+ "'));");
	}

	public void setCenter(GLatLng latlng, int scale) {
		this.center = latlng;
		browser.execute("map.setCenter(new GLatLng(" + latlng.getLat() + ", "
				+ latlng.getLng() + "), " + scale + ");");
	}

	public Browser getBrowser() {
		return browser;
	}

	public void invoke(IInvoke iInvoke) {
		this.iinvoke = iInvoke;
	}

	public IInvoke getInvoke() {
		return iinvoke;
	}

	public void addOverlay(GMarker gMarker) {
		browser.execute("map.addOverlay(new GMarker(new GLatLng("
				+ gMarker.getCenter().getLat() + ","
				+ gMarker.getCenter().getLng() + ")));");
	}
	
	public void addOverlay(GPolyline polyline) {
		browser.execute("map.addOverlay(new GPolyline([new GLatLng("
				+ polyline.getFrom().getLat() + ","
				+ polyline.getFrom().getLng() + "),new GLatLng("
				+ polyline.getTo().getLat() + "," + polyline.getTo().getLng()
				+ ")], '" + polyline.getColor() + "', " + polyline.getScale()
				+ "));");
	}

	public void fromLatLngToDivPixel(GLatLng center2) {
		browser.execute("map.fromLatLngToDivPixel(new GLatLng("
				+ center2.getLat() + "," + center2.getLng() + "))");
	}
}
