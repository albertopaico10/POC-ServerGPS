package com.poc.service.rest.bean.coordinates;

public class CoordinateRequestBean {

	public String longitude;
	public String latitude;
	public String idValueCar;
	public String titleCar;
	
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
	public String getIdValueCar() {
		return idValueCar;
	}
	public void setIdValueCar(String idValueCar) {
		this.idValueCar = idValueCar;
	}
	public String getTitleCar() {
		return titleCar;
	}
	public void setTitleCar(String titleCar) {
		this.titleCar = titleCar;
	}
}
