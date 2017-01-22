package ml.littleapp.service;

import java.util.List;

public interface BaseService<T> {

	List<T> getAll(T t);

	T getById(Integer id);

	void deleteById(Integer id);

	void save(T t);
}
