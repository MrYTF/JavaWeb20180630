<%@page import="cn.edu.lingnan.dao.TeacherDao"%>
<%@page import="cn.edu.lingnan.dto.TeacherDto"%>
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
  <div class="panel-head"><strong><span class="icon-key"></span> 修改教师信息</strong></div>
  <div class="body-content" style="float: 50%">
    <form method="post" class="form-x" action="updateTeacherServlet">
      <div class="form-group" >
        <div class="label">
          <label for="sitename">教师ID：</label>
        </div>
        <div class="field">
          
           <%
           	String tid = request.getParameter("tid");
        	//System.out.println("tid---" + tid);
           	TeacherDao tao = new TeacherDao();
        	TeacherDto tto = tao.findByTid(tid);
           	//System.out.println(tto);
           %>
           
          <input type="text" class="input w50" id="tid" name="tid" size="50" value="<%=tto.getTid() %>" readonly="readonly"/>       
        
          
          
        </div>
      </div>      
      <div class="form-group">
        <div class="label">
          <label for="sitename">教师姓名：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" id="mpass" name="tname" size="50" value="<%=tto.getTname() %>" data-validate="required:请输入教师名,length#>=0:教师名不能为空" />       
        </div>
      </div>      
      <div class="form-group">
        <div class="label">
          <label for="sitename">教师性别：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="tsex" size="50" value="<%=tto.getTsex() %>" data-validate="required:请输入教师性别,length#>=0:教师性别不能为空"/>         
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label for="sitename">教师年龄：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="tage" size="50" value="<%=tto.getTage() %>" 
          onkeypress="return event.keyCode>=48&&event.keyCode<=57" ng-pattern="/[^a-zA-Z]/" maxlength="3" data-validate="required:请输入教师年龄,length#>=0:教师年龄不能为空"/>         
        </div>
      </div>
      
       <div class="form-group">
        <div class="label">
          <label for="sitename">联系方式：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="celphone" size="50" value="<%=tto.getCelphone() %>" data-validate="required:请输入联系方式,length#>=0:联系方式不能为空" maxlength="11"/>          
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