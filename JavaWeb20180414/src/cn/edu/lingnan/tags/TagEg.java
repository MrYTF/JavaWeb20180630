package cn.edu.lingnan.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

public class TagEg extends TagSupport{
	@Override
	public int doStartTag() throws JspException {
		try {
			pageContext.getOut().println("20180528");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Tag.SKIP_BODY;
	}
	@Override
	public int doEndTag() throws JspException {
		return Tag.EVAL_PAGE;
	}
}
