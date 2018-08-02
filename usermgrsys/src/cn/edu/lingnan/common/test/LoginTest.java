package cn.edu.lingnan.common.test;

import org.junit.Test;

import cn.edu.lingnan.usermgr.controller.UserController;
/**
 * 登录方法测试类
 * @author LiQi
 *
 */
public class LoginTest {
	/**
	 * 控制器登录操作测试
	 */
	@Test
	public void test() {
		UserController controller = new UserController();
		controller.doLogin("凌凌柒", "12345");
	}

}
