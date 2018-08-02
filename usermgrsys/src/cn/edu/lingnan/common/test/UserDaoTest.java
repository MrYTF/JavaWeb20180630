package cn.edu.lingnan.common.test;

import java.sql.Connection;
import java.util.Vector;

import org.junit.Test;

import cn.edu.lingnan.common.constant.EnumType;
import cn.edu.lingnan.common.dao.DaoFactory;
import cn.edu.lingnan.common.util.DBUtil;
import cn.edu.lingnan.common.util.TypeUtil;
import cn.edu.lingnan.usermgr.dao.UserDao;
import cn.edu.lingnan.usermgr.dao.UserDaoImp;
import cn.edu.lingnan.usermgr.domain.UserDto;
/**
 * 用户dao测试类
 * @author LiQi
 *
 */
public class UserDaoTest {
	/**
	 * 用户登录
	 */
	@Test
	public void testLogin() {
			Connection connection = DBUtil.getconnection();
			UserDto dto = new UserDto();
			UserDao dao = new UserDaoImp(connection);
			//userDao dao = (userDao) DaoFactory.getDao(connection, enumType.User_Dao);
			dto = dao.login("凌凌柒", "12345");
			System.out.println(dto);
//		userDaoImp daoImp = (userDaoImp)DaoFactory.getDao(connection, enumType.User_Dao);
//		daoImp.name();
	}
	
	/**
	 * 查询所有用户
	 */
	@Test
	public void testFindAllUser() {
			Connection connection = DBUtil.getconnection();
			UserDao dao = new UserDaoImp(connection);
			//userDao dao = (userDao) DaoFactory.getDao(connection, enumType.User_Dao);
			Vector<UserDto> dtos = dao.findAllUser();
			for(int i=0;i<dtos.size();i++) {
				System.out.println(dtos.get(i));
			}	
	}
	
	/**
	 * 删除用户
	 */
	@Test
	public void testDelUser() {
		boolean flag = false;
		Connection connection = DBUtil.getconnection();
		UserDao dao = new UserDaoImp(connection);
		flag = dao.delUser(1);
		System.out.println(flag);
	}
	
	/**
	 * 用户注册/添加用户
	 */
	@Test
	public void testAddUser() {
		boolean flag = false;
		Connection connection = DBUtil.getconnection();
		UserDao dao = new UserDaoImp(connection);
		UserDto dto = new UserDto();
		flag = dao.addUser(dto);
		System.out.println(flag);
	}
	
	/**
	 * 修改用户
	 */
	@Test
	public void testUpdateUser() {
		boolean flag = false;
		Connection connection = DBUtil.getconnection();
		UserDao dao = new UserDaoImp(connection);
		UserDto dto = new UserDto(3, "凌凌柒", "123", "男", 38, "12345678901", TypeUtil.strToDate("2018-01-31"));
		flag = dao.updateUser(dto);
		System.out.println(flag);
	}
}
