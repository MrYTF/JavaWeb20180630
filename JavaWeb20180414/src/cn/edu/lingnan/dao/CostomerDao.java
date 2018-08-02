package cn.edu.lingnan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import cn.edu.lingnan.dto.CostomerDto;
import cn.edu.lingnan.util.DataAccess;
import cn.edu.lingnan.util.DataAccess2;

public class CostomerDao {
	//finCostomerAll
	public Vector<CostomerDto> findCostomer() {
		Vector<CostomerDto> v1=new Vector<CostomerDto>();
		Connection conn=null;
		PreparedStatement prep=null;
		ResultSet rs=null;
		CostomerDto i = null;
		try {
		conn=DataAccess2.getConnection();
		prep=conn.prepareStatement("select * from costomer where ���=1");
		rs=prep.executeQuery();
		while(rs.next()) {//��������
			i=new CostomerDto();
			i.setId(rs.getString("�ͻ����"));
			i.setName(rs.getString("�ͻ�����"));
			i.setSex(rs.getString("�ͻ��Ա�"));
			i.setAge(rs.getInt("�ͻ�����"));
			i.setTelephone(rs.getString("��ϵ��ʽ"));
			i.setCourse(rs.getString("ѡ�μ�¼"));
			i.setRegister(rs.getString("ע��Ǽ�"));
			i.setType(rs.getString("�ͻ�����"));
			i.setSign(rs.getInt("���"));
			v1.add(i);
		}
	}catch(SQLException e) {
		System.out.println("����SQL���ʱ���ִ���");
			e.printStackTrace();
		}finally {
			DataAccess2.closeconn(conn, null, prep, rs);
		}
		return v1;
	}
	//findCostomerById
	public CostomerDto findById(String _id) {
		CostomerDto st=null;
		Connection conn=null;
		PreparedStatement prep=null;
		ResultSet rs=null;
		try {
		conn=DataAccess2.getConnection();
		prep=conn.prepareStatement("select * from costomer where �ͻ����=? and ���=1");
		prep.setString(1,_id);
		rs=prep.executeQuery();	
		while(rs.next()) {//��������
			String id=rs.getString("�ͻ����");
			String name=rs.getString("�ͻ�����");
			String sex=rs.getString("�ͻ��Ա�");
			int age=rs.getInt("�ͻ�����");
			String telephone=rs.getString("��ϵ��ʽ");
			String course=rs.getString("ѡ�μ�¼");
			String register=rs.getString("ע��Ǽ�");
			String type=rs.getString("�ͻ�����");
			st=new CostomerDto(id,name,sex,age,telephone,course,register,type);
		}
		}catch(SQLException e) {
		System.out.println("����SQL���ʱ���ִ���");
			e.printStackTrace();
		}finally {
			DataAccess2.closeconn(conn, null, prep, rs);
		}
		return st;
	}
	
