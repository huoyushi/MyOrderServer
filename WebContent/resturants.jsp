<%@page import="com.huoyushi.MyOrderServer.Entity.*,java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
<head>
<title>Spicemystery a Hotel and Resturant Category Flat Bootstarp Responsive Website Template | Resturant :: w3layouts</title>
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
							<li class="active"><a href=" resturants.html">商户</a></li>
							<li><a href="login.html">登录</a></li>
							<li><a href=" contact.html">联系</a></li>
							<li><a href=" openstore.html">我要开店</a></li>
							<li><a >欢迎 <%Customer s = (Customer)session.getAttribute("customer"); 	
    		                out.print(s.getUname().toString()); %></a></li>
    		                <li><form action="logout" method="post"><input type="submit" value="退出登陆"></form></li>
								<div class="clearfix"> </div>		
						</ul>
								<!-- script-for-nav -->
							<script>
							$( "span.menu" ).click(function() {
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
								<h3> <span class="simpleCart_total">$0.00</span> (<span id="simpleCart_quantity" class="simpleCart_quantity">0</span>)<img src="images/bag.png" alt=""></h3>
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
	
	
	<table id="resturants" class="table table-striped  table-hover">
    	<tr>
			<td>SellerID</td>
			<td>SellerName</td>
			<td>email</td>
		</tr>
		    
<% List<Seller> sellers= (List<Seller>)session.getAttribute("sellerlist");
%>
		<%
		for(Seller seller:sellers) {
		%>
			<tr>
			<td><a href="getmenulist?sellerid=<%=seller.getSellerid()%>"><%=seller.getSellerid()%></a></td>
			<td><%=seller.getUname() %></td>
			<td><%=seller.getEmail() %></td>
		   </tr>
		
		<%
		}
		%>
    </table>
 

     		
	</div>
</div>

<!-- about -->	

</body>
</html>