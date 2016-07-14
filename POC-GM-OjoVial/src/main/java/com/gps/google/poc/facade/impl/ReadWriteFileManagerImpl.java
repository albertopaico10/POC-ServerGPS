package com.gps.google.poc.facade.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.gps.google.poc.bean.CoordinateRequestBean;
import com.gps.google.poc.bean.CoordinateResponseBean;
import com.gps.google.poc.bean.ResponseBean;
import com.gps.google.poc.facade.ReadWriteFileManager;
import com.gps.google.poc.util.CommonConstants;

@Service
public class ReadWriteFileManagerImpl implements ReadWriteFileManager {

	public ResponseBean getGPSCordinates(String fileName) {
		RestTemplate restTemplate=new RestTemplate();
		CoordinateRequestBean beanRequest=new CoordinateRequestBean();
		beanRequest.setIdValueCar(fileName);
		CoordinateResponseBean beanResponse=restTemplate.postForObject(CommonConstants.URLService.URL_GET_COORDINATES, beanRequest, CoordinateResponseBean.class);
		System.out.println("Regreso del Service");
		ResponseBean beanResponseController=new ResponseBean();
		beanResponseController.setLatValue(beanResponse.getLatitude());
		beanResponseController.setLongValue(beanResponse.getLongitude());
		beanResponseController.setTitle(beanResponse.getTitle());
		return beanResponseController;
	}

//	public ResponseBean getGPSCordinates(String idCordinate,String fileName){
//		ResponseBean beanResponse=new ResponseBean();
//		try {
//			List<String> lines=readTextFileByLines("H:/OtherThings/Coordenadas/mapa-"+fileName+".txt");
//			String dataSpecific=lines.get(Integer.parseInt(idCordinate)-1);
//			System.out.println("Coordenada especifica : "+dataSpecific);
//			
//			String coordinatesData[]=dataSpecific.split(",");
//			beanResponse.setLatValue(coordinatesData[1].trim());
//			beanResponse.setLongValue(coordinatesData[2].trim());
//			beanResponse.setTitle(coordinatesData[3]);
////			beanResponse.setLastId(String.valueOf(Integer.parseInt(idCordinate)+1));
//			System.out.println("Proximo Valor : "+beanResponse.getLastId());
//		} catch (IOException e) {
//			System.out.println("Error : "+e.getMessage());
//			e.printStackTrace();
//		}
//		return beanResponse;
//	} 
//	
//	public static String readTextFile(String fileName) throws IOException {
//	    String content = new String(Files.readAllBytes(Paths.get(fileName)));
//	    return content;
//	}
//	
//	public static List<String> readTextFileByLines(String fileName) throws IOException {
//	    List<String> lines = Files.readAllLines(Paths.get(fileName), Charset.defaultCharset());
//	    System.out.println("Cantidad de lineas : "+lines.size());
//	    return lines;
//	}
//	
}
