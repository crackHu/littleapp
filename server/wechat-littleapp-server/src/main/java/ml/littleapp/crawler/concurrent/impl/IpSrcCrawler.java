package ml.littleapp.crawler.concurrent.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;

import org.apache.commons.lang3.time.DateUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import ml.littleapp.crawler.concurrent.Concurrent;
import ml.littleapp.crawler.concurrent.Crawler;
import ml.littleapp.dto.crawler.IpSrcPage;

public class IpSrcCrawler implements Concurrent<IpSrcPage>, Crawler {

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
		String[] pattern = new String[]{"yy-MM-dd HH:mm"};
		
		domains.forEach(domain -> {
			Callable<IpSrcPage> crawler = () -> {
				Document document = crawler(domain);
				String title = document.title();
				String content = document.select("#body").html();
				
				String selectText = document.select("#ip_list .odd").get(0).select("td").last().text();
				Date gmtModified = DateUtils.parseDate(selectText, pattern);
				
				Elements paginations = document.select(".pagination a");
				Element lastPage = paginations.get(paginations.size() - 2);
				Integer pageTotal = Integer.valueOf(lastPage.text());
				
				ipSrcPage = new IpSrcPage(title, content, gmtModified, pageTotal);
				return ipSrcPage;
			};
			callables.add(crawler);
		});
		// jwt
		return callables;
	}
}