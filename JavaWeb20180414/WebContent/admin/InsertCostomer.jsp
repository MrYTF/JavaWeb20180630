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
<script type="text/javascript">
function createXmlHttpRequest(){
    var xmlreq = false;
    if (window.XMLHttpRequest){
        xmlreq = new XMLHttpRequest();
    }else
        if (window.ActiveXObject){
    	try{
    	    xmlreq = new ActiveXObject("Msxml2.XMLHTTP");
    	}catch(e1){
    	    try{
    	        xmlreq = new ActiveXObject("Microsoft.XMLHTTP");
    	    }catch(e2){
    	    }
    	}
    }
    return xmlreq;   	
}
function costomerIdCheck(){
    var request = createXmlHttpRequest();
    //alert("aaa111");
    var id = document.all.id.value;
    request.open("post","idCheckServlet?id="+id);
    request.send();
    //alert("aaa222");
    request.onreadystatechange = function(){
	if(request.readyState==4){
	        var value = request.responseText;
	        if(value=="true"){
	                document.all.id.value="该客户ID已存在";
	        }
    	}
    }
}
function agecheck(){
	//var flag = true;
	var regm = /^[0-9]?$/;
	alert(form.age.value);
	if (!form.age.value.match(regm)){
		//alert("客户年龄输入不正确，请输入数字");
		//form.age.focus();
		return false;
	}
}
</script>
</head>
<body>
<div class="panel admin-panel" >
  <div class="panel-head"><strong><span class="icon-key"></span> 添加客户信息</strong></div>
  <div class="body-content" style="float: 50%">
    <form method="post" class="form-x" action="insertCostomerServlet" name="form">
      <div class="form-group" >
        <div class="label">
          <label for="sitename">客户ID：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" id="id" name="id" onBlur="costomerIdCheck()" size="50" placeholder="请输入客户ID" data-validate="required:请输入客户ID,length#>=0:客户ID不能为空"/>       
        </div>
      </div>      
      <div class="form-group">
        <div class="label">
          <label for="sitename">客户姓名：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" id="name" name="name" size="50" placeholder="请输入客户名" data-validate="required:请输入客户名,length#>=0:客户名不能为空" />       
        </div>
      </div>      
      <div class="form-group">
        <div class="label">
          <label for="sitename">客户性别：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="sex" size="50" placeholder="请输入客户性别" data-validate="required:请输入客户性别,length#>=0:客户性别不能为空"/>         
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label for="sitename">客户年龄：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" id="age" name="age" size="50" onkeypress="return event.keyCode>=48&&event.keyCode<=57" ng-pattern="/[^a-zA-Z]/" maxlength="3" placeholder="请输入客户年龄" data-validate="required:请输入客户年龄,length#>=0:客户年龄不能为空"
           />         
        </div>
      </div>
      
       <div class="form-group">
        <div class="label">
          <label for="sitename">联系方式：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="telephone" size="50" placeholder="请输入联系方式" data-validate="required:请输入联系方式,length#>=6:联系方式不能少于6位数" maxlength="11"/>          
        </div>
      </div>
      
       <div class="form-group">
        <div class="label">
          <label for="sitename">课程记录：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="course" size="50" placeholder="请输入课程记录" data-validate="required:请输入课程记录,length#>=0:课程记录不能为空"/>          
        </div>
      </div>
      
       <div class="form-group">
        <div class="label">
          <label for="sitename">注册登记：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="register" size="50" placeholder="请输入注册登记" data-validate="required:请输入注册登记,length#>=0:注册登记不能为空"/>          
        </div>
      </div>
      
       <div class="form-group">
        <div class="label">
          <label for="sitename">客户类型：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="type" size="50" placeholder="请输入客户类型" data-validate="required:请输入客户类型,length#>=0:客户类型不能为空"/>          
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