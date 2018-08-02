<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.* ,cn.edu.lingnan.dto.UserDto"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>Insert title here</title>
</head>
<body>
	<table border=1>
		<tr>
			<td>ID</td><td>姓名</td><td>密码</td><td>权限</td><td></td>
		</tr>
		<%
			
			Vector<UserDto> v=new Vector<UserDto>();
			v = (Vector<UserDto>)session.getAttribute("alluser");
			Iterator it = v.iterator();
			UserDto s = null;
			while(it.hasNext()){
				s = (UserDto)it.next();	
				
		%>
			
		<tr>
			<td><%=s.getSid()%></td>
			<td><%=s.getSname()%></td>
			<td><%=s.getPassword()%></td>
			<td><%=s.getSuperuser()%></td>
			<td>
				<a href="updateUserInfo.jsp?sid=<%=s.getSid()%>">修改</a>
				<a href="deleteUserServlet?sid=<%=s.getSid()%>">删除</a>
			</td>
		</tr>
		<% 
			} 
		%>
	</table>

</body>
</html>