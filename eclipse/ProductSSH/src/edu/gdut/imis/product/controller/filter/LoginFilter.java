package edu.gdut.imis.product.controller.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {

	private FilterConfig config;
	public void destroy() {
		this.config = null;
	}
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpSession session =((HttpServletRequest)req).getSession();
		String name = String.valueOf(session.getAttribute("user"));
		//System.out.println("���������");
		if (name.equals(new String("null"))) {
			//System.out.println("��תǰ");
			java.io.PrintWriter out = resp.getWriter();
			out.println("<html>");
			out.println("<script>");
			out.println("alert('���Ƚ��е�¼!');window.open ('/ProductSSH/Login.jsp','_parent')");
			out.println("</script>");
			out.println("</html>");
			//((HttpServletResponse)resp).sendRedirect("/Product/Login.jsp");
			//System.out.println("��ת��");
		} else {
			chain.doFilter(req, resp); 
		}
	}
	public void init(FilterConfig config) throws ServletException {
		this.config = config;
	}

}
