package cn.edu.lingnan.usermgr.controller;

import java.util.Vector;

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
	
	/**
	 * 查询所有用户操作
	 * @return 返回用户信息
	 */
	public Vector<UserDto> doFindAll(){
		Vector<UserDto> dtos = new Vector<>();
		try {
			dtos = service.findAllUser();
		} catch (Exception e) {
			System.out.println("doFindAll操作失败....");
			e.printStackTrace();
		}
		return dtos;
	}
	
	/**
	 * 根据id查询操作
	 * @param sid 用户ID
	 * @return 返回对应用户信息
	 */
	public UserDto doFindByID(int sid) {
		UserDto dto = null;
		try {
			dto = service.findByID(sid);
		} catch (Exception e) {
			System.out.println("doFindByID操作失败....");
			e.printStackTrace();
		}
		return dto;
	}
	
	/**
	 * 根据用户名查询操作
	 * @param sname 用户名
	 * @return 返回对应用户信息
	 */
	public UserDto doFindByName(String sname) {
		UserDto dto = null;
		try {
			dto = service.findByName(sname);
		} catch (Exception e) {
			System.out.println("doFindByName操作失败....");
			e.printStackTrace();
		}
		return dto;
	}
	
	/**
	 * 修改操作
	 * @param dto 用户信息
	 * @return 返回是否修改成功
	 */
	public boolean doUpdate(UserDto dto) {
		boolean flag = false;
		try {
			flag = service.updateUser(dto);
		} catch (Exception e) {
			System.out.println("doUpdate操作失败....");
			e.printStackTrace();
		}
		return flag;
	}
	
	/**
	 * 删除操作
	 * @param sid 用户id
	 * @return 返回是否删除成功
	 */
	public boolean doDelete(int sid) {
		boolean flag = false;
		try {
			flag = service.deletUser(sid);
			if (flag) {
				flag = true;
			}
		} catch (Exception e) {
			System.out.println("doDelete操作失败....");
			e.printStackTrace();
		}
		return flag;
	}
	
}
