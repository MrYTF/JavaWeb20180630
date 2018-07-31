package cn.edu.lingnan.usermgr.service;

import java.sql.Connection;
import java.util.Vector;

import cn.edu.lingnan.common.constant.EnumType;
import cn.edu.lingnan.common.dao.DaoFactory;
import cn.edu.lingnan.common.exception.ServiceException;
import cn.edu.lingnan.common.util.DBUtil;
import cn.edu.lingnan.usermgr.dao.UserDao;
import cn.edu.lingnan.usermgr.domain.UserDto;

/**
 * 用户service实例类
 * @author LiQi
 *
 */
public class UserServiceImp implements UserService{
	/**
	 * 在类内部创建唯一实例
	 */
	private static UserService userService = new UserServiceImp();
	/**
	 * 构造方法私有化
	 */
	private UserServiceImp() {
		
	}
	/**
	 * 获得用户service实例
	 * 提供对外访问的方法
	 * @return 返回实例对象
	 */
	public static UserService getInstance() {
		return userService;
	}
	/**
	 * 用户登录
	 * @param sname 用户名
	 * @param password 密码
	 * @return 返回对应用户信息
	 */
	public UserDto login(String sname, String password) {
		Connection connection = null;
		UserDto dto = null;
		try {
			connection = DBUtil.getconnection();
			UserDao dao = (UserDao) DaoFactory.getDao(connection, EnumType.User_Dao);
			dto = dao.login(sname, password);
		} catch (Exception e) {
			throw new ServiceException("登录失败......", e);
		}finally {
			DBUtil.closeConnection(connection);
		}
		return dto;
	}
	
	/**
	 * 用户注册/添加用户
	 * @param dto
	 * @return
	 */
	public boolean addUser(UserDto dto) {
		boolean flag = false;
		Connection connection = null;
		try {
			connection = DBUtil.getconnection();
			UserDao dao = (UserDao)DaoFactory.getDao(connection, EnumType.User_Dao);
			flag = dao.addUser(dto);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeConnection(connection);
		}
		
		return flag;
	}
	
	/**
	 * 查询所有用户
	 * @return
	 */
	public Vector<UserDto> findAllUser() {
		Vector<UserDto> dtos = new Vector<UserDto>();
		Connection connection = null;
		try {
			connection = DBUtil.getconnection();
			UserDao dao = (UserDao) DaoFactory.getDao(connection, EnumType.User_Dao);
			dtos = dao.findAllUser();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtos;
	}
	
	/**
	 * 根据ID查询
	 * @param sid 用户ID
	 * @return 返回对应用户的信息
	 */
	public UserDto findByID(int sid) {
		Connection connection = null;
		UserDto dto = null;
		try {
			connection = DBUtil.getconnection();
			UserDao dao = (UserDao) DaoFactory.getDao(connection, EnumType.User_Dao);
			dto = dao.findByID(sid);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeConnection(connection);
		}
		return dto;
	}
	
	/**
	 * 根据用户名查询
	 * @param sname 用户名
	 * @return 返回对应的用户信息
	 */
	public UserDto findByName(String sname) {
		Connection connection = null;
		UserDto dto = null;
		try {
			connection = DBUtil.getconnection();
			UserDao dao = (UserDao) DaoFactory.getDao(connection, EnumType.User_Dao);
			dto = dao.findByName(sname);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeConnection(connection);
		}
		return dto;
	}
	
	/**
	 * 修改用户
	 * @param dto 用户信息
	 * @return 返回是否修改成功
	 */
	public boolean updateUser(UserDto dto) {
		boolean flag = false;
		Connection connection = null;
		try {
			connection = DBUtil.getconnection();
			UserDao dao = (UserDao) DaoFactory.getDao(connection, EnumType.User_Dao);
			flag = dao.updateUser(dto);
			if (flag) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}
		return flag;
	}
	
	/**
	 * 删除用户
	 * @param sid 用户id
	 * @return 返回是否删除成功
	 */
	public boolean deletUser(int sid) {
		boolean flag = false;
		Connection connection = null;
		try {
			connection = DBUtil.getconnection();
			UserDao dao = (UserDao) DaoFactory.getDao(connection, EnumType.User_Dao);
			flag = dao.delUser(sid);
			if (flag) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeConnection(connection);
		}
		return flag;
	}
}
