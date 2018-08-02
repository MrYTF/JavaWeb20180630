package cn.edu.lingnan.usermgr.view;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Vector;

import cn.edu.lingnan.common.util.TypeUtil;
import cn.edu.lingnan.usermgr.controller.UserController;
import cn.edu.lingnan.usermgr.domain.UserDto;

/**
 * 管理员页面
 * @author LiQi
 *
 */
public class AdminFrame extends NormalFrame{
	
	/**
	 * 构造器
	 * @param dto 传递用户信息
	 */
	public AdminFrame(UserDto dto) {
		super(dto);
	}
	
	/**
	 * 登录成功主页面
	 */
	public void show() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int i = -1;
		while(true) {
			System.out.println("-------欢迎进入管理员页面------");
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
				System.out.println("感谢您的使用，再见....");
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
			System.out.println("-------欢迎进入查询页面-------");
			System.out.println("......查询所有用户-->1......");
			System.out.println("......根据ID查询--->2......");
			System.out.println("......根据姓名查询--->3.....");
			System.out.println("......退出查询------>4.....");
			System.out.println("------------------------");
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
	 * 查询所有用户
	 */
	private void showAllUser() {
		System.out.println("---------查询所有用户--------");
		try {
			UserController controller = new UserController();
			Vector<UserDto> dtos = new Vector<UserDto>();
			dtos = controller.doFindAll();
			for (UserDto dto : dtos) {
				dto.print();
			}
		} catch (Exception e) {
			System.out.println("查询失败...");
			//e.printStackTrace();
		}
	}
	
	/**
	 * 根据ID查询
	 */
	private void showByID() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("--------根据用户ID查询-------");
		while(true) {
			System.out.println("请输入用户ID：");
			try {
				int sid = Integer.parseInt(br.readLine());
				UserController controller = new UserController();
				UserDto dto = controller.doFindByID(sid);
				dto.print();
				//System.out.println(dto.getSid()+"\t"+dto.getSname()+"\t"+dto.getPassword()+"\t"+dto.getGender()+"\t"+dto.getAge()+"\t"+dto.getPhone()+"\t"+dto.getPower());
				break;
			} catch (Exception e) {
				System.out.println("输入不正确，请重新输入...");
				System.out.println("------------------------");
				//e.printStackTrace();
			}
		}
		
		
	}
	
	/**
	 * 根据用户名查询
	 */
	private void showByName() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("--------根据用户名查询--------");
		while(true) {
			System.out.println("请输入用户名：");
			try {
				String sname = br.readLine();
				UserController controller = new UserController();
				UserDto dto = controller.doFindByName(sname);
				dto.print();
				break;
			} catch (Exception e) {
				System.out.println("输入不正确，请重新输入...");
				System.out.println("------------------------");
				//e.printStackTrace();
			}
		}
		
	}
	
	/**
	 * 修改用户信息页面
	 */
	public void updateShow() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean flag = false;
		System.out.println("-------欢迎进入修改页面-------");
		while(true) {
			System.out.println("请输入需要修改的用户ID：");
			try {
				int sid = Integer.parseInt(br.readLine());
				System.out.println("请输入新用户名：");
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
			} catch (Exception e) {
				System.out.println("输入不正确，请重新输入...");
				System.out.println("------------------------");
				//e.printStackTrace();
			}	
		}	
	}
	
	/**
	 * 添加用户页面
	 */
	public void addShow() {
		boolean flag = false;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("-------欢迎进入添加页面-------");
		while(true) {
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
				UserController controller = new UserController();
				UserDto dto = new UserDto(sname, password, gender, age, phone, birth);
				flag = controller.doAdd(dto);
				if (flag) {
					System.out.println("添加成功...");
				}else {
					System.out.println("添加失败...");
				}
				break;
			} catch (Exception e) {
				System.out.println("输入不正确，请重新输入...");
				System.out.println("------------------------");
			}
		}
	}
	
	/**
	 * 删除用户页面
	 */
	public void deletShow() {
		boolean flag = false;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("-------欢迎进入删除页面-------");
		while(true) {
			System.out.println("请输入需要删除的用户ID：");
			try {
				int sid = Integer.parseInt(br.readLine());
				UserController controller = new UserController();
				flag = controller.doDelete(sid);
				if (flag) {
					System.out.println("删除成功...");
				}else {
					System.out.println("删除失败...");
				}
				break;
			} catch (Exception e) {
				System.out.println("输入不正确，请重新输入...");
				System.out.println("------------------------");
			}
		}
	}
	
}
