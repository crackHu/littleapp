package ml.littleapp;

import java.util.List;

import javax.inject.Inject;

import ml.littleapp.mapper.LoggingEventMapper;
import ml.littleapp.model.CrawlerIpPool;
import ml.littleapp.service.CrawlerIpPoolService;

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

	@Test
	public void putCache() {
		CrawlerIpPool CrawlerIpPool = new CrawlerIpPool();
		CrawlerIpPoolService.selectAll(CrawlerIpPool);
	}

	@Test
	public void testInsertCrawlerIpPool() {
		CrawlerIpPool CrawlerIpPool = new CrawlerIpPool();
		CrawlerIpPool.setId(234);
		CrawlerIpPool.setIp(2222);
		CrawlerIpPool.setPort(2222);
		CrawlerIpPool.setAddress("asdfg");
		CrawlerIpPool.setCreateBy("huyg");
		CrawlerIpPool.setCreateDate(234234l);
		CrawlerIpPool.setDeleted(false);
		CrawlerIpPoolService.save(CrawlerIpPool);
	}

	@Test
	public void contextLoads() {
		CrawlerIpPool CrawlerIpPool = new CrawlerIpPool();
		List<CrawlerIpPool> selectAll = CrawlerIpPoolService
				.selectAll(CrawlerIpPool);
		for (CrawlerIpPool c : selectAll) {
			System.out.println(c.getId());
		}
	}

	@Test
	public void testPage() {
		CrawlerIpPool CrawlerIpPool = new CrawlerIpPool();
		List<CrawlerIpPool> list = CrawlerIpPoolService
				.selectAll(CrawlerIpPool);
		for (CrawlerIpPool CrawlerIpPool2 : list) {
			System.out.println(CrawlerIpPool2.getId());
		}
	}

	public static void main(String[] args) throws Exception {
		System.out.println(1);
		try {
			System.out.println(1 / 0);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("asdfasd");
		}
		System.out.println(2);
	}
}
