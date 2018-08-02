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
	                document.all.cid.value="�ÿγ�ID�Ѵ���";
	        }
    	}
    }
}
</script>
</head>
<body>
<div class="panel admin-panel" >
  <div class="panel-head"><strong><span class="icon-key"></span> ��ӿγ���Ϣ</strong></div>
  <div class="body-content" style="float: 50%">
    <form method="post" class="form-x" action="insertCourseServlet">
      <div class="form-group" >
        <div class="label">
          <label for="sitename">�γ�ID��</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" id="cid" name="cid" onBlur="courseIdCheck()" size="50" placeholder="������γ�ID" data-validate="required:������γ�ID,length#>=0:�γ�ID����Ϊ��"/>       
        </div>
      </div>      
      <div class="form-group">
        <div class="label">
          <label for="sitename">�γ����ƣ�</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" id="cname" name="cname" size="50" placeholder="������γ�����" data-validate="required:������γ�����,length#>=0:�γ����Ʋ���Ϊ��" />       
        </div>
      </div>      
      <div class="form-group">
        <div class="label">
          <label for="sitename">�γ�ʱ�䣺</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="time" size="50" placeholder="������γ�ʱ��" data-validate="required:������γ�ʱ��,length#>=0:�γ�ʱ�䲻��Ϊ��"/>         
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label for="sitename">�γ̵ص㣺</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="site" size="50" placeholder="������γ̵ص�" data-validate="required:������γ̵ص�,length#>=0:�γ̵ص㲻��Ϊ��"/>         
        </div>
      </div>
      
       <div class="form-group">
        <div class="label">
          <label for="sitename">�γ̼۸�</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="price" size="50" placeholder="������γ̼۸�" data-validate="required:������γ̼۸�,length#>=0:�γ̼۸���Ϊ��"/>          
        </div>
      </div>
      
       <div class="form-group">
        <div class="label">
          <label for="sitename">��ʦ������</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="lecturer" size="50" placeholder="�������ʦ����" data-validate="required:�������ʦ����,length#>=0:��ʦ��������Ϊ��"/>          
        </div>
      </div>
      
       <div class="form-group">
        <div class="label">
          <label for="sitename">�γ����ͣ�</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="ctype" size="50" placeholder="������γ�����" data-validate="required:������γ�����,length#>=0:�γ����Ͳ���Ϊ��"/>          
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