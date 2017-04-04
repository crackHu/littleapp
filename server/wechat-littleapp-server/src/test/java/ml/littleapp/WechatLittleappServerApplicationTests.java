package ml.littleapp;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ml.littleapp.dto.UserAuthority;
import ml.littleapp.mapper.SysUserMapper;
import ml.littleapp.pojo.CraIpPool;
import ml.littleapp.pojo.CraIpSrc;
import ml.littleapp.pojo.SysUser;
import ml.littleapp.service.CraIpPoolService;
import ml.littleapp.service.impl.CraIpSrcServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WechatLittleappServerApplicationTests {

	@Inject
	private CraIpPoolService CraIpPoolService;
	@Inject
	private CraIpSrcServiceImpl craIpSrcServiceImpl;
	@Inject
	private SysUserMapper sysUserMapper;

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
		craIpSrcServiceImpl.saveByIpProperties();
	}

	@Test
	public void testCraIpSrcSelect() throws Exception {
		CraIpSrc craIpSrc = new CraIpSrc();
		craIpSrc.setPageNum(2);
		craIpSrc.setPageSize(2);
		List<CraIpSrc> all = craIpSrcServiceImpl.getAll(craIpSrc);
		for (CraIpSrc craIpSrc2 : all) {
			System.out.println(craIpSrc2.getDomain());
		}
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

	public static void main(String[] args) throws Exception {

		System.out.println(1234l);
	}
}
