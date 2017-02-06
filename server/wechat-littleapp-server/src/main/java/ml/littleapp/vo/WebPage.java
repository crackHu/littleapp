package ml.littleapp.vo;

import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebPage implements Callable<WebPage> {

	private static final Logger logger = LoggerFactory.getLogger(WebPage.class);
	private WebPage webPage;
	private String url;
	private String title;
	private String content;

	public WebPage(String url) {
		super();
		this.url = url;
	}

	public WebPage(String title, String content) {
		super();
		this.title = title;
		this.content = content;
	}

	public WebPage getWPInfo() {
		ExecutorService executor = Executors.newSingleThreadExecutor();
		FutureTask<WebPage> futureTask = new FutureTask<WebPage>(this);
		executor.execute(futureTask);
		System.out.println("test1");
		try {
			webPage = futureTask.get();
		} catch (InterruptedException | ExecutionException e) {
			logger.error("getWPInfo error!", e);
			e.printStackTrace();
		}
		return webPage;
	}

	@Override
	public WebPage call() throws Exception {
		Document document = null;
		try {
			document = Jsoup.connect(this.url).get();
			String title = document.title();
			String content = document.select("#body").html();
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
