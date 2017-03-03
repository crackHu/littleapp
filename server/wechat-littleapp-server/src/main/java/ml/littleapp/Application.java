package ml.littleapp;

import ml.littleapp.util.MyException;
import ml.littleapp.util.MyMapper;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@ComponentScan
@RestController
@MapperScan(basePackages = { "ml.littleapp.mapper" }, markerInterface = MyMapper.class)
@ServletComponentScan
@SpringBootApplication
public class Application {

	@RequestMapping("/")
	String home() throws MyException {
		throw new MyException("test exception");
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
