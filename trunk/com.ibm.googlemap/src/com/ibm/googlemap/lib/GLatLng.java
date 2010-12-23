package com.ibm.googlemap.lib;

public class GLatLng {

	private double lat;
	private double lng;

	public GLatLng(double d, double e) {
		this.lat = d;
		this.lng = e;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}
}
