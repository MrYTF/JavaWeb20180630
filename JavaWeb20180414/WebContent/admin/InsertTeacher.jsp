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
function teacherIdCheck(){
    var request = createXmlHttpRequest();
    //alert("aaa111");
    var tid = document.all.tid.value;
    request.open("post","teacherIdCheckServlet?tid="+tid);
    request.send();
    //alert("aaa222");
    request.onreadystatechange = function(){
	if(request.readyState==4){
	        var value = request.responseText;
	        if(value=="true"){
	                document.all.tid.value="该教师ID已存在";
	        }
    	}
    }
}
</script>
</head>
<body>
<div class="panel admin-panel" >
  <div class="panel-head"><strong><span class="icon-key"></span> 添加教师信息</strong></div>
  <div class="body-content" style="float: 50%">
    <form method="post" class="form-x" action="insertTeacherServlet">
      <div class="form-group" >
        <div class="label">
          <label for="sitename">教师ID：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" id="tid" name="tid" onBlur="teacherIdCheck()" size="50" placeholder="请输入教师ID" data-validate="required:请输入教师ID,length#>=0:教师ID不能为空"/>       
        </div>
      </div>      
      <div class="form-group">
        <div class="label">
          <label for="sitename">教师姓名：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" id="tname" name="tname" size="50" placeholder="请输入教师名" data-validate="required:请输入教师名,length#>=0:教师名不能为空" />       
        </div>
      </div>      
      <div class="form-group">
        <div class="label">
          <label for="sitename">教师性别：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="tsex" size="50" placeholder="请输入教师性别" data-validate="required:请输入教师性别,length#>=0:教师性别不能为空"/>         
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label for="sitename">教师年龄：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="tage" size="50" placeholder="请输入教师年龄" 
			onkeypress="return event.keyCode>=48&&event.keyCode<=57" ng-pattern="/[^a-zA-Z]/" maxlength="3" data-validate="required:请输入教师年龄,length#>=0:教师年龄不能为空"/>         
        </div>
      </div>
      
       <div class="form-group">
        <div class="label">
          <label for="sitename">联系方式：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="celphone" size="50" placeholder="请输入联系方式" data-validate="required:请输入联系方式,length#>=6:联系方式不能少于6位数" maxlength="11"/>          
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