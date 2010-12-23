package com.ibm.googlemap.lib;

import org.eclipse.swt.browser.BrowserFunction;

public class AddMarkerFunction extends BrowserFunction {
	private GMap2 map;

	public AddMarkerFunction(GMap2 map, String name) {
		super(map.getBrowser(), name);
		this.map = map;
	}

	public Object function(Object[] arguments) {
		IListener listener = map.getListener(GMap2.CLICK);
		if (listener != null) {
			return listener.function(arguments);
		}
		return null;
	}

	public GMap2 getMap() {
		return map;
	}
}