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

public class UpdateTeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String tid = request.getParameter("tid");
		String tname = request.getParameter("tname");
		String tsex = request.getParameter("tsex");
		String tage = request.getParameter("tage");
		String celphone = request.getParameter("celphone");
		TeacherDao tao = new TeacherDao();
		TeacherDto tto = null;
		//TeacherDto tto = new TeacherDto(tid, tname, tsex, tage, celphone);
		tto = tao.findByTid(tid);
		tto.setTid(tid);
		tto.setTname(tname);
		tto.setTsex(tsex);
		tto.setTage(Integer.parseInt(tage));
		tto.setCelphone(celphone);
		boolean flag = tao.updateTeacherById(tto);
		Vector<TeacherDto> v = new Vector<TeacherDto>();
		v = tao.findTeacher();
		HttpSession s = request.getSession();
		s.setAttribute("allteacher", v);
		response.sendRedirect(request.getContextPath()+"/teacher.jsp");
	}

}
