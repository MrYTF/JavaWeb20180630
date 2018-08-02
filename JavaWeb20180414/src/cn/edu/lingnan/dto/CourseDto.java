package cn.edu.lingnan.dto;

import java.io.Serializable;

public class CourseDto implements Serializable{
	private String cid;
	private String cname;
	private String time;
	private String site;
	private String price;
	private String lecturer;
	private String ctype;
	private int sign1;
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getLecturer() {
		return lecturer;
	}
	public void setLecturer(String lecturer) {
		this.lecturer = lecturer;
	}
	public String getCtype() {
		return ctype;
	}
	public void setCtype(String ctype) {
		this.ctype = ctype;
	}
	public int getSign1() {
		return sign1;
	}
	public void setSign1(int sign1) {
		this.sign1 = sign1;
	}
	//teacher
	
	//
	
	public CourseDto (String cid,String cname,String time, String site,String price,String lecturer,String ctype) {
		super();
		this.cid=cid;
		this.cname=cname;
		this.time=time;
		this.site=site;
		this.price=price;
		this.lecturer=lecturer;
		this.ctype=ctype;
	}
	
	public CourseDto() {
		super();
	}
}