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
		prep=conn.prepareStatement("select * from teacher where ���=1");
		rs=prep.executeQuery();
		while(rs.next()) {//��������
			TeacherDto i=new TeacherDto();
			//teacher
			i.setTid(rs.getString("��ʦ���"));
			i.setTname(rs.getString("��ʦ����"));
			i.setTsex(rs.getString("��ʦ�Ա�"));
			i.setTage(rs.getInt("��ʦ����"));
			i.setCelphone(rs.getString("��ϵ��ʽ"));
			v2.add(i);
		}
		}catch(SQLException e) {
			System.out.println("����SQL���ʱ���ִ���");
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
		prep=conn.prepareStatement("select * from teacher where ��ʦ���=? and ���=1");
		prep.setString(1,_tid);
		rs=prep.executeQuery();	
		while(rs.next()) {//��������
			String tid=rs.getString("��ʦ���");
			String tname=rs.getString("��ʦ����");
			String tsex=rs.getString("��ʦ�Ա�");
			int tage=rs.getInt("��ʦ����");
			String celphone=rs.getString("��ϵ��ʽ");
			st=new TeacherDto(tid,tname,tsex,tage,celphone);
		}
		}catch(SQLException e) {
			System.out.println("����SQL���ʱ���ִ���");
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
			prep=conn.prepareStatement("select * from teacher where ��ʦ���=? and ���=1");
			prep.setString(1,_tid);
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
	
	//findTeacherByTname
	public TeacherDto findByTname(String _tname) {
		TeacherDto st=null;
		Connection conn=null;
		PreparedStatement prep=null;
		ResultSet rs=null;
		try {
		conn=DataAccess2.getConnection();
		prep=conn.prepareStatement("select * from teacher where ��ʦ����=? and ���=1");
		prep.setString(1,_tname);
		rs=prep.executeQuery();	
		while(rs.next()) {//��������
			String tid=rs.getString("��ʦ���");
			String tname=rs.getString("��ʦ����");
			String tsex=rs.getString("��ʦ�Ա�");
			int tage=rs.getInt("��ʦ����");
			String celphone=rs.getString("��ϵ��ʽ");
			st=new TeacherDto(tid,tname,tsex,tage,celphone);
		}
		}catch(SQLException e) {
			System.out.println("����SQL���ʱ���ִ���");
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
		String sql = "select * from teacher where ��ʦ��� = ?";
		prep = conn.prepareStatement(sql);
		prep.setString(1, tto.getTid());
		rs = prep.executeQuery();
		while(rs.next())
		{
			//�� rs.getInt("���") == 0 ʱ��ʾ_tid��ŵ���ʦ�����ݿ����Ѿ�����ɾ������ʱֱ�Ӹ���isExist�ֶμ���
			if(rs.getInt("���") == 0) {
				String updatesql = "update teacher set ��� = 1 where ��ʦ��� = ?";
				prep = conn.prepareStatement(updatesql);
				prep.setString(1, tto.getTid());
				prep.executeUpdate();
				//����֮��ֱ���˳�����������������ִ��
				return true;
			}
			else//��ʾ���ݿ��Ѵ���������¼�������ٴβ��룬ֱ�ӽ�������
			{
				System.out.println("����ʦ�Ѵ��ڣ������ظ�����");
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
			System.out.println("����SQL���ʱ���ִ���");
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
		
		prep=conn.prepareStatement("update teacher set ���=0 where ��ʦ���=?");
		prep.setString(1, _tid);
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
	//deleteTeacherByName
	public boolean deleteTeacherByName(String _tname) {
		boolean flag=false;
		Connection conn=null;
		PreparedStatement prep=null;
		try {
		conn=DataAccess2.getConnection();
		prep=conn.prepareStatement("update teacher set ���=0 where ��ʦ����=?");
		prep.setString(1, _tname);
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
	//updateTeacher
	public boolean updateTeacherById(TeacherDto tto) {
		boolean flag=false;
		Connection conn=null;
		PreparedStatement prep=null;
		try {
		conn=DataAccess2.getConnection();
		String sql = "update teacher set ��ʦ���� = ? ,��ʦ�Ա�=?,��ʦ����=?, ��ϵ��ʽ=? where ��ʦ��� = ?";
		prep=conn.prepareStatement(sql);
		prep.setString(1, tto.getTname());
		prep.setString(2, tto.getTsex());
		prep.setInt(3, tto.getTage());
		prep.setString(4, tto.getCelphone());
		prep.setString(5, tto.getTid());
	
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
