package cn.edu.lingnan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import cn.edu.lingnan.dto.CostomerDto;
import cn.edu.lingnan.dto.CourseDto;
import cn.edu.lingnan.dto.TeacherDto;
import cn.edu.lingnan.util.DataAccess;

public class IHBDao {
		//finCostomerAll
		public Vector<CostomerDto> findCostomer() {
			Vector<CostomerDto> v1=new Vector<CostomerDto>();
			Connection conn=null;
			PreparedStatement prep=null;
			ResultSet rs=null;
			try {
			conn=DataAccess.getConnection();
			prep=conn.prepareStatement("select * from costomer where 标记=1");
			rs=prep.executeQuery();
			while(rs.next()) {//处理结果集
				CostomerDto i=new CostomerDto();
				i.setId(rs.getString("客户编号"));
				i.setName(rs.getString("客户姓名"));
				i.setSex(rs.getString("客户性别"));
				i.setAge(rs.getInt("客户年龄"));
				i.setTelephone(rs.getString("联系方式"));
				i.setCourse(rs.getString("选课记录"));
				i.setRegister(rs.getString("注册登记"));
				i.setType(rs.getString("客户类型"));
				v1.add(i);
			}
			}catch(SQLException e) {
				System.out.println("运行SQL语句时出现错误");
				e.printStackTrace();
			}finally {
				DataAccess.closeconn(conn, null, prep, rs);
			}
			return v1;
		}
		
		//findCourseAll
		public Vector<CourseDto> findCourse() {
			Vector<CourseDto> v=new Vector<CourseDto>();
			Connection conn=null;
			PreparedStatement prep=null;
			ResultSet rs=null;
			try {
			conn=DataAccess.getConnection();
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
				DataAccess.closeconn(conn, null, prep, rs);
			}
			return v;
		}
		
