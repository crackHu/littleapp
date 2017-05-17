package ml.littleapp.crawler.concurrent.impl;

import java.util.concurrent.RecursiveTask;

import org.jsoup.nodes.Document;

import ml.littleapp.crawler.concurrent.Crawler;

public class IpSrcPagingTask extends RecursiveTask<Document> implements Crawler {
	
	private int pageTotal;
	
	public IpSrcPagingTask(int pageTotal) {
		this.pageTotal = pageTotal;
	}

	@Override
	protected Document compute() {
		
		return crawler("");
	}

}
