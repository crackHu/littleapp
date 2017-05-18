package ml.littleapp.dto.crawler;

import java.util.Date;

public class IpSrcPage extends Page {

    private Date gmtModified;
	
	private Integer pageTotal;

	public IpSrcPage(String title, String content, Date gmtModified, Integer pageTotal) {
		super(title, content);
		this.gmtModified = gmtModified;
		this.pageTotal = pageTotal;
	}

	public Date getGmtModified() {
		return gmtModified;
	}

	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}

	public Integer getPageTotal() {
		return pageTotal;
	}

	public void setPageTotal(Integer pageTotal) {
		this.pageTotal = pageTotal;
	}

}