		//findTeacherAll
		public Vector<TeacherDto> findTeacher() {
			Vector<TeacherDto> v2=new Vector<TeacherDto>();
			Connection conn=null;
			PreparedStatement prep=null;
			ResultSet rs=null;
			try {
			conn=DataAccess.getConnection();
			prep=conn.prepareStatement("select * from teacher where 标记=1");
			rs=prep.executeQuery();
			while(rs.next()) {//处理结果集
				TeacherDto i=new TeacherDto();
				//teacher
				i.setTid(rs.getString("教师编号"));
				i.setTname(rs.getString("教师姓名"));
				i.setTsex(rs.getString("教师性别"));
				i.setTage(rs.getString("教师年龄"));
				i.setCelphone(rs.getString("联系方式"));
				v2.add(i);
			}
			}catch(SQLException e) {
				System.out.println("运行SQL语句时出现错误");
				e.printStackTrace();
			}finally {
				DataAccess.closeconn(conn, null, prep, rs);
			}
			return v2;
		}
		
		
		//findCostomerById
			public CostomerDto findById(String _id) {
				CostomerDto st=null;
				Connection conn=null;
				PreparedStatement prep=null;
				ResultSet rs=null;
				try {
				conn=DataAccess.getConnection();
				prep=conn.prepareStatement("select * from costomer where 客户编号=? and 标记=1");
				prep.setString(1,_id);
				rs=prep.executeQuery();	
				while(rs.next()) {//处理结果集
					String id=rs.getString("客户编号");
					String name=rs.getString("客户姓名");
					String sex=rs.getString("客户性别");
					int age=rs.getInt("客户年龄");
					String telephone=rs.getString("联系方式");
					String course=rs.getString("选课记录");
					String register=rs.getString("注册登记");
					String type=rs.getString("客户类型");
					st=new CostomerDto(id,name,sex,age,telephone,course,register,type);
				}
				}catch(SQLException e) {
					System.out.println("运行SQL语句时出现错误");
					e.printStackTrace();
				}finally {
					DataAccess.closeconn(conn, null, prep, rs);
				}
				return st;
			}
			//findCostomerByName
			public  CostomerDto findByName(String _name) {
				CostomerDto st=null;
				Connection conn=null;
				PreparedStatement prep=null;
				ResultSet rs=null;
				
				try {
				conn=DataAccess.getConnection();
				prep=conn.prepareStatement("select * from costomer where 客户姓名=? and 标记=1");
				prep.setString(1,_name);
				rs=prep.executeQuery();	
				while(rs.next()) {//处理结果集
					String id=rs.getString("客户编号");
					String name=rs.getString("客户姓名");
					String sex=rs.getString("客户性别");
					int age=rs.getInt("客户年龄");
					String telephone=rs.getString("联系方式");
					String course=rs.getString("选课记录");
					String register=rs.getString("注册登记");
					String type=rs.getString("客户类型");
					st=new CostomerDto(id,name,sex,age,telephone,course,register,type);
					
				}
				}catch(SQLException e) {
					System.out.println("运行SQL语句时出现错误");
					e.printStackTrace();
				}finally {
					DataAccess.closeconn(conn, null, prep, rs);
				}
				return st;
			}
			//findCostomerByClass
			public Vector<CostomerDto> findByCourse(String _course) {
				Vector<CostomerDto> v = new Vector<CostomerDto>();
				CostomerDto st=null;
				Connection conn=null;
				PreparedStatement prep=null;
				ResultSet rs=null;
				try {
				conn=DataAccess.getConnection();
				prep=conn.prepareStatement("select * from costomer where 选课记录=? and 标记=1");
				prep.setString(1,_course);
				rs=prep.executeQuery();	
				while(rs.next()) {//处理结果集
					String id=rs.getString("客户编号");
					String name=rs.getString("客户姓名");
					String sex=rs.getString("客户性别");
					int age=rs.getInt("客户年龄");
					String telephone=rs.getString("联系方式");
					String course=rs.getString("选课记录");
					String register=rs.getString("注册登记");
					String type=rs.getString("客户类型");
					st=new CostomerDto(id,name,sex,age,telephone,course,register,type);
					System.out.println(st);
					v.add(st);
					
				}
				}catch(SQLException e) {
					System.out.println("运行SQL语句时出现错误");
					e.printStackTrace();
				}finally {
					DataAccess.closeconn(conn, null, prep, rs);
				}
				return v;
			}
			//findCostomerByType
			public Vector<CostomerDto> findByType(String _type) {
				Vector<CostomerDto> v = new Vector<CostomerDto>();
				CostomerDto st=null;
				Connection conn=null;
				PreparedStatement prep=null;
				ResultSet rs=null;
				try {
				conn=DataAccess.getConnection();
				prep=conn.prepareStatement("select * from costomer where 客户类型=? and 标记=1");
				prep.setString(1,_type);
				rs=prep.executeQuery();	
				while(rs.next()) {//处理结果集
					String id=rs.getString("客户编号");
					String name=rs.getString("客户姓名");
					String sex=rs.getString("客户性别");
					int age=rs.getInt("客户年龄");
					String telephone=rs.getString("联系方式");
					String course=rs.getString("选课记录");
					String register=rs.getString("注册登记");
					String type=rs.getString("客户类型");
					st=new CostomerDto(id,name,sex,age,telephone,course,register,type);
					System.out.println(st);
					v.add(st);
				}
				}catch(SQLException e) {
					System.out.println("运行SQL语句时出现错误");
					e.printStackTrace();
				}finally {
					DataAccess.closeconn(conn, null, prep, rs);
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
				conn=DataAccess.getConnection();
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
					DataAccess.closeconn(conn, null, prep, rs);
				}
				return st;
			}
			//findCourseByCname
			public CourseDto findByCname(String _cname) {
				CourseDto st=null;
				Connection conn=null;
				PreparedStatement prep=null;
				ResultSet rs=null;
				try {
				conn=DataAccess.getConnection();
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
					DataAccess.closeconn(conn, null, prep, rs);
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
				conn=DataAccess.getConnection();
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
					DataAccess.closeconn(conn, null, prep, rs);
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
				conn=DataAccess.getConnection();
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
					DataAccess.closeconn(conn, null, prep, rs);
				}
				return st;
			}
			//findTeacherByTid
			public TeacherDto findByTid(String _tid) {
				TeacherDto st=null;
				Connection conn=null;
				PreparedStatement prep=null;
				ResultSet rs=null;
				try {
				conn=DataAccess.getConnection();
				prep=conn.prepareStatement("select * from teacher where 教师编号=? and 标记=1");
				prep.setString(1,_tid);
				rs=prep.executeQuery();	
				while(rs.next()) {//处理结果集
					String tid=rs.getString("教师编号");
					String tname=rs.getString("教师姓名");
					String tsex=rs.getString("教师性别");
					String tage=rs.getString("教师年龄");
					String celphone=rs.getString("联系方式");
					st=new TeacherDto(tid,tname,tsex,tage,celphone);
				}
				}catch(SQLException e) {
					System.out.println("运行SQL语句时出现错误");
					e.printStackTrace();
				}finally {
					DataAccess.closeconn(conn, null, prep, rs);
				}
				return st;
			}
			//findTeacherByTname
			public TeacherDto findByTname(String _tname) {
				TeacherDto st=null;
				Connection conn=null;
				PreparedStatement prep=null;
				ResultSet rs=null;
				try {
				conn=DataAccess.getConnection();
				prep=conn.prepareStatement("select * from teacher where 教师姓名=? and 标记=1");
				prep.setString(1,_tname);
				rs=prep.executeQuery();	
				while(rs.next()) {//处理结果集
					String tid=rs.getString("教师编号");
					String tname=rs.getString("教师姓名");
					String tsex=rs.getString("教师性别");
					String tage=rs.getString("教师年龄");
					String celphone=rs.getString("联系方式");
					st=new TeacherDto(tid,tname,tsex,tage,celphone);
				}
				}catch(SQLException e) {
					System.out.println("运行SQL语句时出现错误");
					e.printStackTrace();
				}finally {
					DataAccess.closeconn(conn, null, prep, rs);
				}
				return st;
			}
		
