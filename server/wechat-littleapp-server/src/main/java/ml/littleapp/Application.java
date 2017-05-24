package ml.littleapp;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.inject.Inject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ml.littleapp.task.ScheduledTaskService;
import ml.littleapp.util.MyException;
import ml.littleapp.util.MyMapper;

@ComponentScan
@RestController
@EnableScheduling
@MapperScan(basePackages = { "ml.littleapp.mapper" }, markerInterface = MyMapper.class)
@ServletComponentScan
@EnableAsync
@EnableAspectJAutoProxy
@SpringBootApplication
@EnableConfigurationProperties
public class Application {

	@Inject
	private ScheduledTaskService scheduledTaskService;
	
	@RequestMapping("/auth/test1")
	String home() throws MyException {
		scheduledTaskService.testAsync();
		System.out.println("aaaaa" + System.currentTimeMillis());
		Future<String> future = scheduledTaskService.testResultAsync();
		String result = null;
		try {
			System.out.println("bbbbb" + System.currentTimeMillis());
			result = future.get();
			System.out.println("cccc" + System.currentTimeMillis());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
		// System.exit(SpringApplication.exit(SpringApplication.run(
		//          BatchConfiguration.class, args)));
	}
}
