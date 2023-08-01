package com.gmission.doc.springsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.gmission.doc.springsecurity.UserLoginVO;

@Component
public class SecurityLoginDetailsService implements UserDetailsService {
	
	@Autowired
	private SecurityLoginMapper securityLoginMapper; 
	
	@Override
	public UserDetails loadUserByUsername(String loginid) throws UsernameNotFoundException {
		
		
		UserLoginVO userLoginVO = securityLoginMapper.selectLoginCheck(loginid).stream().findFirst().orElse(new UserLoginVO());
		
		return userLoginVO;
	}

}
