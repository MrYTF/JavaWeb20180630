package cn.edu.lingnan.usermgr.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

import cn.edu.lingnan.common.util.TypeUtil;
import cn.edu.lingnan.usermgr.controller.UserController;
import cn.edu.lingnan.usermgr.domain.UserDto;
/**
 * 普通用户页面
 * @author LiQi
 *
 */
public class NormalFrame extends IndexFrame{
	UserDto dto = null;

	public NormalFrame(UserDto dto) {
		super();
		this.dto = dto;
	}


	/**
	 * 登录成功主页面
	 */
	public void show() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int i = -1;
		while(true){
			System.out.println("------欢迎进入普通用户页面------");
			System.out.println(dto.getSname()+"您好！	您的权限是："+dto.getPower());
			System.out.println("------------------------");
			System.out.println(".......查询个人信息-->1......");
			System.out.println(".......修改个人信息-->2......");
			System.out.println(".......退出登录---->3......");
			System.out.println("------------------------");
			System.out.println("请输入：");
			while(true) {
				try {
					i = Integer.parseInt(br.readLine());
					break;
				} catch (Exception e) {
					System.out.println("输入错误，请输入1-3的数字");
					System.out.println("请重新输入：");
				}	
			} 
			switch (i) {
			case 1:
				this.searchShow();
				break;
			case 2:
				this.updateShow();
				break;
			case 3:
				System.out.println("感谢您的使用，再见！");
				System.exit(0);
			default:
				System.out.println("输入错误，请重新输入....");
				System.out.println("------------------------");
				break;
			}
		}
	}
	/**
	 * 查询个人信息
	 */
	public void searchShow() {
		UserController controller = new UserController();
		dto = controller.doFindByID(dto.getSid());
		dto.print();
	}
	/**
	 * 修改个人信息
	 */
	public void updateShow() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean flag = false;
		while(true) {
			try {
				int sid = dto.getSid();
				System.out.println("请输入新的用户名：");
				String sname = br.readLine();
				System.out.println("请输入新密码：");
				String password = br.readLine();
				System.out.println("请输入新性别：");
				String gender = br.readLine();
				System.out.println("请输入新年龄：");
				int age = Integer.parseInt(br.readLine());
				System.out.println("请输入新联系方式：");
				String phone = br.readLine();
				System.out.println("请输入新出生日期：");
				Date birth = TypeUtil.strToDate(br.readLine());
				UserController controller = new UserController();
				UserDto dto = new UserDto(sid, sname, password, gender, age, phone, birth); 
				flag = controller.doUpdate(dto);
				if (flag) {
					System.out.println("修改成功...");
				}else {
					System.out.println("修改失败...");
				}
				break;
			} catch (IOException e) {
				System.out.println("输入不正确，请重新输入...");
				System.out.println("------------------------");
				//e.printStackTrace();
			}
			
		}
		
	}
}
