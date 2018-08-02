package cn.edu.lingnan.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.lingnan.dao.CourseDao;
import cn.edu.lingnan.dao.TeacherDao;

/**
 * Servlet implementation class TeacherIdCheckServlet
 */
public class TeacherIdCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String tid = req.getParameter("tid");
		//System.out.println("UserIdCheckServlet-----tid:"+tid);
		TeacherDao tao = new TeacherDao();
		boolean flag = tao.findByTeid(tid);
		if(flag)
			resp.getWriter().print("true");
	}

}
