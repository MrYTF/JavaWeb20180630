<%@page import="cn.edu.lingnan.dao.CostomerDao"%>
<%@page import="cn.edu.lingnan.dto.CostomerDto"%>
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
  <div class="panel-head"><strong><span class="icon-key"></span> 修改客户信息</strong></div>
  <div class="body-content" style="float: 50%">
    <form method="post" class="form-x" action="updateCostomerServlet">
      <div class="form-group" >
        <div class="label">
          <label for="sitename">客户ID：</label>
        </div>
        <div class="field">
          
           <%
	           	String cid = request.getParameter("cid");
	           	CostomerDao cao = new CostomerDao();
	           	CostomerDto cto = cao.findById(cid);
           	
           %>
           
          <input type="text" class="input w50" id="mpass" name="id" size="50" value="<%=cto.getId() %>" readonly="readonly"/>       
        
          
          
        </div>
      </div>      
      <div class="form-group">
        <div class="label">
          <label for="sitename">客户姓名：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" id="mpass" name="name" size="50" value="<%=cto.getName() %>" data-validate="required:请输入客户名,length#>=0:客户名不能为空" />       
        </div>
      </div>      
      <div class="form-group">
        <div class="label">
          <label for="sitename">客户性别：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="sex" size="50" value="<%=cto.getSex() %>" data-validate="required:请输入客户性别,length#>=0:客户性别不能为空"/>         
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label for="sitename">客户年龄：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="age" size="50"  value="<%=cto.getAge() %>" 
          onkeypress="return event.keyCode>=48&&event.keyCode<=57" ng-pattern="/[^a-zA-Z]/" maxlength="3" data-validate="required:请输入客户年龄,length#>=0:客户年龄不能为空"/>         
        </div>
      </div>
      
       <div class="form-group">
        <div class="label">
          <label for="sitename">联系方式：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="telephone" size="50" value="<%=cto.getTelephone() %>"  data-validate="required:请输入联系方式,length#>=6:联系方式不能为空" maxlength="11"/>          
        </div>
      </div>
      
       <div class="form-group">
        <div class="label">
          <label for="sitename">课程记录：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="course" size="50" value="<%=cto.getCourse() %>" data-validate="required:请输入课程记录,length#>=0:课程记录不能为空"/>          
        </div>
      </div>
      
       <div class="form-group">
        <div class="label">
          <label for="sitename">注册登记：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="register" size="50" value="<%=cto.getRegister() %>" readonly="readonly"/>          
        </div>
      </div>
      
       <div class="form-group">
        <div class="label">
          <label for="sitename">客户类型：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="type" size="50" value="<%=cto.getType() %>" data-validate="required:请输入客户类型,length#>=0:客户类型不能为空"/>          
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