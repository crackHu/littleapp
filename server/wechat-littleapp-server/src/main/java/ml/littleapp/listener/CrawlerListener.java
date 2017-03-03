package ml.littleapp.listener;

import javax.inject.Inject;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ml.littleapp.service.impl.CraIpSrcServiceImpl;

@WebListener
public class CrawlerListener implements ServletContextListener {

	private static final Logger logger = LoggerFactory.getLogger(CrawlerListener.class);
	@Inject
	private CraIpSrcServiceImpl craIpSrcServiceImpl;

	@Override
	public void contextInitialized(ServletContextEvent sce) {

		logger.info("监听器启动成功", sce);

	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {

	}

}
