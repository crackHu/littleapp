package ml.littleapp.dto.crawler;

public class Page {

	private String title;
	private String content;
	private Integer pageTotal;

	public Page(String title, String content, Integer pageTotal) {
		super();
		this.title = title;
		this.content = content;
		this.pageTotal = pageTotal;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getPageTotal() {
		return pageTotal;
	}

	public void setPageTotal(Integer pageTotal) {
		this.pageTotal = pageTotal;
	}

	@Override
	public String toString() {
		return "Page [title=" + title + ", pageTotal=" + pageTotal + "]";
	}
}
