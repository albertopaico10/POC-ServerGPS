package com.poc.service.rest.facade;

import com.poc.service.rest.bean.coordinates.CoordinateRequestBean;
import com.poc.service.rest.bean.coordinates.CoordinateResponseBean;

public interface CoordinateManger {

	public CoordinateResponseBean saveCoordinates(CoordinateRequestBean beanRequest);
	public CoordinateResponseBean getCoodinates(CoordinateRequestBean beanRequest);
}
