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

public class DeleteUserServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String sid = req.getParameter("sid");
		UserDao sd = new UserDao();
		boolean flag = sd.deleteStudentById(sid);
		Vector<UserDto> v=new Vector<UserDto>();
		v = sd.findAllStudentInfo();
		HttpSession s = req.getSession();
		s.setAttribute("alluser", v);
		resp.sendRedirect(req.getContextPath()+"/admin/superuser.jsp");
	}
}
