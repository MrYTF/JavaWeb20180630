package cn.edu.lingnan.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.UserDao;

public class LoginServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		//1、从页面获取我们想要的数据
		String name = null;
		String password = null;
		name = req.getParameter("username");
		password = req.getParameter("password");
		System.out.println("1:"+name+"   "+password);
		//2、调用后台的业务逻辑去判断这个用户名和密码是否存在且对应
		UserDao sd = new UserDao();
		String sid = sd.findStudentBySNameAndPassword(name, password);
		int superuser = sd.findStudentByNameAndPassword(name, password);
		HttpSession s = req.getSession();
		s.setAttribute("sid", sid);
		s.setAttribute("username", name);
		s.setAttribute("superuser", superuser);
		s.setAttribute("password", password);
		s.setMaxInactiveInterval(3600);//会话时间/秒
		System.out.println("2superuser:"+superuser);
		//3、根据结果去到相应的页面
		
		System.out.println("3:"+req.getContextPath());
		if(superuser != 0 )
			resp.sendRedirect(req.getContextPath()+"/login.jsp");
		else {
			s.setAttribute("url", "index.jsp");
			resp.sendRedirect(req.getContextPath()+"/error.jsp");
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
