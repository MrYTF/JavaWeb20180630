package cn.edu.lingnan.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import cn.edu.lingnan.util.DataAccess;

public class BatchTest {

	public static void main(String[] args) {
		Connection conn=null;
		Statement stat=null;
		PreparedStatement prep=null;
		ResultSet rs=null;
		try {
		conn=DataAccess.getConnection();
		prep=conn.prepareStatement("insert into student values(?,?,?,?)");
		prep.setString(1,"s06");
		prep.setString(2,"cy");
		prep.setString(3,"321");
		prep.setInt(4, 4);
		prep.addBatch();
		prep.setString(1,"s07");
		prep.setString(2,"rt");
		prep.setString(3,"346");
		prep.setInt(4, 3);
		prep.addBatch();
		prep.executeBatch();
		stat=conn.createStatement();
		String sql1="insert into student values('s08','mz','000',1)";
		String sql2="insert into student values('s09','mc','111',2)";
		stat.addBatch(sql1);
		stat.addBatch(sql2);
		stat.executeBatch();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DataAccess.closeconn(conn, stat, prep, rs);
		}
	}

}
