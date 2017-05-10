package ml.littleapp;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import ml.littleapp.service.CraIpSrcService;

@Configuration
public class LittleappCommandLineRunner implements CommandLineRunner {

	@Inject
	private CraIpSrcService ipSrcService;

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public void run(String... args) throws Exception {
		log.info("LittleappCommandLineRunner running...");

		long start = System.currentTimeMillis();

		ipSrcService.init();

		long end = System.currentTimeMillis();
		log.info("LittleappCommandLineRunner finished, cost {}", (end - start) + "ms");
	}

}