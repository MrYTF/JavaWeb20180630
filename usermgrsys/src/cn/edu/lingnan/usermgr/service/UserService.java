package cn.edu.lingnan.usermgr.service;
/**
 * user service类
 * @author LiQi
 *
 */

import java.util.Vector;

import cn.edu.lingnan.usermgr.domain.UserDto;

public interface UserService {
	/**
	 * 用户登录
	 * @param sname 用户名
	 * @param password 密码
	 * @return 用户信息
	 */
	public UserDto login(String sname, String password);
	
	/**
	 * 用户注册/添加用户
	 * @param dto 用户信息
	 * @return 返回是否注册/添加成功
	 */
	public boolean addUser(UserDto dto);
	
	/**
	 * 查询所有用户
	 * @return 返回所有用户的信息
	 */
	public Vector<UserDto> findAllUser();
	
	/**
	 * 根据ID查询
	 * @param sid 用户id
	 * @return 返回对应的用户信息
	 */
	public UserDto findByID(int sid);
	
	/**
	 * 根据用户名查询
	 * @param sname 用户名
	 * @return 返回对应的用户信息
	 */
	public UserDto findByName(String sname);
	
	/**
	 * 修改用户
	 * @param dto 用户信息
	 * @return 返回是否修改成功
	 */
	public boolean updateUser(UserDto dto);
	
	/**
	 * 删除用户
	 * @param sid 用户id
	 * @return 返回是否删除成功
	 */
	public boolean deletUser(int sid);
}
