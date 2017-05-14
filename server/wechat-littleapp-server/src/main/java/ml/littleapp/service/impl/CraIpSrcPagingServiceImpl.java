package ml.littleapp.service.impl;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import ml.littleapp.config.ApplicationProperties;
import ml.littleapp.config.EntityExample;
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

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	private final Example example = EntityExample.ExampleHolder.getInstance(CraIpSrc.class);
	
	@Override
	public void paging() throws Exception {
		// TODO Auto-generated method stub
		
	}
}
