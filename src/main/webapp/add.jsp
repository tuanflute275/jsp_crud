<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
<title>Product</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

</head>
<body>
	<div class="container">
		<h2 class="text-center my-5 text-uppercase">Add Product</h2>
		<form action="addProduct" method="POST">
			<div class="form-group">
				<label for="">Name</label> <input type="text" class="form-control"
					name="name" placeholder="Enter name..." value="">
			</div>

				<div class="form-group">
					<label>Price</label>
                     <input type="number" name="price"
						class="form-control" placeholder="Enter price..." value="">
			</div>

            <label for="">Status</label>
          <div class="form-group">
            <div class="form-check form-check-inline">
                <label class="form-check-label">
                    <input class="form-check-input" type="radio" name="status" value="1" checked> Show
                </label>
            </div>
            <div class="form-check form-check-inline">
                <label class="form-check-label">
                    <input class="form-check-input" type="radio" name="status" value="0"> Hide
                </label>
            </div>
          </div>
			
			<button type="submit" class="btn btn-primary">Add</button>
			<a href="product" type="submit" class="btn btn-danger text-white">Back</a>
		</form>
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>