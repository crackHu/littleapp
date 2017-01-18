package org.huyg.springboot_demo.controller;

import java.io.IOException;

import javax.inject.Inject;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tk.mybatis.mapper.mapper.LoggingEventExceptionMapper;

@RestController
@RequestMapping("/ip")
public class CrawlIpController {
	
	@Inject
	LoggingEventExceptionMapper loggingEventExceptionMapper;

	private static final Logger logger = LoggerFactory
			.getLogger(CrawlIpController.class);
	
	@RequestMapping("crawl")
	public String crawl() throws Exception {
		Connection connect = Jsoup.connect("https://www.baidu.com/");
		String data = null;
		System.out.println(loggingEventExceptionMapper.selectAll());
		try {
			data = connect.get().data();
			logger.debug("This is a debug message");  
	        logger.info("This is an info message");  
	        logger.warn("This is a warn message");  
	        logger.error("This is an error message"); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception("asdddddddddddddddddddd");
		}
		return data;
	}
}
