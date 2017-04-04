package ml.littleapp.mapper;

import org.springframework.cache.annotation.Cacheable;

import ml.littleapp.dto.UserAuthority;
import ml.littleapp.pojo.SysUser;
import ml.littleapp.util.MyMapper;

public interface SysUserMapper extends MyMapper<SysUser> {

	@Cacheable(value = "userAuthority", keyGenerator = "keyGenerator")
	UserAuthority queryByUsername(String username);
}