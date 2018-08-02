package cn.edu.lingnan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import cn.edu.lingnan.dto.UserDto;
import cn.edu.lingnan.util.DataAccess;
import cn.edu.lingnan.util.DataAccess2;

public class UserDao {
	
	//findAllStudent
	public Vector<UserDto> findAllStudentInfo() {
		Vector<UserDto> v=new Vector<UserDto>();
		Connection conn=null;
		PreparedStatement prep=null;
		ResultSet rs=null;
		UserDto s=null;
		try {
		conn=DataAccess2.getConnection();
		prep=conn.prepareStatement("select * from student");
		rs=prep.executeQuery();
		while(rs.next()) {//处理结果集
			s=new UserDto();
			s.setSid(rs.getString("sid"));
			s.setSname(rs.getString("sname"));
			s.setPassword(rs.getString("password"));
			s.setSuperuser(rs.getInt("superuser"));
			v.add(s);
		}
		}catch(SQLException e) {
			System.out.println("运行SQL语句时出现错误");
			e.printStackTrace();
		}finally {
			DataAccess2.closeconn(conn, null, prep, rs);
		}
		return v;
	}
	
	//findStudent
		public UserDto findStudentById(String _id) {
			UserDto std=null;
			Connection conn=null;
			PreparedStatement prep=null;
			ResultSet rs=null;
			try {
			conn=DataAccess2.getConnection();
			prep=conn.prepareStatement("select * from student where sid=?");
			prep.setString(1,_id);
			rs=prep.executeQuery();	
			while(rs.next()) {//处理结果集
				String sid=rs.getString("sid");
				String sname=rs.getString("sname");
				String password=rs.getString("password");
				int superuser=rs.getInt("superuser");
				std=new UserDto(sid,sname,password,superuser);
			}
			}catch(SQLException e) {
				System.out.println("运行SQL语句时出现错误");
				e.printStackTrace();
			}finally {
				DataAccess2.closeconn(conn, null, prep, rs);
			}
			return std;
		}
		
//findStudent
		public boolean findStudentByUid(String _id) {
			boolean flag = false;
			Connection conn=null;
			PreparedStatement prep=null;
			ResultSet rs=null;
			try {
			conn=DataAccess2.getConnection();
			prep=conn.prepareStatement("select * from student where sid=?");
			prep.setString(1,_id);
			rs=prep.executeQuery();	
			if(rs.first())
				flag = true;
			}catch(SQLException e) {
				System.out.println("运行SQL语句时出现错误");
				e.printStackTrace();
			}finally {
				DataAccess2.closeconn(conn, null, prep, rs);
			}
			return flag;
		}
		
		
//findStudent
	public UserDto findStudentByName(String _sname) {
		UserDto std=null;
		Connection conn=null;
		PreparedStatement prep=null;
		ResultSet rs=null;
		try {
		conn=DataAccess2.getConnection();
		prep=conn.prepareStatement("select * from student where sname=?");
		prep.setString(1,_sname);
		rs=prep.executeQuery();	
		while(rs.next()) {//处理结果集
			String sid=rs.getString("sid");
			String sname=rs.getString("sname");
			String password=rs.getString("password");
			int superuser=rs.getInt("superuser");
			std=new UserDto(sid,sname,password,superuser);
		}
		}catch(SQLException e) {
			System.out.println("运行SQL语句时出现错误");
			e.printStackTrace();
		}finally {
			DataAccess2.closeconn(conn, null, prep, rs);
		}
		System.out.println(std.toString());
		return std;
	}
		
//findStudent
	public boolean findStudentBySName(String _sname) {
		boolean flag = false;
		UserDto std=null;
		Connection conn=null;
		PreparedStatement prep=null;
		ResultSet rs=null;
		try {
		conn=DataAccess2.getConnection();
		prep=conn.prepareStatement("select * from student where sname=?");
		prep.setString(1,_sname);
		rs=prep.executeQuery();	
		if(rs.first()) {//处理结果集
			flag = true;
		}
		}catch(SQLException e) {
			System.out.println("运行SQL语句时出现错误");
			e.printStackTrace();
		}finally {
			DataAccess2.closeconn(conn, null, prep, rs);
		}
		return flag;
	}
	
	//findStudentByElse
	public boolean findStudentByElse(String _id,String _name, String _password,int _superuser ) {
			boolean flag=false;
			Connection conn=null;
			PreparedStatement prep=null;
			ResultSet rs=null;
			try {
			conn=DataAccess2.getConnection();
			prep=conn.prepareStatement("select * from student where sid=? and sname=? and password=? and superuser=?");
			prep.setString(1, _id);
			prep.setString(2,_name);
			prep.setString(3,_password);
			prep.setInt(4, _superuser);
			rs=prep.executeQuery();
			if(rs.first())
				flag=true;
			
			}catch(SQLException e) {
				System.out.println("运行SQL语句时出现错误");
				e.printStackTrace();
			}finally {
				DataAccess2.closeconn(conn, null, prep, rs);	
			}
			return flag;
		}
	
