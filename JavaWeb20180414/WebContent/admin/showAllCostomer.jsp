<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.* ,cn.edu.lingnan.dto.CostomerDto"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>Insert title here</title>
</head>
<body>
	<table border=1>
		<tr>
			<td>客户ID</td><td>客户姓名</td><td>客户性别</td><td>客户年龄</td><td>联系方式</td><td>课程记录</td>
			<td>注册登记</td><td>客户类型</td><td>存在记录</td><td></td>
		</tr>
		<%
			
			Vector<CostomerDto> v1=new Vector<CostomerDto>();
			v1 = (Vector<CostomerDto>)session.getAttribute("allcostomer");
			Iterator it1 = v1.iterator();
			CostomerDto c = null;
			while(it1.hasNext()){
				c = (CostomerDto)it1.next();
				
				
		%>
			
		<tr>
			<td><%=c.getId() %></td>
			<td><%=c.getName() %></td>
			<td><%=c.getSex() %></td>
			<td><%=c.getAge() %></td>
			<td><%=c.getTelephone() %></td>
			<td><%=c.getCourse() %></td>
			<td><%=c.getRegister() %></td>
			<td><%=c.getType() %></td>
			<td><%=c.getSign() %></td>
			<td>
				<a href="updateUserInfo.jsp?sid=<%=c.getId()%>">修改</a>
				<a href="deleteCostomerServlet?cid=<%=c.getId()%>">删除</a>
			</td>
		</tr>
		<% 
			} 
		%>
</table>
</body>
</html>