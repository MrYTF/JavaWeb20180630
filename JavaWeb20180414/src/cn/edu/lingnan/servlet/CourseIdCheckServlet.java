package cn.edu.lingnan.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.lingnan.dao.CourseDao;
import cn.edu.lingnan.dao.UserDao;

/**
 * Servlet implementation class CourseIdCheckServlet
 */
public class CourseIdCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String cid = req.getParameter("cid");
		//System.out.println("UserIdCheckServlet-----cid:"+cid);
		CourseDao coa = new CourseDao();
		boolean flag = coa.findByCoid(cid);
		if(flag)
			resp.getWriter().print("true");
	}


}
