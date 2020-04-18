<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="/resources/css/login.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
</head>
<body>
<div class="logo"><a class = "logo" href = "home">SpringIO<a></a></div>
<h2>Sign in/up Form</h2>
<div class="container" id="container">
	<div class="form-container sign-up-container">
		<form action="addUser">
			<h1>Create Account</h1>
			<div class="social-container">
				<a href="#" class="social"><i class="fab fa-facebook-f"></i></a>
				<a href="#" class="social"><i class="fab fa-google-plus-g"></i></a>
				<a href="#" class="social"><i class="fab fa-linkedin-in"></i></a>
			</div>
			<span>or use your email for registration</span>
			<input type="text" placeholder="First Name" name = "firstName"/>
			<input type="text" placeholder="Last Name" name = "lastName"/>
			<input type="email" placeholder="Email" name = "email"/>
			<input type="text" placeholder="Phone Number" name = "phoneNumber"/>
			<input type="password" placeholder="Password" name = "passWord"/>
			<button>Sign Up</button>
		</form>
	</div>
	<div class="form-container sign-in-container">
		<form action="SignIn">
			<h5 style = "color : red">${message}</h5>
			<h1>Sign in</h1>
			<div class="social-container">
				<a href="#" class="social"><i class="fab fa-facebook-f"></i></a>
				<a href="#" class="social"><i class="fab fa-google-plus-g"></i></a>
				<a href="#" class="social"><i class="fab fa-linkedin-in"></i></a>
			</div>
			<span>or use your account</span>
			<input type="text" placeholder="email" name = "email"/>
			<input type="password" placeholder="Password"  name = "passWord"/>
			<a href="#">Forgot your password?</a>
			<button>Sign In</button>
		</form>
	</div>
	<div class="overlay-container">
		<div class="overlay">
			<div class="overlay-panel overlay-left">
				<h1>Welcome To SpringIO</h1>
				<p>Already have an account ? let's shop !</p>
				<button class="ghost" id="signIn">Sign In</button>
			</div>
			<div class="overlay-panel overlay-right">
				<h1>Hello, Friend!</h1>
				<p>Enter the following details and start shopping with us</p>
				<button class="ghost" id="signUp">Sign Up</button>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript" src="/resources/js/login.js"></script>

</body>
</html>