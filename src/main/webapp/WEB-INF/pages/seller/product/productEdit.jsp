<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
	<!-- Content Wrapper. Contains page content -->
	<div class="content-wrapper">
		<!-- Content Header (Page header) -->
		<div class="content-header">
			<div class="container-fluid">
				<div class="row mb-2">
					<div class="col-sm-6">
						<h1 class="m-0">Edit Product</h1>
					</div>
					<!-- /.col -->
					<div class="col-sm-6">
						<ol class="breadcrumb float-sm-right">
							<li class="breadcrumb-item"><a href="#">Home</a></li>
							<li class="breadcrumb-item active">Edit Product</li>
						</ol>
					</div>
					<!-- /.col -->
				</div>
				<!-- /.row -->
			</div>
			<!-- /.container-fluid -->
		</div>
		<!-- /.content-header -->

		<!-- Main content -->
		<section class="content">
			<div class="container-fluid">
				<div class="row">
					<div class="col-12">
						<div class="card pt-5">
							<div class="d-flex m-3">
								<div class="col-5">
								  <div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
								    <!-- Carousel Indicators -->
								    <ol class="carousel-indicators">
								      <c:forEach items="${productPhotoList}" var="productPhoto" varStatus="status">
								        <li data-target="#carouselExampleControls" data-slide-to="${status.index}" class="${status.index == 0 ? 'active' : ''}"></li>
								      </c:forEach>
								    </ol>
								  
								    <!-- Carousel Slides -->
								    <div class="carousel-inner">
								      <c:forEach items="${productPhotoList}" var="productPhoto" varStatus="status">
								        <div class="carousel-item ${status.index == 0 ? 'active' : ''}">
								          <img class="d-block w-100" src="${pageContext.request.contextPath}/resources/img/productImage/${productPhoto.fileName}" alt="Slide ${status.index + 1}">
								        </div>
								      </c:forEach>
								    </div>
								    
								    <!-- Carousel Controls -->
								    <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
								      <span class="carousel-control-prev-icon" aria-hidden="true"></span>
								      <span class="sr-only">Previous</span>
								    </a>
								    <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
								      <span class="carousel-control-next-icon" aria-hidden="true"></span>
								      <span class="sr-only">Next</span>
								    </a>
								  </div>
								</div>
								
								<div class="col-7 align-items-stretch">
									<c:url value="/product/productEdit/save" var="productEdit"></c:url>
									<form:form method="POST" action="${productEdit}"
										modelAttribute="productEdit" enctype="multipart/form-data">
										<div>
											<div class="d-flex justify-content-center">
												<div class="form-group mb-3 col-5">
													<form:label path="name">Product Name</form:label>
													<form:input path="name" class="form-control"/>
													<form:errors path="name" cssClass="text-danger"></form:errors>
												</div>
												<div class="form-group mb-3 col-5">
													<form:label path="price">Product Price</form:label>
													<form:input path="price" class="form-control"/>
													<form:errors path="price" cssClass="text-danger"></form:errors>
												</div>	
											</div>
											<div class="d-flex justify-content-center">
												<div class="form-group mb-3 col-5">
													<form:label path="color">Product Color</form:label>
													<form:input path="color" class="form-control"/>
													<form:errors path="color" cssClass="text-danger"></form:errors>
												</div>
												<div class="form-group mb-3 col-5">
													<form:label path="size">Product Size</form:label>
													<form:input path="size" class="form-control"/>
													<form:errors path="size" cssClass="text-danger"></form:errors>
												</div>	
											</div>
											<div class="d-flex justify-content-center">
												<div class="form-group mb-3 col-5">
													<form:label path="count">Product Count</form:label>
													<form:input path="count" class="form-control"/>
													<form:errors path="count" cssClass="text-danger"></form:errors>
												</div>
												<div class="form-group mb-3 col-5">
											    <form:label path="type">Product Type</form:label>
											    <form:select path="type" class="form-control">
											        <form:option value="instock">In Stock</form:option>
											        <form:option value="preorder">Pre-order</form:option>
											    </form:select>
												</div>	
											</div>
											<div class="d-flex justify-content-center">
												<div class="form-group mb-3 col-10">
													<form:label path="description">Product Description</form:label>
													<form:input path="description" class="form-control"/>
													<form:errors path="description" cssClass="text-danger"></form:errors>
												</div>	
											</div>
											
						    				<div class="d-flex justify-content-center">
								      			<div class="col-10 mb-3">
								        			<div class="row">
								          				<div class="col-6 text-left">
								           					 <button type="submit" class="btn btn-primary">Submit</button>
								          				</div>
								          				<div class="col-6 text-right">
								          					<c:url value="/product/productDetails" var="sellerProductDetails">
								          						<c:param name="shopId" value="${shopId}"></c:param>
																<c:param name="productId" value="${productId}"></c:param>
								          					</c:url>
								            				<a class="btn btn-light" href="${sellerProductDetails}">Cancel</a>
								          				</div>
								        			</div>
								      			</div>
								    		</div>	
																
										</div>
									</form:form>
								</div>

							</div>
						
							<!-- /.card-body -->
						</div>
					</div>
					<!-- /.col -->
				</div>
				<!-- /.row -->
			</div>
			<!-- /.container-fluid -->
		</section>
		<!-- /.content -->
	</div>
	<!-- /.content-wrapper -->