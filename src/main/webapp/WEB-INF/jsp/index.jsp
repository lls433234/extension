<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<title>91用车</title>
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } </script>
<%-- href="${pageContext.request.contextPath}/static/bootstrap/css/head.css"--%>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- js -->
<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<!-- //js -->
<!-- load-more -->
<script>
	$(document).ready(function () {
		size_li = $("#myList li").size();
		x=1;
		$('#myList li:lt('+x+')').show();
		$('#loadMore').click(function () {
			x= (x+1 <= size_li) ? x+1 : size_li;
			$('#myList li:lt('+x+')').show();
		});
		$('#showLess').click(function () {
			x=(x-1<0) ? 1 : x-1;
			$('#myList li').not(':lt('+x+')').hide();
		});
	});
</script>
<!-- //load-more -->
<link href='http://fonts.googleapis.com/css?family=Lato:400,100,100italic,300,300italic,400italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic' rel='stylesheet' type='text/css'>
</head>
	
<body>
<img style="height: 50px;width: 50px" src="createQrCode" alt="">二维码
<!-- header -->
	<div class="header">
		<div class="container">
			<div class="w3l_header_left"> 
				<ul>
					<li><span class="glyphicon glyphicon-earphone" aria-hidden="true"></span>13627619914</li>
					<li><span class="glyphicon glyphicon-envelope" aria-hidden="true"></span>重庆市渝北区郑家院子***</li>
				</ul>
			</div>
			<div id="example2">	
				<div class="wrapper2">
					<div class="content-wrapper2">
						<div class="search-button2">
							<span></span>
						</div>
						<div class="search-box2">
							<form action="#" method="post">
								<input type="text" name="Search" placeholder="Search Here..." required="">
								<input type="submit" value="Send"> <img src="images/close.png" alt=" " />
							</form>
						</div>
					</div>
				</div>
			</div>
			<div class="w3l_header_right">
				<ul>
					<li><a href="aa"><span class="glyphicon glyphicon-user" aria-hidden="true"></span>登录</a></li>
					<li><a href="sign-up.html"><span class="glyphicon glyphicon-user" aria-hidden="true"></span>注册</a></li>
				</ul>
			</div>
			<div class="clearfix"> </div>
			<script type="text/javascript" src="js/demo.js"></script>
		</div>
	</div>
	<div class="logo_nav">
		<div class="container">
			<nav class="navbar navbar-default">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<div class="logo">
						<h1><a class="navbar-brand" href="index.jsp">91<span>k</span>用车网</a></h1>
					</div>
				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse nav-wil" id="bs-example-navbar-collapse-1">
					<nav class="link-effect-2" id="link-effect-2">
						<ul class="nav navbar-nav">
							<li class="active"><a href="index"><span data-hover="Home">首页</span></a></li>
							<li><a href="services"><span data-hover="Services">服务</span></a></li>
							<li><a href="backIndex"><span data-hover="About">产品</span></a></li>
							<li><a href="about"><span data-hover="Short Codes">关于我们</span></a></li>
							<li><a href="mail"><span data-hover="Mail Us">联系我们</span></a></li>
							<li><a href="createQrCode"><span data-hover="Mail Us">二维码</span></a></li>
						</ul>
					</nav>
				</div>
				<!-- /.navbar-collapse -->
			</nav>
		</div>
	</div>

<%--轮播--%>
<div class="c-banner">
	<div class="banner">
	<ul>
		<li><img src="images/lb1.jpg"></li>
		<li><img src="images/lb2.jpg"></li>
		<li><img src="images/lb3.jpg"></li>
	</ul>
</div>
	<div class="nexImg">
		<img src="images/nexImg.png" />
	</div>
	<div class="preImg">
		<img src="images/preImg.png" />
	</div>
	<div class="jumpBtn">
		<ul>
			<li jumpImg="0"></li>
			<li jumpImg="1"></li>
			<li jumpImg="2"></li>
		</ul>
	</div>
</div>

