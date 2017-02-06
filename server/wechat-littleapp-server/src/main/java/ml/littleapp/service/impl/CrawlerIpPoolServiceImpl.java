package ml.littleapp.service.impl;

import java.util.List;

import ml.littleapp.model.CrawlerIpPool;
import ml.littleapp.service.CrawlerIpPoolService;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CrawlerIpPoolServiceImpl extends BaseServiceImpl<CrawlerIpPool>
		implements CrawlerIpPoolService {

	@Override
	@Cacheable(value = "test", keyGenerator = "keyGenerator")
	public List<CrawlerIpPool> selectAll(CrawlerIpPool crawlerCrawlIp) throws Exception {
		System.out.println("无缓存的时候调用这里");
		return super.getAll(crawlerCrawlIp);
	}
}
