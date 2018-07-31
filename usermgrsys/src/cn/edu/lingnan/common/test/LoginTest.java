package cn.edu.lingnan.common.test;

import org.junit.Test;

import cn.edu.lingnan.usermgr.controller.UserController;

public class LoginTest {

	@Test
	public void test() {
		UserController controller = new UserController();
		controller.doLogin("凌凌柒", "12345");
	}

}
