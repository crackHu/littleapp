package ml.littleapp.service.impl;

import java.util.ArrayList;
import java.util.List;

import ml.littleapp.model.CrawlerIpSrc;
import ml.littleapp.service.CrawlerIpSrcService;
import ml.littleapp.util.PropertiesUtil;

import org.springframework.stereotype.Service;

import tk.mybatis.mapper.entity.Example;

@Service
public class CrawlerIpSrcServiceImpl extends BaseServiceImpl<CrawlerIpSrc>
		implements CrawlerIpSrcService {

	@Override
	public void saveByIpProperties() throws Exception {
		List<String> siteList = getIpSites();
		List<CrawlerIpSrc> crawlerIpSrcList = super.getAll(null);
		List<String> urlList = new ArrayList<String>();
		List<String> addList = new ArrayList<String>();
		List<String> updateList = new ArrayList<String>();
		List<String> removeList = new ArrayList<String>();
		CrawlerIpSrc crawlerIpSrc = null;
		boolean updateListFlag = false;
		Example example = new Example(CrawlerIpSrc.class);

		for (CrawlerIpSrc crawlerIpSrc1 : crawlerIpSrcList) {
			String url = crawlerIpSrc1.getUrl();
			Boolean deleted = crawlerIpSrc1.getDeleted();
			if (deleted) {
				updateList.add(url);
			} else {
				urlList.add(url);
			}
		}
		addList.addAll(siteList);
		addList.removeAll(urlList);
		removeList.addAll(urlList);
		removeList.removeAll(siteList);
		if (addList.containsAll(updateList)) {
			addList.removeAll(updateList);
			updateListFlag = false;
		} else if (removeList.containsAll(updateList)) {
			removeList.removeAll(updateList);
			updateListFlag = true;
		}

		for (String url : addList) {
			crawlerIpSrc = new CrawlerIpSrc();
			crawlerIpSrc.setId(System.currentTimeMillis());
			crawlerIpSrc.setUrl(url);
			super.mapper.insertSelective(crawlerIpSrc);
		}

		if (!(addList.isEmpty() && removeList.isEmpty())) {
			crawlerIpSrc = new CrawlerIpSrc();
			crawlerIpSrc.setDeleted(updateListFlag);
			for (String url : updateList) {
				example.clear();
				example.createCriteria().andEqualTo("url", url);
				super.mapper.updateByExampleSelective(crawlerIpSrc, example);
			}
		}

		crawlerIpSrc = new CrawlerIpSrc();
		crawlerIpSrc.setDeleted(true);
		for (String url : removeList) {
			example.clear();
			example.createCriteria().andEqualTo("url", url);
			super.mapper.updateByExampleSelective(crawlerIpSrc, example);
		}
	}

	private static List<String> getIpSites() {
		String path = "src/main/resources/%s";
		String filePath = String.format(path, "crawler");
		String fileName = "ip.properties";
		String propertyName = "site";
		String defaultValue = "";

		List<String> propertyList = PropertiesUtil.getPropertyList(filePath,
				fileName, propertyName, defaultValue);
		return propertyList;
	}

}
