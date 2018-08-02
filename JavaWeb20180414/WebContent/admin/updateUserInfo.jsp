<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.* ,cn.edu.lingnan.dto.UserDto"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>Insert title here</title>
</head>
<body>
<form action="updateUserServlet">
	<table border=1>
		<tr>
			<td>ID</td><td>姓名</td><td>密码</td><td>权限</td><td></td>
		</tr>
		<%
			String sid = request.getParameter("sid");
			Vector<UserDto> v=new Vector<UserDto>();
			v = (Vector<UserDto>)session.getAttribute("alluser");
			Iterator it = v.iterator();
			UserDto s = null;
			while(it.hasNext()){
				s = (UserDto)it.next();	
				if((s.getSid()).equals(sid)){
		%>
			
		<tr>
			<td><input type="text" readOnly="true"  name="sid" value=<%=s.getSid()%>></td>
			<td><input type="text" name="sname" value=<%=s.getSname()%>></td>
			<td><input type="text" name="password" value=<%=s.getPassword()%>></td>
			<td><input type="text" name="superuser" value=<%=s.getSuperuser()%>></td>
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