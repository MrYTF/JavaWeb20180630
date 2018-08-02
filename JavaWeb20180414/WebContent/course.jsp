<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.* ,cn.edu.lingnan.dto.CourseDto"%>
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
 
<script>
    function allcheck(){
    	var checkobj = document.getElementsByName("check");
    	for(var i=0;i<checkobj.length;i++)
 			checkobj[i].checked = true;
    }
    function deleteCheck(){
    	//alert("bbbbb");
    	var checkobj = document.getElementsByName("id[]");
    	var arr = [];
    	var flag = false;
    	for(var i=0;i<checkobj.length;i++){
    		if(checkobj[i].checked == true){
    			arr.push(checkobj[i].value);
    			flag = true;
    		}
    	}
    	//alert(arr);
    	if(flag==true){
    		if(confirm("��ȷ��Ҫɾ��"+arr+"��Щ��¼��?")){
    			
    			location.href="admin/deleteCourseCheckServlet?arr="+arr;
    			window.event.returnValue=false;	//���location.href����ת������
    		}
    		//servletд����1.action="?" 2.<a href=?>
    	}else 
    		alert("��ѡ����Ҫɾ���ļ�¼");
    }
    function deleteOne(){
    	//alert("bbbbb");

    		if(confirm("��ȷ��Ҫɾ��������¼��?")){
    			
    			return true;
    		}
    		else 
    			return false;
    }
</script> 
</head>
<body>

  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder">�γ���Ϣ����</strong></div>
    <div class="padding border-bottom">
    <form method="post" action="findAllCourse">
      <div style="float: left;">
          <input type="text" name="coid" class="input border-blue" placeholder="������γ�ID" style="height:40px; width: 110px;display: inline;">
          <button type="submit" class="button border-blue"><span class="icon-check-square-o"></span>�ύ</button>         
       </div>
      </form>
      <form method="post" action="">
      <c:if test="${superuser==1}">
      <div style="float: right;">
           <button type="button"  class="button border-green" id="checkall" onClick="allcheck();"><span class="icon-check"></span>ȫѡ</button>
          <button type="submit" class="button border-red" onClick="deleteCheck();"><span class="icon-trash-o"></span>����ɾ��</button>
        </div>
        </c:if>
      </form>
      <div style="clear: none; height: 40px">
      <a href="findA"></a>
      </div>
    </div>
    <table class="table table-hover text-center">
      <tr>
        <th width="120">�γ�ID</th>
        <th>�γ�����</th>       
        <th width="25%">�γ�ʱ��</th>
        <th>�γ̵ص�</th>
        <th>�γ̼۸�</th>
        <th>��ʦ����</th>
        <th>�γ�����</th> 
        <c:if test="${superuser==1}">
        <th>����</th> 
        </c:if>     
      </tr>      
 		<%
			
			Vector<CourseDto> v=new Vector<CourseDto>();
 			Object obj = session.getAttribute("allcourse");
 			System.out.println(obj);
 			if(obj != null){	
			v = (Vector)obj;
			if(v.size() > 0){
			Iterator it2 = v.iterator();
			CourseDto cor = null;
			while(it2.hasNext()){
				cor = (CourseDto)it2.next();
				
				
		%>
			
		<tr>
			<td><c:if test="${superuser==1}"><input type="checkbox" name="id[]" value=<%=cor.getCid() %>></c:if><%=cor.getCid() %></td>
			<td><%=cor.getCname() %></td>
			<td><%=cor.getTime() %></td>
			<td><%=cor.getSite() %></td>
			<td><%=cor.getPrice() %></td>
			<td><%=cor.getLecturer() %></td>
			<td><%=cor.getCtype() %></td>
			<c:if test="${superuser==1}">
			<td><div class="button-group"><a class="button border-blue" 
			href="admin/updateCourse.jsp?cid=<%=cor.getCid() %>" >
			<span class=""></span> �޸�</a> <a class="button border-red" 
			href="admin/deleteCourseServlet?coid=<%=cor.getCid()%>" onclick="return deleteOne()">
			<span class=""></span> ɾ��</a> </div></td></c:if>
		</tr>
		<% 
			} }else{
				%>
				<tr><td colspan="9">�γ���ϢΪ��</td></tr>
				<% 
			}
			
 			}else{
				%>
				<tr><td colspan="9">û�иÿγ�</td></tr>
				<% 
			}
		%>

    </table>
    
  </div>

<script type="text/javascript">

function del(id){
	if(confirm("��ȷ��Ҫɾ����?")){
		
	}
}

$("#checkall").click(function(){ 
  $("input[name='id[]']").each(function(){
	  if (this.checked) {
		  this.checked = false;
	  }
	  else {
		  this.checked = true;
	  }
  });
})

function DelSelect(){
	var Checkbox=false;
	 $("input[name='id[]']").each(function(){
	  if (this.checked==true) {		
		Checkbox=true;	
	  }
	});
	if (Checkbox){
		var t=confirm("��ȷ��Ҫɾ��ѡ�е�������");
		if (t==false) return false; 		
	}
	else{
		alert("��ѡ����Ҫɾ��������!");
		return false;
	}
}

</script>
</body></html>