package ml.littleapp.util.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ml.littleapp.config.ThreadNum;

public final class ExecutorHelper {
	
	private final static Logger log = LoggerFactory.getLogger(ExecutorHelper.class);
	
	private ExecutorHelper() {
	}

	public static ExecutorService executor(String threadNum) {
		if (threadNum != null) {
			if (threadNum.equals(ThreadNum.SINGLE.getnThreads())) {
				log.info("ExecutorHelper be invoked : {}", "SINGLE THREAD");
				return Executors.newSingleThreadExecutor();
			} else if (threadNum.equals(ThreadNum.AUTO.getnThreads())) {
				log.info("ExecutorHelper be invoked : {}", "CACHE THREAD");
				return Executors.newCachedThreadPool();
			} else {
				try {
					Integer nThreads = Integer.valueOf(threadNum);
					log.info("ExecutorHelper be invoked : {}", nThreads + " THREAD");
					return Executors.newFixedThreadPool(nThreads);
				} catch (NumberFormatException e) {
					log.info("ExecutorHelper be invoked : {}", "CACHE THREAD");
				}
			}
		}
		return Executors.newCachedThreadPool();
	}
}
