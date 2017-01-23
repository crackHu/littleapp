package ml.littleapp.service;

import java.util.List;

public interface BaseService<T> {

	List<T> getAll(T t);

	T getById(Integer id);

	int deleteById(Integer id);

	int save(T t);
	
	int update(T t);
}
