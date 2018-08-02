package cn.edu.lingnan.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.CostomerDao;
import cn.edu.lingnan.dto.CostomerDto;

public class InsertCostomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		int age = Integer.parseInt(request.getParameter("age"));
		String telephone = request.getParameter("telephone");
		String course = request.getParameter("course");
		String register = request.getParameter("register");
		String type = request.getParameter("type");
		//int sign = Integer.parseInt(request.getParameter("sign"));
		System.out.println(id+" 212---- "+name);
		
		CostomerDao cao = new CostomerDao();
		CostomerDto cto = new CostomerDto(id, name, sex, age, telephone, course, register, type);
//		cto = cao.findById(id);
//		System.out.println(cto);
//		cto.setId(id);
//		cto.setName(name);
//		cto.setSex(sex);
//		cto.setAge(age);
//		cto.setTelephone(telephone);
//		cto.setCourse(course);
//		cto.setRegister(register);
//		cto.setType(type);
		//cto.setSign(sign);
		boolean flag = cao.insertCostomer(cto);
		System.out.println(flag);
		if(flag) {
			//System.out.println(request.getContextPath());
			response.sendRedirect(request.getContextPath()+"/admin/costomer.jsp");
		
		}else
			response.sendRedirect(request.getContextPath()+"/error.jsp");
	}

}
