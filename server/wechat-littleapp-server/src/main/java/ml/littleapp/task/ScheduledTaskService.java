package ml.littleapp.task;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledTaskService {

//    @Autowired
//    JobLauncher jobLauncher;
//
//    @Autowired
//    Job importJob;
//
//    public JobParameters jobParameters;

	@Scheduled(fixedRate = 5000)
	public void execute() throws Exception {
//		jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis()).toJobParameters();
//		jobLauncher.run(importJob, jobParameters);
//		testAsync();
//		System.out.println("lala" + System.currentTimeMillis());
	}
	
	@Async
	public void testAsync() {
		System.out.println("Execute testAsync asynchronously - "  
			      + Thread.currentThread().getName());  
		long start = System.currentTimeMillis();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println("异步执行…………" + (end - start) + Thread.currentThread().getName());
	}
	
	@Async
	public Future<String> testResultAsync() {
		System.out.println("Execute testResultAsync asynchronously - "  
			      + Thread.currentThread().getName());  
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AsyncResult<String> result = new AsyncResult<String>("异步");
		return result;
	}
}