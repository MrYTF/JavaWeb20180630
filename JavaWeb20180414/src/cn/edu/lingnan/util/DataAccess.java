package cn.edu.lingnan.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataAccess {
	private static String driver="com.mysql.jdbc.Driver";
	private static String url="jdbc:mysql://localhost:3306/ihobby";
	private static String username="root";
	private static String password="123";
	private static Connection conn=null;
	public static Connection getConnection() {
		try {
		Class.forName(driver);//ע����������
		conn=DriverManager.getConnection //��ȡ���ݿ�����
				(url,username,password);
		
		}catch(ClassNotFoundException e) {
			System.out.println("���ݿ�jar������ʧ��..........");
			e.printStackTrace();
		}catch(SQLException e) {
			System.out.println("���ݿ����ӻ�ȡʧ��............");
			e.printStackTrace();
			
		}
		System.out.println("���ݿ����ӻ�ȡ�ɹ�..........");
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
			System.out.println("�ر����ӣ���估�����ʱ���ִ���");
			e.printStackTrace();
		}	
	}

}
