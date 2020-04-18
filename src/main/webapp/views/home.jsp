<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link rel="stylesheet" href="/resources/css/homestyle.css">
</head>
<body>
	<ul class="menu-toparea">
		<!--
			if message is not null 
				<li><a href="login">${message}</a></li>
			else
				<li><a href="login">Login </a></li>
				<li><a href="#signup">Sign up</a></li>
			
		 -->
		<li><a href="login">${login}</a></li>
		<li><a href="#signup">${signup}</a></li>
		<li><a href="#contact">Contact</a></li>
		<li><a href="#start selling">Start Selling</a></li>
	</ul>
	<div class="custom-padding">
		<nav class="menuNav">
			<div class="logo">SpringIO</div>

			<ul class="menu-area">
				<li><input type="text" name="search" id="search"
					placeholder="Search" /></li>
				<li><a href="#">New Arrival</a></li>
				<li><a href="#">Clothing</a></li>
				<li><a href="#">Bags</a></li>
				<li><a href="#">Accessories</a></li>
			</ul>
		</nav>
	</div>

	<div class="main">

		<div class="grid" style="max-width: 1200px; margin-top: 100px">
			<div class="row">
				<img
					src="https://cdn.pixabay.com/photo/2018/04/18/06/14/tram-3329586_960_720.jpg"
					alt="" style="width: 100%; height: 450px" />
			</div>
			<div class="item" id="item">
				<div class="row">
					<div class="column">
						<div class="content">
							<img
								src="https://cdn.pixabay.com/photo/2016/07/25/13/52/woman-1540543_960_720.jpg"
								alt="Mountains" style="width: 100%">
							<div class="card-block">
								<h4 class="card-title">Shoes</h4>
								<p class="card-text">Price: $5</p>
								<button>Add To Cart</button>
							</div>
						</div>
					</div>
					<div class="column">
						<div class="content">
							<img
								src="https://cdn.pixabay.com/photo/2017/11/27/07/02/time-2980690_960_720.jpg"
								alt="Mountains" style="width: 100%">
							<div class="card-block">
								<h4 class="card-title">Shoes</h4>
								<p class="card-text">Price: $5</p>
								<button>Add To Cart</button>
							</div>
						</div>
					</div>
					<div class="column">
						<div class="content">
							<img
								src="https://cdn.pixabay.com/photo/2017/02/08/02/56/booties-2047596_960_720.jpg"
								alt="Mountains" style="width: 100%">
							<div class="card-block">
								<h4 class="card-title">Shoes</h4>
								<p class="card-text">Price: $5</p>
								<button>Add To Cart</button>
							</div>
						</div>
					</div>
					<div class="column">
						<div class="content">
							<img
								src="https://cdn.pixabay.com/photo/2015/06/10/13/23/clothesline-804812_960_720.jpg"
								alt="Mountains" style="width: 100%">
							<div class="card-block">
								<h4 class="card-title">Shoes</h4>
								<p class="card-text">Price: $5</p>
								<button>Add To Cart</button>
							</div>
						</div>
					</div>
					<div class="column">
						<div class="content">
							<img
								src="https://cdn.pixabay.com/photo/2016/03/27/19/31/fashion-1283863_960_720.jpg"
								alt="Mountains" style="width: 100%">
							<div class="card-block">
								<h4 class="card-title">Shoes</h4>
								<p class="card-text">Price: $5</p>
								<button>Add To Cart</button>
							</div>
						</div>
					</div>
					<div class="column">
						<div class="content">
							<img
								src="https://cdn.pixabay.com/photo/2016/07/04/04/29/datang-1495918_960_720.jpg"
								alt="Mountains" style="width: 100%">
							<div class="card-block">
								<h4 class="card-title">Shoes</h4>
								<p class="card-text">Price: $5</p>
								<button>Add To Cart</button>
							</div>
						</div>
					</div>
					<div class="column">
						<div class="content">
							<img
								src="https://cdn.pixabay.com/photo/2015/10/30/18/35/shoes-1014606_960_720.jpg"
								alt="Mountains" style="width: 100%">
							<div class="card-block">
								<h4 class="card-title">Shoes</h4>
								<p class="card-text">Price: $5</p>
								<button>Add To Cart</button>
							</div>
						</div>
					</div>
					<div class="column">
						<div class="content">
							<img
								src="https://cdn.pixabay.com/photo/2017/08/27/00/52/accessories-2684884_960_720.jpg"
								alt="Mountains" style="width: 100%">
							<div class="card-block">
								<h4 class="card-title">Shoes</h4>
								<p class="card-text">Price: $5</p>
								<button>Add To Cart</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>





</body>
</html>