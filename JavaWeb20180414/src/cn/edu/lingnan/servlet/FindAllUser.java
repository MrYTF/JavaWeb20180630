package cn.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.CostomerDao;
import cn.edu.lingnan.dao.CourseDao;
import cn.edu.lingnan.dao.UserDao;
import cn.edu.lingnan.dao.TeacherDao;
import cn.edu.lingnan.dto.CostomerDto;
import cn.edu.lingnan.dto.CourseDto;
import cn.edu.lingnan.dto.UserDto;
import cn.edu.lingnan.dto.TeacherDto;

public class FindAllUser extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		//System.out.println("111111111111111");
		String sid = req.getParameter("sid");
		UserDao sd = new UserDao();
		Vector<UserDto> v=null;
		if(sid == "") {
			v = sd.findAllStudentInfo();
		}else {
			UserDto st = sd.findStudentById(sid);
			if(st!=null) {
				v = new Vector<UserDto>();
				v.add(st);
			}
			
		}
		HttpSession s = req.getSession();
		s.setAttribute("alluser", v);
		//System.out.println(v.get(0));
		resp.sendRedirect(req.getContextPath()+"/admin/superuser.jsp");
		//System.out.println("$_$"+req.getContextPath());
	}
}
