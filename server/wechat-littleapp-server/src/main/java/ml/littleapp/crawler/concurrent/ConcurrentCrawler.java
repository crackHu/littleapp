package ml.littleapp.crawler.concurrent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import ml.littleapp.annotation.ConstStatistics;

public interface ConcurrentCrawler<T> {

	List<Callable<T>> getCallables();

	@ConstStatistics
	default Document crawler(String domain) {
		Document document = null;
		try {
			document = Jsoup.connect(domain).get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return document;
	}

	@ConstStatistics
	default List<T> execute(List<Callable<T>> callables) {

		List<T> results = new ArrayList<T>();
		ExecutorService executorService = Executors.newCachedThreadPool();
		// ExecutorService executorService =
		// Executors.newSingleThreadExecutor();
		// ExecutorService executorService = Executors.newFixedThreadPool(1);

		try {
			callables.forEach((callable) -> {
				Future<T> future = executorService.submit(callable);
				try {
					results.add(future.get());
				} catch (InterruptedException | ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			executorService.shutdown();
		}

		return results;
	}

	@ConstStatistics
	default List<T> run(List<String> domains) {
		return execute(getCallables());
	};
}
