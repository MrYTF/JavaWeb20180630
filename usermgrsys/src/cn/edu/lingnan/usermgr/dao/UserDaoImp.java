package cn.edu.lingnan.usermgr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import cn.edu.lingnan.common.exception.DaoException;
import cn.edu.lingnan.common.util.DBUtil;
import cn.edu.lingnan.usermgr.domain.UserDto;
/**
 * userDao实现类
 * @author LiQi
 *
 */
public class UserDaoImp implements UserDao{
	/**
	 * 数据库连接
	 */
	private Connection connection;
	/**
	 * 构造方法
	 * @param connection 数据库连接
	 */
	public UserDaoImp(Connection connection) {
		this.connection = connection;
		//System.out.println("^_^"+this.connection);
	}

	/**
	 * 用户登录
	 */
	public UserDto login(String sname,String password) {
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		UserDto dto = null;
		String sql = "select * from t_user where sname = ? and password = ?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, sname);
			preparedStatement.setString(2, password);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				dto = new UserDto();
				dto.setSid(resultSet.getInt("sid"));
				dto.setSname(resultSet.getString("sname"));
				dto.setPassword(resultSet.getString("password"));
				dto.setGender(resultSet.getString("gender"));
				dto.setAge(resultSet.getInt("age"));
				dto.setPhone(resultSet.getString("phone"));
				dto.setBirth(resultSet.getTimestamp("birth"));
				dto.setPower(resultSet.getString("power"));
				dto.setStatus(resultSet.getInt("status"));
				//System.out.println("(~_*)"+dto);
			}
		} catch (SQLException e) {
			throw new DaoException("无法获取数据库连接......", e);
		}finally {
			DBUtil.closeStatement(resultSet, preparedStatement);
		}
		return dto;
	}
	
	/**
	 * 用户注册/添加用户
	 */
	public boolean addUser(UserDto dto) {
		boolean flag = false;
		int num = 0;
		PreparedStatement preparedStatement = null;
		String sql = "insert into t_user(sname, password, gender, age, phone, birth, power, status) values(?,?,?,?,?,?,?,?)";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, dto.getSname());
			preparedStatement.setString(2, dto.getPassword());
			preparedStatement.setString(3, dto.getGender());
			preparedStatement.setInt(4, dto.getAge());
			preparedStatement.setString(5, dto.getPhone());
			preparedStatement.setDate(6, new java.sql.Date( dto.getBirth().getTime()));
			preparedStatement.setString(7, "普通用户");
			preparedStatement.setInt(8, 1);
			num = preparedStatement.executeUpdate();
			if (num>0) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeStatement(null, preparedStatement);
		}
		return flag;
	}
	
	/**
	 * 查询所有用户
	 * @return 返回容器vector
	 */
	public Vector<UserDto> findAllUser() {
		Vector<UserDto> dtos = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String sql = "select * from t_user";
		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			dtos = new Vector<UserDto>();
			while(resultSet.next()) {
				UserDto dto = new UserDto();
				dto.setSid(resultSet.getInt("sid"));
				dto.setSname(resultSet.getString("sname"));
				dto.setPassword(resultSet.getString("password"));
				dto.setGender(resultSet.getString("gender"));
				dto.setAge(resultSet.getInt("age"));
				dto.setPhone(resultSet.getString("phone"));
				dto.setBirth(resultSet.getTimestamp("birth"));
				dto.setPower(resultSet.getString("power"));
				dto.setStatus(resultSet.getInt("status"));
				dtos.add(dto);
			}
		} catch (SQLException e) {
			throw new DaoException("查询失败....",e);
		}finally {
			DBUtil.closeStatement(resultSet, preparedStatement);
		}
		return dtos;
	}
	
	/**
	 * 根据ID查询用户
	 * @param sid 用户id
	 * @return 返回对应用户信息
	 */
	public UserDto findByID(int sid) {
		UserDto dto = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String sql = "select * from t_user where sid = ?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, sid);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				dto = new UserDto();
				dto.setSid(resultSet.getInt("sid"));
				dto.setSname(resultSet.getString("sname"));
				dto.setPassword(resultSet.getString("password"));
				dto.setGender(resultSet.getString("gender"));
				dto.setAge(resultSet.getInt("age"));
				dto.setPhone(resultSet.getString("phone"));
				dto.setBirth(resultSet.getDate("birth"));
				dto.setPower(resultSet.getString("power"));
				dto.setStatus(resultSet.getInt("status"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeStatement(resultSet, preparedStatement);
		}
		return dto;
	}
	
	/**
	 * 根据姓名查询用户信息
	 * @param sname 姓名
	 * @return 返回对应用户信息
	 */
	public UserDto findByName(String sname) {
		UserDto dto = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String sql = "select * from t_user where sname = ?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, sname);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				dto = new UserDto();
				dto.setSid(resultSet.getInt("sid"));
				dto.setSname(resultSet.getString("sname"));
				dto.setPassword(resultSet.getString("password"));
				dto.setGender(resultSet.getString("gender"));
				dto.setAge(resultSet.getInt("age"));
				dto.setPhone(resultSet.getString("phone"));
				dto.setBirth(resultSet.getDate("birth"));
				dto.setPower(resultSet.getString("power"));
				dto.setStatus(resultSet.getInt("status"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeStatement(resultSet, preparedStatement);
		}
		return dto;
	}
	
	/**
	 * 修改用户
	 */
	public boolean updateUser(UserDto dto) {
		boolean flag = false;
		
		PreparedStatement preparedStatement = null;
		String sql = "update t_user set sname = ?, password = ?, gender = ?, age = ?, phone = ?, birth = ? where sid = ?";
		int num = 0;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, dto.getSname());
			preparedStatement.setString(2, dto.getPassword());
			preparedStatement.setString(3, dto.getGender());
			preparedStatement.setInt(4, dto.getAge());
			preparedStatement.setString(5, dto.getPhone());
			preparedStatement.setDate(6, new java.sql.Date(dto.getBirth().getTime()));
			preparedStatement.setInt(7, dto.getSid());
			num = preparedStatement.executeUpdate();
			if (num>0) {
				flag = true;
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeStatement(null, preparedStatement);
		}
		return flag;
	}
	
	/**
	 * 删除用户
	 * @param sid
	 * @return
	 */
	public boolean delUser(int sid){
		boolean flag = false;
		PreparedStatement statement = null;
		String sql = "delete from t_user where sid = ?";
		int num = 0;
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, sid);
			statement.executeUpdate();
			if (num>0) {
				flag = true;
			}
		} catch (Exception e) {
			throw new DaoException("删除不成功",e);
		}finally {
			DBUtil.closeStatement(null, statement);
		}
		return flag;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
