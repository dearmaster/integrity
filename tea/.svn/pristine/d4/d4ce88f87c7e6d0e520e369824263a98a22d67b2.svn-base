<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String ctx = request.getContextPath();
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>This is header page</title>
<script type="text/javascript" src="<%= ctx%>/js/jquery-2.1.1.js"></script>
<script type="text/javascript" src="<%= ctx%>/js/user_js.js"></script>
<script type="text/javascript">
if(window.Tea == undefined)
	Tea = {}
Tea.ctx = '<%= ctx%>';
</script>
</head>
<body>
	<div id="headMain">
	
		<div id="welcome">
		</div>
		
		<div id="logo">
		</div>
		
		<div id="tabs">
			<ul>
				<li id="navTabHome"><a href="javascript:;">首页</a></li>
				<li id="navTabBusiness"><a href="javascript:;">业务功能</a></li>
				<li id="navTabUser"><a href="javascript:;">用户功能</a></li>
				<li id="navTabReport"><a href="javascript:;">报表管理</a></li>
				<li id="navTabFile"><a href="javascript:;">文件管理</a></li>
				<li id="navTabContact"><a href="javascript:;">联系我们</a></li>
			</ul>
		</div>
		
	</div>

<script type="text/javascript">
	$(function() {
		Tea.Modules.Render.initHeader();
	});
</script>	

</body>
</html>