package com.poc.service.rest.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/dispatcher-servlet.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class UtilMethodsTest {
	
	@Test
	public void getFileNameTest()throws Exception{
		System.out.println("Esto es un TEST");
		String value=UtilMethods.getFileName(CommonConstants.Files.ROOT_FILE_HISTORY+"car1");
		System.out.println("RESULT "+value);
	}
	
}
