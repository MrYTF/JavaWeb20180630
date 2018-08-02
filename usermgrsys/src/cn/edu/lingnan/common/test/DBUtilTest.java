package cn.edu.lingnan.common.test;

import java.sql.Connection;

import org.junit.Test;

import cn.edu.lingnan.common.util.DBUtil;
/**
 * 数据库连接测试类
 * @author LiQi
 *
 */
public class DBUtilTest {
	/**
	 * 数据库连接测试
	 */
	@Test	//注解
	public void testGetconnection() {
		Connection connection = null;
		try {
			connection = DBUtil.getconnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(connection);
	}
	
	/**
	 * 关闭数据库连接测试
	 */
	@Test
	public void testCloseConnection() {
		Connection connection = null;
		try {
			connection = DBUtil.getconnection();
			DBUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
