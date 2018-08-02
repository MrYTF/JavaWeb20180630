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

public class FindAllCostomer extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String cid = req.getParameter("cid");
		CostomerDao cd = new CostomerDao();
		//System.out.println(cid);
		Vector<CostomerDto> v= null;
		
		if(cid == "") {
			v = cd.findCostomer();
		}else {
			CostomerDto c = cd.findById(cid);
			if(c!=null) {
				v = new Vector<CostomerDto>();
				v.add(c);
			}
				
		}
		
		HttpSession s = req.getSession();
		s.setAttribute("allcostomer", v);
		resp.sendRedirect("costomer.jsp");
	}
}
