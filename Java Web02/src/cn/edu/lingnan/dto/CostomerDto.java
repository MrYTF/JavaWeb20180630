package cn.edu.lingnan.dto;

public class CostomerDto {
	@Override
	public String toString() {
		return "CostomerDto [id=" + id + ", name=" + name + ", sex=" + sex + ", age=" + age + ", telephone=" + telephone
				+ ", course=" + course + ", register=" + register + ", type=" + type + ", sign=" + sign + "]";
	}
	private String id;
	private String name;
	private String sex;
	private int age;
	private String telephone;
	private String course;
	private String register;
	private String type;
	private int sign;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getRegister() {
		return register;
	}
	public void setRegister(String register) {
		this.register = register;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getSign() {
		return sign;
	}
	public void setSign(int sign) {
		this.sign = sign;
	}
	public CostomerDto (String id,String name,String sex,int age,String telephone,String course,String register,String type) {
		super();
		this.id=id;
		this.name=name;
		this.sex=sex;
		this.age=age;
		this.telephone=telephone;
		this.course=course;
		this.register=register;
		this.type=type;
	}
	public CostomerDto() {
		super();
	}
}
