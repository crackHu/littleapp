package ml.littleapp.crawler.concurrent.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;

import org.jsoup.nodes.Document;

import ml.littleapp.crawler.concurrent.ConcurrentCrawler;
import ml.littleapp.dto.crawler.IpSrcPage;

public class IpSrcCrawler implements ConcurrentCrawler<IpSrcPage> {

	private IpSrcPage ipSrcPage = null;
	private List<String> domains = null;

	public IpSrcCrawler(String domain) {
		this.domains = Arrays.asList(domain);
	}
	
	public IpSrcCrawler(List<String> domains) {
		this.domains = domains;
	}

	@Override
	public List<Callable<IpSrcPage>> getCallables() {

		List<Callable<IpSrcPage>> callables = new ArrayList<Callable<IpSrcPage>>();
		domains.forEach((domain) -> {
			Callable<IpSrcPage> crawler = () -> {
				Document document = crawler(domain);
				String title = document.title();
				String content = document.select("#body").html().substring(0, 20);
				System.out.println("getCallables[" + domain + "]:" + Thread.currentThread().getName());
				ipSrcPage = new IpSrcPage(title, content);
				return ipSrcPage;
			};
			callables.add(crawler);
		});

		return callables;
	}
}