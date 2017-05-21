package ml.littleapp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ml.littleapp.util.MyException;
import ml.littleapp.util.MyMapper;

@ComponentScan
@RestController
@EnableScheduling
@MapperScan(basePackages = { "ml.littleapp.mapper" }, markerInterface = MyMapper.class)
@ServletComponentScan
@EnableAspectJAutoProxy
@SpringBootApplication
@EnableConfigurationProperties
public class Application {

	@RequestMapping("/auth/test1")
	String home() throws MyException {
		throw new MyException("test exception");
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
