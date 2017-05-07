package ml.littleapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import org.jsoup.Connection.Request;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ml.littleapp.crawler.concurrent.impl.IpSrcCrawler;
import ml.littleapp.dto.UserAuthority;
import ml.littleapp.dto.crawler.IpSrcPage;
import ml.littleapp.mapper.CraIpSrcMapper;
import ml.littleapp.mapper.SysUserMapper;
import ml.littleapp.pojo.CraIpPool;
import ml.littleapp.pojo.CraIpSrc;
import ml.littleapp.pojo.SysUser;
import ml.littleapp.rabbitmq.Sender;
import ml.littleapp.service.CraIpPoolService;
import ml.littleapp.service.CraIpSrcService;
import tk.mybatis.mapper.entity.Example;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WechatLittleappServerApplicationTests {

	@Inject
	private CraIpPoolService CraIpPoolService;
	@Inject
	private CraIpSrcService ipSrcService;
	@Inject
	private CraIpSrcMapper ipSrcMapper;
	@Inject
	private SysUserMapper sysUserMapper;
	
	@Inject
	private Sender sender;

	@Test
	public void putCache() throws Exception {
		CraIpPool CraIpPool = new CraIpPool();
		CraIpPoolService.selectAll(CraIpPool);
	}

	@Test
	public void testInsertCraIpPool() throws Exception {
		CraIpPool CraIpPool = new CraIpPool();
		CraIpPool.setId(234l);
		CraIpPool.setIp(2222);
		CraIpPool.setPort(2222);
		CraIpPool.setAddress("asdfg");
		CraIpPool.setIsDeleted(false);
		CraIpPoolService.save(CraIpPool);
	}

	@Test
	public void contextLoads() throws Exception {
		CraIpPool CraIpPool = new CraIpPool();
		List<CraIpPool> selectAll = CraIpPoolService.selectAll(CraIpPool);
		for (CraIpPool c : selectAll) {
			System.out.println(c.getId());
		}
	}

	@Test
	public void testPage() throws Exception {
		CraIpPool CraIpPool = new CraIpPool();
		List<CraIpPool> list = CraIpPoolService.selectAll(CraIpPool);
		for (CraIpPool CraIpPool2 : list) {
			System.out.println(CraIpPool2.getId());
		}
	}

	@Test
	public void testCraIpSrcSave() throws Exception {
		ipSrcService.initIpProperties();
	}

	@Test
	public void testCraIpSrcUpdate() throws Exception {
		CraIpSrc ipSrc = new CraIpSrc();
		ipSrc.setDomain("adsfSDf");
		Example example = new Example(CraIpSrc.class);
		example.or().andEqualTo("title", "44");
		ipSrcMapper.updateByExampleSelective(ipSrc, example);
	}

	@Test
	public void testCraIpSrcSelect() throws Exception {
		CraIpSrc craIpSrc = new CraIpSrc();
		craIpSrc.setPageNum(2);
		craIpSrc.setPageSize(2);
		// List<CraIpSrc> all = craIpSrcServiceImpl.getAll(craIpSrc);
		List<CraIpSrc> all = ipSrcService.getAll(null);
		
		Object craIpSrc1 = all.get(0);
		Class<? extends Object> class1 = craIpSrc1.getClass();
		Class<? extends Object> class2 = CraIpSrc.class;
		if (class1 == class2) {
			System.out.println("lalads落地费1");
		} else {
			System.out.println("的事发生的1");
		}
		if (craIpSrc1 instanceof CraIpSrc) {
			System.out.println("lalads落地费2");
		} else {
			System.out.println("的事发生的2");
		}
		
		all.forEach((a) -> System.out.println(a.getDomain()));
	}

	@Test
	public void testUser() {
		SysUser sysUser = new SysUser();
		sysUser.setUsername("admin");
		SysUser selectOne = sysUserMapper.selectOne(sysUser);
		System.out.println(selectOne.getUsername());

		List<SysUser> selectByExample = sysUserMapper.selectByExample(sysUser);
		selectByExample.forEach(s -> System.out.println(s.getUsername()));

	}

	@Test
	public void testUserMapper() {
		UserAuthority userAuthority = sysUserMapper.queryByUsername("admin");

		// return authorities.stream()
		// .map(authority ->
		// new SimpleGrantedAuthority(authority.name())
		// )
		// .collect(Collectors.toList());
	}

	public interface Callback<T> {
		
		T call();
	}

	public static class MyUtil<Key, Value> {
		
		public <T> T value(Callback<T> cb) {
			return cb.call();
		}

	}

	@Test
	public void test3() {
		MyUtil myUtil = new MyUtil();
		Long value = (Long) myUtil.value(() -> 10L);
		System.out.println("result:" + value);
	}

	@Test
	public void test4() {
		MyUtil<String, String> myUtil = new MyUtil<>();
		Long value = myUtil.value(() -> 10L);
		System.out.println("result:" + value);
	}
	
	@Test
	public void testStream() {
		List<String> list = Collections.emptyList();
		list.add("aaa");
		list.add("bb");
		list.add("cc");
		list.stream().forEach((s) -> System.out.print(s));
	}
	
	@Test
	public void testRabbitMQ() {
		sender.send();
	}
	
	@Test
	public void commandLineRunner() throws Exception {
		List<String> domains = ipSrcService.initIpProperties();
		IpSrcCrawler ipSrcCrawler = new IpSrcCrawler(domains);
		List<IpSrcPage> ipSrcPages = ipSrcCrawler.run(domains);
		ipSrcPages.forEach((page) -> System.out.print(page));
	}
	
	@Test
	public void testJsoup() {
		Request request = Jsoup.connect("http://www.xicidaili.com/qq").request();
	}
	
	@Test
	public void testBeanCopy() {
		CraIpSrc ipSrc = new CraIpSrc();
		IpSrcPage ipSrcPage = new IpSrcPage("asdf", "asdf", 2);
		BeanUtils.copyProperties(ipSrcPage, ipSrc);
		System.out.println(ipSrc.getTitle() + ipSrc.getContent());
	}

	public static void main(String[] args) throws Exception {
		Document document = Jsoup.connect("http://www.xicidaili.com/qq").get();
		Elements select = document.select(".pagination a");
		Element element = select.get(select.size() - 2);
		System.out.println(element.text());
	}
}
