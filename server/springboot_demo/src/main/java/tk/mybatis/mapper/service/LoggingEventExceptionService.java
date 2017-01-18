package tk.mybatis.mapper.service;

import java.util.List;

import org.springframework.stereotype.Service;

import tk.mybatis.mapper.model.LoggingEventException;

public interface LoggingEventExceptionService {

	List<LoggingEventException> selectAll();
}
