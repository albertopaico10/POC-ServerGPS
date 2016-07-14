package com.gps.google.poc.facade.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gps.google.poc.facade.ReadWriteFileManager;

@ContextConfiguration(locations = {"/dispatcher-servlet.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
//@Transactional
public class ReadWriteFileManagerImplTest {

	@Autowired
	private ReadWriteFileManager readWriteFileManager;
	
	@Test
	public void getGPSCordinatesTest()throws Exception{
		System.out.println("Esto es un TEST");
		readWriteFileManager.getGPSCordinates("carro1");
	}
	
}
