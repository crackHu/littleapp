package ml.littleapp.service;

import ml.littleapp.model.CrawlerIpSrc;

public interface CrawlerIpSrcService extends BaseService<CrawlerIpSrc> {

	boolean saveByIpProperties() throws Exception;
}
