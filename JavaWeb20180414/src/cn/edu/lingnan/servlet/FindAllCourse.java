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

public class FindAllCourse extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String coid = req.getParameter("coid");
		CourseDao coa = new CourseDao();
		Vector<CourseDto> v = null;
		//System.out.println("2-----------2");
			if(coid=="")
			{
				v = coa.findCourse();
				
			}else {
				CourseDto cot = coa.findByCid(coid);
				if(cot!=null) {
					v = new Vector<CourseDto>();
					v.addElement(cot);
				}
			}
			HttpSession s = req.getSession();
			s.setAttribute("allcourse", v);
			resp.sendRedirect("course.jsp");
	}
}
