package tk.mybatis.mapper.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import tk.mybatis.mapper.mapper.LoggingEventExceptionMapper;
import tk.mybatis.mapper.model.LoggingEventException;
import tk.mybatis.mapper.service.LoggingEventExceptionService;

@Service
public class LoggingEventExceptionServiceImpl implements
		LoggingEventExceptionService {

	@Inject
	private LoggingEventExceptionMapper loggingEventExceptionMapper;

	@Override
	public List<LoggingEventException> selectAll() {
		List<LoggingEventException> selectAll = loggingEventExceptionMapper.selectAll();
		return selectAll;
	}
}
