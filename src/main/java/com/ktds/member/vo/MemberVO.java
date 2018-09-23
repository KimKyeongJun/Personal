package com.ktds.member.vo;

public class MemberVO {

	String id;
	String password;
	String email;
	String phone;
	String mileage;
	String salt;
	String loginFailCount;
	String latestLogin;
	String isAdmin;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMileage() {
		return mileage;
	}

	public void setMileage(String mileage) {
		this.mileage = mileage;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getLoginFailCount() {
		return loginFailCount;
	}

	public void setLoginFailCount(String loginFailCount) {
		this.loginFailCount = loginFailCount;
	}

	public String getLatestLogin() {
		return latestLogin;
	}

	public void setLatestLogin(String latestLogin) {
		this.latestLogin = latestLogin;
	}

	public String isAdmin() {
		return isAdmin;
	}

	public void setAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}

}
