package cn.edu.lingnan.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {


	public void destroy() {
		// TODO Auto-generated method stub
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//1. ͨ��session����ȡsuperuser
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession s = req.getSession();
		//System.out.println("------");
		Object superuser = s.getAttribute("superuser");
		//System.out.println("-----"+s.getAttribute("superuser"));
		//2. ��ȡURI
		String uri = req.getRequestURI();
		//3. �ж�superuser�Ƿ�Ϊ�գ���Ϊ��ʱ��chain.doFilter();
		//	   �ж�URI�Ƿ���index.jsp����JavaWeb20180414��β
		//System.out.println(superuser+"------"+uri);
		if(superuser!=null || uri.endsWith("index.jsp") || uri.endsWith("JavaWeb20180414/") 
				|| uri.endsWith("loginServlet") || uri.endsWith("register.jsp") 
				|| uri.endsWith("nameCheckServlet") ||uri.endsWith("IdCheckServlet") ||uri.endsWith("registerServlet")) {
			chain.doFilter(request, response);
		}else {
			HttpServletResponse resp = (HttpServletResponse)response;
			resp.sendRedirect("index.jsp");
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
