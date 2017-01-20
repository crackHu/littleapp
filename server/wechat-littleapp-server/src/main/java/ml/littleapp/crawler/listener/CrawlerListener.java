package ml.littleapp.crawler.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebListener
public class CrawlerListener implements ServletContextListener {

	private static final Logger logger = LoggerFactory
			.getLogger(CrawlerListener.class);

	@Override
	public void contextInitialized(ServletContextEvent sce) {

		logger.info("监听器启动成功", sce);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}


}
