package ml.littleapp.service;

import ml.littleapp.model.CrawlerIpSrc;

public interface CrawlerIpSrcService extends BaseService<CrawlerIpSrc> {

	void saveByIpProperties() throws Exception;
}
