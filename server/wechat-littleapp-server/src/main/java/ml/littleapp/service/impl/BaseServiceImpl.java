package ml.littleapp.service.impl;

import java.util.List;

import javax.inject.Inject;

import ml.littleapp.model.BaseEntity;
import ml.littleapp.service.BaseService;
import tk.mybatis.mapper.common.Mapper;

import com.github.pagehelper.PageHelper;

public class BaseServiceImpl<T extends BaseEntity> implements BaseService<T> {
	
	@Inject
	protected Mapper<T> mapper;

	@Override
	public List<T> getAll(T t) throws Exception {
		if (t.getPageNum() != null && t.getPageSize() != null) {
			PageHelper.startPage(t.getPageNum(), t.getPageSize());
		}
		return mapper.selectAll();
	}
	
	@Override
	public List<T> getAll(Integer pageNum, Integer pageSize) throws Exception {
		if (pageNum != null && pageSize != null) {
			PageHelper.startPage(pageNum, pageSize);
		}
		return mapper.selectAll();
	}

	@Override
	public T getById(Integer id) throws Exception {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public int deleteById(Integer id) throws Exception {
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public int save(T t) throws Exception {
		return mapper.insert(t);
	}

	@Override
	public int update(T t) throws Exception {
		return mapper.updateByPrimaryKey(t);
	}
}
