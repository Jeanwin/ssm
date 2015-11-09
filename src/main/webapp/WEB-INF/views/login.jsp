<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="org.apache.shiro.web.filter.authc.FormAuthenticationFilter"%>
<%@ page import="org.apache.shiro.authc.ExcessiveAttemptsException"%>
<%@ page import="org.apache.shiro.authc.IncorrectCredentialsException"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>系统登录页面</title>
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
<%@ include file="/WEB-INF/views/include/head.jsp"%>
<style type="text/css">
.arrow {
	position: absolute;
	width: 20px;
	height: 20px;
	top: 10px;
	left: -20px;
}

.arrow * {
	display: block;
	border-width: 10px;
	position: absolute;
	border-style: dashed solid dashed dashed;
	font-size: 0;
	line-height: 0;
}

.arrow em {
	border-shadow: 0px 0px 6px 1px #1BEF4A;
	border-color: transparent #1BEF4A transparent transparent;
}

.arrow span {
	border-color: transparent rgba(0, 0, 0, 0.7) transparent transparent;
	left: 2px;
}

body {
	margin: 0;
	padding: 0;
	font-family: 微软雅黑;
	background: #e3e3e3;
}

.nopadding {
	padding: 0;
}

#header {
	height: 80px;
	background: #5ECFBA;
}

#header .logo a img {
	margin: 10px 15%;
}

#content {
	min-height: 600px;
	position: relative;
	z-index: 1;
	background-image: url("${ctx}/static/images/cover.jpg");
	-o-background-size: 100%;
	-webkit-background-size: 100%;
}

#title {
	position: absolute;
	padding: 0px;
	margin: 0;
	top: 250px;
	color: #fff;
	left: calc(50% - 300px);
}

.logo2 {
	position: absolute;
	top: 236px;
	left: calc(50% - 380px);
}

#content .login_panel {
	border: 1px solid transparent;
	border-color: #ddd;
	box-shadow: 0px 0px 25px -6px rgba(255, 255, 255, 0.8);
	width: 350px;
	height: 360px;
	z-index: 99999;
	position: absolute;
	top: 120px;
	right: 15%;
}

.hover_none_underline:hover {
	text-decoration: none;
}

.hover_none_underline {
	display: block;
}

#content .login_inner {
	width: 350px;
	height: 360px;
	background: #7AD057;
	margin: auto;
	padding: 20px;
	margin: auto;
	background: rgba(255, 255, 255, 0.5) !important;
	filter: Alpha(opacity = 50);
	background: #fff; /*　使用IE专属滤镜实现IE背景透明*/
}

.login_form_title {
	font-size: 20px;
	font-weight: 600;
	color: #428bca;
	margin-bottom: 10px;
}

.padding-right-none {
	padding-right: 0;
}

#forget_password {
	display: block;
	min-height: 27px;
	padding-top: 7px;
	float: right;
}

.margin_bottom_10 {
	margin-bottom: 10px;
}

#footer {
	background: #e3e3e3;
	text-align: center;
	padding-top: 30px;
	height: 74px;
}

#content_left {
	height: 600px;
	width: 50%;
}

.rectangle {
	border: 1px solid #1BEF4A;
	width: 40px;
	height: 40px;
	box-shadow: 0px 0px 6px 1px #1BEF4A;
	position: absolute;
	display: none;
}

.r1 {
	top: calc(50% - 220px);
	left: calc(50% - 450px);
}

.r2 {
	top: calc(50% - 250px);
	left: calc(50% - 185px);
}

.r3 {
	top: calc(50% + 50px);
	left: calc(50% - 350px);
}

.repopver {
	border-radius: 8px;
	border: 1px solid #1BEF4A;
	width: 180px;
	height: 120px;
	box-shadow: 0px 0px 6px 1px #1BEF4A;
	position: absolute;
	color: #fff;
	background-color: rgba(0, 0, 0, 0.4);
	padding: 6px 12px;
	display: none;
	border: 1px solid #1BEF4A;
}

.p1 {
	top: calc(50% - 220px);
	left: calc(50% - 400px);
}

.p2 {
	top: calc(50% - 250px);
	left: calc(50% - 135px);
}

.p3 {
	top: calc(50% + 50px);
	left: calc(50% - 300px);
}

