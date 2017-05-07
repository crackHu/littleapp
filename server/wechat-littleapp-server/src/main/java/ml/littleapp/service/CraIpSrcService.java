package ml.littleapp.service;

import java.util.List;

import ml.littleapp.pojo.CraIpSrc;
import tk.mybatis.mapper.entity.Example;

public interface CraIpSrcService extends BaseService<CraIpSrc> {

	void init() throws Exception;
	
	List<String> initIpProperties() throws Exception;
	
	void batchUpdate(List<CraIpSrc> list, Example example);
}
