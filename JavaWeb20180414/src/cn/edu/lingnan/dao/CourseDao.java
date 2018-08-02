package cn.edu.lingnan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import cn.edu.lingnan.dto.CourseDto;
import cn.edu.lingnan.dto.TeacherDto;
import cn.edu.lingnan.util.DataAccess;
import cn.edu.lingnan.util.DataAccess2;

public class CourseDao {
	//findCourseAll
	public Vector<CourseDto> findCourse() {
		Vector<CourseDto> v=new Vector<CourseDto>();
		Connection conn=null;
		PreparedStatement prep=null;
		ResultSet rs=null;
		try {
		conn=DataAccess2.getConnection();
		prep=conn.prepareStatement("select * from course where 标记=1");
		rs=prep.executeQuery();
		while(rs.next()) {//处理结果集
			CourseDto i=new CourseDto();
			//course
			i.setCid(rs.getString("课程编号"));
			i.setCname(rs.getString("课程名称"));
			i.setTime(rs.getString("上课时间"));
			i.setSite(rs.getString("上课地点"));
			i.setPrice(rs.getString("课程价格"));
			i.setLecturer(rs.getString("教师名称"));
			i.setCtype(rs.getString("课程类型"));
			v.add(i);
		}
		}catch(SQLException e) {
			System.out.println("运行SQL语句时出现错误");
			e.printStackTrace();
		}finally {
			DataAccess2.closeconn(conn, null, prep, rs);
		}
		return v;
	}
	//findCourseByCid
	public CourseDto findByCid(String _cid) {
		CourseDto st=null;
		Connection conn=null;
		PreparedStatement prep=null;
		ResultSet rs=null;
		try {
		conn=DataAccess2.getConnection();
		prep=conn.prepareStatement("select * from course where 课程编号=? and 标记=1");
		prep.setString(1,_cid);
		rs=prep.executeQuery();	
		while(rs.next()) {//处理结果集
			String cid=rs.getString("课程编号");
			String cname=rs.getString("课程名称");
			String time=rs.getString("上课时间");
			String site=rs.getString("上课地点");
			String price=rs.getString("课程价格");
			String lecturer=rs.getString("教师名称");
			String ctype=rs.getString("课程类型");
			st=new CourseDto(cid,cname,time,site,price,lecturer,ctype);
		}
		}catch(SQLException e) {
			System.out.println("运行SQL语句时出现错误");
			e.printStackTrace();
		}finally {
			DataAccess2.closeconn(conn, null, prep, rs);
		}
		return st;
	}
	
	public CourseDto findByTname(String tname) {
		CourseDto st=null;
		Connection conn=null;
		PreparedStatement prep=null;
		ResultSet rs=null;
		try {
		conn=DataAccess2.getConnection();
		prep=conn.prepareStatement("select * from course where 教师名称=? and 标记=1");
		prep.setString(1,tname);
		rs=prep.executeQuery();	
		while(rs.next()) {//处理结果集
			String cid=rs.getString("课程编号");
			String cname=rs.getString("课程名称");
			String time=rs.getString("上课时间");
			String site=rs.getString("上课地点");
			String price=rs.getString("课程价格");
			String lecturer=rs.getString("教师名称");
			String ctype=rs.getString("课程类型");
			st=new CourseDto(cid,cname,time,site,price,lecturer,ctype);
		}
		}catch(SQLException e) {
			System.out.println("运行SQL语句时出现错误");
			e.printStackTrace();
		}finally {
			DataAccess2.closeconn(conn, null, prep, rs);
		}
		return st;
	}
	
