package ml.littleapp.util.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import ml.littleapp.config.ThreadNum;

public final class ExecutorHelper {

	private ExecutorHelper() {
	}

	public static Executor executor(String threadNum) {
		if (threadNum != null) {
			if (threadNum.equals(ThreadNum.SINGLE)) {
				return Executors.newSingleThreadExecutor();
			} else if (threadNum.equals(ThreadNum.AUTO)) {
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
	
	public static void main(String[] args) {
		Executor executor = ExecutorHelper.executor("auto");
	}

}
