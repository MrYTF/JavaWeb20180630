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
		prep=conn.prepareStatement("select * from costomer where 标记=1");
		rs=prep.executeQuery();
		while(rs.next()) {//处理结果集
			i=new CostomerDto();
			i.setId(rs.getString("客户编号"));
			i.setName(rs.getString("客户姓名"));
			i.setSex(rs.getString("客户性别"));
			i.setAge(rs.getInt("客户年龄"));
			i.setTelephone(rs.getString("联系方式"));
			i.setCourse(rs.getString("选课记录"));
			i.setRegister(rs.getString("注册登记"));
			i.setType(rs.getString("客户类型"));
			i.setSign(rs.getInt("标记"));
			v1.add(i);
		}
	}catch(SQLException e) {
		System.out.println("运行SQL语句时出现错误");
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
			prep=conn.prepareStatement("select * from costomer where 客户编号=? and 标记=1");
			prep.setString(1,_id);
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
	
	
	//findCostomerByName
	public CostomerDto findByName(String _name) {
		CostomerDto st=null;
		Connection conn=null;
		PreparedStatement prep=null;
		ResultSet rs=null;
		try {
		conn=DataAccess2.getConnection();
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
		}
		}catch(SQLException e) {
		System.out.println("运行SQL语句时出现错误");
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
		}
		}catch(SQLException e) {
		System.out.println("运行SQL语句时出现错误");
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
		String sql = "select * from costomer where 客户编号=?";
		prep = conn.prepareStatement(sql);
		prep.setString(1, cto.getId());
		rs = prep.executeQuery();
		
		while(rs.next())
		{
				//当 rs.getInt("标记") == 0 时表示_cid编号的客户在数据库中已经别软删除，此时直接更新isExist字段即可
			if(rs.getInt("标记") == 0) {
			String updatesql = "update costomer set 标记 = 1 where 客户编号 = ?";
			prep = conn.prepareStatement(updatesql);
			prep.setString(1, cto.getId());
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
		System.out.println("运行SQL语句时出现错误");
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
			prep=conn.prepareStatement("update costomer set 标记=0 where 客户编号=?");
			prep.setString(1, _id);
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
	
	//deleteCostomerById
		public boolean deleteCostomerByCourseId(String cid) {
			boolean flag=false;
			Connection conn=null;
			PreparedStatement prep=null;
			try {
				conn=DataAccess2.getConnection();
				prep=conn.prepareStatement("update costomer set 标记=0 where 选课记录=?");
				prep.setString(1, cid);
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
		
	//deleteCostomerByName
	public boolean deleteCostomerByName(String _name) {
		boolean flag=false;
		Connection conn=null;
		PreparedStatement prep=null;
		try {
		conn=DataAccess2.getConnection();
		prep=conn.prepareStatement("update costomer set 标记=0 where 客户姓名=?");
		prep.setString(1, _name);
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
		String sql = "update costomer set 客户姓名=?,客户性别=?,客户年龄=?,联系方式=?,选课记录=?,注册登记=?,客户类型=? where 客户编号 =?";
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
		System.out.println("运行SQL语句时出现错误");
			e.printStackTrace();
		}finally {
			DataAccess2.closeconn(conn, null, prep, null);	
		}
		return flag;
	}
}