	//findCourseByCid
		public boolean findByCoid(String _cid) {
			boolean flag = false;
			Connection conn=null;
			PreparedStatement prep=null;
			ResultSet rs=null;
			try {
			conn=DataAccess2.getConnection();
			prep=conn.prepareStatement("select * from course where 课程编号=? and 标记=1");
			prep.setString(1,_cid);
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
	
	//findCourseByCname
	public CourseDto findByCname(String _cname) {
		CourseDto st=null;
		Connection conn=null;
		PreparedStatement prep=null;
		ResultSet rs=null;
		try {
		conn=DataAccess2.getConnection();
		prep=conn.prepareStatement("select * from course where 课程名称=? and 标记=1");
		prep.setString(1,_cname);
		rs=prep.executeQuery();	
		while(rs.next()) {//处理结果集
			String cid=rs.getString("课程编号");
			String cname=rs.getString("课程名称");
			String time=rs.getString("上课时间");
			String site=rs.getString("上课地点");
			String price=rs.getString("课程价格");
			String lecturer=rs.getString("教师名称");
			String ctype=rs.getString("课程类型");
			st=new CourseDto(cid,cname,time,site,price,lecturer,ctype);
		}
		}catch(SQLException e) {
			System.out.println("运行SQL语句时出现错误");
			e.printStackTrace();
		}finally {
			DataAccess2.closeconn(conn, null, prep, rs);
		}
		return st;
	}
	//findCourseByLecturer
	public CourseDto findByLecturer(String _lecturer) {
		CourseDto st=null;
		Connection conn=null;
		PreparedStatement prep=null;
		ResultSet rs=null;
		try {
		conn=DataAccess2.getConnection();
		prep=conn.prepareStatement("select * from course where 教师名称=? and 标记=1");
		prep.setString(1,_lecturer);
		rs=prep.executeQuery();	
		while(rs.next()) {//处理结果集
			String cid=rs.getString("课程编号");
			String cname=rs.getString("课程名称");
			String time=rs.getString("上课时间");
			String site=rs.getString("上课地点");
			String price=rs.getString("课程价格");
			String lecturer=rs.getString("教师名称");
			String ctype=rs.getString("课程类型");
			st=new CourseDto(cid,cname,time,site,price,lecturer,ctype);
		}
		}catch(SQLException e) {
			System.out.println("运行SQL语句时出现错误");
			e.printStackTrace();
		}finally {
			DataAccess2.closeconn(conn, null, prep, rs);
		}
		return st;
	}
	//findCourseByCtype
	public CourseDto findByCtype(String _ctype) {
		CourseDto st=null;
		Connection conn=null;
		PreparedStatement prep=null;
		ResultSet rs=null;
		try {
		conn=DataAccess2.getConnection();
		prep=conn.prepareStatement("select * from course where 课程类型=? and 标记=1");
		prep.setString(1,_ctype);
		rs=prep.executeQuery();	
		while(rs.next()) {//处理结果集
			String cid=rs.getString("课程编号");
			String cname=rs.getString("课程名称");
			String time=rs.getString("上课时间");
			String site=rs.getString("上课地点");
			String price=rs.getString("课程价格");
			String lecturer=rs.getString("教师名称");
			String ctype=rs.getString("课程类型");
			st=new CourseDto(cid,cname,time,site,price,lecturer,ctype);
		}
		}catch(SQLException e) {
			System.out.println("运行SQL语句时出现错误");
			e.printStackTrace();
		}finally {
			DataAccess2.closeconn(conn, null, prep, rs);
		}
		return st;
	}
	//insertCourse
	public boolean insertCourse(CourseDto cot) {
		boolean flag=false;
		Connection conn=null;
		PreparedStatement prep=null;
		ResultSet rs = null;
		try {
		conn=DataAccess2.getConnection();
		String sql = "select * from course where 课程编号=?";
		prep = conn.prepareStatement(sql);
		prep.setString(1, cot.getCid());
		rs = prep.executeQuery();
		while(rs.next())
		{
			//当 rs.getInt("标记") == 0 时表示_tid编号的老师在数据库中已经别软删除，此时直接更新isExist字段即可
			if(rs.getInt("标记") == 0) {
				String updatesql = "update course set 标记 = 1 where 课程编号 = ?";
				prep = conn.prepareStatement(updatesql);
				prep.setString(1, cot.getCid());
				prep.executeUpdate();
				//更新之后直接退出函数，不让它往下执行
				return true;
			}
			else//表示数据库已存在这条记录，不给再次插入，直接结束函数
			{
				System.out.println("该课程已存在，请勿重复插入");
				return false;
			}
		}
		prep=conn.prepareStatement("insert into course values(?,?,?,?,?,?,?,?)");
		prep.setString(1, cot.getCid());
		prep.setString(2, cot.getCname());
		prep.setString(3, cot.getTime());
		prep.setString(4, cot.getSite());
		prep.setString(5, cot.getPrice());
		prep.setString(6, cot.getLecturer());
		prep.setString(7, cot.getCtype());
		prep.setInt(8, 1);
		prep.executeUpdate();
		//if(number != null)
			flag=true;
		}catch(SQLException e) {
			System.out.println("运行SQL语句时出现错误");
			e.printStackTrace();
		}finally {
			DataAccess2.closeconn(conn, null, prep, null);	
		}
		return flag;
	}	
	//deleteCourseById
	public boolean deleteCourseById(String _cid) {
		boolean flag=false;
		Connection conn=null;
		PreparedStatement prep=null;
		try {
		conn=DataAccess2.getConnection();
		
		CostomerDao costomerDao = new CostomerDao();
		boolean isSuccess = costomerDao.deleteCostomerByCourseId(_cid);
		System.out.println(isSuccess);
		
		prep=conn.prepareStatement("update course set 标记=0 where 课程编号=?");
		prep.setString(1, _cid);
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
	
	//deleteCourseById
	public boolean deleteCourseByTeacherName(String tname) {
		boolean flag=false;
		Connection conn=null;
		PreparedStatement prep=null;
		try {
		conn=DataAccess2.getConnection();
		
		TeacherDao dao = new TeacherDao();
		TeacherDto dto = dao.findByTname(tname);
		System.out.println("------"+dto);
		CourseDto courseDto = this.findByTname(dto.getTname());
		this.deleteCourseById(courseDto.getCid());
		prep=conn.prepareStatement("update course set 标记=0 where 教师名称=?");
		prep.setString(1, tname);
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
	
	//deleteCourseByCname
	public boolean deleteCourseByCname(String _cname) {
		boolean flag=false;
		Connection conn=null;
		PreparedStatement prep=null;
		try {
		conn=DataAccess2.getConnection();
		prep=conn.prepareStatement("update course set 标记=0 where 课程名称=?");
		prep.setString(1, _cname);
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
	//updateCourse
	public boolean updateCourseById(CourseDto cot) {
		boolean flag=false;
		Connection conn=null;
		PreparedStatement prep=null;
		String sql = "update course set 课程名称 =?, 上课时间=?, 上课地点=?, 课程价格=?, 教师名称=?, 课程类型=?, 标记=? where 课程编号 =?";
		try {
		conn=DataAccess2.getConnection();
		
		prep=conn.prepareStatement(sql);
		prep.setString(1, cot.getCname());
		prep.setString(2, cot.getTime());
		prep.setString(3, cot.getSite());
		prep.setString(4, cot.getPrice());
		prep.setString(5, cot.getLecturer());
		prep.setString(6, cot.getCtype());
		prep.setInt(7, 1);
		prep.setString(8, cot.getCid());
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
