package ml.littleapp.listener;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import ml.littleapp.model.CrawlerIpSrc;
import ml.littleapp.service.impl.CrawlerIpSrcServiceImpl;
import ml.littleapp.util.PropertiesUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebListener
public class CrawlerListener implements ServletContextListener {

	private static final Logger logger = LoggerFactory
			.getLogger(CrawlerListener.class);
	@Inject
	private CrawlerIpSrcServiceImpl crawlerIpSrcServiceImpl;

	@Override
	public void contextInitialized(ServletContextEvent sce) {

		logger.info("监听器启动成功", sce);
		

	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {

	}

}
