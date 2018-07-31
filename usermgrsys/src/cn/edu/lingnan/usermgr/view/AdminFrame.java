package cn.edu.lingnan.usermgr.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import cn.edu.lingnan.usermgr.domain.UserDto;
import oracle.net.aso.i;

/**
 * 管理员页面
 * @author LiQi
 *
 */
public class AdminFrame extends NormalFrame{
	
	public AdminFrame(UserDto dto) {
		super(dto);
		// TODO Auto-generated constructor stub
	}
	/**
	 * 登录成功主页面
	 */
	public void show() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int i = -1;
		while(true) {
			System.out.println("-------欢迎进入管理员页面-------");
			System.out.println(dto.getSname()+"您好！	您的权限是："+dto.getPower());
			System.out.println("------------------------");
			System.out.println("........查询用户-->1.......");
			System.out.println("........修改用户-->2.......");
			System.out.println("........添加用户-->3.......");
			System.out.println("........删除用户-->4.......");
			System.out.println("........退出登录-->5.......");
			System.out.println("------------------------");
			System.out.println("请输入：");
			while(true) {
				try {
					i = Integer.parseInt(br.readLine());
				} catch (Exception e) {
					System.out.println("输入错误，请输入1-5的数字");
					System.out.println("请重新输入：");
				}
				break;
			}
			switch (i) {
			case 1:
				this.searchShow();
				break;
			case 2:
				this.updateShow();
				break;
			case 3:
				this.addShow();
				break;
			case 4:
				this.deletShow();
				break;
			case 5:
				System.out.println("感谢您的使用....");
				System.exit(0);
			default:
				System.out.println("输入错误，请重新输入....");
				break;
			}
		}		
	} 

	/**
	 *查询用户页面
	 */
	public void searchShow() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int i = -1;
		while(i != 4) {
			System.out.println("------欢迎进入查询页面-------");
			System.out.println("查询所有用户--------------1");
			System.out.println("根据ID查询--------------2");
			System.out.println("根据姓名查询--------------3");
			System.out.println("退出查询----------------4");
			System.out.println("----------------------");
			System.out.println("请输入：");
			while(true) {
				try {
					i = Integer.parseInt(br.readLine());
					break;
				} catch (Exception e) {
					System.out.println("输入错误，请输入1-4的数字");
					System.out.println("请重新输入：");
				}
			}	
			switch (i) {
			case 1:
				this.showAllUser();
				break;
			case 2:
				this.showByID();
				break;
			case 3:
				this.showByName();
				break;
			case 4:
				break;
			default:
				System.out.println("输入错误，请重新输入....");
				break;
			}
		}
	}

	/**
	 * 根据用户名查询
	 */
	private void showByName() {
		
		
	}
	/**
	 * 根据ID查询
	 */
	private void showByID() {
		// TODO Auto-generated method stub
		
	}
	/**
	 * 查询所有用户
	 */
	private void showAllUser() {
		
		
	}
	/**
	 * 修改用户信息页面
	 */
	public void updateShow() {
		
	}
	/**
	 * 添加用户页面
	 */
	public void addShow() {
		
	}
	/**
	 * 删除用户页面
	 */
	public void deletShow() {
		
	}
	
}
