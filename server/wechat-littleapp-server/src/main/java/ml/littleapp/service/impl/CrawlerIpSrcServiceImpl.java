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

		long start1 = System.currentTimeMillis();
		WebPage webPage = new WebPage(addList);
		List<WebPage> wpInfo = webPage.getWPInfo();
		/*for (int i = 0; i < wpInfo.size(); i++) {
			crawlerIpSrc = new CrawlerIpSrc();
			crawlerIpSrc.setUrl(addList.get(i));
			BeanUtils.copyProperties(wpInfo.get(i), crawlerIpSrc);
			super.mapper.insertSelective(crawlerIpSrc);
		}*/
		
		/*for (String url : addList) {
			crawlerIpSrc = new CrawlerIpSrc();
			crawlerIpSrc.setUrl(url);
-
			WebPage webPage = new WebPage(url);
			long start = System.currentTimeMillis();
			BeanUtils.copyProperties(webPage.getWPInfo(), crawlerIpSrc);
			long end = System.currentTimeMillis();
			System.out.println("使用时间："+(end-start)+"ms");
			super.mapper.insertSelective(crawlerIpSrc);
		}*/
		long end1 = System.currentTimeMillis();
		System.out.println("使用时间："+(end1-start1)+"ms");

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
