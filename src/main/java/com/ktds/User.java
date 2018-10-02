package com.ktds;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class User implements UserDetails {

	private String userId;
	private String userPassword;
	private String grade;
	private boolean isBlockAccount;
	private String token;

	public User(String userId, String userPassword, String grade, boolean isBlockAccount, String token) {
		this.userId = userId;
		this.userPassword = userPassword;
		this.grade = grade;
		this.isBlockAccount = isBlockAccount;
		this.token = token;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public boolean isBlockAccount() {
		return isBlockAccount;
	}

	public void setBlockAccount(boolean isBlockAccount) {
		this.isBlockAccount = isBlockAccount;
	}
	

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority( grade ));
		if ( grade.equals("ROLE_ADMIN")){
			authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		}
		return authorities;
	}

	@Override
	public String getPassword() {
		return this.userPassword;
	}

	@Override
	public String getUsername() {
		return this.userId;
	}

	@Override
	public boolean isAccountNonExpired() {			// 잠긴 계정인지 아닌지
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return !isBlockAccount;
	}

	@Override
	public boolean isCredentialsNonExpired() {		// 패스워드가 만료됐는지 아닌지(안됐으면 true)
		return true;
	}

	@Override
	public boolean isEnabled() {					// 탈퇴한 회원인지 아닌지
		return true;
	}

}
