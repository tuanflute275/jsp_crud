<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
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
		<h2 class="text-center my-5 text-uppercase">List Product</h2>
		<div class="row align-items-center justify-content-between px-3">
			<div class="">
				<a href="addProduct" class="btn btn-primary my-3" role="button">Add
					New +</a>
			</div>
			<form action="product" method="post">
				<div class="d-flex align-items-center">
					<div class="form-group">
						<label for=""></label> <input type="text" name="search" id=""
							class="form-control" placeholder="Enter your search...">
					</div>
					<button type="submit" class="btn btn-primary mt-2">Search</button>
					<a name="default" id=""
						class="btn btn-warning text-white mt-2 ml-1" href="product"
						role="button">Default</a>
				</div>
			</form>
		</div>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Price</th>
					<th>Status</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listS }" var="item">
					<tr>
						<td>${item.id }</td>
						<td>${item.name }</td>
						<td>${item.price }$</td>
						<td>${item.status == 1 ? "Show" : "Hide" }</td>
						<td><a href="updateProduct?pid=${item.id }"
							class="btn btn-primary" role="button">Edit</a> <a
							onclick="return confirm('Do you want to delete this item ?')"
							href="deleteProduct?pid=${item.id }" class="btn btn-danger"
							role="button">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<ul class="pagination" id="pagination"></ul>
		<input type="hidden" value="" id="page" name="page" /> <input
			type="hidden" value="" id="maxPageItem" name="maxPageItem" /> <input
			type="hidden" value="" id="sortName" name="sortName" /> <input
			type="hidden" value="" id="sortBy" name="sortBy" /> <input
			type="hidden" value="" id="type" name="type" />
	</div>
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	<script
		src="<c:url value='/template/paging/jquery.twbsPagination.js' />"></script>

	<script type="text/javascript">
		var totalPages = 5;
		var currentPage = 1;
		var limit = 2;
		$(function() {
			window.pagObj = $('#pagination').twbsPagination({
				totalPages : totalPages,
				visiblePages : 10,
				startPage : currentPage,
				onPageClick : function(event, page) {
					if (currentPage != page) {
						$('#maxPageItem').val(limit);
						$('#page').val(page);
						$('#sortName').val('title');
						$('#sortBy').val('desc');
						$('#type').val('list');
						$('#formSubmit').submit();
					}
				}
			});
		});
	</script>
</body>
</html>