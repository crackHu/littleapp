package ml.littleapp.task;

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
		System.out.println(System.currentTimeMillis());
	}
}