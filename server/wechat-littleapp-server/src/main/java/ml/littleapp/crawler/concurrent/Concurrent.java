package ml.littleapp.crawler.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ml.littleapp.util.concurrent.ExecutorHelper;

public interface Concurrent<T> {

	final Logger log = LoggerFactory.getLogger(Concurrent.class);

	List<Callable<T>> getCallables();

	default List<T> execute(List<Callable<T>> callables, String threadNum) {

		List<T> results = new ArrayList<T>();
		ExecutorService executorService = ExecutorHelper.executor(threadNum);

		try {
			callables.forEach((callable) -> {
				Future<T> future = executorService.submit(callable);
				// List<Future<T>> invokeAll = executorService.invokeAll(callables);

				try {
					results.add(future.get());
				} catch (InterruptedException | ExecutionException e) {
					log.error(e.getMessage(), e);
				}
			});
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			executorService.shutdown();
		}

		return results;
	}

	default List<T> run(List<String> domains, String threadNum) {
		return execute(getCallables(), threadNum);
	};
}