.img_pop {
	width: 39px;
	height: 34px;
	float: left;
}
</style>
<script type="text/javascript">
	function initialize() {
		var map = new BMap.Map("bdmap");
		console.log(map);
		var point = new BMap.Point(116.404, 39.915);
		map.centerAndZoom(point, 15);
		window.setTimeout(function() {
			map.panTo(new BMap.Point(116.409, 39.918));
		}, 2000);
		map.addControl(new BMap.NavigationControl());
		map.addControl(new BMap.ScaleControl());
		map.addControl(new BMap.OverviewMapControl());
		map.addControl(new BMap.MapTypeControl());
		map.setCurrentCity("北京"); // 仅当设置城市信息时，MapTypeControl的切换功能才能可用
		var stCtrl = new BMap.PanoramaControl();
		stCtrl.setOffset(new BMap.Size(20, 20));
		map.addControl(stCtrl);
		/* 全景图 */
		var panorama = new BMap.Panorama("panorama"); //2
		panorama.setPosition(new BMap.Point(120.320032, 31.589666)); //3  
		// panorama.setId('0100010000130501122416015Z1');  
		panorama.setPov({
			heading : -40,
			pitch : 6
		});
	}
	function loadScript() {
		var script = document.createElement("script");
		script.src = "http://api.map.baidu.com/api?v=1.5&ak=Gao8G41wFK8eluedQLOqsLnW&callback=initialize";//此为v1.5版本的引用方式  
		// http://api.map.baidu.com/api?v=1.5&ak=您的密钥&callback=initialize"; //此为v1.4版本及以前版本的引用方式  
		document.body.appendChild(script);
	}

	$(function() {
		//记住密码,自动登陆
		if ($.cookie("rmbuser") == "true") {
			$("#rmbuser").attr("checked", true);
			$("#loginname").val($.cookie("username"));
			$("#password").val($.cookie("password"));
			setTimeout(function() {
				document.form_login.submit();
				//$("#form_login").triger("submit");
			}, 100000);
		}
		//生成验证码
		$("#code_img").click(function() {
			$(this).attr("src", $(this).attr("src") + "?date=" + new Date().getTime());
			$.animateIt($("#code_img"), "animated swing");
		});
		//自动登录，保存用户信息 
		$("#rmbuser").click(function() {
			if (document.getElementById("rmbuser").checked === true) {
				var username = $("#loginname").val();
				var password = $("#password").val();
				$.cookie("rmbuser", "true", {
					expires : 7
				}); // 存储一个带7天期限的 cookie 
				$.cookie("username", username, {
					expires : 7
				}); // 存储一个带7天期限的 cookie 
				$.cookie("password", password, {
					expires : 7
				}); // 存储一个带7天期限的 cookie 
			} else {
				$.cookie("rmbuser", "false", {
					expires : -1
				});
				$.cookie("username", '', {
					expires : -1
				});
				$.cookie("password", '', {
					expires : -1
				});
			}
		});
		//hover提示
		var isHover = false;
		var index;
		var dispear;
		var dis;
		$("#content_left").mousemove(function(e) {
			if (e.type == "mousemove" && !isHover) {
				if ($(".rectangle").css("display") === "none") {
					$(".rectangle").fadeIn();
				}
				//如果上次计时未完成，计时复位
				if (dispear != undefined) {
					clearTimeout(dispear);
				}
				dispear = setTimeout(function() {
					clearTimeout(dispear);
					if ($(".rectangle").css("display") === "block") {
						$(".rectangle").fadeOut();
					}
				}, 1000)
			}
			return false;
		})
		$(".rectangle").mouseover(function() {
			isHover = true;
			if (dispear != undefined) {
				clearTimeout(dispear);
			}
			if (dis != undefined) {
				clearTimeout(dis);
			}
			if ($(this).css("display") === "block") {
				index = $(".rectangle").index($(this));
				$(".rectangle").not(":eq(" + index + ")").fadeOut();
				$(".repopver").not(":eq(" + index + ")").fadeOut();
				$(this).next(".repopver").fadeIn();
			} else {
				//$(this).fadeIn();
				//$(this).next(".repopver").fadeIn();	
			}
			return false;
		})
		$(".repopver").mouseover(function() {
			isHover = true;
			if (dispear != undefined) {
				clearTimeout(dispear);
			}
			if (dis != undefined) {
				clearTimeout(dis);
			}
			index = $(".repopver").index($(this));
			$(".rectangle").not(":eq(" + index + ")").fadeOut();
			$(".repopver").not(":eq(" + index + ")").fadeOut();
		})
		$(".rectangle").mouseout(function() {
			isHover = false;
			dis = setTimeout(function() {
				$(".rectangle").next(".repopver").fadeOut();
			}, 1000)
			return false;
		})
		$(".repopver").mouseout(function() {
			isHover = false;
			dis = setTimeout(function() {
				$(".repopver").fadeOut();
				$(".repopver").fadeOut();
			}, 1000)
			return false;
		})
	})