	//findCostomerById
		public boolean findByCid(String _id) {
			boolean flag = false;
			Connection conn=null;
			PreparedStatement prep=null;
			ResultSet rs=null;
			try {
			conn=DataAccess2.getConnection();
			prep=conn.prepareStatement("select * from costomer where �ͻ����=? and ���=1");
			prep.setString(1,_id);
			rs=prep.executeQuery();	
			if(rs.first()) {//��������
				flag = true;
			}
			}catch(SQLException e) {
			System.out.println("����SQL���ʱ���ִ���");
				e.printStackTrace();
			}finally {
				DataAccess2.closeconn(conn, null, prep, rs);
			}
			return flag;
		}
	
	
	//findCostomerByName
	public CostomerDto findByName(String _name) {
		CostomerDto st=null;
		Connection conn=null;
		PreparedStatement prep=null;
		ResultSet rs=null;
		try {
		conn=DataAccess2.getConnection();
		prep=conn.prepareStatement("select * from costomer where �ͻ�����=? and ���=1");
		prep.setString(1,_name);
		rs=prep.executeQuery();	
		while(rs.next()) {//��������
			String id=rs.getString("�ͻ����");
			String name=rs.getString("�ͻ�����");
			String sex=rs.getString("�ͻ��Ա�");
			int age=rs.getInt("�ͻ�����");
			String telephone=rs.getString("��ϵ��ʽ");
			String course=rs.getString("ѡ�μ�¼");
			String register=rs.getString("ע��Ǽ�");
			String type=rs.getString("�ͻ�����");
			st=new CostomerDto(id,name,sex,age,telephone,course,register,type);
		}
		}catch(SQLException e) {
		System.out.println("����SQL���ʱ���ִ���");
			e.printStackTrace();
		}finally {
			DataAccess2.closeconn(conn, null, prep, rs);
		}
		return st;
	}
	//findCostomerByClass
	public CostomerDto findByCourse(String _course) {
		CostomerDto st=null;
		Connection conn=null;
		PreparedStatement prep=null;
		ResultSet rs=null;
		try {
		conn=DataAccess2.getConnection();
		prep=conn.prepareStatement("select * from costomer where ѡ�μ�¼=? and ���=1");
		prep.setString(1,_course);
		rs=prep.executeQuery();	
		while(rs.next()) {//��������
			String id=rs.getString("�ͻ����");
			String name=rs.getString("�ͻ�����");
			String sex=rs.getString("�ͻ��Ա�");
			int age=rs.getInt("�ͻ�����");
			String telephone=rs.getString("��ϵ��ʽ");
			String course=rs.getString("ѡ�μ�¼");
			String register=rs.getString("ע��Ǽ�");
			String type=rs.getString("�ͻ�����");
			st=new CostomerDto(id,name,sex,age,telephone,course,register,type);
		}
		}catch(SQLException e) {
		System.out.println("����SQL���ʱ���ִ���");
			e.printStackTrace();
		}finally {
			DataAccess2.closeconn(conn, null, prep, rs);
		}
		return st;
	}
	//findCostomerByType
	public CostomerDto findByType(String _type) {
		CostomerDto st=null;
		Connection conn=null;
		PreparedStatement prep=null;
		ResultSet rs=null;
		try {
		conn=DataAccess2.getConnection();
		prep=conn.prepareStatement("select * from costomer where �ͻ�����=? and ���=1");
		prep.setString(1,_type);
		rs=prep.executeQuery();	
		while(rs.next()) {//��������
			String id=rs.getString("�ͻ����");
			String name=rs.getString("�ͻ�����");
			String sex=rs.getString("�ͻ��Ա�");
			int age=rs.getInt("�ͻ�����");
			String telephone=rs.getString("��ϵ��ʽ");
			String course=rs.getString("ѡ�μ�¼");
			String register=rs.getString("ע��Ǽ�");
			String type=rs.getString("�ͻ�����");
			st=new CostomerDto(id,name,sex,age,telephone,course,register,type);
		}
		}catch(SQLException e) {
		System.out.println("����SQL���ʱ���ִ���");
			e.printStackTrace();
		}finally {
			DataAccess2.closeconn(conn, null, prep, rs);
		}
		return st;
	}
	//insertCostomer
	public boolean insertCostomer(CostomerDto cto) {
		boolean flag=false;
//		String id = cto.getId();
//		String name = cto.getName();
//		String sex = cto.getSex();
//		int age = cto.getAge();
//		String telephone = cto.getTelephone();
//		String course = cto.getCourse();
//		String register = cto.getRegister();
//		String type = cto.getType();
		//int sign = cto.getSign();
		Connection conn=null;
		PreparedStatement prep=null;
		ResultSet rs = null;
		try {
		conn=DataAccess2.getConnection();
		String sql = "select * from costomer where �ͻ����=?";
		prep = conn.prepareStatement(sql);
		prep.setString(1, cto.getId());
		rs = prep.executeQuery();
		
		while(rs.next())
		{
				//�� rs.getInt("���") == 0 ʱ��ʾ_cid��ŵĿͻ������ݿ����Ѿ�����ɾ������ʱֱ�Ӹ���isExist�ֶμ���
			if(rs.getInt("���") == 0) {
			String updatesql = "update costomer set ��� = 1 where �ͻ���� = ?";
			prep = conn.prepareStatement(updatesql);
			prep.setString(1, cto.getId());
			prep.executeUpdate();
			//����֮��ֱ���˳�����������������ִ��
			return true;
			}
		else//��ʾ���ݿ��Ѵ���������¼�������ٴβ��룬ֱ�ӽ�������
			{
				System.out.println("�ÿͻ��Ѵ��ڣ������ظ�����");
				return false;
			}
		}
		prep=conn.prepareStatement("insert into costomer values(?,?,?,?,?,?,?,?,?)");
		prep.setString(1, cto.getId());
		prep.setString(2, cto.getName());
		prep.setString(3, cto.getSex());
		prep.setInt(4, cto.getAge());
		prep.setString(5, cto.getTelephone());
		prep.setString(6, cto.getCourse());
		prep.setString(7, cto.getRegister());
		prep.setString(8, cto.getType());
		prep.setInt(9, 1);
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
	
	//deleteCostomerById
	public boolean deleteCostomerById(String _id) {
		boolean flag=false;
		Connection conn=null;
		PreparedStatement prep=null;
		try {
			conn=DataAccess2.getConnection();
			prep=conn.prepareStatement("update costomer set ���=0 where �ͻ����=?");
			prep.setString(1, _id);
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
	
	//deleteCostomerById
		public boolean deleteCostomerByCourseId(String cid) {
			boolean flag=false;
			Connection conn=null;
			PreparedStatement prep=null;
			try {
				conn=DataAccess2.getConnection();
				prep=conn.prepareStatement("update costomer set ���=0 where ѡ�μ�¼=?");
				prep.setString(1, cid);
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
		
	//deleteCostomerByName
	public boolean deleteCostomerByName(String _name) {
		boolean flag=false;
		Connection conn=null;
		PreparedStatement prep=null;
		try {
		conn=DataAccess2.getConnection();
		prep=conn.prepareStatement("update costomer set ���=0 where �ͻ�����=?");
		prep.setString(1, _name);
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
	//updateCostomer
	public boolean updateCostomerById(CostomerDto cto) {
		boolean flag=false;
		Connection conn=null;
		//Statement stat = null;
		PreparedStatement prep=null;
//		String id = cto.getId();
//		String name = cto.getName();
//		String sex = cto.getSex();
//		int age = cto.getAge();
//		String telephone = cto.getTelephone();
//		String course = cto.getCourse();
//		String register = cto.getRegister();
//		String type = cto.getType();
//		int sign = cto.getSign();
		String sql = "update costomer set �ͻ�����=?,�ͻ��Ա�=?,�ͻ�����=?,��ϵ��ʽ=?,ѡ�μ�¼=?,ע��Ǽ�=?,�ͻ�����=? where �ͻ���� =?";
		try {
		conn=DataAccess2.getConnection();
//		stat = conn.createStatement();
//		stat.executeUpdate(sql);
		
		prep=conn.prepareStatement(sql);
		prep.setString(1, cto.getName());
		prep.setString(2, cto.getSex());
		prep.setInt(3,cto.getAge() );
		prep.setString(4, cto.getTelephone());
		prep.setString(5, cto.getCourse());
		prep.setString(6, cto.getRegister());
		prep.setString(7,cto.getType());
		prep.setString(8, cto.getId());
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
