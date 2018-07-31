package cn.edu.lingnan.usermgr.controller;

import cn.edu.lingnan.usermgr.domain.UserDto;
import cn.edu.lingnan.usermgr.service.UserService;
import cn.edu.lingnan.usermgr.service.UserServiceImp;

/**
 * 控制器类
 * @author LiQi
 *
 */
public class UserController {
	//声明用户service接口对象，用于业务处理
	UserService service = UserServiceImp.getInstance();
	/**
	 * 登录操作
	 * @param sname
	 * @param password
	 * @return
	 */
	public UserDto doLogin(String sname, String password) {
		UserDto dto = null;
		try {
			//调用service接口中的login方法进行用户登录操作
			dto = service.login(sname, password);
		} catch (Exception e) {
			System.out.println("doLogin操作失败....");
			e.printStackTrace();
		}
		return dto;
	}
	
	/**
	 * 注册操作/添加操作
	 * @param dto
	 * @return
	 */
	public boolean doAdd(UserDto dto) {
		boolean flag = false;
		try {
			flag = service.addUser(dto);
			if (flag) {
				flag = true;
			}
		} catch (Exception e) {
			System.out.println("doAdd操作失败....");
			e.printStackTrace();
		}
		return flag;
	}
}
