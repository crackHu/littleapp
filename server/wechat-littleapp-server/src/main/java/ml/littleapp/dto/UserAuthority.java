/**
 * @Company Copyright © 2017 油兔不二. All rights reserved.
 *
 * @Title: UserAuthority.java
 * @Prject: wechat-littleapp-server
 * @Package: ml.littleapp.dto
 * @Description: TODO
 * @author: crack
 * @date: 2017年4月4日 下午4:04:42
 * @version: V1.0
 */
package ml.littleapp.dto;

import java.util.List;

import ml.littleapp.pojo.SysUser;

/**
 * @ClassName: UserAuthority
 * @Description: TODO
 * @author: crack
 * @date: 2017年4月4日 下午4:04:42
 */
public class UserAuthority extends SysUser {

	private List<String> authorities;

	public List<String> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<String> authorities) {
		this.authorities = authorities;
	}

	@Override
	public String toString() {
		return "UserAuthority [authorities=" + authorities + "]";
	}

}
