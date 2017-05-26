package ml.littleapp.crawler.concurrent.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.util.Assert;

import ml.littleapp.crawler.concurrent.Concurrent;
import ml.littleapp.crawler.concurrent.Crawler;
import ml.littleapp.dto.crawler.IpSrcPagingPage;

public class IpSrcPagingCrawler implements Concurrent<IpSrcPagingPage>, Crawler {

	private IpSrcPagingPage ipSrcPaging = null;
	private List<Map<String, Object>> domainPageTotals = null;

	public IpSrcPagingCrawler(List<Map<String, Object>> domainPageTotals) {
		this.domainPageTotals = domainPageTotals;
	}

	@Override
	public List<Callable<IpSrcPagingPage>> getCallables() {

		List<Callable<IpSrcPagingPage>> callables = new ArrayList<Callable<IpSrcPagingPage>>();
		
		domainPageTotals.stream().forEach(domainPageTotals -> {
			@SuppressWarnings("unused")
			Callable<IpSrcPagingPage> crawler = () -> {
				String domain = (String) domainPageTotals.get("domain");
				String query = (String) domainPageTotals.get("query");
				Integer pageTotal = (Integer) domainPageTotals.get("pageTotal");
				
				Assert.hasText(domain, "domain is invalid");
				Assert.hasText(query, "query is invalid");
				Assert.notNull(pageTotal, "pageTotal is invalid");
				
				ForkJoinPool forkJoinPool = new ForkJoinPool();
				IpSrcPagingTask task = new IpSrcPagingTask(domain, query, pageTotal);
				ForkJoinTask<List<Document>> joinTask = forkJoinPool.submit(task);
				List<Document> docList = joinTask.get();
				
				Document document = crawler(domain);
				String title = document.title();
				String content = document.select("#body").html();

				Elements paginations = document.select(".pagination a");
				Element lastPage = paginations.get(paginations.size() - 2);
				Integer pageNo = Integer.valueOf(lastPage.text());
				
				ipSrcPaging = new IpSrcPagingPage(title, content, pageNo);
				return ipSrcPaging;
			};
			callables.add(crawler);
		});

		return callables;
	}
}