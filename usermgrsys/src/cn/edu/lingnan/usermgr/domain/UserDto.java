package cn.edu.lingnan.usermgr.domain;

import java.util.Date;
/**
 * 用户信息实体类
 * @author LiQi
 *
 */
public class UserDto {
	private int sid;
	private String sname;
	private String password;
	private String gender;
	private int age;
	private String phone;
	private Date birth;
	private String power;
	private int status;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String getPower() {
		return power;
	}
	public void setPower(String power) {
		this.power = power;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

	public UserDto(int sid, String sname, String password, String gender, int age, String phone, Date birth,
			String power, int status) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.password = password;
		this.gender = gender;
		this.age = age;
		this.phone = phone;
		this.birth = birth;
		this.power = power;
		this.status = status;
	}
	
	public UserDto(int sid, String sname, String password, String gender, int age, String phone, Date birth) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.password = password;
		this.gender = gender;
		this.age = age;
		this.phone = phone;
		this.birth = birth;
	}
	
	public UserDto(String sname, String password, String gender, int age, String phone, Date birth) {
		super();
		this.sname = sname;
		this.password = password;
		this.gender = gender;
		this.age = age;
		this.phone = phone;
		this.birth = birth;
	}
	
	public UserDto() {
		super();
	}	
	
	@Override
	public String toString() {
		return "userDto [sid=" + sid + ", sname=" + sname + ", password=" + password + ", gender=" + gender + ", age="
				+ age + ", phone=" + phone + ", birth=" + birth + ", power=" + power + ", status=" + status + "]";
	}
	
	/**
	 * 打印用户信息
	 */
	public void print() {
		System.out.println("用户ID："+sid+"\t用户名："+sname+"\t密码："+password+"\t性别："+gender+"\t年龄："+age+"\t联系方式："+phone+"\t出生日期："+birth+"\t权限："+power);
	}
}
