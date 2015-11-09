<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>用户首页</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/WEB-INF/views/include/head.jsp"%>
<style type="text/css">
body {
	padding: 0;
	margin: 0;
	font-family: "微软雅黑";
}

#header {
	height: 80px;
	background: #5ECFBA;
}

#header .logo a img {
	margin: 10px 15%;
}

.nopadding {
	padding: 0;
}
</style>
<script type="text/javascript">
      $(function(){
    	  $('.carousel').carousel();
      })
</script>
</head>
<body>
	<div class="container-fluid nopadding" style="background:rgba(0,0,125,1)">
		<div id="header" class="row">
			<div class="logo">
				<a href="http://www.zonekey.com.cn/" hidefocus><img height="70" width="160" src="${ctx}/static/images/logo.png" class="animated slideInRight"></a>
			</div>
		</div>
		<!-- banner -->
		<div class="row" style="height:500px">
			<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
				<!-- Indicators -->
				<ol class="carousel-indicators">
					<li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
					<li data-target="#carousel-example-generic" data-slide-to="1"></li>
					<li data-target="#carousel-example-generic" data-slide-to="2"></li>
				</ol>

				<!-- Wrapper for slides -->
				<div class="carousel-inner" role="listbox">
					<div class="item active">
						<img width="100%" height="600" src="${ctx}/static/images/banner_0.jpg" alt="banner_0" />
						<div class="carousel-caption">banner1</div>
					</div>
					<div class="item">
						<img width="100%" height="600" src="${ctx}/static/images/banner_1.jpg" alt="banner_1" />
						<div class="carousel-caption">banner2</div>
					</div>
					<div class="item">
						<img width="100%" height="600" src="${ctx}/static/images/banner_2.jpg" alt="banner_2" />
						<div class="carousel-caption">banner3</div>
					</div>
				</div>

				<!-- Controls -->
				<a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev"> <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span> <span
					class="sr-only">Previous</span>
				</a> <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next"> <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span> <span
					class="sr-only">Next</span>
				</a>
			</div>
		</div>
	</div>
</body>
</html>