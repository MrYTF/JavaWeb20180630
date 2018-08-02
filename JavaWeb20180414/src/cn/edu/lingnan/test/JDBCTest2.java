package cn.edu.lingnan.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import cn.edu.lingnan.dto.UserDto;
import cn.edu.lingnan.util.DataAccess;

public class JDBCTest2 {

	public static void main(String[] args) {
		Connection conn=null;
		Statement stat=null;
		ResultSet rs=null;
		UserDto s=null;
		try {
		conn=DataAccess.getConnection();
		stat=conn.createStatement//创建SQL语句对象
				(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		String sql="select * from student";
		rs=stat.executeQuery(sql);//执行SQL语句对象
		//insert
//		rs.moveToInsertRow();
//		rs.updateString(1,"s05");
//		rs.updateString("sname", "yh");
//		rs.insertRow();
		
		//update
//		rs.last();
//		rs.updateString(2, "mr");
//		rs.updateRow();
		
		//delete
		rs.absolute(3);
		rs.deleteRow();
		
//		System.out.println(rs.isBeforeFirst());
//		System.out.println(rs.isFirst());
//		rs.absolute(3);
//		System.out.println(rs.getString(2));
//		rs.relative(-1);
//		System.out.println(rs.getString("sname"));
//		System.out.println("------------------------");
//		rs.beforeFirst();
//		while(rs.next()){
//			System.out.println(rs.getString(2));
//		}
//		System.out.println(rs.isLast());
//		System.out.println(rs.isAfterLast());
//		
		}catch(SQLException e) {
			System.out.println("运行SQL语句时出现错误");
			e.printStackTrace();
		}finally {
			DataAccess.closeconn(conn, stat, null, rs);
		}
	}

}
