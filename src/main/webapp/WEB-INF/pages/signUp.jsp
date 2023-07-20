<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
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
<style>
</style>
</head>
<body>
	<div class="container">
        <div class="d-flex main-div">
            <div class="row">
                <div class="col-lg photo-div  .d-none .d-sm-block"></div>
                <div class="col-lg form-div">
                	<c:url value="/signUp/save" var="createUser"></c:url>
                	<form:form method="POST" action="${createUser}" modelAttribute="registerForm">
					    <div class="text-center mt-5">
					        <h1>Together</h1>
					        <span>Welcome To Our Together Online Shop again.</span><br>
					        
					        <c:url value="/login" var="login"></c:url>
					        <span>Already signed up ?  &nbsp;</span><a href="${login}">Sign in</a>
					    </div>
					    <div class="col-12 mt-5">
						    <div class="d-flex justify-content-between main-radioDiv">
						        <div class="radiobut">
						            <div class="form-check">
						                <form:radiobutton path="role_id" id="user" value="2" />
						                <form:label for="user" path="role_id" class="form-check-label">Personal</form:label>
						            </div>
						        </div>
						
						        <div class="radiobut">
						            <div class="form-check">
						                <form:radiobutton path="role_id" id="seller" value="3" />
						                <form:label for="seller" path="role_id" class="form-check-label">Business</form:label>
						            </div>
						        </div>
						        
						        <form:errors path="role_id" cssClass="errorColor"></form:errors>
						    </div>
						</div>
					    
					    <div class="col-12 mt-4">
					    	<form:errors path="email" cssClass="errorColor"></form:errors>
					        <div>
					        	<form:input path="email" class="form-control rounded-0" placeholder="Enter email address"/>
					        </div>
					    </div>
					    
					    <div class="col-12 mt-4">
					    	<form:errors path="name" cssClass="errorColor"></form:errors>
					        <div>
					        	<form:input path="name" class="form-control rounded-0" placeholder="Enter your name"/>
					        </div>
					    </div>					    

					    <div class="col-12 mt-4">
					    	<form:errors path="password" cssClass="errorColor"></form:errors>
					        <div>
					        	<form:input path="password" class="form-control rounded-0" placeholder="Enter Password"/>
					        </div>
					    </div>
					    
					    <div class="col-12 mt-3 mb-4">
					        <div>
					            <button type="submit" class="btn btn-danger rounded-0">Sign In</button>
					        </div>
					    </div>	
                	</form:form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>