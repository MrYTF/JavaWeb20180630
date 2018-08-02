package cn.edu.lingnan.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cn.edu.lingnan.common.exception.DateException;
import cn.edu.lingnan.common.exception.EmailException;
/**
 * 格式检查与转换工具类
 * @author LiQi
 *
 */
public class TypeUtil {


	/**
	 * 字符转日期类型方法
	 * @param string 字符串
	 * @return 返回日期类型
	 */
	public static Date strToDate(String string) {
		Date date = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			date = dateFormat.parse(string);
		} catch (Exception e) {
			throw new DateException("字符转日期格式失败", e);
			//e.printStackTrace();
		}
		return date;
	}
	
	/**
	 * 日期转字符串
	 * @param date 日期
	 * @return 返回字符串类型
	 */
	public static String dateToStr(Date date) {
		String string = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			string = dateFormat.format(date);
		} catch (Exception e) {
			throw new DateException("日期转字符格式失败", e);
			//e.printStackTrace();
		}
		return string;
	}

	/**
	 * 检查邮箱格式
	 * @param mail 邮箱
	 * @return 返回检查结果
	 */
	public static boolean checkEmail(String mail) {
		String string = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,3}$";
		try {
			Pattern pattern = Pattern.compile(string);
			Matcher matcher = pattern.matcher(mail);
			if (matcher.matches()) {
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			throw new EmailException("邮箱格式不正确", e);
			// TODO: handle exception
		}
	}
	
	/**
	 * 判断字符串是否为空
	 * @param string 字符串
	 * @return 返回判断结果
	 */
	public static boolean isNull(String string) {
		if (string != null && string != "") {
			return true;
		}else {
			return false;
		}
	}
}