	//findStudentByNameAndPassword判断用户权限
		public int findStudentByNameAndPassword(String _name, String _password) {
				int superuser=0;
				Connection conn=null;
				PreparedStatement prep=null;
				ResultSet rs=null;
				try {
				conn=DataAccess2.getConnection();
				prep=conn.prepareStatement
						("select * from student where sname=? and password=? ");
				prep.setString(1,_name);
				prep.setString(2,_password);
				rs=prep.executeQuery();
				if(rs.first()) {
					superuser = Integer.parseInt(rs.getString("superuser"));
					System.out.println("----1----"+superuser);
				}
				}catch(SQLException e) {
					System.out.println("运行SQL语句时出现错误");
					e.printStackTrace();
				}finally {
					DataAccess2.closeconn(conn, null, prep, rs);	
				}
				return superuser;
			}
		
//findStudentByNameAndPassword判断用户权限
		public String findStudentBySNameAndPassword(String _name, String _password) {
				String uid = "";
				Connection conn=null;
				PreparedStatement prep=null;
				ResultSet rs=null;
				try {
				conn=DataAccess2.getConnection();
				prep=conn.prepareStatement
						("select * from student where sname=? and password=? ");
				prep.setString(1,_name);
				prep.setString(2,_password);
				rs=prep.executeQuery();
				if(rs.first()) {
					uid = rs.getString("sid");
					System.out.println("----1----"+uid);
				}
				}catch(SQLException e) {
					System.out.println("运行SQL语句时出现错误");
					e.printStackTrace();
				}finally {
					DataAccess2.closeconn(conn, null, prep, rs);	
				}
				return uid;
			}
		
		//insertStudent用户注册
		public boolean insertStudent(UserDto sdto) {
			boolean flag=false;
			String uid = sdto.getSid();
			String name = sdto.getSname();
			String password = sdto.getPassword();
			int superuser = sdto.getSuperuser();
			Connection conn=null;
			PreparedStatement prep=null;
			try {
			conn=DataAccess2.getConnection();
			prep=conn.prepareStatement("insert into student values(?,?,?,?)");
			prep.setString(1, uid);
			prep.setString(2, name);
			prep.setString(3, password);
			prep.setInt(4, superuser);
			prep.executeUpdate();
			flag=true;
			}catch(SQLException e) {
				System.out.println("运行SQL语句时出现错误");
				e.printStackTrace();
			}finally {
				DataAccess2.closeconn(conn, null, prep, null);	
			}
			return flag;
		}	
		
	//insertStudent
		public boolean insertStudentById(String _id, String _name, String _password, int _superuser) {
			boolean flag=false;
			Connection conn=null;
			PreparedStatement prep=null;
			int[] number= {0,0};
			try {
			conn=DataAccess2.getConnection();
			prep=conn.prepareStatement("insert into student values(?,?,?,?)");
			prep.setString(1, _id);
			prep.setString(2, _name);
			prep.setString(3, _password);
			prep.setInt(4, _superuser);
			prep.addBatch();
			number=prep.executeBatch();
			if(number!=null)
				flag=true;
			}catch(SQLException e) {
				System.out.println("运行SQL语句时出现错误");
				e.printStackTrace();
			}finally {
				DataAccess2.closeconn(conn, null, prep, null);	
			}
			return flag;
		}	
	
	//deleteStudent
	public boolean deleteStudentById(String _id) {
		boolean flag=false;
		Connection conn=null;
		PreparedStatement prep=null;
		int[] number= {0,0};
		try {
		conn=DataAccess2.getConnection();
		prep=conn.prepareStatement("delete from student where sid=?");
		prep.setString(1, _id);
		prep.addBatch();
		number=prep.executeBatch();
		if(number!=null)
			flag=true;
		}catch(SQLException e) {
			System.out.println("运行SQL语句时出现错误");
			e.printStackTrace();
		}finally {
			DataAccess2.closeconn(conn, null, prep, null);
		}
		return flag;
	}
	
	//updateStudent
	public boolean updateStudentById(UserDto sdto) {
		boolean flag=false;
		Connection conn=null;
		Statement stat = null;
		String sid = sdto.getSid();
		String sname = sdto.getSname();
		String password = sdto.getPassword();
		int superuser = sdto.getSuperuser();
		String sql = "update student set sname='"+sname+"', password='"+password+"', "
				+ "superuser='"+superuser+"' where sid='"+sid+"'";
		//PreparedStatement prep=null;
		//int[] number= {0,0};
		try {
		conn=DataAccess2.getConnection();
		stat = conn.createStatement();
		stat.executeUpdate(sql);
//		prep=conn.prepareStatement
//				("update student set sname=?, password=?, superuser=? where sid=?");
//		prep.setString(1, sdto.getSname());
//		prep.setString(2, sdto.getPassword());
//		prep.setInt(3, sdto.getSuperuser());
//		prep.setString(4, sdto.getSid());
//		prep.addBatch();
//		number=prep.executeBatch();
		//if(number!=null)	
		flag=true;
		}catch(SQLException e) {
			System.out.println("运行SQL语句时出现错误");
			e.printStackTrace();
		}finally {
			DataAccess2.closeconn(conn, stat, null, null);
		}
		return flag;
	}
	
}

	

