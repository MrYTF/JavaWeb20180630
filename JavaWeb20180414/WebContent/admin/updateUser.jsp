<%@page import="cn.edu.lingnan.dao.UserDao"%>
<%@page import="cn.edu.lingnan.dto.UserDto"%>
<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>
<link rel="stylesheet" href="../css/pintuer.css">
<link rel="stylesheet" href="../css/admin.css">
<script src="../js/jquery.js"></script>
<script src="../js/pintuer.js"></script>
</head>
<body>
<div class="panel admin-panel" >
  <div class="panel-head"><strong><span class="icon-key"></span> 修改用户信息</strong></div>
  <div class="body-content" style="float: 50%">
    <form method="post" class="form-x" action="updateUserServlet">
      <div class="form-group" >
        <div class="label">
          <label for="sitename">用户ID：</label>
        </div>
        <div class="field">
          
           <%
           	String sid = request.getParameter("sid");
        	UserDao sd = new UserDao();
        	UserDto st = sd.findStudentById(sid);
           	
           %>
           
          <input type="text" class="input w50" id="mpass" name="sid" size="50" value="<%=st.getSid() %>" readonly="readonly"/>       
        
          
          
        </div>
      </div>      
      <div class="form-group">
        <div class="label">
          <label for="sitename">用户姓名：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" id="mpass" name="sname" size="50" value="<%=st.getSname() %>" data-validate="required:请输入客户名,length#>=0:客户名不能为空" />       
        </div>
      </div>      
      <div class="form-group">
        <div class="label">
          <label for="sitename">用户密码：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="password" size="50" value="<%=st.getPassword() %>" data-validate="required:请输入客户性别,length#>=0:客户性别不能为空"/>         
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label for="sitename">用户权限：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="superuser" size="50" value="<%=st.getSuperuser() %>" data-validate="required:请输入客户年龄,length#>=0:客户年龄不能为空"/>         
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit"> 提交</button>   
        </div>
      </div>      
    </form>
  </div>
</div>
</body></html>