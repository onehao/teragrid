package com.ibm.googlemap.lib;

import org.eclipse.swt.browser.BrowserFunction;

public class InitFunction extends BrowserFunction {
	private GMap2 map;

	public InitFunction(GMap2 map, String name) {
		super(map.getBrowser(), name);
		this.map = map;
	}

	public Object function(Object[] arguments) {
		map.getInvoke().invoke();
		return null;
	}

	public GMap2 getMap() {
		return map;
	}
}
