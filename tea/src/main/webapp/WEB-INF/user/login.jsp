<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%
	String ctx = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome to the login page</title>
<script type="text/javascript" src="<%= ctx%>/js/jquery-2.1.1.js"></script>
<link rel="stylesheet" type="text/css" href="<%= ctx%>/css/common.css">
<style type="text/css">
<!--

#__01 {
	position:absolute;
/* 	left:0px;
	top:0px; */
	margin-left: 22px;
	width:854px;
	height:530px;
}

#login-01 {
	position:absolute;
	left:0px;
	top:0px;
	width:854px;
	height:159px;
}

#login-02 {
	position:absolute;
	left:0px;
	top:159px;
	width:369px;
	height:151px;
}

#login-03 {
	position:absolute;
	left:369px;
	top:159px;
	width:154px;
	height:27px;
}

#login-04 {
	position:absolute;
	left:523px;
	top:159px;
	width:331px;
	height:371px;
}

#login-05 {
	position:absolute;
	left:369px;
	top:186px;
	width:154px;
	height:25px;
}

#login-06 {
	position:absolute;
	left:369px;
	top:211px;
	width:9px;
	height:99px;
}

#login-07 {
	position:absolute;
	left:378px;
	top:211px;
	width:131px;
	height:63px;
}

#login-08 {
	position:absolute;
	left:509px;
	top:211px;
	width:14px;
	height:99px;
}

#login-09 {
	position:absolute;
	left:378px;
	top:274px;
	width:131px;
	height:36px;
}

#login-10 {
	position:absolute;
	left:0px;
	top:310px;
	width:351px;
	height:220px;
}

#login-11 {
	position:absolute;
	left:351px;
	top:310px;
	width:172px;
	height:69px;
}

#login-12 {
	position:absolute;
	left:351px;
	top:379px;
	width:172px;
	height:18px;
}

#login-13 {
	position:absolute;
	left:351px;
	top:397px;
	width:32px;
	height:133px;
}

#login-14 {
	position:absolute;
	left:383px;
	top:397px;
	width:47px;
	height:33px;
}

#login-15 {
	position:absolute;
	left:430px;
	top:397px;
	width:45px;
	height:33px;
}

#login-16 {
	position:absolute;
	left:475px;
	top:397px;
	width:48px;
	height:133px;
}

#login-17 {
	position:absolute;
	left:383px;
	top:430px;
	width:92px;
	height:100px;
}

-->
</style>
<!-- End Save for Web Styles -->
</head>
<body class="bg-body">

	<div id="loginMain" class="bg-body-green">
		<div class="bg-body-white">

			<div id="headerContainer">
				<jsp:include page="../common/header.jsp" flush="true" />
			</div>

			<div id="loginDiv">
				<form action="<%=ctx%>/user/login" method="post">
					<div id="__01">
						<div id="login-01">
							<img src="../images/login/login_01.gif" width="854" height="159" alt="">
						</div>
						<div id="login-02">
							<img src="../images/login/login_02.gif" width="369" height="151" alt="">
						</div>
						<div id="login-03" style="background: url(../images/login/login_03.gif) no-repeat; color: white; font-size: 20px;">
							欢 迎 登 录
						</div>
						<div id="login-04">
							<img src="../images/login/login_04.gif" width="331" height="371" alt="">
						</div>
						<div id="login-05">
							<img src="../images/login/login_05.gif" width="154" height="25" alt="">
						</div>
						<div id="login-06">
							<img src="../images/login/login_06.gif" width="9" height="99" alt="">
						</div>
						<div id="login-07">
							<img src="../images/login/login_07.gif" width="131" height="63" alt="">
						</div>
						<div id="login-08">
							<img src="../images/login/login_08.gif" width="14" height="99" alt="">
						</div>
						<div id="login-09">
							<img src="../images/login/login_09.gif" width="131" height="36" alt="">
						</div>
						<div id="login-10">
							<img src="../images/login/login_10.gif" width="351" height="220" alt="">
						</div>
						<div id="login-11" style="background: url(../images/login/login_11.gif) no-repeat; color: white; font-size: 14px;">
							用户名
							<input type="text" name="username" style="width: 110px; margin-bottom: 5px;">
							密&emsp;码
							<input type="password" name="password" style="width: 110px;">
							<!-- <img src="../images/login/login_11.gif" width="172" height="69" alt=""> -->
						</div>
						<div id="login-12">
							<img src="../images/login/login_12.gif" width="172" height="18" alt="">
						</div>
						<div id="login-13">
							<img src="../images/login/login_13.gif" width="32" height="133" alt="">
						</div>
						<div id="login-14">
							<input type="submit" value="" style="background: url(../images/login/login_14.gif); width: 100%; height: 100%;">
							<!-- <img src="../images/login/login_14.gif" width="47" height="33" alt=""> -->
						</div>
						<div id="login-15">
							<input type="reset" value="" style="background: url(../images/login/login_15.gif); width: 100%; height: 100%;">
							<!-- <img src="../images/login/login_15.gif" width="45" height="33" alt=""> -->
						</div>
						<div id="login-16">
							<img src="../images/login/login_16.gif" width="48" height="133" alt="">
						</div>
						<div id="login-17">
							<img src="../images/login/login_17.gif" width="92" height="100" alt="">
						</div>
					</div>	
				</form>		
			</div>

<%-- 			<div id="footerContainer">
				<jsp:include page="../common/footer.jsp" flush="true" />
			</div> --%>

		</div>
	</div>

<script type="text/javascript">
	$(function() {
		Tea.Modules.Render.initLoginPage();
	});
</script>	

</body>

</html>