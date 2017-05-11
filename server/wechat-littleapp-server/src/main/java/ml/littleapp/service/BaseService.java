package ml.littleapp.service;

import java.util.List;

public interface BaseService<T> {

	List<T> getAll(T t) throws Exception;

	List<T> getAll(Integer pageNum, Integer pageSize) throws Exception;

	T getById(Integer id) throws Exception;

	int deleteById(Integer id) throws Exception;

	int save(T t) throws Exception;

	int update(T t) throws Exception;
}
