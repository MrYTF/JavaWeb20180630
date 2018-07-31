package cn.edu.lingnan.common.dao;

import java.sql.Connection;

import cn.edu.lingnan.common.exception.DaoException;
import cn.edu.lingnan.usermgr.dao.UserDaoImp;
/**
 * dao工厂类
 * @author LiQi
 *
 */
public class DaoFactory {
	/**
	 * 获取userdao对象的工厂方法
	 * @param connection 数据库连接对象
	 * @param type dao常量
	 * @return dao接口
	 * BaseDao baseDao = new userDaoImp(connection);
	 */
	
	public static BaseDao getDao(Connection connection, String type) {
		//如果传入的dao类型是userdao，就实例化userdao实现类
		if ("user".equals(type)) {
			//返回实例化的dao对象
			return new UserDaoImp(connection);
		//如果没有和以上指定类型匹配的值，就提示错误信息
		}else {
			throw new DaoException();
		}
	}
	
}
