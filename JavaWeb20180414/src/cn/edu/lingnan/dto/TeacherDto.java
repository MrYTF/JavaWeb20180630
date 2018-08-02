package cn.edu.lingnan.dto;

import java.io.Serializable;

public class TeacherDto implements Serializable{
	private String tid;
	private String tname;
	private String tsex;
	private int tage;
	private String celphone;
	private int sign2;
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	@Override
	public String toString() {
		return "TeacherDto [tid=" + tid + ", tname=" + tname + ", tsex=" + tsex + ", tage=" + tage + ", celphone="
				+ celphone + ", sign2=" + sign2 + "]";
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getTsex() {
		return tsex;
	}
	public void setTsex(String tsex) {
		this.tsex = tsex;
	}
	public int getTage() {
		return tage;
	}
	public void setTage(int tage) {
		this.tage = tage;
	}
	public String getCelphone() {
		return celphone;
	}
	public void setCelphone(String celphone) {
		this.celphone = celphone;
	}
	public int getSign2() {
		return sign2;
	}
	public void setSign2(int sign2) {
		this.sign2 = sign2;
	}
	public TeacherDto (String tid,String tname,String tsex, int tage,String celphone) {
		super();
		this.tid=tid;
		this.tname=tname;
		this.tsex=tsex;
		this.tage=tage;
		this.celphone=celphone;	
	}
	public TeacherDto() {
		super();
	}
}
