package ml.littleapp.service;

import java.util.List;

import ml.littleapp.model.CrawlerIpPool;

public interface CrawlerIpPoolService extends BaseService<CrawlerIpPool> {

	List<CrawlerIpPool> selectAll(CrawlerIpPool crawlerCrawlIp)
			throws Exception;
}