</script>
</head>
<body>
	<div class="container-fluid nopadding">
		<div id="header" class="row">
			<div class="logo">
				<a href="http://www.zonekey.com.cn/" hidefocus><img height="70" width="160" class="animated slideInRight" src="${ctx}/static/images/logo.png"></a>
			</div>
		</div>
		<div id="content" class="row">
			<div id="content_left">
				<!-- rectangle -->
				<div id="rectangle_container">
					<div class="rectangle_div">
						<div class="rectangle r1"></div>
						<div class="repopver p1">
							<div class="arrow">
								<em></em> <span></span>
							</div>
							<img src="${ctx}/static/images/logo2.png" width="39" height="34" class="img_pop" /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;中国农业大学成立于一九四六年，是一所集工学，理学，文学于一体的多学科现代化高校。
						</div>
					</div>
					<div class="rectangle_div">
						<div class="rectangle r2"></div>
						<div class="repopver p2">
							<div class="arrow">
								<em></em> <span></span>
							</div>
							<img src="${ctx}/static/images/logo2.png" width="39" height="34" class="img_pop" /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;中国农业大学成立于一九四六年，是一所集工学，理学，文学于一体的多学科现代化高校。
						</div>
					</div>
					<div class="rectangle_div">
						<div class="rectangle r3"></div>
						<div class="repopver p3">
							<div class="arrow">
								<em></em> <span></span>
							</div>
							<img src="${ctx}/static/images/logo2.png" width="39" height="34" class="img_pop" /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;中国农业大学成立于一九四六年，是一所集工学，理学，文学于一体的多学科现代化高校。
						</div>
					</div>
				</div>
				<!-- end rectangle -->
				<!-- logo2 -->
				<div>
					<img src="${ctx}/static/images/logo2.png" width="77" height="68" class="logo2" />
					<h1 id="title" class="animated animate-2 flipInX">现代中庆录播系统</h1>
				</div>
			</div>
			<!-- end logo2 -->
			<div class="login_panel">
				<div class="login_inner">
					<form class="form-horizontal" name="form_login" action="${ctx}/login" method="post" onsubmit="document.getElementById('time_stamp').value=new Date();">
						<div class="form-group margin_bottom_10">
							<h4 class="login_form_title">用户登录</h4>
							<input id="time_stamp" type="hidden" name="timeStamp" value="123" />
						</div>
						<!-- 错误信息 -->
						<div id="login_message" style="height:20px">
							<%
								String error = (String) request.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
								if (error != null) {
							%>
							<span class="control-group error" style="color:red;font-size:11px"><%=error%></span>
							<%
								}
							%>
						</div>
						<!-- 用户名 -->
						<div class="form-group margin_bottom_10">
							<div class="input-group">
								<span class="input-group-addon"><i class="text-primary glyphicon glyphicon-user"></i></span> <input type="text" id="loginname" name="loginname" class="form-control" placeholder="请输入用户名">
							</div>
						</div>
						<!-- 密码 -->
						<div class="form-group margin_bottom_10">
							<div class="input-group">
								<span class="input-group-addon"><i class="text-primary glyphicon glyphicon-lock"></i></span> <input type="password" id="password" name="password" class="form-control" placeholder="请输入密码">
							</div>
						</div>
						<c:if test="${count>2}">
							<div class="form-group margin_bottom_10">
								<div class="col-sm-offset-1 col-sm-7 padding-right-none">
									<input type="text" id="code" name="code" class="form-control" placeholder="请输入验证码">
								</div>
								<div class="col-sm-4 text-right padding-right-none">
									<img id="code_img" width="80" height="32" alt="验证码" src="${ctx}/admin/getCode">
								</div>
							</div>
						</c:if>
						<!-- 自动登陆和忘记密码 -->
						<div class="form-group margin_bottom_10">
							<div class="col-sm-6 nopadding">
								<div class="checkbox">
									<label> <input type="checkbox" id="rmbuser">自动登录
									</label>
								</div>
							</div>
							<!-- 忘记密码 -->
							<div class="col-sm-6 padding-right-none">
								<a id="forget_password" href="${ctx}/admin/toRetrive" hidefocus>忘记密码?</a>
							</div>
						</div>
						<!-- 提交按钮 -->
						<div class="form-group margin_bottom_10">
							<div class="col-sm-12 nopadding">
								<button type="submit" class="btn btn-info btn-block" hidefocus>登录</button>
							</div>
						</div>
						<!-- 我要注册 -->
						<div class="form-group margin_bottom_10">
							<div class="col-sm-12 nopadding">
								<!-- onclick="javascript:window.location.href='https://www.baidu.com'" -->
								<a href="${ctx}/admin/toRegister" class="hover_none_underline btn btn-default btn-block" hidefocus>我要注册</a>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
		<div id="footer" class="row">
			<strong><a href="http://www.zonekey.com.cn/" target="_blank" hidefocus>现代中庆</a> Copyright © 1996-2015 </strong>&nbsp;<strong><a href="http://www.zonekey.com.cn/" target="_blank" hidefocus>zonekey.com</a></strong> All
			Rights Reversed. 京ICP备11018032号-8 京公网安备11010802013056
		</div>
</body>
</html>