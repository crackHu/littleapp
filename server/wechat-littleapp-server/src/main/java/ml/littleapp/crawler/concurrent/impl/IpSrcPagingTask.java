package ml.littleapp.crawler.concurrent.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

import org.jsoup.nodes.Document;

import com.google.common.collect.Lists;

import ml.littleapp.crawler.concurrent.Crawler;

public class IpSrcPagingTask extends RecursiveTask<List<Document>> implements Crawler {
	
	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = -2425968505051680816L;

	private String domain;
	
	private String query;
	
	private int pageTotal;
	
	private int startPage;

	private int endPage;
	
	public IpSrcPagingTask(int startPage, int endPage) {
		this.startPage = startPage;
		this.endPage = endPage;
	}
	
	public IpSrcPagingTask(String domain, String query, int pageTotal) {
		this.domain = domain;
		this.query = query;
		this.pageTotal = pageTotal;
	}

	@Override
	protected List<Document> compute() {
 		ArrayList<Document> docList = Lists.newArrayList();
		int pageFlag= pageTotal / 5;  
		boolean canCompute = endPage != 0 && (endPage - startPage) <= pageFlag;
		if (canCompute) {
			for (int i = startPage; i <= endPage; i++) {
				String url = startPage == 0 ? domain + query : domain + query + i;
				Document document = crawler(url);
				docList.add(document);
			}
		} else {
			int avgPage = endPage != 0 ? (endPage + startPage) / 2 : pageTotal / 2;
			
			IpSrcPagingTask leftTask = new IpSrcPagingTask(startPage, avgPage);
			IpSrcPagingTask rightTask = new IpSrcPagingTask(avgPage + 1, endPage);
			leftTask.fork();
			rightTask.fork();
			List<Document> leftResult = leftTask.join();
			List<Document> rightResult = rightTask.join();
			docList.addAll(leftResult);
			docList.addAll(rightResult);
		}
		return docList;
	}

}
