package cn.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.UserDao;
import cn.edu.lingnan.dto.UserDto;

public class UpdateUserServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String sid = req.getParameter("sid");
		String sname = req.getParameter("sname");
		String password = req.getParameter("password");
		String superuser = req.getParameter("superuser");
		//System.out.println(sid+"     "+sname+"     "+password+"     "+superuser);
		UserDto sdto = null;
		UserDao sdao = new UserDao();
		sdto = sdao.findStudentById(sid);
		sdto.setSid(sid);
		sdto.setSname(sname);
		sdto.setPassword(password);
		sdto.setSuperuser(Integer.parseInt(superuser));
		boolean flag = sdao.updateStudentById(sdto);
		Vector<UserDto> v=new Vector<UserDto>();
		v = sdao.findAllStudentInfo();
		HttpSession s = req.getSession();
		s.setAttribute("alluser", v);
		resp.sendRedirect(req.getContextPath()+"/admin/superuser.jsp");
	}
}
