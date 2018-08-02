package cn.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.CourseDao;
import cn.edu.lingnan.dto.CourseDto;

public class DeleteCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		this.doPost(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String coid = request.getParameter("coid");
		CourseDao coa = new CourseDao();
		//CourseDto cot = new CourseDto();
		boolean flag = coa.deleteCourseById(coid);
		Vector<CourseDto> v = new Vector<CourseDto>();
		v = coa.findCourse();
		
		HttpSession s = request.getSession();
		s.setAttribute("allcourse",v);
		response.sendRedirect(request.getContextPath()+"/course.jsp");
	}

}
