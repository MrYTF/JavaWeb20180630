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
  <div class="panel-head"><strong><span class="icon-key"></span> �޸Ŀͻ���Ϣ</strong></div>
  <div class="body-content" style="float: 50%">
    <form method="post" class="form-x" action="updateCostomerServlet">
      <div class="form-group" >
        <div class="label">
          <label for="sitename">�ͻ�ID��</label>
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
          <label for="sitename">�ͻ�������</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" id="mpass" name="name" size="50" value="<%=cto.getName() %>" data-validate="required:������ͻ���,length#>=0:�ͻ�������Ϊ��" />       
        </div>
      </div>      
      <div class="form-group">
        <div class="label">
          <label for="sitename">�ͻ��Ա�</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="sex" size="50" value="<%=cto.getSex() %>" data-validate="required:������ͻ��Ա�,length#>=0:�ͻ��Ա���Ϊ��"/>         
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label for="sitename">�ͻ����䣺</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="age" size="50"  value="<%=cto.getAge() %>" 
          onkeypress="return event.keyCode>=48&&event.keyCode<=57" ng-pattern="/[^a-zA-Z]/" maxlength="3" data-validate="required:������ͻ�����,length#>=0:�ͻ����䲻��Ϊ��"/>         
        </div>
      </div>
      
       <div class="form-group">
        <div class="label">
          <label for="sitename">��ϵ��ʽ��</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="telephone" size="50" value="<%=cto.getTelephone() %>"  data-validate="required:��������ϵ��ʽ,length#>=6:��ϵ��ʽ����Ϊ��" maxlength="11"/>          
        </div>
      </div>
      
       <div class="form-group">
        <div class="label">
          <label for="sitename">�γ̼�¼��</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="course" size="50" value="<%=cto.getCourse() %>" data-validate="required:������γ̼�¼,length#>=0:�γ̼�¼����Ϊ��"/>          
        </div>
      </div>
      
       <div class="form-group">
        <div class="label">
          <label for="sitename">ע��Ǽǣ�</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="register" size="50" value="<%=cto.getRegister() %>" readonly="readonly"/>          
        </div>
      </div>
      
       <div class="form-group">
        <div class="label">
          <label for="sitename">�ͻ����ͣ�</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="type" size="50" value="<%=cto.getType() %>" data-validate="required:������ͻ�����,length#>=0:�ͻ����Ͳ���Ϊ��"/>          
        </div>
      </div>
      
      
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit"> �ύ</button>   
        </div>
      </div>      
    </form>
  </div>
</div>
</body></html>