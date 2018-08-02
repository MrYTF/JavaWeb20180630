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

public class DeleteCostomerCheckServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String[] arr = req.getParameterValues("arr");
		System.out.println("(&_&)"+arr);
		CostomerDao cao = new CostomerDao();
		for(String a : arr) { 	
			String[] b = a.split(",");
			for(String c : b)
				cao.deleteCostomerById(c);
		}
		Vector<CostomerDto> v1= new Vector<CostomerDto>();
		v1 = cao.findCostomer();
		System.out.println(v1);
		HttpSession s = req.getSession();
		s.setAttribute("allcostomer", v1);
		resp.sendRedirect(req.getContextPath()+"/admin/costomer.jsp");
	}
}
