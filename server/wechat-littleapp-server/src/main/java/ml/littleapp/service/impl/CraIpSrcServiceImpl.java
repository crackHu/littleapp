package ml.littleapp.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import ml.littleapp.annotation.ConstStatistics;
import ml.littleapp.config.ApplicationProperties;
import ml.littleapp.config.ApplicationProperties.Crawler.Ip.Init;
import ml.littleapp.config.EntityExample;
import ml.littleapp.crawler.concurrent.impl.IpSrcCrawler;
import ml.littleapp.dto.crawler.IpSrcPage;
import ml.littleapp.pojo.CraIpSrc;
import ml.littleapp.service.CraIpSrcService;
import ml.littleapp.util.IdWorker;
import ml.littleapp.util.concurrent.ExecutorHelper;
import tk.mybatis.mapper.entity.Example;

@Service
public class CraIpSrcServiceImpl extends BaseServiceImpl<CraIpSrc> implements CraIpSrcService {

	@Inject
	private IdWorker idWorker;

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	private Example example = null; // new Example(CraIpSrc.class)
	
	@Override
	@ConstStatistics
	public void init() throws Exception {
		List<String> domains = initIpProperties();
		IpSrcCrawler ipSrcCrawler = new IpSrcCrawler(domains);
		List<IpSrcPage> ipSrcPages = ipSrcCrawler.run(getIpProperties().getInit().getThreadNum());

		IntStream.range(0, ipSrcPages.size()).forEach(index -> {
			String domain = domains.get(index);
			IpSrcPage ipSrcPage = ipSrcPages.get(index);
			
			CraIpSrc ipSrc = new CraIpSrc();
			BeanUtils.copyProperties(ipSrcPage, ipSrc);
			example = new Example(CraIpSrc.class);
			example.clear();
			example.or().andEqualTo("domain", domain);
			super.mapper.updateByExampleSelective(ipSrc, example);
		});
		
		// cache thread 1365ms
		// single 1263ms
		// fix one 1287ms
		// fix five 1302ms
	}

	@Override
	@ConstStatistics
	public List<String> initIpProperties() throws Exception {
		List<CraIpSrc> ipSrcs = super.mapper.selectAll();
		// List<String> ipSiteList = GetPropertiesUtil.getIpSites();
		List<String> ipSiteList = Arrays.asList(getIpProperties().getSources());

		// 需要插入的集合
		List<String> insertList = new ArrayList<String>(ipSiteList);
		// 需要删除的集合
		List<String> deleteList = new ArrayList<String>();
		// 需要更新 isDeleted 为 false 的集合
		List<String> updateList = new ArrayList<String>();

		ipSrcs.forEach(ipSrc -> {
			String domain = ipSrc.getDomain();
			Boolean deleted = ipSrc.getIsDeleted();
			if (ipSiteList.contains(domain)) {
				// 1.
				if (deleted) {
					updateList.add(domain);
				}
				// 2.
				insertList.remove(domain);
			} else {
				// 3.
				if (!deleted) {
					deleteList.add(domain);
				}
			}
		});

		log.info("initIpProperties ipSiteList: {}", ipSiteList);
		log.info("initIpProperties updateList: {}", updateList);
		log.info("initIpProperties insertList: {}", insertList);
		log.info("initIpProperties deleteList: {}", deleteList);

		// 线程计数器
		CountDownLatch countDownLatch = new CountDownLatch(3);

		// 1. updateList - 如果需要插入的集合元素存在数据库切已经删除，需要更新为不删除
		Runnable updateThread = () -> {
			System.out.println("updateList:" + Thread.currentThread().getName());
			batchModifyActiveOrNotByDomains(updateList, false);
			countDownLatch.countDown();
		};

		// 2. insertList - 需要插入的集合插入数据库
		Runnable insertThread = () -> {
			System.out.println("insertThread:" + Thread.currentThread().getName());
			insertList.forEach(domain -> {
				CraIpSrc ipSrc = new CraIpSrc();
				ipSrc.setId(idWorker.nextId());
				ipSrc.setDomain(domain);
				super.mapper.insertSelective(ipSrc);
			});
			countDownLatch.countDown();
		};

		// 3. deleteList - 需要删除的集合从数据库中删除
		Runnable deleteThread = () -> {
			System.out.println("deleteList:" + Thread.currentThread().getName());
			batchModifyActiveOrNotByDomains(deleteList, true);
			countDownLatch.countDown();
		};

		ExecutorService executorService = Executors.newCachedThreadPool();
		executorService = ExecutorHelper.executor(getIpProperties().getInit().getThreadNum());

		try {
			if (updateList.size() > 0)
				executorService.submit(updateThread);
			if (insertList.size() > 0)
				executorService.submit(insertThread);
			if (deleteList.size() > 0)
				executorService.submit(deleteThread);
			
			// countDownLatch.await();
		} catch (Exception e) {
			log.error("initIpProperties concurrency error", e);
		} finally {
			executorService.shutdown();
		}

		return ipSiteList;

		// 串行 646ms
		// 1线程 393ms
		// 3线程 399ms
		// 计数器 1线程 598ms
		// 计数器 3线程 606ms
		// long start1 = System.currentTimeMillis();
		// WebPage webPage = new WebPage(insertList);
		// List<WebPage> wpInfo = webPage.getWPInfo();
		// long end1 = System.currentTimeMillis();
		// System.out.println("使用时间：" + (end1 - start1) + "ms");
	}

	private void batchModifyActiveOrNotByDomains(List<String> domains, Boolean isActive) {
		if (domains == null || domains.size() == 0)
			return;

		List<CraIpSrc> list = new ArrayList<CraIpSrc>();
		domains.forEach(domain -> {
			CraIpSrc ipSrc = new CraIpSrc();
			ipSrc.setIsDeleted(isActive);
			list.add(ipSrc);
			example.clear();
			example.or().andEqualTo("domain", domain);
			this.batchUpdate(list, example);
		});
	}

	@Override
	public void batchUpdate(List<CraIpSrc> list, Example example) {
		list.forEach(item -> {
			super.mapper.updateByExampleSelective(item, example);
		});
	}

}
