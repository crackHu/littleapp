package ml.littleapp.service.impl;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import ml.littleapp.pojo.CraIpPool;
import ml.littleapp.service.CraIpPoolService;

@Service
public class CraIpPoolServiceImpl extends BaseServiceImpl<CraIpPool> implements CraIpPoolService {

	@Override
	@Cacheable(value = "test", keyGenerator = "keyGenerator")
	public List<CraIpPool> selectAll(CraIpPool crawlerCrawlIp) throws Exception {
		System.out.println("无缓存的时候调用这里");
		return super.getAll(crawlerCrawlIp);
	}
}
