<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>找回密码</title>
<%@ include file="/WEB-INF/views/include/head.jsp"%>
<style type="text/css">
body {
	padding: 0;
	margin: 0;
	font-family: 微软雅黑;
}

#header {
	height: 80px;
	background: #5ECFBA;
}

#header .logo a img {
	margin: 10px 15%;
}

#retrive_content {
	height: 550px;
	margin-bottom: 10px;
}

.nopadding {
	padding: 0;
}

#retrive_title {
	height: 40px;
	background: #f2f2f2;
}

#retrive_title h4 {
	color: #333;
	padding-left: 50px;
}

#retrive_progress {
	height: 50px;
	margin: 10px 0px 10px;
	background: #fafafa;
}

#retrive_ul {
	margin-bottom: 0px;
}

#retrive_ul li {
	text-align: center;
	height: 50px;
	line-height: 44px;
	color: #666;
	font-size: 18px;
	width: calc(100% - 35px);
}

.retrive_span {
	display: inline-block;
	width: 24px;
	height: 24px;
	padding: 5px 5px;
	font-size: 14px;
	font-weight: 700;
	line-height: 1;
	color: #fff;
	text-align: center;
	white-space: nowrap;
	vertical-align: middle;
	background-color: #5ECFBA;
	border-radius: 12px;
	margin-right: 6px;
}

.retrive_arrow {
	position: absolute;
	width: 50px;
	height: 50px;
	top: 0;
	right: -25px;
}

.retrive_arrow * {
	display: block;
	border-width: 25px;
	position: absolute;
	border-style: dashed dashed dashed solid;
	font-size: 0;
	line-height: 0;
}

.retrive_arrow em {
	border-color: transparent transparent transparent #9FDFEF;
	width: 70px;
	height: 70px;
	top: -10px;
	right: -10px;
	border-width: 35px;
}

.retrive_arrow span {
	border-color: transparent transparent transparent #fafafa;
	right: 10px;
}

.over_hidden {
	overflow: hidden;
}

#retrive_form {
	min-height: 480px;
	background: #fafafa;
}

.padding-20px {
	padding: 50px 0px 20px;
}

.retrive_label {
	color: #333;
	font-size: 14px;
	padding-left: 15px;
	font-weight: inherit;
}

.padding-right-none {
	padding-right: 0;
}

.padding-left-none {
	padding-left: 0;
}

.width-10 {
	width: 10%;
}

.nopadding {
	padding-right: 0;
	padding-left: 0;
}

#retrive_li1 {
	background: #ddd;
}

#arrow1 span {
	border-color: transparent transparent transparent #ddd;
}

#footer {
	background: #f2f2f2;
	text-align: center;
	padding-top: 30px;
	height: 74px;
}

.background_f2 {
	background: #f2f2f2;
}

#loginname {
	max-width: 463px;
}

.padding-left-70 {
	padding-left: 70px;
}

.min-width-95 {
	min-width: 95px;
}

.margin-left-25 {
	margin-left: 30%;
}

#retrive_success i {
	top: 3px;
	padding-right: 6px;
}

#retrive_success_title {
	font-size: 20px;
	padding-bottom: 80px;
}

#retrive_success_login a {
	display: block;
	width: 120px;
	height: 34px;
	background: #5BC0DE;
	color: #fff;
	text-align: center;
	line-height: 34px;
}

#retrive_success_login a:hover {
	text-decoration: none;
	background: green;
}

.min-width-100 {
	min-width: 100px;
}
</style>
<script type="text/javascript">
	$(function() {
		$("#code_img,#code_img_btn").click(function() {
			$("#code_img").attr("src", $("#code_img").attr("src") + "?time=" + new Date());
			$.animateIt($("#code_img"), "animated bounceIn");
		})
	})
