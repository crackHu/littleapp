package ml.littleapp.crawler.concurrent.impl;

import java.util.concurrent.RecursiveTask;

import org.jsoup.nodes.Document;

import ml.littleapp.crawler.concurrent.Crawler;

public class IpSrcPagingTask extends RecursiveTask<Document> implements Crawler {
	
	private final static int THRESHOLD = 2;
	
	private String domain;
	
	private int pageTotal;
	
	public IpSrcPagingTask(String domain, int pageTotal) {
		this.domain = domain;
		this.pageTotal = pageTotal;
	}

	@Override
	protected Document compute() {
		
		int avg = pageTotal / 3;
		int start = 0;
		int end = pageTotal;
				
		boolean canCompute = (end - start) <= THRESHOLD;
		
		return crawler("");
	}

}
