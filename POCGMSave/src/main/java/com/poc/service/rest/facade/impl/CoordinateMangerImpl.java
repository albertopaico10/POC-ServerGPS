package com.poc.service.rest.facade.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.poc.service.rest.bean.coordinates.CoordinateRequestBean;
import com.poc.service.rest.bean.coordinates.CoordinateResponseBean;
import com.poc.service.rest.facade.CoordinateManger;
import com.poc.service.rest.util.CommonConstants;
import com.poc.service.rest.util.UtilMethods;

@Service
@Transactional
public class CoordinateMangerImpl implements CoordinateManger {
	private static final Logger logger = LoggerFactory.getLogger(CoordinateMangerImpl.class);
	public CoordinateResponseBean saveCoordinates(CoordinateRequestBean beanRequest){
		logger.info("Start CoordinateMangerImpl");
		CoordinateResponseBean beanResponse=new CoordinateResponseBean();
		try {
			// -- Save in Live File
			File file = new File(CommonConstants.Files.ROOT_FILE_LIVE+beanRequest.getIdValueCar()+CommonConstants.GenericValues.TXT_EXTENSION);
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(beanRequest.getLongitude()+", "+beanRequest.getLatitude()+", "+beanRequest.getTitleCar());
			bw.close();
			System.out.println("Done Live File");
			// -- End
			// -- Save in History File
			String fileNameHistory=UtilMethods.getFileName(CommonConstants.Files.ROOT_FILE_HISTORY+beanRequest.getIdValueCar());
			
			FileWriter fwHistory = new FileWriter(fileNameHistory,true);
			BufferedWriter bwHistory = new BufferedWriter(fwHistory);
			String lastId=getLastIdHistoryFile(fileNameHistory);
			bwHistory.write(lastId+", "+beanRequest.getLongitude()+", "+beanRequest.getLatitude());
			bwHistory.newLine();
			bwHistory.close();
			System.out.println("Done History File");
			// -- End
		} catch (Exception e) {
			System.out.println("Error : "+e.getMessage());
			e.printStackTrace();
			beanResponse.setMessagesResponse(e.getMessage());
		}
		logger.info("End CoordinateMangerImpl");
		beanResponse.setCodeResponse(CommonConstants.Coordinates.COORDINATE_SUCESS_REGISTER_CODE);
		beanResponse.setMessagesResponse(CommonConstants.Coordinates.COORDINATE_SUCESS_REGISTER_MESSAGES);
		return beanResponse;
	}
	
	private String getLastIdHistoryFile(String fileName) {
		String lastId="";
		try {
			List<String> lines=UtilMethods.readTextFileByLines(fileName);
			if(lines.size()==0){
				lastId="1";
			}else{
				int countRegister=lines.size()+1;
				lastId=String.valueOf(countRegister);
			}
		} catch (Exception e) {
			System.out.println("Error : "+e.getMessage());
			e.printStackTrace();
			lastId="0";
		}
		
		return lastId;
	}
	
	public CoordinateResponseBean getCoodinates(CoordinateRequestBean beanRequest){
		CoordinateResponseBean beanResponse=new CoordinateResponseBean();
		try {
			List<String> lines=UtilMethods.readTextFileByLines(CommonConstants.Files.ROOT_FILE_LIVE+beanRequest.getIdValueCar()+CommonConstants.GenericValues.TXT_EXTENSION);
			String dataSpecific=lines.get(0);
			System.out.println("Coordenada especifica : "+dataSpecific);
			
			String coordinatesData[]=dataSpecific.split(",");
			beanResponse.setLatitude(coordinatesData[0].trim());
			beanResponse.setLongitude(coordinatesData[1].trim());
			beanResponse.setTitle(coordinatesData[2]);
			beanResponse.setCodeResponse(CommonConstants.Coordinates.COORDINATE_SUCESS_GET_COORDINATE);
			beanResponse.setMessagesResponse(CommonConstants.Coordinates.COORDINATE_SUCESS_MESSAGES_GET_COORDINATE);
		} catch (IOException e) {
			System.out.println("Error : "+e.getMessage());
			e.printStackTrace();
			beanResponse.setMessagesResponse(e.getMessage());
		}
		return beanResponse; 
	}
	
}
