package cn.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.UserDao;
import cn.edu.lingnan.dto.UserDto;


public class UpdatePassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//1、从页面获取数据
		
		String oldpass = request.getParameter("oldpass");
		String newpass = request.getParameter("newpass");
		//2、调用后台业务逻辑判断用户名和密码是否对应
		UserDao sd = new UserDao();
		UserDto st = null;
		HttpSession s = request.getSession();
		
		Object username = s.getAttribute("username");
		String sname = (String)username;
		Vector<UserDto> v = new Vector<UserDto>();
		System.out.println(sname);
		st = sd.findStudentByName(sname);
		boolean flag = true;
		//判断从页面获取到的密码是否与原来的密码一致
		if(!oldpass.equals(st.getPassword())) {
			s.setAttribute("url", "pass.jsp");
			response.sendRedirect(request.getContextPath()+"/error.jsp");
			return;
		}
		
		st.setPassword(newpass);
		flag = sd.updateStudentById(st);
		v.add(st);
		//System.out.println(st);
		s.setAttribute("sid", st.getSid());
		s.setAttribute("username", st.getSname());
		s.setAttribute("superuser", st.getSuperuser());
		s.setAttribute("password",st.getPassword());
		if(flag) {
			s.setAttribute("url", "pass.jsp");
			s.setAttribute("updatepass", v);
			response.sendRedirect(request.getContextPath()+"/KO.jsp");
		}
		else {
			s.setAttribute("url", "pass.jsp");
			response.sendRedirect(request.getContextPath()+"/error.jsp");
		}
			
		
	}

}
