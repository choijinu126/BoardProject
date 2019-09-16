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
		<h4>ID check</h4>
		<hr/>
		
		<form action="/member/hhome" method="post" class="form-inline">
			<label for="home_id">아이디 카드를 접촉해주세요 : &nbsp;</label>
	    	<input type="text" class="form-control" id="home_id" placeholder="Enter id" name="id">
	    	<button type="submit" class="btn btn-dark" style="margin-left: 10px;">확인</button>
    	</form>
	</div>
	<hr>

	<c:choose>
		<c:when test="${empty vo}"></c:when>
		<c:when test="${not empty vo}">
			<div class="container">
				<table class="table table-sm table-hover"
					style="text-align: center;">
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
						<tr>
							<td>${vo.id}</td>
							<td>${vo.name}</td>
							<td>${vo.joindate}</td>
							<td>${vo.locker}</td>
							<td>${vo.shirts}</td>
						<tr>
					</tbody>
				</table>
			</div>
			<hr>
		</c:when>
	</c:choose>
	
	<div class="container">
		<h4>Notice</h4>
		<hr/>
		
		<div class="container">
			<table class="table table-sm table-hover"
				style="text-align: center;">
				<thead class="thead-dark">
					<tr>
						<th>제목</th>
						<th>작성일</th>
						<th>조회수</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${notice}" var="noticeDTO">
						<tr>
							<td>${noticeDTO.title}</td>
							<td>${noticeDTO.writeday}</td>
							<td>${noticeDTO.readcnt}</td>
						<tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		
		<h4>Event</h4>
		<hr/>
		
		<div class="container">
			<table class="table table-sm table-hover"
				style="text-align: center;">
				<thead class="thead-dark">
					<tr>
						<th>제목</th>
						<th>작성일</th>
						<th>조회수</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${event}" var="noticeDTO">
						<tr>
							<td>${noticeDTO.title}</td>
							<td>${noticeDTO.writeday}</td>
							<td>${noticeDTO.readcnt}</td>
						<tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	
	<c:import url="main_footer.jsp"></c:import>
</div>
</body>
</html>