<!-- banner-bottom -->
	<div class="banner-bottom">
		<div class="container">
			<div class="col-md-6 banner_bottom_left">
				<h3>九幺</h3>
				<p><i>简介</i> 经营范围：信息技术、网络技术研发;电子科技领域内技术开发、技术转让、技术咨询、技术服务;软件设计与开发、
					游戏软件开发、计算机系统集成;通信系统开发集成、自动化控制系统开发与集成;网络工程、自动化工程设计、施工;网站设计与
					开发;网页制作;软件销售。(依法须经批准的项目,经相关部门批准后方可开展经营活动)信息技术、网络技术研发;电子科技领域
					内技术开发、技术转让、技术咨询、技术服务;软件设计与开发、游戏软件开发、计算机系统集成;通信系统开发集成、自动化控
					制系统开发与集成;网络工程、自动化工程设计、施工;网站设计与开发;网页制作;软件销售。(依法须经批准的项目,经相关部门
					批准后方可开展经营活动)</p>
				<div class="wthree_more wthree_more1">
					<a href="about.jsp" class="button--wayra button--border-thick button--text-upper button--size-s">阅读更多信息</a>
				</div>
			</div>
			<div class="col-md-6 banner_bottom_right">
				<div class="wthree_banner_bottom_right_grids">
					<div class="col-md-6 banner_bottom_right_grid">
						<div class="view view-tenth">
							<div class="agile_text_box">
								<i></i>
								<h3>91优速</h3>
								<p>高速无障碍快速通行，享受更高效的旅途，91伴您出行</p>
							</div>
							<div class="mask">
								<img src="images/1.jpg" class="img-responsive" alt="" />
							</div>
						</div>
					</div>
					<div class="col-md-6 banner_bottom_right_grid">
						<div class="view view-tenth">
							<div class="agile_text_box">
								<i class="men"></i>
								<h3>网车易贷</h3>
								<p>用心干事业，真心交朋友，严格对每个项目进行征信调查、评估和审核</p>
							</div>
							<div class="mask">
								<img src="images/2.jpg" class="img-responsive" alt="" />
							</div>
						</div>
					</div>
					<div class="clearfix"> </div>
				</div>
				<div class="wthree_banner_bottom_right_grids">
					<div class="col-md-6 banner_bottom_right_grid">
						<div class="view view-tenth">
							<div class="agile_text_box">
								<i class="shipping"></i>
								<h3>油卡垫付</h3>
								<p>,让汽车运输行业更稳定、更活跃,能够创造更理想的经济价值</p>
							</div>
							<div class="mask">
								<img src="images/3.jpg" class="img-responsive" alt="" />
							</div>
						</div>
					</div>
					<div class="col-md-6 banner_bottom_right_grid">
						<div class="view view-tenth">
							<div class="agile_text_box">
								<i class="clock"></i>
								<h3>车险分期</h3>
								<p>提前消费，提前享受，可以购买更高档车型，提高生活品质</p>
							</div>
							<div class="mask">
								<img src="images/4.jpg" class="img-responsive" alt="" />
							</div>
						</div>
					</div>
					<div class="clearfix"> </div>
				</div>
			</div>
			<div class="clearfix"> </div>
		</div>
	</div>
