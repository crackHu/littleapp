package ml.littleapp.crawler.concurrent;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface Crawler {

	final Logger log = LoggerFactory.getLogger(Crawler.class);

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
}
