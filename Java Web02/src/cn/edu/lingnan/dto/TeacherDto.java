package cn.edu.lingnan.dto;

public class TeacherDto {
	private String tid;
	private String tname;
	private String tsex;
	private String tage;
	private String celphone;
	private int sign2;
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
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
	public String getTage() {
		return tage;
	}
	public void setTage(String tage) {
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
	public TeacherDto (String tid,String tname,String tsex, String tage,String celphone) {
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