<!-- banner-bottom -->
<!-- news -->
	<div class="news">
		<div class="container">
			<h3>新闻</h3>
			<div class="agileits_news_grids">
				<div class="tab-1 resp-tab-content">
					<div class="load_more">	
						<ul id="myList">
							<li>
								<div class="l_g">
									<div class="col-md-6 agileits_news_grid_left">
										<div class="agileits_news_grid_left_gridl">
											<p class="para1">28 <span>June- 2016</span></p>
											<p class="para1"><i class="glyphicon glyphicon-envelope" aria-hidden="true"></i><a href="#"><span>comments- 8</span></a></p>
											<p><i class="glyphicon glyphicon-eye-open" aria-hidden="true"></i><a href="#"><span>view- 21</span></a></p>
										</div>
										<div class="agileits_news_grid_left_gridr">
											<img src="images/6.jpg" alt=" " class="img-responsive" />
											<h4><a href="single.html">合作公司众多</a></h4>
											<p>将企业和经济组织间相互依赖的活动关系看作是一种企业网络，而各种从事这类活动的经济行为者就是网络中的节点。</p>
										</div>
										<div class="clearfix"> </div>
									</div>
									<div class="col-md-6 agileits_news_grid_left">
										<div class="agileits_news_grid_left_gridl">
											<p class="para1">30 <span>June- 2016</span></p>
											<p class="para1"><i class="glyphicon glyphicon-envelope" aria-hidden="true"></i><a href="#"><span>comments- 5</span></a></p>
											<p><i class="glyphicon glyphicon-eye-open" aria-hidden="true"></i><a href="#"><span>view- 34</span></a></p>
										</div>
										<div class="agileits_news_grid_left_gridr">
											<img src="images/7.jpg" alt=" " class="img-responsive" />
											<h4>工作现场</h4>
											<p>业务人员在现场对合作人提供最便捷的服务，真正做到快速便捷</p>
										</div>
										<div class="clearfix"> </div>
									</div>
									<div class="clearfix"> </div>
								</div>
							</li>
							<li>
								<div class="l_g">
									<div class="col-md-6 agileits_news_grid_left">
										<div class="agileits_news_grid_left_gridl">
											<p class="para1">28 <span>June- 2016</span></p>
											<p class="para1"><i class="glyphicon glyphicon-envelope" aria-hidden="true"></i><a href="#"><span>comments- 8</span></a></p>
											<p><i class="glyphicon glyphicon-eye-open" aria-hidden="true"></i><a href="#"><span>view- 21</span></a></p>
										</div>
										<div class="agileits_news_grid_left_gridr">
											<img src="images/8.jpg" alt=" " class="img-responsive" />
											<h4>撒旦法师法撒旦法时代</h4>
											<p>Q业务人员在现场对合作人提供最便捷的服务，真正做到快速便捷</p>
										</div>
										<div class="clearfix"> </div>
									</div>
									<div class="col-md-6 agileits_news_grid_left">
										<div class="agileits_news_grid_left_gridl">
											<p class="para1">30 <span>June- 2016</span></p>
											<p class="para1"><i class="glyphicon glyphicon-envelope" aria-hidden="true"></i><a href="#"><span>comments- 5</span></a></p>
											<p><i class="glyphicon glyphicon-eye-open" aria-hidden="true"></i><a href="#"><span>view- 34</span></a></p>
										</div>
										<div class="agileits_news_grid_left_gridr">
											<img src="images/9.jpg" alt=" " class="img-responsive" />
											<h4>士大夫撒地方士大夫撒发大水发</h4>
											<p>业务人员在现场对合作人提供最便捷的服务，真正做到快速便捷</p>
										</div>
										<div class="clearfix"> </div>
									</div>
									<div class="clearfix"> </div>
								</div>
							</li>
							<li>
								<div class="l_g">
									<div class="col-md-6 agileits_news_grid_left">
										<div class="agileits_news_grid_left_gridl">
											<p class="para1">28 <span>June- 2016</span></p>
											<p class="para1"><i class="glyphicon glyphicon-envelope" aria-hidden="true"></i><a href="#"><span>comments- 8</span></a></p>
											<p><i class="glyphicon glyphicon-eye-open" aria-hidden="true"></i><a href="#"><span>view- 21</span></a></p>
										</div>
										<div class="agileits_news_grid_left_gridr">
											<img src="images/10.jpg" alt=" " class="img-responsive" />
											<h4>tempora incidunt eius</h4>
											<p>Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse 
												quam nihil molestiae consequatur, vel illum qui dolorem.</p>
										</div>
										<div class="clearfix"> </div>
									</div>
									<div class="col-md-6 agileits_news_grid_left">
										<div class="agileits_news_grid_left_gridl">
											<p class="para1">30 <span>June- 2016</span></p>
											<p class="para1"><i class="glyphicon glyphicon-envelope" aria-hidden="true"></i><a href="#"><span>comments- 5</span></a></p>
											<p><i class="glyphicon glyphicon-eye-open" aria-hidden="true"></i><a href="#"><span>view- 34</span></a></p>
										</div>
										<div class="agileits_news_grid_left_gridr">
											<img src="images/11.jpg" alt=" " class="img-responsive" />
											<h4>illumqui dolorem eum</h4>
											<p>Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse 
												quam nihil molestiae consequatur, vel illum qui dolorem.</p>
										</div>
										<div class="clearfix"> </div>
									</div>
									<div class="clearfix"> </div>
								</div>
							</li>
						</ul>
						<div id="loadMore">更多显示</div>
						<div id="showLess">隐藏显示</div>
					</div>
				</div>
			</div>
		</div>
	</div>
<!-- //news -->
<!-- testimonials -->
	<div class="testimonials">
		<div class="container">
			<h3>公司代表</h3>
			<div class="w3_testimonials_grids">
				<section class="slider">
					<div class="flexslider">
						<ul class="slides">
							<li>	
								<div class="w3_testimonials_grid">
									<img src="images/1.png" alt=" " class="img-responsive" />
									<h4><i>理念:立志要如山，行道要如水。不如山，不能坚定；不如水，不能曲达。</i></h4>
									<h5>宋月圆</h5>
									<p>创始人</p>
								</div>
							</li>
							<li>	
								<div class="w3_testimonials_grid">
									<img src="images/2.png" alt=" " class="img-responsive" />
									<h4><i>理念:任何的限制，都是从自己的内心开始的。</i></h4>
									<h5>王晓飞</h5>
									<p>总经理</p>
								</div>
							</li>
							<li>	
								<div class="w3_testimonials_grid">
									<img src="images/3.png" alt=" " class="img-responsive" />
									<h4><i>理念:工作，要勤劳：劳作是最可靠的财富。</i></h4>
									<h5>毛青青</h5>
									<p>副总经理</p>
								</div>
							</li>
						</ul>
					</div>
				</section>
				<!-- flexSlider -->
					<link rel="stylesheet" href="css/flexslider.css" type="text/css" media="screen" property="" />
					<script defer src="js/jquery.flexslider.js"></script>
					<script type="text/javascript">
					$(window).load(function(){
					  $('.flexslider').flexslider({
						animation: "slide",
						start: function(slider){
						  $('body').removeClass('loading');
						}
					  });
					});
				  </script>
				<!-- //flexSlider -->
			</div>
		</div>
	</div>
	<div class="agileinfo_copy_right">
		<div class="container">
			<div class="agileinfo_copy_right_left">
				<p>Copyright &copy; 2017.Company name All rights reserved.More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">重庆九幺科技公司</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">官网</a></p>
			</div>
			<div class="clearfix"> </div>
		</div>
	</div>
