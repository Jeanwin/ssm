<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册页面</title>
<%@ include file="/WEB-INF/views/include/head.jsp"%>
<style type="text/css">
body {
	margin: 0;
	padding: 0;
	font-family: 微软雅黑;
	background: #e3e3e3;
}

.background {
	background-image: url("${ctx}/static/images/bg_login.jpg");
	background-size: contain;
}

.box-shadow-3 {
	-webkit-box-shadow: 0 0 10px rgba(0, 204, 204, .5);
	-moz-box-shadow: 0 0 10px rgba(0, 204, 204, .5);
	box-shadow: 0 0 10px rgba(0, 204, 204, .5);
}

.nopadding {
	padding: 0;
}

.hover_none_underline:hover {
	text-decoration: none;
}

.row_nomargin {
	margin: 0 20px;
}

.padding-20 {
	padding: 30px;
}

.reg_title {
	margin: 0 20px;
	color: aqua;
}

.width_75percent {
	width: 75%;
}

.width_41percent {
	width: 41.66666667%;
}

.color_form_label {
	color: lemonchiffon;
}

.padding-left-none {
	padding-left: 0px;
}

.margin-left-30 {
	margin-left: 30px;
}

.btn-changeimg {
	width: 144px;
	margin-top: 20px;
}

.text-white {
	color: #fff;
}

.maxwidth-222 {
	max-width: 222px;
}

#header {
	height: 80px;
	background: #5ECFBA;
}

#header .logo a img {
	margin: 10px 15%;
}

#reg_pannel {
	width: 60%;
	min-width: 800px;
	margin: 30px auto;
	background: rgba(125, 150, 180, 0.6);
}

#reg_pannel input[type='radio'],input[type='checkbox'] {
	height: 18px;
	width: 18px;
	margin-top: 1px;
}

.cursor_pointer {
	cursor: pointer;
}

#footer {
	background: #e3e3e3;
	text-align: center;
	padding-top: 30px;
	height: 74px;
}

.width-30px {
	width: 20px;
}

.height-26px {
	height: 26px;
	line-height: 26px;
}

.text-protocal {
	color: #68EFAE;
}
</style>
<script type="text/javascript">
	$(function() {
		//生成验证码
		$("#code_img").click(function(e) {
			$(this).attr("src", $(this).attr("src") + "?time=" + new Date());
			$.animateIt($("#code_img"), "animated bounceIn");
			//$("#code_img").addClass("animated infinite bounce");
		})
		$("#birthday_container").birthday();
		$(document).area("province", "district", "county");//调用插件
		$("#province").trigger("change");
		/**
		 * 用按钮选择文件
		 */
		window.onImgSelect = function() {
			$.fileButton("img_input", "img_select");
		};
		// 图片预览
		window.imgPreview = function() {
			$.imgPreview("img_input", "img_person");
		};
	})
