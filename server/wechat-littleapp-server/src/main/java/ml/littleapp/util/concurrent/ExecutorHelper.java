package ml.littleapp.util.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ml.littleapp.config.ThreadNum;

public final class ExecutorHelper {

	private ExecutorHelper() {
	}

	public static Executor executor(String threadNum) {
		if (threadNum != null) {
			if (threadNum.equals(ThreadNum.SINGLE.getnThreads())) {
				return Executors.newSingleThreadExecutor();
			} else if (threadNum.equals(ThreadNum.AUTO.getnThreads())) {
				return Executors.newCachedThreadPool();
			} else {
				try {
					Integer nThreads = Integer.valueOf(threadNum);
					return Executors.newFixedThreadPool(nThreads);
				} catch (NumberFormatException e) {
				}
			}
		}
		return Executors.newCachedThreadPool();
	}
}
