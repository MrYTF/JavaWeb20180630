package cn.edu.lingnan.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.lingnan.dao.CostomerDao;
import cn.edu.lingnan.dao.UserDao;

/**
 * Servlet implementation class UserIdCheckServlet
 */
public class UserIdCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String uid = req.getParameter("uid");
		//System.out.println("UserIdCheckServlet-----uid:"+uid);
		UserDao sd = new UserDao();
		boolean flag = sd.findStudentByUid(uid);
		if(flag)
			resp.getWriter().print("true");
	}

}
