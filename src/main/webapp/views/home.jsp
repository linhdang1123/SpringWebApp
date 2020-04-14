<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign Up</title>
<link rel="stylesheet" href="/resources/css/style.css">
</head>
<body>
<div id="clouds">
    <div class="cloud x1"></div>
    <!-- Time for multiple clouds to dance around -->
    <div class="cloud x2"></div>
    <div class="cloud x3"></div>
    <div class="cloud x4"></div>
    <div class="cloud x5"></div>
</div>
 <div class="container">
      <div id="login">
        <form action="addUser">
          <fieldset class="clearfix">          
			<p><span class="fontawesome-user"></span><input type="text"  placeholder="Enter First Name" name = "firstName" required></p> 
			<p><span class="fontawesome-user"></span><input type="text" placeholder="Enter Last Name" name="lastName" required></p> 
			<p><span class="fontawesome-user"></span><input type="text" placeholder="Enter Email" name="email"  required></p>   
            <p><span class="fontawesome-user"></span><input type="text" placeholder="Enter Phone Number" name="phoneNumber" required></p> 
            <p><span class="fontawesome-user"></span><input type="password"  placeholder="Enter Password" name="passWord" required></p>
            <p><input type="submit" value="Sign Up"></p>
          </fieldset>
        </form>
      </div> 
    </div>
    <div class="bottom"></div>
</body>
</html>