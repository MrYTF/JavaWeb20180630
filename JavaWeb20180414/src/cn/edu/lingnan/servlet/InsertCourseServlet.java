package cn.edu.lingnan.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.lingnan.dao.CourseDao;
import cn.edu.lingnan.dto.CourseDto;


public class InsertCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String cid = request.getParameter("cid");
		String cname = request.getParameter("cname");
		String time = request.getParameter("time");
		String site = request.getParameter("site");
		String price = request.getParameter("price");
		String lecturer = request.getParameter("lecturer");
		String ctype = request.getParameter("ctype");
		System.out.println(cid+" ---- ^_^ -_- *_* ---- "+cname);
		CourseDao coa = new CourseDao();
		CourseDto cot = new CourseDto(cid, cname, time, site, price, lecturer, ctype);
		boolean flag = coa.insertCourse(cot);
		if(flag) {
			System.out.println(request.getContextPath());
			response.sendRedirect(request.getContextPath()+"/course.jsp");
		}
		else 
			response.sendRedirect(request.getContextPath()+"/error.jsp");
	}

}
