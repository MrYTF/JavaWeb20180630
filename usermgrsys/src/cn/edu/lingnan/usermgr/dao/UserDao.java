package cn.edu.lingnan.usermgr.dao;

import java.util.Vector;

import cn.edu.lingnan.common.dao.BaseDao;
import cn.edu.lingnan.usermgr.domain.UserDto;
/**
 * userDao接口类
 * @author LiQi
 *
 */
public interface UserDao extends BaseDao {
	
	/**
	 * 用户登录
	 * @param sname 用户姓名
	 * @param password 用户密码
	 * @return 返回信息匹配的用户所有信息
	 */
	public UserDto login(String sname,String password);
	
	/**
	 * 用户注册/添加用户
	 * @param dto 用户信息
	 * @return 返回是否添加成功
	 */
	public boolean addUser(UserDto dto);
	
	/**
	 * 查询所有用户
	 * @return 返回所有用户信息的集合
	 */
	public Vector<UserDto> findAllUser();
	
	/**
	 * 根据ID查询
	 * @param sid 用户ID
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
	 * @return 返回布尔值
	 */
	public boolean delUser(int sid);
	
}
