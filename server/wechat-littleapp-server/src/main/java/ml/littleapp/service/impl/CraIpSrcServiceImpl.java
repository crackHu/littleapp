package ml.littleapp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import ml.littleapp.pojo.CraIpSrc;
import ml.littleapp.service.CraIpSrcService;
import ml.littleapp.util.PropertiesUtil;
import ml.littleapp.vo.WebPage;
import tk.mybatis.mapper.entity.Example;

@Service
public class CraIpSrcServiceImpl extends BaseServiceImpl<CraIpSrc> implements CraIpSrcService {

	@Override
	public void saveByIpProperties() throws Exception {
		List<String> siteList = getIpSites();
		List<CraIpSrc> CraIpSrcList = super.getAll(null);
		List<String> urlList = new ArrayList<String>();
		List<String> addList = new ArrayList<String>();
		List<String> updateList = new ArrayList<String>();
		List<String> removeList = new ArrayList<String>();
		CraIpSrc CraIpSrc = null;
		Example example = new Example(CraIpSrc.class);

		for (CraIpSrc CraIpSrc1 : CraIpSrcList) {
			String url = CraIpSrc1.getDomain();
			Boolean deleted = CraIpSrc1.getIsDeleted();
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
				CraIpSrc = new CraIpSrc();
				CraIpSrc.setIsDeleted(false);
				example.clear();
				example.createCriteria().andEqualTo("url", update_);
				super.mapper.updateByExampleSelective(CraIpSrc, example);
				addList.remove(update_);
			} else if (removeList.contains(update_)) {
				removeList.removeAll(updateList);
			}
		}

		long start1 = System.currentTimeMillis();
		WebPage webPage = new WebPage(addList);
		List<WebPage> wpInfo = webPage.getWPInfo();
		long end1 = System.currentTimeMillis();
		System.out.println("使用时间：" + (end1 - start1) + "ms");

		/*CraIpSrc = new CraIpSrc();
		CraIpSrc.setIsDeleted(true);
		for (String url : removeList) {
			example.clear();
			example.createCriteria().andEqualTo("url", url);
			super.mapper.updateByExampleSelective(CraIpSrc, example);
		}*/
	}

	private static List<String> getIpSites() {
		String path = "src/main/resources/%s";
		String filePath = String.format(path, "crawler");
		String fileName = "ip.properties";
		String propertyName = "site";
		String defaultValue = "";

		List<String> propertyList = PropertiesUtil.getPropertyList(filePath, fileName, propertyName, defaultValue);
		return propertyList;
	}

}
