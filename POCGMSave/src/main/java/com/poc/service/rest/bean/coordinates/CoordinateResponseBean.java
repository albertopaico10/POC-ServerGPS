package com.poc.service.rest.bean.coordinates;

public class CoordinateResponseBean {

	public String codeResponse;
	public String longitude;
	public String latitude;
	public String title;
	public String messagesResponse;
	
	public String getCodeResponse() {
		return codeResponse;
	}

	public void setCodeResponse(String codeResponse) {
		this.codeResponse = codeResponse;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessagesResponse() {
		return messagesResponse;
	}

	public void setMessagesResponse(String messagesResponse) {
		this.messagesResponse = messagesResponse;
	}
}
