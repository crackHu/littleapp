package org.huyg.springboot_demo;

import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import tk.mybatis.mapper.mapper.LoggingEventMapper;
import tk.mybatis.mapper.service.LoggingEventExceptionService;
import tk.mybatis.springboot.util.MyMapper;

@RestController
@Configuration
@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan("tk.mybatis.mapper")
@ServletComponentScan("org.littleapp.crawler.listener")
@MapperScan(basePackages = { "tk.mybatis.mapper.mapper" }, markerInterface = MyMapper.class)
public class SampleController extends SpringBootServletInitializer {

	@Resource
	LoggingEventExceptionService loggingEventExceptionService;
	@Inject
	LoggingEventMapper loggingEventMapper;

	@RequestMapping("/")
	@ResponseBody
	List home() {
		List selectAll = loggingEventMapper.selectAll();
		return selectAll;
	}

	public static void main(String[] args) throws Exception {
		SpringApplication app = new SpringApplication(SampleController.class);
		app.run(args);
	}
}