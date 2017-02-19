package ml.littleapp;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ml.littleapp.mapper.LoggingEventMapper;
import ml.littleapp.pojo.CraIpPool;
import ml.littleapp.pojo.CraIpSrc;
import ml.littleapp.service.CraIpPoolService;
import ml.littleapp.service.impl.CraIpSrcServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WechatLittleappServerApplicationTests {

	@Inject
	private CraIpPoolService CraIpPoolService;
	@Inject
	private LoggingEventMapper loggingEventMapper;
	@Inject
	private CraIpSrcServiceImpl craIpSrcServiceImpl;

	@Test
	public void putCache() throws Exception {
		CraIpPool CraIpPool = new CraIpPool();
		CraIpPoolService.selectAll(CraIpPool);
	}

	@Test
	public void testInsertCraIpPool() throws Exception {
		CraIpPool CraIpPool = new CraIpPool();
		CraIpPool.setId(234l);
		CraIpPool.setIp(2222);
		CraIpPool.setPort(2222);
		CraIpPool.setAddress("asdfg");
		CraIpPool.setIsDeleted(false);
		CraIpPoolService.save(CraIpPool);
	}

	@Test
	public void contextLoads() throws Exception {
		CraIpPool CraIpPool = new CraIpPool();
		List<CraIpPool> selectAll = CraIpPoolService.selectAll(CraIpPool);
		for (CraIpPool c : selectAll) {
			System.out.println(c.getId());
		}
	}

	@Test
	public void testPage() throws Exception {
		CraIpPool CraIpPool = new CraIpPool();
		List<CraIpPool> list = CraIpPoolService.selectAll(CraIpPool);
		for (CraIpPool CraIpPool2 : list) {
			System.out.println(CraIpPool2.getId());
		}
	}

	@Test
	public void testCraIpSrcSave() throws Exception {
		craIpSrcServiceImpl.saveByIpProperties();
	}

	@Test
	public void testCraIpSrcSelect() throws Exception {
		CraIpSrc craIpSrc = new CraIpSrc();
		craIpSrc.setPageNum(2);
		craIpSrc.setPageSize(2);
		List<CraIpSrc> all = craIpSrcServiceImpl.getAll(craIpSrc);
		for (CraIpSrc craIpSrc2 : all) {
			System.out.println(craIpSrc2.getDomain());
		}
	}

	public static void main(String[] args) throws Exception {

		System.out.println(1234l);
	}
}
