package cn.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.TeacherDao;
import cn.edu.lingnan.dto.TeacherDto;

public class DeleteTeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String tid = request.getParameter("tid");
		TeacherDao tao = new TeacherDao();
		//TeacherDto tto = new TeacherDto();
		boolean flag = tao.deleteTeacherById(tid);
		Vector<TeacherDto> v = new Vector<TeacherDto>();
		v = tao.findTeacher();
		HttpSession s = request.getSession();
		s.setAttribute("allteacher", v);
		response.sendRedirect(request.getContextPath()+"/teacher.jsp");
	}

}
