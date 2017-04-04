/**
 * @Company Copyright © 2017 油兔不二. All rights reserved.
 *
 * @Title: UserTest.java
 * @Prject: wechat-littleapp-server
 * @Package: ml.littleapp.security.model
 * @Description: TODO
 * @author: crack
 * @date: 2017年4月4日 下午10:10:12
 * @version: V1.0
 */
package ml.littleapp.security.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @ClassName: UserTest
 * @Description: TODO
 * @author: crack
 * @date: 2017年4月4日 下午10:10:12
 */
public class UserTest implements UserDetails {

	/* (non Javadoc)
	 * @Title: getAuthorities
	 * @Description: TODO
	 * @return
	 * @see org.springframework.security.core.userdetails.UserDetails#getAuthorities()
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non Javadoc)
	 * @Title: getPassword
	 * @Description: TODO
	 * @return
	 * @see org.springframework.security.core.userdetails.UserDetails#getPassword()
	 */
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non Javadoc)
	 * @Title: getUsername
	 * @Description: TODO
	 * @return
	 * @see org.springframework.security.core.userdetails.UserDetails#getUsername()
	 */
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non Javadoc)
	 * @Title: isAccountNonExpired
	 * @Description: TODO
	 * @return
	 * @see org.springframework.security.core.userdetails.UserDetails#isAccountNonExpired()
	 */
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non Javadoc)
	 * @Title: isAccountNonLocked
	 * @Description: TODO
	 * @return
	 * @see org.springframework.security.core.userdetails.UserDetails#isAccountNonLocked()
	 */
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non Javadoc)
	 * @Title: isCredentialsNonExpired
	 * @Description: TODO
	 * @return
	 * @see org.springframework.security.core.userdetails.UserDetails#isCredentialsNonExpired()
	 */
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non Javadoc)
	 * @Title: isEnabled
	 * @Description: TODO
	 * @return
	 * @see org.springframework.security.core.userdetails.UserDetails#isEnabled()
	 */
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

}
