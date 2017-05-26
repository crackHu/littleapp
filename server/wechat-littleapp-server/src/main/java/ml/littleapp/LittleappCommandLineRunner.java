package ml.littleapp;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import ml.littleapp.service.impl.CraIpSrcPagingServiceImpl;
import ml.littleapp.service.impl.CraIpSrcServiceImpl;

@Configuration
public class LittleappCommandLineRunner implements CommandLineRunner {

	@Inject
	private CraIpSrcServiceImpl ipSrcServiceImpl;
	@Inject
	private CraIpSrcPagingServiceImpl ipSrcPagingServiceImpl;

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public void run(String... args) throws Exception {
		log.info("LittleappCommandLineRunner running...");

		long start = System.currentTimeMillis();

		ScheduledExecutorService scheduled = Executors.newScheduledThreadPool(1);
//		scheduled.scheduleWithFixedDelay(new Runnable() {
//			@Override
//			public void run() {
//				try {
					ipSrcServiceImpl.init();
					log.info("努力😡");
					ipSrcPagingServiceImpl.paging();
//				} catch (Exception e) {
//					log.error("LittleappCommandLineRunner init error", e);
//				}
//			}
//		}, 5, 10, TimeUnit.SECONDS);
		
		long end = System.currentTimeMillis();
		log.info("LittleappCommandLineRunner finished, cost {}", (end - start) + "ms");
	}

}