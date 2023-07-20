<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign In</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>

<c:url value="/resources/css/signIn.css" var="signInCss"></c:url>
<link rel="stylesheet" href="${signInCss}">

<script>
    function validateForm() {
        var email = document.forms["signupForm"]["username"].value;
        var password = document.forms["signupForm"]["password"].value;
        var emailError = document.getElementById("emailError");
        var passwordError = document.getElementById("passwordError");
        var isValid = true;

        emailError.textContent = "";
        passwordError.textContent = "";

        if (email.trim() === "") {
            emailError.textContent = "Email is required.";
            isValid = false;
        }

        if (password.trim() === "") {
            passwordError.textContent = "Password is required.";
            isValid = false;
        }

        return isValid;
    }
</script>
</head>
<body>
    <div class="container">
        <div class="d-flex main-div">
            <div class="row">
                <div class="col-lg photo-div  .d-none .d-sm-block"></div>
                <div class="col-lg form-div">
                    <!-- form -->
                    <form action="" method="post" name="signupForm" onsubmit="return validateForm()">
                        <div class="text-center mt-5">
                            <h1>Together</h1>
                            <span>Welcome To Our Together Online Shop again.</span><br>
                            <span>Let's do amazing things by signing in.</span>
                        </div>

                        <div class="col-12 mt-4">
                            <div>
                                <input type="email" name="username" class="form-control rounded-0" placeholder="Enter email address">
                            </div>
                            <div id="emailError" class="error-message"></div>
                        </div>

                        <div class="col-12 mt-4">
                            <div>
                                <input type="password" name="password" class="form-control rounded-0" placeholder="Enter your password">
                            </div>
                            <div id="passwordError" class="error-message"></div>
                        </div>

                        <div class="col-12 mt-2 d-flex  justify-content-between main-checkDiv">
                            <div class="form-check rememberMe">
                                <input class="form-check-input" type="checkbox" name="remember-me" id="rememberMe">
                                <label for="rememberMe" class="form-check-label">Remember Me</label>
                            </div>
                            <div class="form-check">
                            	<c:url value="/recoveryPassword" var="recoveryPassword"></c:url>
                                <a href="${recoveryPassword}" class="text-decoration-none text">Recovery Password</a>
                            </div>
                        </div>

                        <div class="col-12 mt-5">
                            <div>
                                <button class="btn btn-danger rounded-0">Sign In</button>
                            </div>
                        </div>

                        <div class="col-12 mt-4">
                            <div class="d-flex justify-content-center">
                                <p>Don't have an account yet? &nbsp;</p>
                                <c:url value="/signUp.jsp" var="signUp"></c:url>
                                <a href="signUp" class="text-decoration-none text"> Sign Up.</a>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