			//insertTeacher
			public boolean insertTeacher(String _tid, String _tname, String _tsex, int _tage, String _celphone) {
				boolean flag=false;
				Connection conn=null;
				PreparedStatement prep=null;
				ResultSet rs = null;
				try {
				conn=DataAccess.getConnection();
				String sql = "select * from teacher where 教师编号 = ?";
				prep = conn.prepareStatement(sql);
				prep.setString(1, _tid);
				rs = prep.executeQuery();
				while(rs.next())
				{
					//当 rs.getInt("标记") == 0 时表示_tid编号的老师在数据库中已经别软删除，此时直接更新isExist字段即可
					if(rs.getInt("标记") == 0) {
						String updatesql = "update teacher set 标记 = 1 where 教师编号 = ?";
						prep = conn.prepareStatement(updatesql);
						prep.setString(1, _tid);
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
				prep.setString(1, _tid);
				prep.setString(2, _tname);
				prep.setString(3, _tsex);
				prep.setInt(4, _tage);
				prep.setString(5, _celphone);
				prep.setInt(6, 1);
				prep.executeUpdate();
					flag=true;
				}catch(SQLException e) {
					System.out.println("运行SQL语句时出现错误");
					e.printStackTrace();
				}finally {
					DataAccess.closeconn(conn, null, prep, null);	
				}
				return flag;
			}	
			
			//insertCourse
			public boolean insertCourse(String _cid, String _cname, String _time, String _site, String _price, String _lecturer, String _ctype) {
				boolean flag=false;
				Connection conn=null;
				PreparedStatement prep=null;
				ResultSet rs = null;
				try {
				conn=DataAccess.getConnection();
				String sql = "select * from course where 课程编号=?";
				prep = conn.prepareStatement(sql);
				prep.setString(1, _cid);
				rs = prep.executeQuery();
				while(rs.next())
				{
					//当 rs.getInt("标记") == 0 时表示_tid编号的老师在数据库中已经别软删除，此时直接更新isExist字段即可
					if(rs.getInt("标记") == 0) {
						String updatesql = "update course set 标记 = 1 where 课程编号 = ?";
						prep = conn.prepareStatement(updatesql);
						prep.setString(1, _cid);
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
				prep.setString(1, _cid);
				prep.setString(2, _cname);
				prep.setString(3, _time);
				prep.setString(4, _site);
				prep.setString(5, _price);
				prep.setString(6, _lecturer);
				prep.setString(7, _ctype);
				prep.setInt(8, 1);
				prep.executeUpdate();
				//if(number != null)
					flag=true;
				}catch(SQLException e) {
					System.out.println("运行SQL语句时出现错误");
					e.printStackTrace();
				}finally {
					DataAccess.closeconn(conn, null, prep, null);	
				}
				return flag;
			}	
			
		//insertCostomer
			public boolean insertCostomer(String _id, String _name, String _sex, int _age, String _telephone, String _course, String _register, String _type) {
				boolean flag=false;
				Connection conn=null;
				PreparedStatement prep=null;
				ResultSet rs = null;
				try {
				conn=DataAccess.getConnection();
				String sql = "select * from costomer where 客户编号=?";
				prep = conn.prepareStatement(sql);
				prep.setString(1, _id);
				rs = prep.executeQuery();
				
				while(rs.next())
				{
					//当 rs.getInt("标记") == 0 时表示_tid编号的老师在数据库中已经别软删除，此时直接更新isExist字段即可
					if(rs.getInt("标记") == 0) {
						String updatesql = "update costomer set 标记 = 1 where 客户编号 = ?";
						prep = conn.prepareStatement(updatesql);
						prep.setString(1, _id);
						prep.executeUpdate();
						//更新之后直接退出函数，不让它往下执行
						return true;
					}
					else//表示数据库已存在这条记录，不给再次插入，直接结束函数
					{
						System.out.println("该客户已存在，请勿重复插入");
						return false;
					}
				}
				prep=conn.prepareStatement("insert into costomer values(?,?,?,?,?,?,?,?,?)");
				prep.setString(1, _id);
				prep.setString(2, _name);
				prep.setString(3, _sex);
				prep.setInt(4, _age);
				prep.setString(5, _telephone);
				prep.setString(6, _course);
				prep.setString(7, _register);
				prep.setString(8, _type);
				prep.setInt(9, 1);
				prep.executeUpdate();
				//if(number != null)
					flag=true;
				}catch(SQLException e) {
					System.out.println("运行SQL语句时出现错误");
					e.printStackTrace();
				}finally {
					DataAccess.closeconn(conn, null, prep, null);	
				}
				return flag;
			}	
		
		//deleteCostomerById
		public boolean deleteCostomerById(String _id) {
			boolean flag=false;
			Connection conn=null;
			PreparedStatement prep=null;
			try {
			conn=DataAccess.getConnection();
			prep=conn.prepareStatement("update costomer set 标记=0 where 客户编号=?");
			prep.setString(1, _id);
			prep.executeUpdate();
				flag=true;
			}catch(SQLException e) {
				System.out.println("运行SQL语句时出现错误");
				e.printStackTrace();
			}finally {
				DataAccess.closeconn(conn, null, prep, null);
			}
			return flag;
		}
		//deleteCostomerByName
				public boolean deleteCostomerByName(String _name) {
					boolean flag=false;
					Connection conn=null;
					PreparedStatement prep=null;
					try {
					conn=DataAccess.getConnection();
					prep=conn.prepareStatement("update costomer set 标记=0 where 客户姓名=?");
					prep.setString(1, _name);
					prep.executeUpdate();
						flag=true;
					}catch(SQLException e) {
						System.out.println("运行SQL语句时出现错误");
						e.printStackTrace();
					}finally {
						DataAccess.closeconn(conn, null, prep, null);
					}
					return flag;
				}
				//deleteCourseById
				public boolean deleteCourseById(String _cid) {
					boolean flag=false;
					Connection conn=null;
					PreparedStatement prep=null;
					try {
					conn=DataAccess.getConnection();
					prep=conn.prepareStatement("update course set 标记=0 where 课程编号=?");
					prep.setString(1, _cid);
					prep.executeUpdate();
						flag=true;
					}catch(SQLException e) {
						System.out.println("运行SQL语句时出现错误");
						e.printStackTrace();
					}finally {
						DataAccess.closeconn(conn, null, prep, null);
					}
					return flag;
				}
				//deleteCourseByCname
				public boolean deleteCourseByCname(String _cname) {
					boolean flag=false;
					Connection conn=null;
					PreparedStatement prep=null;
					try {
					conn=DataAccess.getConnection();
					prep=conn.prepareStatement("update course set 标记=0 where 课程名称=?");
					prep.setString(1, _cname);
					prep.executeUpdate();
						flag=true;
					}catch(SQLException e) {
						System.out.println("运行SQL语句时出现错误");
						e.printStackTrace();
					}finally {
						DataAccess.closeconn(conn, null, prep, null);
					}
					return flag;
				}
				
				//deleteTeacherById
				public boolean deleteTeacherById (String _tid) {
					boolean flag=false;
					Connection conn=null;
					PreparedStatement prep=null;
					try {
					conn=DataAccess.getConnection();
					prep=conn.prepareStatement("update teacher set 标记=0 where 教师编号=?");
					prep.setString(1, _tid);
					prep.executeUpdate();
						flag=true;
					}catch(SQLException e) {
						System.out.println("运行SQL语句时出现错误");
						e.printStackTrace();
					}finally {
						DataAccess.closeconn(conn, null, prep, null);
					}
					return flag;
				}
				//deleteTeacherByName
				public boolean deleteTeacherByName(String _tname) {
					boolean flag=false;
					Connection conn=null;
					PreparedStatement prep=null;
					try {
					conn=DataAccess.getConnection();
					prep=conn.prepareStatement("update teacher set 标记=0 where 教师姓名=?");
					prep.setString(1, _tname);
					prep.executeUpdate();
						flag=true;
					}catch(SQLException e) {
						System.out.println("运行SQL语句时出现错误");
						e.printStackTrace();
					}finally {
						DataAccess.closeconn(conn, null, prep, null);
					}
					return flag;
				}
				//updateCostomer
				public boolean updateCostomerById(String _id, String _name,String _sex,int _age,String _telephone,String _course ,String _record,String _type) {
					boolean flag=false;
					Connection conn=null;
					PreparedStatement prep=null;
					try {
					conn=DataAccess.getConnection();
					String sql = "update costomer set 客户姓名 = ? ,客户性别=?,客户年龄=?,联系方式=?,选课记录=?,注册登记=?,客户类型=? where 客户编号 = ?";
					prep=conn.prepareStatement(sql);
					prep.setString(1, _name);
					prep.setString(2, _sex);
					prep.setInt(3,_age );
					prep.setString(4, _telephone);
					prep.setString(5, _course);
					prep.setString(6, _record);
					prep.setString(7,_type);
					prep.setString(8, _id);
					prep.executeUpdate();
						flag=true;
					}catch(SQLException e) {
						System.out.println("运行SQL语句时出现错误");
						e.printStackTrace();
					}finally {
						DataAccess.closeconn(conn, null, prep, null);	
					}
					return flag;
				}
				
				//updateCourse
				public boolean updateCourseById(String _cid, String _cname, String _time, String _site) {
					boolean flag=false;
					Connection conn=null;
					PreparedStatement prep=null;
					try {
					conn=DataAccess.getConnection();
					String sql = "update course set 课程名称 = ? , 上课时间=? , 上课地点=? where 课程编号 = ?";
					prep=conn.prepareStatement(sql);
					prep.setString(1, _cname);
					prep.setString(2, _site);
					prep.setString(3, _time);
					prep.setString(4, _cid);
					prep.executeUpdate();
						flag=true;
					}catch(SQLException e) {
						System.out.println("运行SQL语句时出现错误");
						e.printStackTrace();
					}finally {
						DataAccess.closeconn(conn, null, prep, null);	
					}
					return flag;
				}
				
				//updateTeacher
				public boolean updateTeacherById(String _tid, String _tname,String _tsex,String _tage,String _celphone) {
					boolean flag=false;
					Connection conn=null;
					PreparedStatement prep=null;
					try {
					conn=DataAccess.getConnection();
					String sql = "update teacher set 教师姓名 = ? ,教师性别=?,教师年龄=?, 联系方式=? where 教师编号 = ?";
					prep=conn.prepareStatement(sql);
					prep.setString(1, _tname);
					prep.setString(2, _tsex);
					prep.setString(3, _tage);
					prep.setString(4, _celphone);
					prep.setString(5, _tid);

					prep.executeUpdate();
						flag=true;
					}catch(SQLException e) {
						System.out.println("运行SQL语句时出现错误");
						e.printStackTrace();
					}finally {
						DataAccess.closeconn(conn, null, prep, null);	
					}
					return flag;
				}
	}	
