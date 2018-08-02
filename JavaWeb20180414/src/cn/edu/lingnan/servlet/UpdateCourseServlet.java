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

public class UpdateCourseServlet extends HttpServlet {
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
		//System.out.println(cid+" ^_^  ^_^ "+cname);
		CourseDao coa = new CourseDao();
		CourseDto cot = null;
		cot = coa.findByCid(cid);
		//System.out.println("^_^ *_* *_*#"+cot);
		cot.setCid(cid);
		cot.setCname(cname);
		cot.setTime(time);
		cot.setSite(site);
		cot.setPrice(price);
		cot.setLecturer(lecturer);
		cot.setCtype(ctype);
		boolean flag = coa.updateCourseById(cot);
		Vector<CourseDto> v = new Vector<CourseDto>();
		v = coa.findCourse();
		HttpSession s = request.getSession();
		s.setAttribute("allcourse", v);
		response.sendRedirect(request.getContextPath()+"/course.jsp");
	}

}
