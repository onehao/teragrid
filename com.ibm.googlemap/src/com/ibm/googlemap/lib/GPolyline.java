package com.ibm.googlemap.lib;

public class GPolyline{

	private GLatLng from;
	private GLatLng to;
	private String color;
	private int scale;

	public GPolyline(GLatLng from, GLatLng to, String color, int scale) {
		this.from = from;
		this.to = to;
		this.color = color;
		this.scale = scale;
	}

	public GLatLng getFrom() {
		return from;
	}

	public void setFrom(GLatLng from) {
		this.from = from;
	}

	public GLatLng getTo() {
		return to;
	}

	public void setTo(GLatLng to) {
		this.to = to;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getScale() {
		return scale;
	}

	public void setScale(int scale) {
		this.scale = scale;
	}
}