<!-- //footer -->
<!-- for bootstrap working -->
	<script src="js/bootstrap.js"></script>
<!-- //for bootstrap working -->

<script type="text/javascript">
	//定时器返回值
	var time=null;
	//记录当前位子
	var nexImg = 0;
	//用于获取轮播图图片个数
	var imgLength = $(".c-banner .banner ul li").length;
	//当时动态数据的时候使用,上面那个删除
	// var imgLength =0;
	//设置底部第一个按钮样式
	$(".c-banner .jumpBtn ul li[jumpImg="+nexImg+"]").css("background-color","black");

	//页面加载
	$(document).ready(function(){
		// dynamicData();
		//启动定时器,设置时间为3秒一次
		time =setInterval(intervalImg,3000);
	});

	//点击上一张
	$(".preImg").click(function(){
		//清楚定时器
		clearInterval(time);
		var nowImg = nexImg;
		nexImg = nexImg-1;
		console.log(nexImg);
		if(nexImg<0){
			nexImg=imgLength-1;
		}
		//底部按钮样式设置
		$(".c-banner .jumpBtn ul li").css("background-color","white");
		$(".c-banner .jumpBtn ul li[jumpImg="+nexImg+"]").css("background-color","black");

		//将当前图片试用绝对定位,下一张图片试用相对定位
		$(".c-banner .banner ul img").eq(nowImg).css("position","absolute");
		$(".c-banner .banner ul img").eq(nexImg).css("position","relative");

		//轮播淡入淡出
		$(".c-banner .banner ul li").eq(nexImg).css("display","block");
		$(".c-banner .banner ul li").eq(nexImg).stop().animate({"opacity":1},1000);
		$(".c-banner .banner ul li").eq(nowImg).stop().animate({"opacity":0},1000,function(){
			$(".c-banner ul li").eq(nowImg).css("display","none");
		});

		//启动定时器,设置时间为3秒一次
		time =setInterval(intervalImg,3000);
	})

	//点击下一张
	$(".nexImg").click(function(){
		clearInterval(time);
		intervalImg();
		time =setInterval(intervalImg,3000);
	})

	//轮播图
	function intervalImg(){
		if(nexImg<imgLength-1){
			nexImg++;
		}else{
			nexImg=0;
		}

		//将当前图片试用绝对定位,下一张图片试用相对定位
		$(".c-banner .banner ul img").eq(nexImg-1).css("position","absolute");
		$(".c-banner .banner ul img").eq(nexImg).css("position","relative");

		$(".c-banner .banner ul li").eq(nexImg).css("display","block");
		$(".c-banner .banner ul li").eq(nexImg).stop().animate({"opacity":1},1000);
		$(".c-banner .banner ul li").eq(nexImg-1).stop().animate({"opacity":0},1000,function(){
			$(".c-banner .banner ul li").eq(nexImg-1).css("display","none");
		});
		$(".c-banner .jumpBtn ul li").css("background-color","white");
		$(".c-banner .jumpBtn ul li[jumpImg="+nexImg+"]").css("background-color","black");
	}

	//轮播图底下按钮
	//动态数据加载的试用应放在请求成功后执行该代码,否则按钮无法使用
	$(".c-banner .jumpBtn ul li").each(function(){
		//为每个按钮定义点击事件
		$(this).click(function(){
			clearInterval(time);
			$(".c-banner .jumpBtn ul li").css("background-color","white");
			jumpImg = $(this).attr("jumpImg");
			if(jumpImg!=nexImg){
				var after =$(".c-banner .banner ul li").eq(jumpImg);
				var befor =$(".c-banner .banner ul li").eq(nexImg);

				//将当前图片试用绝对定位,下一张图片试用相对定位
				$(".c-banner .banner ul img").eq(nexImg).css("position","absolute");
				$(".c-banner .banner ul img").eq(jumpImg).css("position","relative");

				after.css("display","block");
				after.stop().animate({"opacity":1},1000);
				befor.stop().animate({"opacity":0},1000,function(){
					befor.css("display","none");
				});
				nexImg=jumpImg;
			}
			$(this).css("background-color","black");
			time =setInterval(intervalImg,3000);
		});
	});
</script>
</body>
</html>