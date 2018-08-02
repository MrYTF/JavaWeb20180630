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
function courseIdCheck(){
    var request = createXmlHttpRequest();
    //alert("aaa111");
    var cid = document.all.cid.value;
    request.open("post","courseIdCheckServlet?cid="+cid);
    request.send();
    //alert("aaa222");
    request.onreadystatechange = function(){
	if(request.readyState==4){
	        var value = request.responseText;
	        if(value=="true"){
	                document.all.cid.value="该课程ID已存在";
	        }
    	}
    }
}
</script>
</head>
<body>
<div class="panel admin-panel" >
  <div class="panel-head"><strong><span class="icon-key"></span> 添加课程信息</strong></div>
  <div class="body-content" style="float: 50%">
    <form method="post" class="form-x" action="insertCourseServlet">
      <div class="form-group" >
        <div class="label">
          <label for="sitename">课程ID：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" id="cid" name="cid" onBlur="courseIdCheck()" size="50" placeholder="请输入课程ID" data-validate="required:请输入课程ID,length#>=0:课程ID不能为空"/>       
        </div>
      </div>      
      <div class="form-group">
        <div class="label">
          <label for="sitename">课程名称：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" id="cname" name="cname" size="50" placeholder="请输入课程名称" data-validate="required:请输入课程名称,length#>=0:课程名称不能为空" />       
        </div>
      </div>      
      <div class="form-group">
        <div class="label">
          <label for="sitename">课程时间：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="time" size="50" placeholder="请输入课程时间" data-validate="required:请输入课程时间,length#>=0:课程时间不能为空"/>         
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label for="sitename">课程地点：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="site" size="50" placeholder="请输入课程地点" data-validate="required:请输入课程地点,length#>=0:课程地点不能为空"/>         
        </div>
      </div>
      
       <div class="form-group">
        <div class="label">
          <label for="sitename">课程价格：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="price" size="50" placeholder="请输入课程价格" data-validate="required:请输入课程价格,length#>=0:课程价格不能为空"/>          
        </div>
      </div>
      
       <div class="form-group">
        <div class="label">
          <label for="sitename">教师姓名：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="lecturer" size="50" placeholder="请输入教师姓名" data-validate="required:请输入教师姓名,length#>=0:教师姓名不能为空"/>          
        </div>
      </div>
      
       <div class="form-group">
        <div class="label">
          <label for="sitename">课程类型：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="ctype" size="50" placeholder="请输入课程类型" data-validate="required:请输入课程类型,length#>=0:课程类型不能为空"/>          
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