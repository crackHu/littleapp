package ml.littleapp.dto.crawler;

public class Page {

	private String title;
	private String content;

	public Page(String title, String content) {
		super();
		this.title = title;
		this.content = content;
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

	@Override
	public String toString() {
		return "Page [title=" + title + ", content=" + content + "]";
	}
}
