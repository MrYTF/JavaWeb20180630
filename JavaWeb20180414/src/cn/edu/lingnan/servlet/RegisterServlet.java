package cn.edu.lingnan.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.UserDao;
import cn.edu.lingnan.dto.UserDto;

public class RegisterServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		//1����ҳ���ȡ������Ҫ������
		String sid = null;
		String sname = null;
		String password = null;
		int superuser = 0;
		sid = req.getParameter("uid");
		sname = req.getParameter("username");
		password = req.getParameter("password");
		superuser = Integer.parseInt(req.getParameter("superuser"));
		System.out.println("1:"+sid+"    "+sname+"   "+password+"    "+superuser);
		
		//2�����ú�̨��ҵ���߼�ȥ�ж�����û����������Ƿ�����Ҷ�Ӧ
		UserDao sd = new UserDao();
		UserDto sdto = new UserDto();
		sdto.setSid(sid);
		sdto.setSname(sname);
		sdto.setPassword(password);
		sdto.setSuperuser(superuser);
		boolean flag = sd.insertStudent(sdto);
		HttpSession s = req.getSession();
		s.setAttribute("superuser", superuser);
		System.out.println("Ȩ��:"+superuser);
		//3�����ݽ��ȥ����Ӧ��ҳ��
		System.out.println("����·��:"+req.getContextPath());
		if(flag)
			resp.sendRedirect(req.getContextPath()+"/index.jsp");
		else 
			resp.sendRedirect(req.getContextPath()+"/KO.jsp");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
