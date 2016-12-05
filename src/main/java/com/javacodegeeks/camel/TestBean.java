package com.javacodegeeks.camel;


import com.javacodegeeks.datalayer.gprslkwinfo.dao.GprsLkwInfoDAO;
import com.javacodegeeks.datalayer.gprslkwinfo.model.GprsLkwInfo;
import org.apache.camel.Converter;
import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import org.springframework.beans.factory.annotation.Autowired;


//import static org.apache.hadoop.hdfs.web.resources.ExceptionHandler.LOG;

@Component("myService")
public class TestBean {
	
	@Autowired
	GprsLkwInfoDAO gprsLkwInfoDAO;

	
	public String hello(String msg) {
		GprsLkwInfo gprsLkwInfo=gprsLkwInfoDAO.findByGprsLkwInfoLkwId(581631);
		//System.out.println("gprsLkwInfo A : " + gprsLkwInfo);
		return gprsLkwInfo.toString()+ ":" + Thread.currentThread();
	}

	@Converter
	public static String toString(byte[] data, Exchange exchange) {
		if (exchange != null) {
			String charsetName = exchange.getProperty(Exchange.CHARSET_NAME, String.class);
			if (charsetName != null) {
				try {
					return new String(data, charsetName);
				} catch (UnsupportedEncodingException e) {
					//LOG.warn("Cannot convert the byte to String with the charset " + charsetName, e);
				}
			}
		}
		return new String(data);
	}
}