</script>
</head>
<body>
	<!-- 头部 -->
	<div class="container-fluid nopadding" id="retrive_header">
		<!-- logo -->
		<div id="header" class="row">
			<div class="logo">
				<a href="http://www.zonekey.com.cn/"><img height="70" width="160" class="animated slideInRight" src="${ctx}/static/images/logo.png"></a>
			</div>
		</div>
		<!-- title -->
		<div id="retrive_title" class="row">
			<div class="container">
				<h4>找回密码</h4>
			</div>
		</div>
	</div>
	<div class="container" id="retrive_content">
		<!-- 找回密码进度条 -->
		<div class="row" id="retrive_progress">
			<ul id="retrive_ul" class="list-unstyled">
				<div class="col-sm-4 over_hidden nopadding">
					<li id="retrive_li1"><span class="retrive_span">1</span>确认账号</li>
					<div class="retrive_arrow" id="arrow1">
						<em></em><span></span>
					</div>
				</div>
				<div class="col-sm-4 over_hidden nopadding">
					<li id="retrive_li2"><span class="retrive_span">2</span>安全验证</li>
					<div class="retrive_arrow" id="arrow2">
						<em></em><span></span>
					</div>
				</div>
				<div class="col-sm-4 over_hidden nopadding">
					<li><span class="retrive_span">3</span>重置密码</li>
				</div>
			</ul>
		</div>
		<!-- 找回密码表单 -->
		<div class="row" id="retrive_form">
			<!-- 确认掌火 -->
			<div class="row padding-20px margin-left-25" style="display:block;" id="retrive_form_confirm">
				<from class="form-horizontal" id="form_confirm">
				<div class="form-group">
					<label class="retrive_label">请填写您需要找回的账号:</label>
				</div>
				<div class="form-group">
					<div class="col-sm-6">
						<input type="text" id="loginname" name="loginname" class="form-control" placeholder="请您输入用户名/邮箱/手机号" />
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-3">
						<input type="text" name="code" class="form-control" placeholder="请输入验证码" />
					</div>
					<div class="col-sm-1 width-10 min-width-100 padding-left-none">
						<img id="code_img" class="cursor_pointer" width="80" height="34" src="${ctx}/admin/getCode" alt="验证码" />
					</div>
					<div class="col-sm-2 padding-left-none">
						<button id="code_img_btn" class="btn btn-info">换一张</button>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-3">
						<button class="btn btn-info btn-block">下一步</button>
					</div>
				</div>
				</from>
			</div>
			<!-- 安全验证 -->
			<div class="row padding-20px margin-left-25" id="retrive_form_verify" style="display:none;">
				<form class="form-horizontal" id="form_verify">
					<div class="form-group">
						<label class="retrive_label">为了您的帐号安全，请完成身份验证</label>
					</div>
					<div class="form-group">
						<div class="col-sm-3">
							<label class="control-label">邮箱验证:</label>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-6 padding-left-70">
							<h5>邮箱：1984719960@qq.com</h5>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-3">
							<label class="control-label">验证码:</label>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-3">
							<input type="text" placeholder="验证码" class="form-control" />
						</div>
						<div class="col-sm-2">
							<button class="btn btn-default btn-block min-width-100">发送验证码</button>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-3">
							<button class="btn btn-info btn-block">下一步</button>
						</div>
					</div>
				</form>
			</div>
			<!-- 重置密码-->
			<div class="row padding-20px margin-left-25" id="retrive_form_reset" style="display:none">
				<form class="form-horizontal" id="form_reset">
					<div class="form-group">
						<div class="col-sm-12">您正在找回的账号是:admin</div>
					</div>
					<div class="form-group">
						<div class="col-sm-1 min-width-95">
							<label class="control-label pull-right">新密码:</label>
						</div>
						<div class="col-sm-4">
							<input type="password" name="password" class="form-control" placeholder="新密码" />
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-1 min-width-95">
							<label class="control-label pull-right">确认密码:</label>
						</div>
						<div class="col-sm-4">
							<input type="password" name="repassword" class="form-control" placeholder="与新密码保持一致" />
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-1 min-width-95"></div>
						<div class="col-sm-4">
							<input type="submit" class="btn btn-info btn-block" value="确认" />
						</div>
					</div>
				</form>
			</div>
			<!-- 密码修改成功 -->
			<div class="row padding-20px margin-left-25" id="retrive_success" style="display:none">
				<div id="retrive_success_title">
					<span><i class="glyphicon glyphicon-ok-sign text-success"></i>恭喜您,账号admin重置密码成功</span>
				</div>
				<div id="retrive_success_login">
					<a>直接登录</a>
				</div>
			</div>
		</div>
	</div>
	<!-- 尾部 -->
	<div class="container-fluid nopadding background_f2">
		<div id="footer" class="row">
			<strong><a href="http://www.zonekey.com.cn/" target="_blank">现代中庆</a> Copyright © 1996-2015 </strong>&nbsp;<strong><a href="http://www.zonekey.com.cn/" target="_blank">zonekey.com</a></strong> All
			Rights Reversed. 京ICP备11018032号-8 京公网安备11010802013056
		</div>
	</div>
</body>
</html>