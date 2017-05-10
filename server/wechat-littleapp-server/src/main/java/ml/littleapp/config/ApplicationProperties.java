package ml.littleapp.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties
public class ApplicationProperties {

	private final Crawler crawler = new Crawler();

	public Crawler getCrawler() {
		return crawler;
	}

	public static class Crawler {

		private final Ip ip = new Ip();

		public Ip getIp() {
			return ip;
		}

		public static class Ip {

			private final Init init = new Init();

			private final Paging paging = new Paging();

			private final Verify verify = new Verify();
			
			private String[] sources;
			
			public String[] getSources() {
				return sources;
			}

			public void setSources(String[] sources) {
				this.sources = sources;
			}

			public Init getInit() {
				return init;
			}

			public Paging getPaging() {
				return paging;
			}

			public Verify getVerify() {
				return verify;
			}

			public static class Init {

				private String threadNum;
				
				public String getThreadNum() {
					return threadNum;
				}

				public void setThreadNum(String threadNum) {
					this.threadNum = threadNum;
				}
			}

			public static class Paging {

				private String threadNum;

				public String getThreadNum() {
					return threadNum;
				}

				public void setThreadNum(String threadNum) {
					this.threadNum = threadNum;
				}
			}

			public static class Verify {

				private String threadNum;

				public String getThreadNum() {
					return threadNum;
				}

				public void setThreadNum(String threadNum) {
					this.threadNum = threadNum;
				}
			}
		}

	}

}
