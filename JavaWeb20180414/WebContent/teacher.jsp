<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.* ,cn.edu.lingnan.dto.TeacherDto"%>
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
    		if(confirm("您确定要删除"+arr+"这些记录吗?")){
    			
    			location.href="admin/deleteTeacherCheckServlet?arr="+arr;
    			window.event.returnValue=false;	//解决location.href不跳转的问题
    		}
    		//servlet写法：1.action="?" 2.<a href=?>
    	}else 
    		alert("请选择您要删除的记录");
    }
    function deleteOne(){
    	//alert("bbbbb");

    		if(confirm("您确定要删除这条记录吗?")){
    			
    			return true;
    		}
    		else 
    			return false;
    }
</script> 
</head>
<body>

  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder">教师信息管理</strong></div>
    <div class="padding border-bottom">
    <form method="post" action="findAllTeacher">
      <div style="float: left;">
          <input type="text" name="tid" class="input border-blue" placeholder="请输入教师ID" style="height:40px; width: 110px;display: inline;">
          <button type="submit" class="button border-blue"><span class="icon-check-square-o"></span>提交</button>
         
       </div>
      </form>
      <form method="post" action="">
      <div style="float: right;">
      <c:if test="${superuser==1}">
           <button type="button"  class="button border-green" id="checkall" onClick="allcheck();"><span class="icon-check"></span>全选</button>
          <button type="submit" class="button border-red" onClick="deleteCheck();"><span class="icon-trash-o"></span>批量删除</button>
      </c:if>
        </div>
      </form>
      <div style="clear: none; height: 40px">
      <a href="findA"></a>
      </div>
    </div>
    <table class="table table-hover text-center">
      <tr>
        <th width="120">教师ID</th>
        <th>教师姓名</th>       
        <th>教师性别</th>
        <th>教师年龄</th>
        <th>联系方式</th>
        <c:if test="${superuser==1}">
        <th>操作</th>
        </c:if>      
      </tr>      
 		<%
			
			Vector<TeacherDto> v3=new Vector<TeacherDto>();
 			Object obj = session.getAttribute("allteacher");
 			//System.out.println(obj);
 			if(obj != null){	
			v3 = (Vector)obj;
			if(v3.size() > 0){
			Iterator it1 = v3.iterator();
			TeacherDto tto = null;
			while(it1.hasNext()){
				tto = (TeacherDto)it1.next();	
		%>
			
		<tr>
			<td><c:if test="${superuser==1}"><input type="checkbox" name="id[]" value=<%=tto.getTid() %>></c:if><%=tto.getTid() %></td>
			<td><%=tto.getTname() %></td>
			<td><%=tto.getTsex() %></td>
			<td><%=tto.getTage() %></td>
			<td><%=tto.getCelphone() %></td>
			<c:if test="${superuser==1}">
			<td><div class="button-group"><a class="button border-blue" 
			href="admin/updateTeacher.jsp?tid=<%=tto.getTid() %>" >
			<span class=""></span> 修改</a> <a class="button border-red" 
			href="admin/deleteTeacherServlet?tid=<%=tto.getTid()%>" onclick="return deleteOne()">
			<span class=""></span> 删除</a> </div></td>
			</c:if>
		</tr>
		<% 
			} }else{
				%>
				<tr><td colspan="9">教师信息为空</td></tr>
				<% 
			}
			
 			}else{
				%>
				<tr><td colspan="9">没有该教师</td></tr>
				<% 
			}
		%>

    </table>
    
  </div>

<script type="text/javascript">

function del(id){
	if(confirm("您确定要删除吗?")){
		
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
		var t=confirm("您确认要删除选中的内容吗？");
		if (t==false) return false; 		
	}
	else{
		alert("请选择您要删除的内容!");
		return false;
	}
}

</script>
</body></html>