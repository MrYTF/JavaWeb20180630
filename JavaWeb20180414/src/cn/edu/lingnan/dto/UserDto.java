package cn.edu.lingnan.dto;

import java.io.Serializable;

public class UserDto implements Serializable{
	private String sid;
	private String sname;
	private String password;
	private int superuser;
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	@Override
	public String toString() {
		return "UserDto [sid=" + sid + ", sname=" + sname + ", password=" + password + ", superuser=" + superuser + "]";
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getSuperuser() {
		return superuser;
	}
	public void setSuperuser(int superuser) {
		this.superuser = superuser;
	}
	public UserDto (String sid,String sname,String password,int superuser) {
		super();
		this.sid=sid;
		this.sname=sname;
		this.password=password;
		this.superuser=superuser;
	}
	public UserDto() {
		super();
	}
}
