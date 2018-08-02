package cn.edu.lingnan.common.test;

import java.util.Date;

import org.junit.Test;

import cn.edu.lingnan.common.util.TypeUtil;
/**
 * 类型转换、检查、判断测试类
 * @author LiQi
 *
 */
public class TypeUtilTest {
	/**
	 * 字符转日期测试
	 */
	@Test
	public void testXtrtoDate() {
		String string = "1997-12-16";
		Date date = TypeUtil.strToDate(string);
		System.out.println(date);
	}
	/**
	 * 日期转字符测试
	 */
	@Test
	public void testDatetoStr() {
		Date date = TypeUtil.strToDate("1997-12-16");
		String string = TypeUtil.dateToStr(date);
		System.out.println(string);
	}
	/**
	 * 检查邮箱测试
	 */
	@Test
	public void testCheckEmail() {
		boolean flag1 = false;
		boolean flag2 = false;
		String mail1 = "15341163.cenn";
		String mail2 = "1534171551@qq.com";
		flag1 = TypeUtil.checkEmail(mail1);
		flag2 = TypeUtil.checkEmail(mail2);
		System.out.println(flag1+"*_*"+flag2);
	}
	/**
	 * 判断字符串是否为空测试
	 */
	@Test
	public void testIsNull() {
		boolean flag = false;
		String string = "srt fjyy";
		flag = TypeUtil.isNull(string);
		System.out.println(flag);
	}
	
}
