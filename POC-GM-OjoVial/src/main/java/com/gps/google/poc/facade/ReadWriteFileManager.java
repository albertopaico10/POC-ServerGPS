package com.gps.google.poc.facade;

import com.gps.google.poc.bean.ResponseBean;

public interface ReadWriteFileManager {
	public ResponseBean getGPSCordinates(String fileName);
}
