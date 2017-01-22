package ml.littleapp.service;

import java.util.List;

import ml.littleapp.model.CrawlerCrawlIp;

public interface CrawlerCrawlIpService extends BaseService<CrawlerCrawlIp> {

	List<CrawlerCrawlIp> selectAll(CrawlerCrawlIp crawlerCrawlIp);
}
