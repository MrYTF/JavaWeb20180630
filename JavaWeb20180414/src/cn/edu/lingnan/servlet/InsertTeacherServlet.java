package cn.edu.lingnan.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.lingnan.dao.TeacherDao;
import cn.edu.lingnan.dto.TeacherDto;

public class InsertTeacherServlet extends HttpServlet {
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
		int tage = Integer.parseInt(request.getParameter("tage"));
		String celphone = request.getParameter("celphone");
		TeacherDao tao = new TeacherDao();
		TeacherDto tto = new TeacherDto(tid, tname, tsex, tage, celphone);
		boolean flag = tao.insertTeacher(tto);
		if(flag) {
			//System.out.println(request.getContextPath());
			response.sendRedirect(request.getContextPath()+"/teacher.jsp");
		
		}else
			response.sendRedirect(request.getContextPath()+"/error.jsp");
	}
}

