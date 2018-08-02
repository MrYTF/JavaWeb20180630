<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.* ,cn.edu.lingnan.dto.CostomerDto"%>
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
    			
    			location.href="deleteCostomerCheckServlet?arr="+arr;
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
    <div class="panel-head"><strong class="icon-reorder">�ͻ���Ϣ����</strong></div>
    <div class="padding border-bottom">
    <form method="post" action="findAllCostomer">
      <div style="float: left;">
          <input type="text" name="cid" class="input border-blue" placeholder="������ͻ�ID" style="height:40px; width: 110px;display: inline;">
          <button type="submit" class="button border-blue"><span class="icon-check-square-o"></span>�ύ</button>
         
       </div>
      </form>
      <form method="post" action="">
      <div style="float: right;">
           <button type="button"  class="button border-green" id="checkall" onClick="allcheck();"><span class="icon-check"></span>ȫѡ</button>
          <button type="submit" class="button border-red" onClick="deleteCheck();"><span class="icon-trash-o"></span>����ɾ��</button>
        </div>
      </form>
      <div style="clear: none; height: 40px">
      <a href="findA"></a>
      </div>
    </div>
    <table class="table table-hover text-center">
      <tr>
        <th width="120">�ͻ�ID</th>
        <th>�ͻ�����</th>       
        <th>�ͻ��Ա�</th>
        <th>�ͻ�����</th>
        <th>��ϵ��ʽ</th>
        <th>�γ̼�¼</th>
         <th>ע��Ǽ�</th>
        <th>�ͻ�����</th>  
        <th>����</th> 
             
      </tr>      
 		<%
			
			Vector<CostomerDto> v1=new Vector<CostomerDto>();
 			Object obj = session.getAttribute("allcostomer");
 			//System.out.println(obj);
 			if(obj != null){	
			v1 = (Vector)obj;
			if(v1.size() > 0){
			Iterator it1 = v1.iterator();
			CostomerDto c = null;
			while(it1.hasNext()){
				c = (CostomerDto)it1.next();	
		%>
			
		<tr>
			<td><input type="checkbox" name="id[]" value=<%=c.getId() %>><%=c.getId() %></td>
			<td><%=c.getName() %></td>
			<td><%=c.getSex() %></td>
			<td><%=c.getAge() %></td>
			<td><%=c.getTelephone() %></td>
			<td><%=c.getCourse() %></td>
			<td><%=c.getRegister() %></td>
			<td><%=c.getType() %></td>	
			<td><div class="button-group"><a class="button border-blue" 
			href="updateCostomer.jsp?cid=<%=c.getId() %>" >
			<span class=""></span> �޸�</a> <a class="button border-red" 
			href="deleteCostomerServlet?cid=<%=c.getId()%>" onclick="return deleteOne()">
			<span class=""></span> ɾ��</a> </div></td>
		</tr>
		<% 
			} }else{
				%>
				<tr><td colspan="9">�ͻ���ϢΪ��</td></tr>
				<% 
			}
			
 			}else{
				%>
				<tr><td colspan="9">û�иÿͻ�</td></tr>
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