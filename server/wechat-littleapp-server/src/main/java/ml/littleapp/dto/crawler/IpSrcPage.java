package ml.littleapp.dto.crawler;

public class IpSrcPage extends Page {

	private Integer pageTotal;

	public IpSrcPage(String title, String content, Integer pageTotal) {
		super(title, content);
		this.pageTotal = pageTotal;
	}

	public Integer getPageTotal() {
		return pageTotal;
	}

	public void setPageTotal(Integer pageTotal) {
		this.pageTotal = pageTotal;
	}

}
