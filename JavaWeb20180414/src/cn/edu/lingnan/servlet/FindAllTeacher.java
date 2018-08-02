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

public class FindAllTeacher extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String tid = req.getParameter("tid");
		TeacherDao tao = new TeacherDao();
		Vector<TeacherDto> v = null;
		 if(tid == "") {
			 v = tao.findTeacher();
		 }else {
			 TeacherDto tto = tao.findByTid(tid);
			 if(tto!=null) {
				 v = new Vector<TeacherDto>();
				 v.add(tto);
			 }
			 
		 }
		 HttpSession s = req.getSession();
		 s.setAttribute("allteacher", v);
		 //System.out.println(req.getContextPath());
		 resp.sendRedirect(req.getContextPath()+"/teacher.jsp");
		 
	}
}
