package com.gps.google.poc.bean;

import java.io.Serializable;

public class ResponseBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String longValue;
	private String latValue;
	private String title;
	
	public String getLongValue() {
		return longValue;
	}
	public void setLongValue(String longValue) {
		this.longValue = longValue;
	}
	public String getLatValue() {
		return latValue;
	}
	public void setLatValue(String latValue) {
		this.latValue = latValue;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}
