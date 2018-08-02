package cn.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.CostomerDao;
import cn.edu.lingnan.dto.CostomerDto;

public class UpdateCostomerServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {

	
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String sex = req.getParameter("sex");
		String age = req.getParameter("age");
		String telephone = req.getParameter("telephone");
		String course = req.getParameter("course");
		String register = req.getParameter("register");
		String type = req.getParameter("type");
		//System.out.println("  ----  "+name+"   "+sex);
		//String sign = req.getParameter("sign");
		CostomerDto cto = null;
		CostomerDao cao = new CostomerDao();
		cto = cao.findById(id);
		cto.setId(id);
		cto.setName(name);
		cto.setSex(sex);
		cto.setAge(Integer.parseInt(age));
		cto.setTelephone(telephone);
		cto.setCourse(course);
		cto.setRegister(register);
		cto.setType(type);
		//cto.setSign(Integer.parseInt(sign));
		boolean flag1 = cao.updateCostomerById(cto);
		//System.out.println(flag1);
		Vector<CostomerDto> v1=new Vector<CostomerDto>();
		v1 = cao.findCostomer();
		HttpSession s = req.getSession();
		s.setAttribute("allcostomer", v1);
		resp.sendRedirect(req.getContextPath()+"/admin/costomer.jsp");
	}
}
