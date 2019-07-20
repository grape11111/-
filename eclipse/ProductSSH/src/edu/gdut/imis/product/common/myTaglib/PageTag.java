package edu.gdut.imis.product.common.myTaglib;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import edu.gdut.imis.product.common.PageBean;

public class PageTag<T> extends SimpleTagSupport {
	private List<T>list;
	private PageBean pb;
	private String var;//把遍历到的记录放到域对象里面
	public List<T> getList() {
		return list;
	}
	public PageBean getPb() {
		return pb;
	}
	public String getVar() {
		return var;
	}
	public void setVar(String var) {
		this.var=var;
	}
	
	
	public void setList(List<T> list) {
		this.list = list;
	}
	public void setPb(PageBean pb) {
		this.pb = pb;
	}
	public void doTag() throws JspException,IOException{
		PageContext pagecontext=(PageContext) this.getJspContext();
		int begin=pb.getCurrPage()*pb.getPageSize();
		int end=(pb.getCurrPage()+1)*pb.getPageSize();
		if(end>list.size()) {
			end=list.size();
		}
		List<T>currlist=list.subList(begin, end);
		Iterator <T>it=currlist.iterator();
		while(it.hasNext() ){
			Object obj=it.next();
			pagecontext.setAttribute(var, obj);
			this.getJspBody().invoke(null);
		}
		String uri=((HttpServletRequest)pagecontext.getRequest()).getRequestURI();
		pagecontext.getOut().println("<tr><td colspan='5'>");
		pagecontext.getOut().print("<a href="+uri+"?currPage=0>首页</a>&nbsp;");
		if(pb.getCurrPage()<2) {
			pagecontext.getOut().print("<a href="+uri+"?currPage=0>上一页</a>&nbsp;");
		}else {
			pagecontext.getOut().print("<a href="+uri+"?currPage="+(pb.getCurrPage()-1)+">上一页</a>&nbsp;");
		}
		for(int i=0;i<pb.getTotalPage();i++) {
			pagecontext.getOut().print("<a href="+uri+"?currPage="+i+">"+(i+1)+"</a>&nbsp;");
		}
		if(pb.getCurrPage()>=pb.getTotalPage()-1) {
			pagecontext.getOut().print("<a href="+uri+"?currPage="+(pb.getTotalPage()-1)+">下一页</a>&nbsp;");
		}else {
			pagecontext.getOut().print("<a href="+uri+"?currPage="+(pb.getCurrPage()+1)+">下一页</a>&nbsp;");
		}
		pagecontext.getOut().print("<a href="+uri+"?currPage="+(pb.getTotalPage()-1)+">末页</a>&nbsp;");
		pagecontext.getOut().print("</td></tr>");
	}
	
}
