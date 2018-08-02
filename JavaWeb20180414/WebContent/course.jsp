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
    		if(confirm("您确定要删除"+arr+"这些记录吗?")){
    			
    			location.href="admin/deleteCourseCheckServlet?arr="+arr;
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
    <div class="panel-head"><strong class="icon-reorder">课程信息管理</strong></div>
    <div class="padding border-bottom">
    <form method="post" action="findAllCourse">
      <div style="float: left;">
          <input type="text" name="coid" class="input border-blue" placeholder="请输入课程ID" style="height:40px; width: 110px;display: inline;">
          <button type="submit" class="button border-blue"><span class="icon-check-square-o"></span>提交</button>         
       </div>
      </form>
      <form method="post" action="">
      <c:if test="${superuser==1}">
      <div style="float: right;">
           <button type="button"  class="button border-green" id="checkall" onClick="allcheck();"><span class="icon-check"></span>全选</button>
          <button type="submit" class="button border-red" onClick="deleteCheck();"><span class="icon-trash-o"></span>批量删除</button>
        </div>
        </c:if>
      </form>
      <div style="clear: none; height: 40px">
      <a href="findA"></a>
      </div>
    </div>
    <table class="table table-hover text-center">
      <tr>
        <th width="120">课程ID</th>
        <th>课程名称</th>       
        <th width="25%">课程时间</th>
        <th>课程地点</th>
        <th>课程价格</th>
        <th>教师姓名</th>
        <th>课程类型</th> 
        <c:if test="${superuser==1}">
        <th>操作</th> 
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
			<span class=""></span> 修改</a> <a class="button border-red" 
			href="admin/deleteCourseServlet?coid=<%=cor.getCid()%>" onclick="return deleteOne()">
			<span class=""></span> 删除</a> </div></td></c:if>
		</tr>
		<% 
			} }else{
				%>
				<tr><td colspan="9">课程信息为空</td></tr>
				<% 
			}
			
 			}else{
				%>
				<tr><td colspan="9">没有该课程</td></tr>
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