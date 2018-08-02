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

public class DeleteCostomerServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		//req.setCharacterEncoding("GB2312");
		this.doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String cid = req.getParameter("cid");
		//String cname = req.getParameter("cname");
		//System.out.println(cname);
		//System.out.println(cid);
		CostomerDao cd = new CostomerDao();
		boolean flag = cd.deleteCostomerById(cid);
		Vector<CostomerDto> v1=new Vector<CostomerDto>();
		v1 = cd.findCostomer();
		HttpSession s = req.getSession();
		s.setAttribute("allcostomer", v1);
		resp.sendRedirect("costomer.jsp");
	}
}
