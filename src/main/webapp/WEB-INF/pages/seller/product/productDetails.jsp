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
						<h1 class="m-0">Product Details</h1>
					</div>
					<!-- /.col -->
					<div class="col-sm-6">
						<ol class="breadcrumb float-sm-right">
							<li class="breadcrumb-item"><a href="#">Home</a></li>
							<li class="breadcrumb-item active">Product Details</li>
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
						<div class="card">
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
									<div>
										<form class="border rounded p-3 mb-2">
											<div class="d-flex  mb-2">
											  <div class="form-group col-6">
											    <label for="name">Product Name</label>
											    <input type="text" class="form-control" id="name" value="${product.name}">
											  </div>
											  <div class="form-group col-6">
											    <label for="price">Product Price</label>
											    <input type="text" class="form-control" id="price"  value="${product.price}">
											  </div>
											</div>
											
											<div class="d-flex  mb-2">
											  <div class="form-group col-6">
											    <label for="name">Product Color</label>
											    <input type="text" class="form-control" id="color" value="${product.color}">
											  </div>
											  <div class="form-group col-6">
											    <label for="size">Product Size</label>
											    <input type="text" class="form-control" id="size"  value="${product.size}">
											  </div>
											</div>
											
											<div class="d-flex  mb-2">
											  <div class="form-group col-6">
											    <label for="count">Product Count</label>
											    <input type="text" class="form-control" id="count" value="${product.count}">
											  </div>
											  <div class="form-group col-6">
											    <label for="type">Product type</label>
											    <input type="text" class="form-control" id="type"  value="${product.type}">
											  </div>
											</div>
											
											<div class="form-group col-12">
											   <label for="description">Product Description</label>
											   <input type="text" class="form-control" id="type"  value="${product.description}">
											</div>

											
											<div class="d-flex mb-2">
											    <div class="form-group col-md-6">
											    	<c:url value="/product/productEdit" var="productEdit">
														<c:param name="shopId" value="${shopId}"></c:param>
														<c:param name="productId" value="${productId}"></c:param>
													</c:url>
											        <a class="btn btn-primary btn-block px-3" href="${productEdit}">Change</a>
											    </div>
											    <div class="form-group col-md-6"> 
											    	<c:url value="/seller/productList" var="sellerShopProductList">
											    		<c:param name="shopId" value="${shopId}"></c:param>
											    	</c:url>
											        <a class="btn btn-primary btn-block px-3" href="${sellerShopProductList}">Home</a> 
											    </div>
											</div>
										</form>
									</div>
								</div>

							</div>
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