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
			<td>�ͻ�ID</td><td>�ͻ�����</td><td>�ͻ��Ա�</td><td>�ͻ�����</td><td>��ϵ��ʽ</td><td>�γ̼�¼</td>
			<td>ע��Ǽ�</td><td>�ͻ�����</td><td>���ڼ�¼</td><td></td>
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
				<a href="updateUserInfo.jsp?sid=<%=c.getId()%>">�޸�</a>
				<a href="deleteCostomerServlet?cid=<%=c.getId()%>">ɾ��</a>
			</td>
		</tr>
		<% 
			} 
		%>
</table>
</body>
</html>