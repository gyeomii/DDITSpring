package com.jsp.dto;

public class MenuVO {
	private String mcode; // 메뉴코드
	private String mname; // 메뉴이름
	private String murl; // 메뉴url
	private String micon; // 메뉴아이콘
	private String jText; // javascript
	private String upcode; // 상위메뉴코드
	private int mlevel; // 메뉴레벨
	
	public String getMcode() {
		return mcode;
	}
	public void setMcode(String mcode) {
		this.mcode = mcode;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getMurl() {
		return murl;
	}
	public void setMurl(String murl) {
		this.murl = murl;
	}
	public String getMicon() {
		return micon;
	}
	public void setMicon(String micon) {
		this.micon = micon;
	}
	public String getjText() {
		return jText;
	}
	public void setjText(String jText) {
		this.jText = jText;
	}
	public String getUpcode() {
		return upcode;
	}
	public void setUpcode(String upcode) {
		this.upcode = upcode;
	}
	public int getMlevel() {
		return mlevel;
	}
	public void setMlevel(int mlevel) {
		this.mlevel = mlevel;
	}

	
}
