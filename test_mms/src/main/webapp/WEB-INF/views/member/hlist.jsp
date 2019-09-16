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
	<h4>Member List</h4>
	<hr/>
		<table class="table table-sm table-hover" style="text-align: center;">
			<thead class="thead-dark">
				<tr>
					<th>id</th>
					<th>이름</th>
					<th>가입일</th>
					<th>락커 대여</th>
					<th>운동복 대여</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="vo">
				<tr>
					<td>
						<a href="/member/hread?id=${vo.id}">${vo.id}</a>
					</td>
					<td>${vo.name}</td>
					<td>${vo.joindate}</td>
					<td>${vo.locker}</td>
					<td>${vo.shirts}</td>
				<tr>
				</c:forEach>
			</tbody>
		</table>
		
		<div class="row" style="float: right; margin-right: 5px">
			<a class="btn btn-success btn-sm" role="button" href="/member/hinsert">신규</a>
		</div>
	</div>
</div>
</body>
</html>