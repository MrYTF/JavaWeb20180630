package cn.edu.lingnan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import cn.edu.lingnan.dto.TeacherDto;
import cn.edu.lingnan.util.DataAccess;
import cn.edu.lingnan.util.DataAccess2;

public class TeacherDao {
	//findTeacherAll
	public Vector<TeacherDto> findTeacher() {
		Vector<TeacherDto> v2=new Vector<TeacherDto>();
		Connection conn=null;
		PreparedStatement prep=null;
		ResultSet rs=null;
		try {
		conn=DataAccess2.getConnection();
		prep=conn.prepareStatement("select * from teacher where 标记=1");
		rs=prep.executeQuery();
		while(rs.next()) {//处理结果集
			TeacherDto i=new TeacherDto();
			//teacher
			i.setTid(rs.getString("教师编号"));
			i.setTname(rs.getString("教师姓名"));
			i.setTsex(rs.getString("教师性别"));
			i.setTage(rs.getInt("教师年龄"));
			i.setCelphone(rs.getString("联系方式"));
			v2.add(i);
		}
		}catch(SQLException e) {
			System.out.println("运行SQL语句时出现错误");
			e.printStackTrace();
		}finally {
			DataAccess2.closeconn(conn, null, prep, rs);
		}
		return v2;
	}
	//findTeacherByTid
	public TeacherDto findByTid(String _tid) {
		TeacherDto st=null;
		Connection conn=null;
		PreparedStatement prep=null;
		ResultSet rs=null;
		try {
		conn=DataAccess2.getConnection();
		prep=conn.prepareStatement("select * from teacher where 教师编号=? and 标记=1");
		prep.setString(1,_tid);
		rs=prep.executeQuery();	
		while(rs.next()) {//处理结果集
			String tid=rs.getString("教师编号");
			String tname=rs.getString("教师姓名");
			String tsex=rs.getString("教师性别");
			int tage=rs.getInt("教师年龄");
			String celphone=rs.getString("联系方式");
			st=new TeacherDto(tid,tname,tsex,tage,celphone);
		}
		}catch(SQLException e) {
			System.out.println("运行SQL语句时出现错误");
			e.printStackTrace();
		}finally {
			DataAccess2.closeconn(conn, null, prep, rs);
		}
		return st;
	}
	
	//findTeacherByTid
		public boolean findByTeid(String _tid) {
			boolean flag = false;
			Connection conn=null;
			PreparedStatement prep=null;
			ResultSet rs=null;
			try {
			conn=DataAccess2.getConnection();
			prep=conn.prepareStatement("select * from teacher where 教师编号=? and 标记=1");
			prep.setString(1,_tid);
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
	
	//findTeacherByTname
	public TeacherDto findByTname(String _tname) {
		TeacherDto st=null;
		Connection conn=null;
		PreparedStatement prep=null;
		ResultSet rs=null;
		try {
		conn=DataAccess2.getConnection();
		prep=conn.prepareStatement("select * from teacher where 教师姓名=? and 标记=1");
		prep.setString(1,_tname);
		rs=prep.executeQuery();	
		while(rs.next()) {//处理结果集
			String tid=rs.getString("教师编号");
			String tname=rs.getString("教师姓名");
			String tsex=rs.getString("教师性别");
			int tage=rs.getInt("教师年龄");
			String celphone=rs.getString("联系方式");
			st=new TeacherDto(tid,tname,tsex,tage,celphone);
		}
		}catch(SQLException e) {
			System.out.println("运行SQL语句时出现错误");
			e.printStackTrace();
		}finally {
			DataAccess2.closeconn(conn, null, prep, rs);
		}
		return st;
	}
	
	//insertTeacher
	public boolean insertTeacher(TeacherDto tto) {
		boolean flag=false;
		Connection conn=null;
		PreparedStatement prep=null;
		ResultSet rs = null;
		try {
		conn=DataAccess2.getConnection();
		String sql = "select * from teacher where 教师编号 = ?";
		prep = conn.prepareStatement(sql);
		prep.setString(1, tto.getTid());
		rs = prep.executeQuery();
		while(rs.next())
		{
			//当 rs.getInt("标记") == 0 时表示_tid编号的老师在数据库中已经别软删除，此时直接更新isExist字段即可
			if(rs.getInt("标记") == 0) {
				String updatesql = "update teacher set 标记 = 1 where 教师编号 = ?";
				prep = conn.prepareStatement(updatesql);
				prep.setString(1, tto.getTid());
				prep.executeUpdate();
				//更新之后直接退出函数，不让它往下执行
				return true;
			}
			else//表示数据库已存在这条记录，不给再次插入，直接结束函数
			{
				System.out.println("该老师已存在，请勿重复插入");
				return false;
			}
		}
		prep = conn.prepareStatement("insert into teacher values(?,?,?,?,?,?)");
		prep.setString(1, tto.getTid());
		prep.setString(2, tto.getTname());
		prep.setString(3, tto.getTsex());
		prep.setInt(4, tto.getTage());
		prep.setString(5, tto.getCelphone());
		prep.setInt(6, 1);
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
	//deleteTeacherById
	public boolean deleteTeacherById (String _tid) {
		boolean flag=false;
		Connection conn=null;
		PreparedStatement prep=null;
		try {
		conn=DataAccess2.getConnection();
		
		CourseDao courseDao = new CourseDao();
		TeacherDto t = this.findByTid(_tid);
		courseDao.deleteCourseByTeacherName(t.getTname());
		
		prep=conn.prepareStatement("update teacher set 标记=0 where 教师编号=?");
		prep.setString(1, _tid);
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
	//deleteTeacherByName
	public boolean deleteTeacherByName(String _tname) {
		boolean flag=false;
		Connection conn=null;
		PreparedStatement prep=null;
		try {
		conn=DataAccess2.getConnection();
		prep=conn.prepareStatement("update teacher set 标记=0 where 教师姓名=?");
		prep.setString(1, _tname);
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
	//updateTeacher
	public boolean updateTeacherById(TeacherDto tto) {
		boolean flag=false;
		Connection conn=null;
		PreparedStatement prep=null;
		try {
		conn=DataAccess2.getConnection();
		String sql = "update teacher set 教师姓名 = ? ,教师性别=?,教师年龄=?, 联系方式=? where 教师编号 = ?";
		prep=conn.prepareStatement(sql);
		prep.setString(1, tto.getTname());
		prep.setString(2, tto.getTsex());
		prep.setInt(3, tto.getTage());
		prep.setString(4, tto.getCelphone());
		prep.setString(5, tto.getTid());
	
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
}
