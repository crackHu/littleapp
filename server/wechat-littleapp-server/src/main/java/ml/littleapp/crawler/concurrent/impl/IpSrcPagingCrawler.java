package ml.littleapp.crawler.concurrent.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import ml.littleapp.crawler.concurrent.ConcurrentCrawler;
import ml.littleapp.dto.crawler.IpSrcPagingPage;

public class IpSrcPagingCrawler implements ConcurrentCrawler<IpSrcPagingPage> {

	private IpSrcPagingPage ipSrcPaging = null;
	private List<String> domains = null;

	public IpSrcPagingCrawler(String domain) {
		this.domains = Arrays.asList(domain);
	}

	public IpSrcPagingCrawler(List<String> domains) {
		this.domains = domains;
	}

	@Override
	public List<Callable<IpSrcPagingPage>> getCallables() {

		List<Callable<IpSrcPagingPage>> callables = new ArrayList<Callable<IpSrcPagingPage>>();
		domains.forEach((domain) -> {
			Callable<IpSrcPagingPage> crawler = () -> {
				Document document = crawler(domain);
				String title = document.title();
				String content = document.select("#body").html();

				Elements paginations = document.select(".pagination a");
				Element lastPage = paginations.get(paginations.size() - 2);
				Integer pageTotal = Integer.valueOf(lastPage.text());
				
				ipSrcPaging = new IpSrcPagingPage(title, content, pageTotal);
				return ipSrcPaging;
			};
			callables.add(crawler);
		});

		return callables;
	}
}