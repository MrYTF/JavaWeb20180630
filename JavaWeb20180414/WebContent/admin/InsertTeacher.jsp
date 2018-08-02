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
	                document.all.tid.value="�ý�ʦID�Ѵ���";
	        }
    	}
    }
}
</script>
</head>
<body>
<div class="panel admin-panel" >
  <div class="panel-head"><strong><span class="icon-key"></span> ��ӽ�ʦ��Ϣ</strong></div>
  <div class="body-content" style="float: 50%">
    <form method="post" class="form-x" action="insertTeacherServlet">
      <div class="form-group" >
        <div class="label">
          <label for="sitename">��ʦID��</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" id="tid" name="tid" onBlur="teacherIdCheck()" size="50" placeholder="�������ʦID" data-validate="required:�������ʦID,length#>=0:��ʦID����Ϊ��"/>       
        </div>
      </div>      
      <div class="form-group">
        <div class="label">
          <label for="sitename">��ʦ������</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" id="tname" name="tname" size="50" placeholder="�������ʦ��" data-validate="required:�������ʦ��,length#>=0:��ʦ������Ϊ��" />       
        </div>
      </div>      
      <div class="form-group">
        <div class="label">
          <label for="sitename">��ʦ�Ա�</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="tsex" size="50" placeholder="�������ʦ�Ա�" data-validate="required:�������ʦ�Ա�,length#>=0:��ʦ�Ա���Ϊ��"/>         
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label for="sitename">��ʦ���䣺</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="tage" size="50" placeholder="�������ʦ����" 
			onkeypress="return event.keyCode>=48&&event.keyCode<=57" ng-pattern="/[^a-zA-Z]/" maxlength="3" data-validate="required:�������ʦ����,length#>=0:��ʦ���䲻��Ϊ��"/>         
        </div>
      </div>
      
       <div class="form-group">
        <div class="label">
          <label for="sitename">��ϵ��ʽ��</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="celphone" size="50" placeholder="��������ϵ��ʽ" data-validate="required:��������ϵ��ʽ,length#>=6:��ϵ��ʽ��������6λ��" maxlength="11"/>          
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