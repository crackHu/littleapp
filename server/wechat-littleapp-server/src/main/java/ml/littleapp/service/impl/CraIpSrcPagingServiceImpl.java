package ml.littleapp.service.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.common.collect.Maps;

import ml.littleapp.config.ApplicationProperties;
import ml.littleapp.crawler.concurrent.impl.IpSrcPagingCrawler;
import ml.littleapp.pojo.CraIpSrc;
import ml.littleapp.pojo.CraIpSrcPaging;
import ml.littleapp.service.CraIpSrcPagingService;
import ml.littleapp.util.IdWorker;
import tk.mybatis.mapper.entity.Example;

@Service
public class CraIpSrcPagingServiceImpl extends BaseServiceImpl<CraIpSrcPaging> implements CraIpSrcPagingService {

	@Inject
	private IdWorker idWorker;
	@Inject
	private ApplicationProperties applicationProperties;

	@Inject
	private CraIpSrcServiceImpl ipSrcServiceImpl;

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	private final Example example = null;

	@Override
	public void paging() throws Exception {
		List<CraIpSrc> ipSrcs = ipSrcServiceImpl.getAll(null);
		List<Map<String, Object>> domainPageTotals = ipSrcs.stream()
				.map(ipSrc -> {
					Map<String, Object> map = Maps.newHashMap();
					map.put("domain", ipSrc.getDomain());
					map.put("query", ipSrc.getQuery());
					map.put("pageTotal", ipSrc.getPageTotal());
					return map;
				})
				.collect(Collectors.toList());
		IpSrcPagingCrawler ipSrcPagingCrawler = new IpSrcPagingCrawler(domainPageTotals);
		ipSrcPagingCrawler.run(getIpProperties().getPaging().getThreadNum());
	}
}
