package cn.edu.lingnan.usermgr.view;
/**
 * 页面显示
 * @author LiQi
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

import cn.edu.lingnan.common.util.TypeUtil;
import cn.edu.lingnan.usermgr.controller.UserController;
import cn.edu.lingnan.usermgr.domain.UserDto;
/**
 * 主视图层
 * @author LiQi
 *
 */
public class IndexFrame implements BaseFrame{
	
	/**
	 * 系统首页面
	 */
	@Override
	public void show() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int i = -1;
		//循环操作
		while(true) {
			//用户登录和注册页面
			System.out.println("-------欢迎使用用户管理系统-----");
			System.out.println();
			System.out.println("登录--------------------1");
			System.out.println("注册--------------------2");
			System.out.println("退出--------------------3");
			System.out.println();
			System.out.println("------------------------");
			System.out.println("请输入：");
			
			while(true) {
				try {
					i = Integer.parseInt(br.readLine());
					break;
				} catch (Exception e) {
					System.out.println("输入错误，请输入1-3数字");
					System.out.println("请重新输入：");
				}
			}
			/**
			 * 判断用户输入的值
			 */
			switch(i) {
			case 1: 
				this.loginShow();
				break;
			case 2:
				this.addShow();
				break;
			case 3:
				System.out.println("感谢您的使用，回见....");
				System.exit(0);
			default:
				System.out.println("输入错误，请重新输入...");
				break;
			}
		}
	
	}
	
	/**
	 * 用户登录页面
	 */
	public void loginShow() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("--------用户登录界面---------");
		while(true) {
		System.out.println("请输入您的用户名：");
		try {
			String sname = br.readLine();
			System.out.println("请输入您的密码：");
			String password = br.readLine();
			UserController controller = new UserController();
			UserDto dto = controller.doLogin(sname, password);
			if (dto != null) {
				System.out.println("登录成功....");
				System.out.println("------------------------");
				System.out.println();
				if ("管理员".equals(dto.getPower())) {
					AdminFrame adminFrame = new AdminFrame(dto);
					adminFrame.show();
				}else {
					NormalFrame frame = new NormalFrame(dto);
					frame.show();
				}
				break;
			}
			else {
				System.out.println("登录失败....");
				System.out.println("用户名或密码错误...");
				System.out.println("------------------------");
			}
		} catch (IOException e) {
			System.out.println("输入不正确，请重新输入....");
			e.printStackTrace();
		}
		}
	}
	
	/**
	 * 用户注册页面
	 */
	@Override
	public void addShow() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean flag = false;
		System.out.println("---------用户注册页面--------");
		System.out.println("请输入用户名：");
		try {
			String sname = br.readLine();
			System.out.println("请输入密码：");
			String password = br.readLine();
			System.out.println("请输入性别：");
			String gender = br.readLine();
			System.out.println("请输入年龄：");
			int age = Integer.parseInt(br.readLine());
			System.out.println("请输入联系方式：");
			String phone = br.readLine();
			System.out.println("请输入出生日期：");
			Date birth = TypeUtil.strToDate(br.readLine());
			UserDto dto = new UserDto(sname, password, gender, age, phone, birth);
			UserController controller = new UserController();
			flag = controller.doAdd(dto);
			if (flag) {
				System.out.println("注册成功，请登录....");
			}else {
				System.out.println("注册失败....");
			}
		} catch (IOException e) {
			System.out.println("输入不正确，注册失败...");
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 父类方法
	 */
	@Override
	public void searchShow() {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * 父类方法
	 */
	@Override
	public void updateShow() {
		// TODO Auto-generated method stub
		
	}
	
}
