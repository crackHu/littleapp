package ml.littleapp.vo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebPage implements Callable<WebPage> {

	private static final Logger logger = LoggerFactory.getLogger(WebPage.class);
	private WebPage webPage;
	private List<String> url;
	private AtomicInteger urlIndex = new AtomicInteger(0);
	private String title;
	private String content;

	public WebPage(List<String> url) {
		super();
		this.url = url;
	}

	public WebPage(String title, String content) {
		super();
		this.title = title;
		this.content = content;
	}

	public List<WebPage> getWPInfo() {
		ExecutorService executorService = Executors.newCachedThreadPool();
		List<FutureTask<WebPage>> futureTasks = new ArrayList<FutureTask<WebPage>>();
		List<WebPage> webPages = new ArrayList<WebPage>();

		for (int i = 0; i < url.size(); i++) {
			FutureTask<WebPage> futureTask = new FutureTask<WebPage>(this);
			futureTasks.add(futureTask);
			executorService.execute(futureTask);
		}
		try {
			for (FutureTask<WebPage> futureTask : futureTasks) {
				webPages.add(futureTask.get(10, TimeUnit.SECONDS));
			}
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			logger.error("getWPInfo error! detail:" + e.getMessage(), e);
			e.printStackTrace();
		} finally {
			executorService.shutdown();
		}
		return webPages;
	}

	@Override
	public WebPage call() throws Exception {
		Document document = null;
		try {
			int index = urlIndex.getAndIncrement();
			document = Jsoup.connect(this.url.get(index)).get();
			String title = document.title();
			String content = document.select("#body").html();
			System.out.println("thread[" + index + "]:" + title + "name:" + Thread.currentThread().getName());
			webPage = new WebPage(title, "asdf");
		} catch (IOException e) {
			logger.error("连接失败", e);
			e.printStackTrace();
		}
		return webPage;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
