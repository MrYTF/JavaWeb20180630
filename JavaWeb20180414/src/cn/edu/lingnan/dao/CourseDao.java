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
		prep=conn.prepareStatement("select * from course where ���=1");
		rs=prep.executeQuery();
		while(rs.next()) {//��������
			CourseDto i=new CourseDto();
			//course
			i.setCid(rs.getString("�γ̱��"));
			i.setCname(rs.getString("�γ�����"));
			i.setTime(rs.getString("�Ͽ�ʱ��"));
			i.setSite(rs.getString("�Ͽεص�"));
			i.setPrice(rs.getString("�γ̼۸�"));
			i.setLecturer(rs.getString("��ʦ����"));
			i.setCtype(rs.getString("�γ�����"));
			v.add(i);
		}
		}catch(SQLException e) {
			System.out.println("����SQL���ʱ���ִ���");
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
		prep=conn.prepareStatement("select * from course where �γ̱��=? and ���=1");
		prep.setString(1,_cid);
		rs=prep.executeQuery();	
		while(rs.next()) {//��������
			String cid=rs.getString("�γ̱��");
			String cname=rs.getString("�γ�����");
			String time=rs.getString("�Ͽ�ʱ��");
			String site=rs.getString("�Ͽεص�");
			String price=rs.getString("�γ̼۸�");
			String lecturer=rs.getString("��ʦ����");
			String ctype=rs.getString("�γ�����");
			st=new CourseDto(cid,cname,time,site,price,lecturer,ctype);
		}
		}catch(SQLException e) {
			System.out.println("����SQL���ʱ���ִ���");
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
		prep=conn.prepareStatement("select * from course where ��ʦ����=? and ���=1");
		prep.setString(1,tname);
		rs=prep.executeQuery();	
		while(rs.next()) {//��������
			String cid=rs.getString("�γ̱��");
			String cname=rs.getString("�γ�����");
			String time=rs.getString("�Ͽ�ʱ��");
			String site=rs.getString("�Ͽεص�");
			String price=rs.getString("�γ̼۸�");
			String lecturer=rs.getString("��ʦ����");
			String ctype=rs.getString("�γ�����");
			st=new CourseDto(cid,cname,time,site,price,lecturer,ctype);
		}
		}catch(SQLException e) {
			System.out.println("����SQL���ʱ���ִ���");
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
			prep=conn.prepareStatement("select * from course where �γ̱��=? and ���=1");
			prep.setString(1,_cid);
			rs=prep.executeQuery();	
			if(rs.first())
				flag = true;
			}catch(SQLException e) {
				System.out.println("����SQL���ʱ���ִ���");
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
		prep=conn.prepareStatement("select * from course where �γ�����=? and ���=1");
		prep.setString(1,_cname);
		rs=prep.executeQuery();	
		while(rs.next()) {//��������
			String cid=rs.getString("�γ̱��");
			String cname=rs.getString("�γ�����");
			String time=rs.getString("�Ͽ�ʱ��");
			String site=rs.getString("�Ͽεص�");
			String price=rs.getString("�γ̼۸�");
			String lecturer=rs.getString("��ʦ����");
			String ctype=rs.getString("�γ�����");
			st=new CourseDto(cid,cname,time,site,price,lecturer,ctype);
		}
		}catch(SQLException e) {
			System.out.println("����SQL���ʱ���ִ���");
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
		prep=conn.prepareStatement("select * from course where ��ʦ����=? and ���=1");
		prep.setString(1,_lecturer);
		rs=prep.executeQuery();	
		while(rs.next()) {//��������
			String cid=rs.getString("�γ̱��");
			String cname=rs.getString("�γ�����");
			String time=rs.getString("�Ͽ�ʱ��");
			String site=rs.getString("�Ͽεص�");
			String price=rs.getString("�γ̼۸�");
			String lecturer=rs.getString("��ʦ����");
			String ctype=rs.getString("�γ�����");
			st=new CourseDto(cid,cname,time,site,price,lecturer,ctype);
		}
		}catch(SQLException e) {
			System.out.println("����SQL���ʱ���ִ���");
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
		prep=conn.prepareStatement("select * from course where �γ�����=? and ���=1");
		prep.setString(1,_ctype);
		rs=prep.executeQuery();	
		while(rs.next()) {//��������
			String cid=rs.getString("�γ̱��");
			String cname=rs.getString("�γ�����");
			String time=rs.getString("�Ͽ�ʱ��");
			String site=rs.getString("�Ͽεص�");
			String price=rs.getString("�γ̼۸�");
			String lecturer=rs.getString("��ʦ����");
			String ctype=rs.getString("�γ�����");
			st=new CourseDto(cid,cname,time,site,price,lecturer,ctype);
		}
		}catch(SQLException e) {
			System.out.println("����SQL���ʱ���ִ���");
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
		String sql = "select * from course where �γ̱��=?";
		prep = conn.prepareStatement(sql);
		prep.setString(1, cot.getCid());
		rs = prep.executeQuery();
		while(rs.next())
		{
			//�� rs.getInt("���") == 0 ʱ��ʾ_tid��ŵ���ʦ�����ݿ����Ѿ�����ɾ������ʱֱ�Ӹ���isExist�ֶμ���
			if(rs.getInt("���") == 0) {
				String updatesql = "update course set ��� = 1 where �γ̱�� = ?";
				prep = conn.prepareStatement(updatesql);
				prep.setString(1, cot.getCid());
				prep.executeUpdate();
				//����֮��ֱ���˳�����������������ִ��
				return true;
			}
			else//��ʾ���ݿ��Ѵ���������¼�������ٴβ��룬ֱ�ӽ�������
			{
				System.out.println("�ÿγ��Ѵ��ڣ������ظ�����");
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
			System.out.println("����SQL���ʱ���ִ���");
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
		
		prep=conn.prepareStatement("update course set ���=0 where �γ̱��=?");
		prep.setString(1, _cid);
		prep.executeUpdate();
		
		
			flag=true;
		}catch(SQLException e) {
			System.out.println("����SQL���ʱ���ִ���");
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
		prep=conn.prepareStatement("update course set ���=0 where ��ʦ����=?");
		prep.setString(1, tname);
		prep.executeUpdate();
			flag=true;
		}catch(SQLException e) {
			System.out.println("����SQL���ʱ���ִ���");
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
		prep=conn.prepareStatement("update course set ���=0 where �γ�����=?");
		prep.setString(1, _cname);
		prep.executeUpdate();
			flag=true;
		}catch(SQLException e) {
			System.out.println("����SQL���ʱ���ִ���");
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
		String sql = "update course set �γ����� =?, �Ͽ�ʱ��=?, �Ͽεص�=?, �γ̼۸�=?, ��ʦ����=?, �γ�����=?, ���=? where �γ̱�� =?";
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
			System.out.println("����SQL���ʱ���ִ���");
			e.printStackTrace();
		}finally {
			DataAccess2.closeconn(conn, null, prep, null);	
		}
		return flag;
	}
}
