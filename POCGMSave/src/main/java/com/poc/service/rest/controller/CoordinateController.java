package com.poc.service.rest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.poc.service.rest.bean.coordinates.CoordinateRequestBean;
import com.poc.service.rest.bean.coordinates.CoordinateResponseBean;
import com.poc.service.rest.facade.CoordinateManger;
import com.poc.service.rest.facade.impl.CoordinateMangerImpl;
import com.poc.service.rest.util.CommonConstants;
import com.poc.service.rest.util.UtilMethods;


@Controller
public class CoordinateController {

	private static final Logger logger = LoggerFactory.getLogger(CoordinateController.class);
	@Autowired
	private CoordinateManger coordinateManger=new CoordinateMangerImpl();
	
	@RequestMapping(value = CommonConstants.ValueRequestMapping.REGISTER_COORDINATES, method = RequestMethod.POST)
	public @ResponseBody CoordinateResponseBean registerCoordinates(@RequestBody CoordinateRequestBean beanRequest) {
		logger.info("Start registerCoordinates.");
//		System.out.println("Star:"+UtilMethods.getCurrentTimeStamp());
		CoordinateResponseBean beanResponse=coordinateManger.saveCoordinates(beanRequest);
		logger.info("END");
//		System.out.println("END:"+UtilMethods.getCurrentTimeStamp());
		return beanResponse;
	}
	
	@RequestMapping(value = CommonConstants.ValueRequestMapping.GET_COORDINATES, method = RequestMethod.POST)
	public @ResponseBody CoordinateResponseBean getCoordinates(@RequestBody CoordinateRequestBean beanRequest) {
		logger.info("Start getCoordinates.");
		CoordinateResponseBean beanResponse=coordinateManger.getCoodinates(beanRequest);
		logger.info("END");
		return beanResponse;
	}
}
