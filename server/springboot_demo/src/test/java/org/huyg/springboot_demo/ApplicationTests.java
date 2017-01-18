package org.huyg.springboot_demo;

import javax.inject.Inject;

import org.huyg.springboot_demo.controller.CrawlIpController;
import org.huyg.springboot_demo.dao.UserMapper;
import org.huyg.springboot_demo.pojo.User;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@Transactional
public class ApplicationTests {

	@Inject
	private UserMapper userMapper;
	@Inject
	private CrawlIpController crawlIpController;
	private static long begin;

	@BeforeClass
	public static void beforeClass() {
	}
	
	@AfterClass 
	public static void afterClass() {
	}
	
	@Test
	@Rollback
	public void testUserMapper() throws Exception {
		User user = userMapper.findUserByName("王偉");
		System.out.println(user);
	}
	
	@Test
	@Rollback
	public void testCrawlIpController() throws Exception {
		begin = System.currentTimeMillis();
		
		System.out.println(crawlIpController.crawl());
		
		long end = System.currentTimeMillis();
		System.out.println("耗时：" + (end - begin) * 0.001);
	}
	
}
