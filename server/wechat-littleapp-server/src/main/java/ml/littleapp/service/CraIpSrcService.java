package ml.littleapp.service;

import ml.littleapp.pojo.CraIpSrc;

public interface CraIpSrcService extends BaseService<CraIpSrc> {

	void saveByIpProperties() throws Exception;
}
