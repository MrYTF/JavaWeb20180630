<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.* ,cn.edu.lingnan.dto.CostomerDto"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>Insert title here</title>
</head>
<body>
<form action="updateCostomerServlet">
	<table border=1>
		<tr>
			<td>客户ID</td><td>客户姓名</td><td>客户性别</td><td>客户年龄</td><td>联系方式</td><td>课程记录</td>
			<td>注册登记</td><td>客户类型</td><td>存在记录</td><td></td>
		</tr>
		<%
			String cid = request.getParameter("cid");
			Vector<CostomerDto> v=new Vector<CostomerDto>();
			v = (Vector<CostomerDto>)session.getAttribute("allcostomer");
			Iterator it = v.iterator();
			CostomerDto c = null;
			while(it.hasNext()){
				c = (CostomerDto)it.next();	
				if((c.getId()).equals(cid)){
		%>
			
		<tr>
			<td><input type="text" readOnly="true"  name="id" value=<%=c.getId() %>></td>
			<td><input type="text" name="name" value=<%=c.getName() %>></td>
			<td><input type="text" name="sex" value=<%=c.getSex() %>></td>
			<td><input type="text" name="age" value=<%=c.getAge() %>></td>
			<td><input type="text" name="telephone" value=<%=c.getTelephone() %> maxlength="11"></td>
			<td><input type="text" name="course" value=<%=c.getCourse() %>></td>
			<td><input type="text" name="register" value=<%=c.getRegister() %>></td>
			<td><input type="text" name="type" value=<%=c.getType() %>></td>
			<td><input type="text" name="sign" value=<%=c.getSign() %>></td>
			<td><input type="submit" value="确认修改"></td>
		</tr>
		<% 
			} 
				}
		%>
	</table>
</form>
</body>
</html>