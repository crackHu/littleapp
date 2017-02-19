package ml.littleapp.service;

import java.util.List;

import ml.littleapp.pojo.CraIpPool;

public interface CraIpPoolService extends BaseService<CraIpPool> {

	List<CraIpPool> selectAll(CraIpPool craIpPool) throws Exception;
}
