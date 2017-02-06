package ml.littleapp.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import ml.littleapp.model.CrawlerIpSrc;
import ml.littleapp.service.CrawlerIpSrcService;
import ml.littleapp.util.IdWorker;
import ml.littleapp.util.PropertiesUtil;
import ml.littleapp.vo.WebPage;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.introspector.PropertyUtils;

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
		IdWorker idWorker = new IdWorker(); 
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
		for (String update_ : updateList) {
			if (addList.contains(update_)) {
				crawlerIpSrc = new CrawlerIpSrc();
				crawlerIpSrc.setDeleted(false);
				example.clear();
				example.createCriteria().andEqualTo("url", update_);
				super.mapper.updateByExampleSelective(crawlerIpSrc, example);
				addList.remove(update_);
			} else if (removeList.contains(update_)) {
				removeList.removeAll(updateList);
			}
		}

		for (String url : addList) {
			crawlerIpSrc = new CrawlerIpSrc();
			crawlerIpSrc.setId(idWorker.nextId());
			crawlerIpSrc.setUrl(url);

			WebPage webPage = new WebPage(url);
			BeanUtils.copyProperties(webPage.getWPInfo(), crawlerIpSrc);
			System.out.println("test2");
			super.mapper.insertSelective(crawlerIpSrc);
		}

		System.out.println("test3");
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
