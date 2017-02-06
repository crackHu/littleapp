package ml.littleapp;

import java.util.List;

import javax.inject.Inject;

import ml.littleapp.mapper.LoggingEventMapper;
import ml.littleapp.model.CrawlerIpPool;
import ml.littleapp.model.CrawlerIpSrc;
import ml.littleapp.service.CrawlerIpPoolService;
import ml.littleapp.service.impl.CrawlerIpSrcServiceImpl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WechatLittleappServerApplicationTests {

	@Inject
	private CrawlerIpPoolService CrawlerIpPoolService;
	@Inject
	private LoggingEventMapper loggingEventMapper;
	@Inject
	private CrawlerIpSrcServiceImpl crawlerIpSrcServiceImpl;

	@Test
	public void putCache() throws Exception {
		CrawlerIpPool CrawlerIpPool = new CrawlerIpPool();
		CrawlerIpPoolService.selectAll(CrawlerIpPool);
	}

	@Test
	public void testInsertCrawlerIpPool() throws Exception {
		CrawlerIpPool CrawlerIpPool = new CrawlerIpPool();
		CrawlerIpPool.setId(234l);
		CrawlerIpPool.setIp(2222);
		CrawlerIpPool.setPort(2222);
		CrawlerIpPool.setAddress("asdfg");
		CrawlerIpPool.setCreateBy("huyg");
		CrawlerIpPool.setDeleted(false);
		CrawlerIpPoolService.save(CrawlerIpPool);
	}

	@Test
	public void contextLoads() throws Exception {
		CrawlerIpPool CrawlerIpPool = new CrawlerIpPool();
		List<CrawlerIpPool> selectAll = CrawlerIpPoolService
				.selectAll(CrawlerIpPool);
		for (CrawlerIpPool c : selectAll) {
			System.out.println(c.getId());
		}
	}

	@Test
	public void testPage() throws Exception {
		CrawlerIpPool CrawlerIpPool = new CrawlerIpPool();
		List<CrawlerIpPool> list = CrawlerIpPoolService
				.selectAll(CrawlerIpPool);
		for (CrawlerIpPool CrawlerIpPool2 : list) {
			System.out.println(CrawlerIpPool2.getId());
		}
	}

	@Test
	public void testCrawlerIpSrcSave() throws Exception {
		crawlerIpSrcServiceImpl.saveByIpProperties();
	}

	@Test
	public void testCrawlerIpSrcSelect() throws Exception {
		CrawlerIpSrc crawlerIpSrc = new CrawlerIpSrc();
		crawlerIpSrc.setPageNum(2);
		crawlerIpSrc.setPageSize(2);
		List<CrawlerIpSrc> all = crawlerIpSrcServiceImpl.getAll(crawlerIpSrc);
		for (CrawlerIpSrc crawlerIpSrc2 : all) {
			System.out.println(crawlerIpSrc2.getUrl());
		}
	}

	public static void main(String[] args) throws Exception {

		System.out.println(1234l);
	}
}
