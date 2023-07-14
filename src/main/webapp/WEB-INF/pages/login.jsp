<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign Up</title>
<link
  href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
  rel="stylesheet">
<script
 src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>

<c:url value="/resources/css/signUp.css" var="signUpCss"></c:url>
 <link rel="stylesheet" href="${signUpCss}">
</head>
<body>
	<div class="container">
        <div class="d-flex main-div">
            <div class="row">
                <div class="col-lg photo-div  .d-none .d-sm-block"></div>
                <div class="col-lg form-div">
                    <form action="" method="post">
                        <div class="text-center mt-5">
                            <h1>Together</h1>
                            <span>Welcome To Our Together Online Shop again.</span><br>
                            <span>Let's do amazing things by signing in.</span>
                        </div>

                        <div class="col-12 mt-4">
                            <div class="d-flex justify-content-center">
                                <input type="email" name="username" class="form-control rounded-0" placeholder="Enter email address">
                            </div>
                        </div>

                        <div class="col-12 mt-4">
                            <div class="d-flex justify-content-center">
                                <input type="password" name="password" class="form-control rounded-0" placeholder="Enter your password">
                            </div>
                        </div>

                        <div class="col-12 mt-2 d-flex justify-content-evenly">
                            <div class="form-check rememberMe">
                                <input class="form-check-input" type="checkbox" name="remember-me" id="rememberMe">
                                <label for="rememberMe" class="form-check-label">Remember Me</label>
                            </div>
                            <div class="form-check">
                                <a href="#" class="text-decoration-none text">Recovery Password</a>
                            </div>
                        </div>

                        <div class="col-12 mt-5">
                            <div class="d-flex justify-content-center">
                                <button class="btn btn-danger rounded-0">Sign In</button>
                            </div>
                        </div>

                        <div class="col-12 mt-4">
                            <div class="d-flex justify-content-center">
                                <p>Don't have an account yet? &nbsp;</p>
                                <a href="#" class="text-decoration-none text"> Sign Up.</a>
                            </div>
                        </div>

                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>