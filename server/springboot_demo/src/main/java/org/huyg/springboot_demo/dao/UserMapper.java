package org.huyg.springboot_demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.huyg.springboot_demo.pojo.User;

@Mapper
public interface UserMapper {

	@Select("select * from user where name = #{name}")
	User findUserByName(@Param("name") String name);
}
