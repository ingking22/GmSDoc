package com.gmission.doc.springsecurity;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginVO implements UserDetails {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7307324309074552766L;
	private String loginid;
	private String userid;
	private String usernm;
	private String userpw;
	private String deptid;
	private String email;
	private String telno;
	private String mobileno;
	private String faxno;
	private String companyaddr;
	private String loginyn;
	private String userauthcd;
	private String jobgradecode1;
	private String jobgradecode2;
	private String jobrankcode;
	private String jobrankname;
	private int sortorder;
	private String retireyn; 
	private String companycd;
	private String approveryn;
	private String requesthostip;
	private String pctypecd;
	private String regdt;
	private String moddt;
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(userauthcd));
		
		return authorities;
	}

	@Override
	public String getPassword() {
		return userpw;
	}

	@Override
	public String getUsername() {
		return usernm;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
