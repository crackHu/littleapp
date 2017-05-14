package ml.littleapp.dto.crawler;

public class IpSrcPagingPage extends Page {

    private Integer pageNo;

	public IpSrcPagingPage(String title, String content, Integer pageNo) {
		super(title, content);
		this.pageNo = pageNo;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	
	
	
}
