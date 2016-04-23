<%@page import="com.huoyushi.MyOrderServer.Entity.*,java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE HTML>
<html>
<head>
<title>Spicemystery a Hotel and Resturant Category Flat Bootstarp Responsive Website Template | Orders :: w3layouts</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all">
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Spicemystery Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Libre+Baskerville:400,700' rel='stylesheet' type='text/css'>
<script src="js/jquery.min.js"></script>
<link rel="stylesheet" href="css/flexslider.css" type="text/css" media="screen" />
 <script src="js/simpleCart.min.js"> </script>
</head>
<body>
<!-- header -->
<div class="head-top">
			
		</div>
	<div class="header">
		
		<div class="container">
			<div class="logo">
				<a href="index.html"><img src="images/logo.png" class="img-responsive" alt=""></a>
			</div>
			<div class="header-left">
				<div class="head-nav">
					<span class="menu"> </span>
						<ul>
							<li><a href="index.html">主页</a></li>
							<li><a href=" resturants.html">商户</a></li>
							<li><a href="login.html">登录</a></li>
							<li><a href=" contact.html">联系</a></li>
							<li><a href=" openstore.html">我要开店</a></li>
								<div class="clearfix"> </div>		
						</ul>
								<!-- script-for-nav -->
							<script>
							$( "span.menu" ).click(function() {
								var price=
								  $( ".head-nav ul" ).slideToggle(300, function() {
									// Animation complete.
								  });
								});
							</script>
						<!-- script-for-nav --> 
					</div>
					<div class="header-right1">
						<div class="cart box_1">
							<a href="checkout.html">
								<h3> <span class="simpleCart_total">$0.0</span> (<span id="simpleCart_quantity" class="simpleCart_quantity">0</span>)<img src="images/bag.png" alt=""></h3>
							</a>	
							<p><a href="javascript:;" class="simpleCart_empty">清空购物车</a></p>
							<div class="clearfix"> </div>
						</div>
					</div>
					<div class="clearfix"> </div>
				</div>
					<div class="clearfix"> </div>
			</div>
	</div>
<!-- header -->
<!-- about -->
<div class="orders">
	<div class="container">
		<div class="order-top">
			<li class="data"><h4>菜品</h4>
			<% List<Menu> menus= (List<Menu>)session.getAttribute("menulist");
             %>
             <%
		    for(Menu menu:menus) {
		      %>
				<p><%=menu.getMname()%></p>
				<% } %>
			</li>
			<li class="data">
				<div class="special-info grid_1 simpleCart_shelfItem">
					<h4>Price</h4>
					<%for(Menu menu:menus){ %>
					<div class="pre-top">
						<div class="pr-left">
							<div class="item_price"><span class="item_price"><h6><%=menu.getPrice() %></h6></span></div>
						</div>
						<div class="pr-right">
							<div class="item_add"><span class="item_add"><a href="#">选择</a></span></div>
						</div>
							<div class="clearfix"></div>
					</div>
					<%} %>
					
					</div>
				</li>
			<div class="clearfix"></div>
		</div>
	</div>
</div>
<!-- about -->	

</body>
</html>