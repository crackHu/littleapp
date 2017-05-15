package ml.littleapp.crawler.concurrent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import ml.littleapp.util.concurrent.ExecutorHelper;

@Component
public interface ConcurrentCrawler<T> {

	final Logger log = LoggerFactory.getLogger(ConcurrentCrawler.class);
	
	List<Callable<T>> getCallables();

	default Document crawler(String domain) {
		log.info("爬取：{} ……", domain);
		Document document = null;
		try {
			document = Jsoup.connect(domain).get();
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}
		return document;
	}

	default List<T> execute(List<Callable<T>> callables, String threadNum) {

		List<T> results = new ArrayList<T>();
		ExecutorService executorService = ExecutorHelper.executor(threadNum);
		
		try {
			callables.forEach((callable) -> {
				Future<T> future = executorService.submit(callable);
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
