<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container-fluid">
		<c:import url="main_logo.jsp"></c:import>

		<div class="container">
			<h4>Member Insert</h4>
			<hr />

			<form action="/member/hinsert" method="post">
				<div class="form-group">
					<label for="id">id</label>
					<input
						type="text" class="form-control" id="id"
						aria-describedby="id" placeholder="Enter id" name="id">
				</div>
				
				<div class="form-group">
					<label for="pw">Password</label> <input
						type="password" class="form-control" id="pw"
						placeholder="Password", name="pw">
				</div>
				
				<div class="form-group">
					<label for="name">name</label>
					<input
						type="text" class="form-control" id="name"
						aria-describedby="name" placeholder="Enter name" name="name">
				</div>
				
				<div class="form-group">
					<label for="phone">phone</label>
					<input
						type="text" class="form-control" id="phone"
						aria-describedby="phone" placeholder="Enter phone" name="phone">
						<small id="phone" class="form-text text-muted">
							헬스장 운영을 위한 목적 외에 다른 목적으로 사용되지 않습니다.
						</small>
				</div>

				<div class="form-group">
					<label for="birthday" class="">Birthday</label>
					<div class="col-10">
						<input class="form-control" type="date" value="2011-01-01"
							id="birthday" name="birthday">
					</div>
				</div>

				<div class="form-group form-check">
					<input type="checkbox" class="form-check-input" id="locker" name="locker">
					<label class="form-check-label" for="locker">Locker</label>
				</div>
				<div class="form-group form-check">
					<input type="checkbox" class="form-check-input" id="shirts" name="shirts">
					<label class="form-check-label" for="shirts">Shirts</label>
				</div>
				<button type="submit" class="btn btn-primary">Submit</button>
			</form>
		</div>
	</div>
</body>
</html>