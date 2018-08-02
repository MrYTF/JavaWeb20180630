package cn.edu.lingnan.common.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.edu.lingnan.common.exception.DaoException;

/**
 * 数据库工具类
 * @author LiQi
 *
 */
public class DBUtil {
	/**
	 * 私有变量类
	 */
	private static String driver = "oracle.jdbc.driver.OracleDriver";
	private static String url = "jdbc:oracle:thin:@localhost:1521:orcl";//orcl为数据库的SID
	private static String username = "scott";
	private static String password = "123";
	/**
	 * 数据库工具类
	 * @return	返回获取到的数据库的连接
	 */
	public static Connection getconnection() {
		Connection connection = null;
		try {
			Class.forName(driver); 
			connection = DriverManager.getConnection(url,username,password);
			//System.out.println("数据库连接成功......");
		} catch (ClassNotFoundException e) {
			throw new DaoException("数据库jar包加载失败......",e);
			//System.out.println("数据库jar包加载失败......");
			//e.printStackTrace();
		}catch (SQLException e) {
			throw new DaoException("数据库连接失败......",e);
//			System.out.println("数据库连接失败......");
//			e.printStackTrace();
		}
		
		return connection;
	}
	
	/**
	 * 开始事务
	 * @param connection 数据库连接
	 */
	public static void beginTransaction(Connection connection) {
		try {
			//将事务的自动提交模式设为假
			connection.setAutoCommit(false);
		} catch (SQLException e) {
			throw new DaoException("事务开始失败......",e);
			//e.printStackTrace();
		}
	}
	
	/**
	 * 提交事务
	 * @param connection 数据库连接
	 */
	public static void commit(Connection connection) {
		try {
			//提交事务
			connection.commit();
			//将事务的自动提交模式设为真
			connection.setAutoCommit(true);
		} catch (SQLException e) {
			throw new DaoException("事务提交失败......",e);
			//e.printStackTrace();
		}
	}
	
	/**
	 * 回滚事务
	 * @param connection 数据库连接
	 */
	public static void rollback(Connection connection) {
		try {
			//回滚事务
			connection.rollback();
			//将事务的自动提交模式设为真
			connection.setAutoCommit(true);
		} catch (SQLException e) {
			throw new DaoException("事务回滚失败......",e);
			//e.printStackTrace();
		}
	}
	
	/**
	 * 关闭数据库连接
	 * @param connection 数据库连接
	 */
	public static void closeConnection(Connection connection){
		try {
			//如果数据库连接对象不为空，关闭该对象
			if (connection != null) {
				connection.close();
			}
			//System.out.println("关闭数据库连接成功......");	
		} catch (SQLException e) {
			throw new DaoException("关闭数据库连接失败......",e);
//			System.out.println("关闭数据库连接失败......");
//			e.printStackTrace();
		}	
	}
	
	/**
	 * 关闭结果集对象、SQL语句预编译对象
	 * @param resultSet 结果集对象
	 * @param statement SQL语句预编译对象
	 */
	public static void closeStatement(ResultSet resultSet,PreparedStatement statement) {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
			if (statement != null)	{
				statement.close();
			}
		} catch (SQLException e) {
			throw new DaoException("关闭声明对象失败......",e);
//			System.out.println("关闭声明对象失败......");
//			e.printStackTrace();
		}
	}
}

