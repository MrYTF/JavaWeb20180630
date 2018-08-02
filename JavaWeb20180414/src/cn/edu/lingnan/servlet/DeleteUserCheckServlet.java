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


public class DeleteUserCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String[] arr = request.getParameterValues("arr");
		UserDao sd = new UserDao();
		for(String a : arr) {
			String[] b = a.split(",");
			for(String c : b)
				sd.deleteStudentById(c);
		}
		Vector<UserDto> v = new Vector<UserDto>();
		v = sd.findAllStudentInfo();
		HttpSession s = request.getSession();
		s.setAttribute("alluser", v);
		response.sendRedirect(request.getContextPath()+"/admin/superuser.jsp");
	}

}
