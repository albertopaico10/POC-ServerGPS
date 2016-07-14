package com.poc.service.rest.util;

public class CommonConstants {
	
	public class ValueRequestMapping{
		public static final String REGISTER_COORDINATES = "/rest/coordinate/register";
		public static final String GET_COORDINATES = "/rest/coordinate/get";
	}
	
	public class Files{
//		public static final String ROOT_FILE_LIVE = "H:/OtherThings/Coordenadas/live-map-";
		public static final String ROOT_FILE_LIVE = "/aplicaciones/coordinate/live-map-";
		public static final String ROOT_FILE_HISTORY = "/aplicaciones/coordinate/history-map-";
	}
	
	public class GenericValues{
		public static final String TXT_EXTENSION = ".txt";
	}
	
	public class Coordinates{
		public static final String COORDINATE_SUCESS_REGISTER_CODE = "SUCESS_REGISTER";
		public static final String COORDINATE_SUCESS_GET_COORDINATE = "SUCESS_GET_COORDINATE";
		public static final String COORDINATE_SUCESS_REGISTER_MESSAGES = "Se Registro Correctamente la Coordenada";
		public static final String COORDINATE_SUCESS_MESSAGES_GET_COORDINATE = "Se obtuvo la coordenada Correctamente";
	}
	
}

