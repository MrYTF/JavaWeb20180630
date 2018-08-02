package cn.edu.lingnan.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import cn.edu.lingnan.util.DataAccess;

public class PreparedStatementTest {

	public static void main(String[] args) {
		Connection conn=null;
		PreparedStatement prep=null;
		ResultSet rs=null;
		try {
		conn=DataAccess.getConnection();
		prep=conn.prepareStatement("insert into student values(?,?,?,?)");
		prep.setString(1,"s04");
		prep.setString(2,"zy");
		prep.setString(3,"123");
		prep.setInt(4, 4);
		prep.executeUpdate();	
		prep.setString(1,"s05");
		prep.setString(2,"cmc");
		prep.setString(3,"456");
		prep.setInt(4, 3);
		prep.executeUpdate();		
		
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DataAccess.closeconn(conn, null, prep, rs);
		}
	}

}
