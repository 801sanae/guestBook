package com.hanains.guestbook.vo;

public class GuestBookVo {
	
	private int no;
	private String name;
	private String password;
	private String message;
	private String reg_date;

	public GuestBookVo() {
//		System.out.println("::"+this.getClass());
	}	
	
	public int getNo() {
		return no;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}
	
	public String getMessage() {
		return message;
	}

	public String getReg_date() {
		return reg_date;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}

	@Override
	public String toString() {
		return "GuestBookVo [no=" + no + ", name=" + name + ", password=" + password + ", reg_date=" + reg_date + "]";
	}
}
