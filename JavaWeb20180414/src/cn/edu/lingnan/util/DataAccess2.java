package cn.edu.lingnan.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class DataAccess2 {
	private static String driver=null;
	private static String url=null;
	private static String user=null;
	private static String password=null;
	private static String xmlPath="database.conf.xml";
	private static String xsdPath="database.conf.xsd";
	private static Connection conn=null;
	private static HashMap<String,String> hm=new HashMap<String,String>();
	
	static {
		if(XmlValidator.validator(xmlPath,xsdPath)) {
			hm=XmlParser.parser(xmlPath);
			driver=hm.get("driver");
			url=hm.get("url");
			user=hm.get("user");
			password=hm.get("password");
			//System.out.println(driver+"-----"+url+"-----"+user+"-----"+password);
		}
		//else System.out.println("false");
	}
	public static Connection getConnection() {
		try {
		Class.forName(driver);//注册驱动程序
		conn=DriverManager.getConnection //获取数据库连接
				(url,user,password);
		
		}catch(ClassNotFoundException e) {
			System.out.println("数据库jar包加载失败..........");
			e.printStackTrace();
		}catch(SQLException e) {
			System.out.println("数据库连接获取失败............");
			e.printStackTrace();
			
		}
		System.out.println("数据库连接获取成功..........");
		return conn;
	}
	public static void closeconn(Connection conn, Statement stat, PreparedStatement prep, ResultSet rs) {
		try {
			if(rs!=null) {
				rs.close();
				rs=null;
			}
			if(stat!=null) {
				stat.close();
				stat=null;
			}
			if(prep!=null) {
				prep.close();
				prep=null;
			}
			if(conn!=null) {
				conn.close();
				conn=null;
			}
		}catch(SQLException e) {
			System.out.println("关闭连接，语句及结果集时出现错误");
			e.printStackTrace();
		}	
	}

}

