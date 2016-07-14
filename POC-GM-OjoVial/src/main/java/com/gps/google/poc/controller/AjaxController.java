package com.gps.google.poc.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.gps.google.poc.bean.RequestBean;
import com.gps.google.poc.bean.ResponseBean;
import com.gps.google.poc.facade.ReadWriteFileManager;

@Controller
public class AjaxController {
	@Autowired
	private ReadWriteFileManager readWriteFileManager;
//	@RequestMapping(value = "/callgpslocation.htm", method = RequestMethod.POST)
//	public @ResponseBody ResponseBean getTags(@RequestBody RequestBean tagName) {
//		System.out.println("Entre por ajax...!!! =) "+tagName.getNameValue()); 
//		ResponseBean beanResponse=new ResponseBean();
//		beanResponse.setLatValue("-12.028324");
//		beanResponse.setLongValue("-77.092464");
//		beanResponse.setTitle("Title Ajax -  Casa");
//		System.out.println("Estoy saliendo =)");
//		return beanResponse;
//
//	}
	
	@RequestMapping(value = "/callgpslocation.htm", method = RequestMethod.POST)
	public ResponseEntity<ResponseBean> getTags(@RequestBody RequestBean tagName) {
		System.out.println("Entre por ajax...!!! =)asdas "+tagName.getNameValue()+"***"+tagName.getFileName()); 
		ResponseBean beanResponse=readWriteFileManager.getGPSCordinates(tagName.getFileName());
		System.out.println("Estoy saliendo =)");
		return new ResponseEntity<ResponseBean>(beanResponse,HttpStatus.OK);

	}
	
//	@RequestMapping(value = "/callgpslocation.htm", method = RequestMethod.GET)
//	public @ResponseBody ResponseBean callgpslocation() {
//		System.out.println("Entre por ajax...!!! =) 3 "); 
//		ResponseBean beanResponse=new ResponseBean();
//		beanResponse.setLatValue("-12.028324");
//		beanResponse.setLongValue("-77.092464");
//		beanResponse.setTitle("Title Ajax -  Casa");
//		System.out.println("Estoy saliendo =)");
//		return beanResponse;
//
//	}
	
//	@RequestMapping(value = "/callgpslocation.htm", method = RequestMethod.POST)
//	public @ResponseBody String callgpslocation() {
//		
//		return "HOLAAAAAAAAAAAAAAAAAAaa2222";
//
//	}
	
}
