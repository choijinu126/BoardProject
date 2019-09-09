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
	<h3>게시물 수정</h3>
	<div class="container">
		<div class="row">
			<form action="/board/modify" method="post">
				<div class="form-group">
					<label for="bno">글번호</label>
					<input id="bno" name="bno" class="form-control" value="${vo.bno}" readonly="readonly">
				</div>
				
				<div class="form-group">
					<label for="title">제목</label>
					<input id="title" name="title" class="form-control" value="${vo.title}">
				</div>
				
				<div class="form-group">
					<label for="writer">작성자</label>
					<input id="writer" name="writer" class="form-control" readonly="readonly" value="${vo.writer}">
				</div>
				
				<div class="form-group">
					<label for="content">내용</label>
					<textarea id="content" name="content" class="form-control" row=5>${vo.content}</textarea>
				</div>
				
				<div class="form-group">
					<input type="submit" class="btn btn-primary" value="수정">
				</div>
			</form>
		</div>
	</div>
</body>
</html>