package ml.littleapp.mapper;

import ml.littleapp.dto.UserAuthority;
import ml.littleapp.pojo.SysUser;
import ml.littleapp.util.MyMapper;

public interface SysUserMapper extends MyMapper<SysUser> {

	UserAuthority queryByUsername(String username);
}