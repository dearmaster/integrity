<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String ctx = request.getContextPath();
	String username = (String) request.getSession().getAttribute("user_in_session") == null ? "" : (String) request.getSession().getAttribute("user_in_session");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎来到xxx系统</title>
<link rel="stylesheet" type="text/css" href="<%= ctx%>/css/common.css">
<script type="text/javascript" src="<%= ctx%>/js/jquery-2.1.1.js"></script>
<script type="text/javascript" src="<%= ctx%>/js/user_js.js"></script>
</head>
<body class="bg-body">

	<div id="indexMain" class="bg-body-green">
		<div class="bg-body-white">

			<div id="headerContainer">
				<jsp:include page="WEB-INF/common/header.jsp" flush="true" />
			</div>

			<div id="indexDiv">
				<jsp:include page="WEB-INF/module/home.jsp" flush="true" />
				<jsp:include page="WEB-INF/module/business.jsp" flush="true" />
				<jsp:include page="WEB-INF/module/usermgr.jsp" flush="true" />
				<jsp:include page="WEB-INF/module/reportmgr.jsp" flush="true" />
				<jsp:include page="WEB-INF/module/filemgr.jsp" flush="true" />
				<jsp:include page="WEB-INF/module/contactus.jsp" flush="true" />
			</div>

			<div id="footerContainer">
				<jsp:include page="WEB-INF/common/footer.jsp" flush="true" />
			</div>

		</div>
	</div>


<script type="text/javascript">
	$(function() {
		Tea.Modules.Render.initIndexPage('<%= username%>');
	});
</script>	

</body>
</html>