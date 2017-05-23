package ml.littleapp.task;

import java.util.concurrent.TimeUnit;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledTask {

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
		testAsync();
		System.out.println("lala" + System.currentTimeMillis());
	}
	
	@Async
	public void testAsync() {
		long start = System.currentTimeMillis();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println("异步执行…………" + (end - start));
	}
}