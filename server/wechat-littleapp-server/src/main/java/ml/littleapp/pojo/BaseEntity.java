package ml.littleapp.pojo;

import javax.persistence.Transient;

/**
 * 基础信息
 * 
 * @author huyg
 * @since 2017-01-22 14:40:04
 */
public class BaseEntity {

	@Transient
	private Integer pageNum = 1;

	@Transient
	private Integer pageSize = 10;

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
}