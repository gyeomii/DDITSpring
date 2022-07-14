package com.java.dto;

import java.util.Date;
//테이블을 Class로 사상시킴
public class MemberVO {
	// 사용자가 입력하는 정보
	private String id; // 아이디
	private String pwd; // 비밀번호
	private String email; // 이메일
	private String picture; // 사진파일경로/파일명
	private String phone; // 전화번호
	private String name; // 이름
	private String address; // 주소

	// 시스템에서 처리하는 정보, 관리자가 관리하는 정보
	private Date regDate; // 등록일
	private String authority; // 권한
	private int enabled; // 사용여부
	private String register; // 둥록자

	public MemberVO() {
	}

	public MemberVO(String id, String pwd) {
		super();
		this.id = id;
		this.pwd = pwd;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public String getRegister() {
		return register;
	}

	public void setRegister(String register) {
		this.register = register;
	}

	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone 
				+ ", address=" + address + "]";
	}
}
