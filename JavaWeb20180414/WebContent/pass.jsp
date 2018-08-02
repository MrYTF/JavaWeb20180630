<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="cn.edu.lingnan.dao.UserDao, cn.edu.lingnan.dto.UserDto"%>
<%@ taglib prefix="aa" uri="/testtags" %>
<%@ taglib prefix="c" uri="/jstlc" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head"><strong><span class="icon-key"></span> �޸��˻�����</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="updatePassServlet">
      <div class="form-group">
        <div class="label">
          <label for="sitename">����Ա�ʺ�����</label>
        </div>
        <div class="field">
          <label style="line-height:33px;">
          <c:out value="${username}" />
          </label>
        </div>
      </div>      
      <div class="form-group">
        <div class="label">
          <label for="sitename">ԭʼ���룺</label>
        </div>
        <div class="field">
          <input type="password" class="input w50" id="mpass" name="oldpass" size="50" placeholder="������ԭʼ����" data-validate="required:������ԭʼ����" />
          
             
        </div>
        
      </div>      
      <div class="form-group">
        <div class="label">
          <label for="sitename">�����룺</label>
        </div>
        <div class="field">
          <input type="password" class="input w50" name="newpass" size="50" placeholder="������������" data-validate="required:������������,length#>=5:�����벻��С��5λ" />         
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label for="sitename">ȷ�������룺</label>
        </div>
        <div class="field">
          <input type="password" class="input w50" name="renewpass" size="50" placeholder="���ٴ�����������" data-validate="required:���ٴ�����������,repeat#newpass:������������벻һ��" />          
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