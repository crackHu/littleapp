package ml.littleapp.service.impl;

import java.util.List;

import ml.littleapp.model.CrawlerIpSrc;
import ml.littleapp.service.CrawlerIpSrcService;
import ml.littleapp.util.PropertiesUtil;

import org.springframework.stereotype.Service;

@Service
public class CrawlerIpSrcServiceImpl extends BaseServiceImpl<CrawlerIpSrc>
		implements CrawlerIpSrcService {

	@Override
	public boolean saveByIpProperties() throws Exception {

		List<CrawlerIpSrc> all = super.getAll(null);
		
		List<String> ipSites = getIpSites();
		for (String site : ipSites) {
			CrawlerIpSrc crawlerIpSrc = new CrawlerIpSrc();
			crawlerIpSrc.setId(System.currentTimeMillis());
			crawlerIpSrc.setUrl(site);
			super.mapper.insertSelective(crawlerIpSrc);
		}

		return false;
	}

	private static List<String> getIpSites() {
		String path = "src/main/resources/%s";
		String filePath = String.format(path, "crawler");
		String fileName = "ip.properties";
		String propertyName = "site";
		String defaultValue = "null";

		List<String> propertyList = PropertiesUtil.getPropertyList(filePath,
				fileName, propertyName, defaultValue);
		return propertyList;
	}
}
