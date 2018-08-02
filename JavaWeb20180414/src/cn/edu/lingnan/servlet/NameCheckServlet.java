package cn.edu.lingnan.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.lingnan.dao.UserDao;

public class NameCheckServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		req.setCharacterEncoding("GB2312");
		resp.setCharacterEncoding("GB2312");
		String username = req.getParameter("username");
		System.out.println("NameCheckServlet-----username:"+username);
		UserDao sd = new UserDao();
		boolean flag = sd.findStudentBySName(username);
		if(flag)
			resp.getWriter().print("true");
	}
}
