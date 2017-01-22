package ml.littleapp.service.impl;

import java.util.List;

import ml.littleapp.model.CrawlerCrawlIp;
import ml.littleapp.service.CrawlerCrawlIpService;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CrawlerCrawlIpServiceImpl extends BaseServiceImpl<CrawlerCrawlIp>
		implements CrawlerCrawlIpService {

	@Override
	@Cacheable(value = "test", keyGenerator = "keyGenerator")
	public List<CrawlerCrawlIp> selectAll(CrawlerCrawlIp crawlerCrawlIp) {
		System.out.println("无缓存的时候调用这里");
		return super.getAll(crawlerCrawlIp);
	}
}
