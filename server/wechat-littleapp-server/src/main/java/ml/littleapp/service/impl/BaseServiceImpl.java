package ml.littleapp.service.impl;

import java.util.List;

import javax.inject.Inject;

import ml.littleapp.model.BaseEntity;
import ml.littleapp.service.BaseService;
import tk.mybatis.mapper.common.Mapper;

import com.github.pagehelper.PageHelper;

public class BaseServiceImpl<T extends BaseEntity> implements
		BaseService<T> {

	@Inject
	private Mapper<T> mapper;

	@Override
	public List<T> getAll(T t) {
		if (t.getPage() != null && t.getRows() != null) {
			PageHelper.startPage(t.getPage(), t.getRows());
		}
		return mapper.selectAll();
	}

	@Override
	public T getById(Integer id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public int deleteById(Integer id) {
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public int save(T t) {
		return mapper.insert(t);
	}

	@Override
	public int update(T t) {
		return mapper.updateByPrimaryKey(t);
	}
	
}
