package com.ktds.member.vo;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.ktds.member.validator.MemberValidator;

public class MemberVO {

	@NotEmpty(message="아이디를 입력해주세요", groups= {MemberValidator.MemberRegist.class, MemberValidator.MemberLogin.class})
	String id;
	@NotEmpty(message="비밀번호를 입력해주세요", groups= {MemberValidator.MemberRegist.class, MemberValidator.MemberLogin.class})
	@Pattern(regexp="((?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&*()]).{8,})", message="비밀번호는 8글자 이상 대소문자, 숫자, 특수문자 조합으로 설정해야 합니다.", groups= {MemberValidator.MemberRegist.class})
	String password;
	@NotEmpty(message="이메일을 입력해주세요", groups= {MemberValidator.MemberRegist.class})
	@Email(message="이메일  형식으로 작성해주세요", groups= {MemberValidator.MemberRegist.class})
	String email;
	@NotEmpty(message="전화번호를 입력해주세요", groups= {MemberValidator.MemberRegist.class})
	String phone;
	@NotEmpty(message="이름을 입력하세요", groups = {MemberValidator.MemberRegist.class})
	String name;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
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

}
