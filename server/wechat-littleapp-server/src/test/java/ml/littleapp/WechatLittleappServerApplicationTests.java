package ml.littleapp;

import java.util.List;

import javax.inject.Inject;

import ml.littleapp.mapper.LoggingEventMapper;
import ml.littleapp.model.CrawlerCrawlIp;
import ml.littleapp.model.LoggingEvent;
import ml.littleapp.service.CrawlerCrawlIpService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WechatLittleappServerApplicationTests {

	@Inject
	private CrawlerCrawlIpService crawlerCrawlIpService;
	@Inject
	private LoggingEventMapper loggingEventMapper;

	@Test
	public void putCache() {
		CrawlerCrawlIp crawlerCrawlIp = new CrawlerCrawlIp();
		crawlerCrawlIpService.selectAll(crawlerCrawlIp);
	}
	
	@Test
	public void testInsertCrawlerCrawlIp() {
		CrawlerCrawlIp crawlerCrawlIp = new CrawlerCrawlIp();
		crawlerCrawlIp.setId(234);
		crawlerCrawlIp.setIp(2222);
		crawlerCrawlIp.setPort(2222);
		crawlerCrawlIp.setAddress("asdfg");
		crawlerCrawlIp.setCreateBy("huyg");
		crawlerCrawlIp.setCreateDate(234234l);
		crawlerCrawlIp.setDeleted(false);
		crawlerCrawlIpService.save(crawlerCrawlIp);
	}

	@Test
	public void contextLoads() {
		CrawlerCrawlIp crawlerCrawlIp = new CrawlerCrawlIp();
		List<CrawlerCrawlIp> selectAll = crawlerCrawlIpService
				.selectAll(crawlerCrawlIp);
		for (CrawlerCrawlIp c : selectAll) {
			System.out.println(c.getId());
		}
	}

	@Test
	public void testPage() {
		CrawlerCrawlIp crawlerCrawlIp = new CrawlerCrawlIp();
		List<CrawlerCrawlIp> list = crawlerCrawlIpService.selectAll(crawlerCrawlIp);
		for (CrawlerCrawlIp crawlerCrawlIp2 : list) {
			System.out.println(crawlerCrawlIp2.getId());
		}
	}

	public static void main(String[] args) {
		System.out.println(System.currentTimeMillis());
	}
}