</script>
</head>
<body>
	<div class="container-fluid nopadding background">
		<div id="header" class="row">
			<div class="logo">
				<a href="https://www.baidu.com"><img height="70" width="160" src="${ctx}/static/images/logo.png"></a>
			</div>
		</div>
		<!-- 注册面板 -->
		<div id="reg_pannel">
			<div class="reg_inner box-shadow-3 animated fadeInDown">
				<!-- 注册标题 -->
				<div class="row reg_title">
					<h3>用户注册</h3>
				</div>
				<!-- 注册表单 -->
				<div class="row row_nomargin padding-20">
					<form class="form-horizontal" name="form_register" method="post" action="${ctx}/admin/register" enctype="multipart/form-data">
						<div class="col-sm-8">
							<!-- 用户名 -->
							<div class="form-group">
								<label class="col-sm-3 control-label color_form_label">用户名:</label> <input type="text" name="loginname" placeholder="请输入用户名" class="width_75percent col-sm-9 form-control" />
							</div>
							<!-- 密码 -->
							<div class="form-group">
								<label class="col-sm-3 control-label color_form_label">密码:</label> <input type="password" name="password" placeholder="请输入密码" class="width_75percent form-control col-sm-9" />
							</div>
							<!-- 确认密码 -->
							<div class="form-group">
								<label class="col-sm-3 control-label color_form_label">确认密码:</label> <input type="password" name="repassword" placeholder="请再次输入密码" class="width_75percent form-control col-sm-9" />
							</div>
							<!-- 性别 -->
							<div class="form-group">
								<label class="col-sm-3 control-label color_form_label">性别:</label>
								<div class="col-sm-9 width_75percent padding-left-none">
									<div class="radio">
										<label class="text-white"> <input type="radio" name="sex" value="1" checked /> 男
										</label> <label class="text-white margin-left-30"> <input type="radio" name="sex" value="2" /> 女
										</label>
									</div>
								</div>
							</div>
							<!-- 生日 -->
							<div class="form-group" id="birthday_container">
								<label class="col-sm-3 control-label color_form_label">生日:</label>
								<div class="col-sm-3 padding-left-none">
									<select class="form-control" name="year" placeholder="年">
									</select>
								</div>
								<div class="col-sm-3 padding-left-none">
									<select class="form-control" name="month" placeholder="月">
									</select>
								</div>
								<div class="col-sm-3 padding-left-none">
									<select class="form-control" name="day" placeholder="日">
									</select>
								</div>
							</div>
							<!-- 所在城市 -->
							<div class="form-group">
								<label class="col-sm-3 control-label color_form_label">所在城市:</label>
								<div class="col-sm-3 padding-left-none">
									<select class="form-control" id="province" name="province" placeholder="省">
									</select>
								</div>
								<div class="col-sm-3 padding-left-none">
									<select class="form-control" id="district" name="district" placeholder="市区">
									</select>
								</div>
								<div class="col-sm-3 padding-left-none">
									<select class="form-control" id="county" name="county" placeholder="县">
									</select>
								</div>
							</div>
							<!-- 验证码 -->
							<div class="form-group">
								<label class="col-sm-3 control-label color_form_label">验证码:</label> <input type="text" name="code" placeholder="验证码" class="col-sm-5 form-control width_41percent" />
								<div class="col-sm-4">
									<img id="code_img" class="cursor_pointer" width="80" height="34" src="${ctx}/admin/getCode" alt="验证码" />
								</div>
							</div>
							<!-- 手机号 -->
							<div class="form-group">
								<label class="col-sm-3 control-label color_form_label">手机号:</label> <input type="text" name="mobile" placeholder="请输入手机号" class="col-sm-9 form-control width_75percent" />
							</div>
							<!-- 接受用户协议 -->
							<div class="form-group">
								<div class="col-sm-1 width-30px col-sm-offset-3 nopadding">
									<input type="checkbox" name="isAgree" class="checkbox" />
								</div>
								<div class="col-sm-6 nopadding" style="color:#fff">
									<div class="height-26px">
										阅读并同意<a class="text-protocal">《zonekey用户协议》</a>
									</div>
								</div>
							</div>
							<!-- 提交按钮 -->
							<div class="form-group">
								<div class="col-sm-offset-3 col-sm-9 nopadding">
									<button type="submit" class="btn btn-info btn-block maxwidth-222">提交注册</button>
								</div>
							</div>
						</div>
						<div class="col-sm-4">
							<div class="row row_nomargin">
								<img id="img_person" class="cursor_pointer" width="144" height="176" alt="个人头像" src="${ctx}/static/images/user.png" onclick="onImgSelect()" />
							</div>
							<!-- file表单 -->
							<div class="row row_nomargin hidden">
								<input id="img_input" type="file" name="picture" onchange="imgPreview()" />
							</div>
							<!-- 选择按钮 -->
							<div class="row row_nomargin">
								<a id="img_select" class="btn btn-info btn-changeimg" onclick="onImgSelect()">更换头像</a>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
		<!-- end注册面板 -->
		<div id="footer" class="row">
			<strong><a href="http://www.zonekey.com.cn/" target="_blank">现代中庆</a> Copyright © 1996-2015 </strong>&nbsp;<strong><a href="http://www.zonekey.com.cn/" target="_blank">zonekey.com</a></strong> All
			Rights Reversed. 京ICP备11018032号-8 京公网安备11010802013056
		</div>
	</div>
</body>
</html>