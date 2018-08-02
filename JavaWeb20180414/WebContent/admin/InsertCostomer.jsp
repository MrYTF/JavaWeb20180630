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
	                document.all.id.value="�ÿͻ�ID�Ѵ���";
	        }
    	}
    }
}
function agecheck(){
	//var flag = true;
	var regm = /^[0-9]?$/;
	alert(form.age.value);
	if (!form.age.value.match(regm)){
		//alert("�ͻ��������벻��ȷ������������");
		//form.age.focus();
		return false;
	}
}
</script>
</head>
<body>
<div class="panel admin-panel" >
  <div class="panel-head"><strong><span class="icon-key"></span> ��ӿͻ���Ϣ</strong></div>
  <div class="body-content" style="float: 50%">
    <form method="post" class="form-x" action="insertCostomerServlet" name="form">
      <div class="form-group" >
        <div class="label">
          <label for="sitename">�ͻ�ID��</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" id="id" name="id" onBlur="costomerIdCheck()" size="50" placeholder="������ͻ�ID" data-validate="required:������ͻ�ID,length#>=0:�ͻ�ID����Ϊ��"/>       
        </div>
      </div>      
      <div class="form-group">
        <div class="label">
          <label for="sitename">�ͻ�������</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" id="name" name="name" size="50" placeholder="������ͻ���" data-validate="required:������ͻ���,length#>=0:�ͻ�������Ϊ��" />       
        </div>
      </div>      
      <div class="form-group">
        <div class="label">
          <label for="sitename">�ͻ��Ա�</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="sex" size="50" placeholder="������ͻ��Ա�" data-validate="required:������ͻ��Ա�,length#>=0:�ͻ��Ա���Ϊ��"/>         
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label for="sitename">�ͻ����䣺</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" id="age" name="age" size="50" onkeypress="return event.keyCode>=48&&event.keyCode<=57" ng-pattern="/[^a-zA-Z]/" maxlength="3" placeholder="������ͻ�����" data-validate="required:������ͻ�����,length#>=0:�ͻ����䲻��Ϊ��"
           />         
        </div>
      </div>
      
       <div class="form-group">
        <div class="label">
          <label for="sitename">��ϵ��ʽ��</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="telephone" size="50" placeholder="��������ϵ��ʽ" data-validate="required:��������ϵ��ʽ,length#>=6:��ϵ��ʽ��������6λ��" maxlength="11"/>          
        </div>
      </div>
      
       <div class="form-group">
        <div class="label">
          <label for="sitename">�γ̼�¼��</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="course" size="50" placeholder="������γ̼�¼" data-validate="required:������γ̼�¼,length#>=0:�γ̼�¼����Ϊ��"/>          
        </div>
      </div>
      
       <div class="form-group">
        <div class="label">
          <label for="sitename">ע��Ǽǣ�</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="register" size="50" placeholder="������ע��Ǽ�" data-validate="required:������ע��Ǽ�,length#>=0:ע��Ǽǲ���Ϊ��"/>          
        </div>
      </div>
      
       <div class="form-group">
        <div class="label">
          <label for="sitename">�ͻ����ͣ�</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="type" size="50" placeholder="������ͻ�����" data-validate="required:������ͻ�����,length#>=0:�ͻ����Ͳ���Ϊ��"/>          
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