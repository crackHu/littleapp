package ml.littleapp.security.service;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ml.littleapp.dto.UserAuthority;
import ml.littleapp.mapper.SysUserMapper;
import ml.littleapp.pojo.SysUser;
import ml.littleapp.security.JwtUser;
import ml.littleapp.security.JwtUserFactory;
import ml.littleapp.security.model.User;
import ml.littleapp.security.repository.UserRepository;

/**
 * Created by stephan on 20.03.16.
 */
@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {

//    @Autowired
//    private UserRepository userRepository;
    @Inject
    private SysUserMapper sysUserMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepository.findByUsername(username);
    	UserAuthority user = sysUserMapper.queryByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        } else {
            // return JwtUserFactory.create(user);
        	JwtUser create = JwtUserFactory.create(user);
        	return create;
        }
    }
}
