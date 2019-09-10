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
	<div class="container">
		<h3>자세히 보기</h3>
		
		<form action="">
			<input type="hidden" name="bno" value="${vo.bno}">
		</form>
		
		<div class="form-group">
			<label for="bno">글번호</label>
			<input class="form-control" id="bno" value="${vo.bno}" readonly="readonly">
		</div>
		
		<div class="form-group">
			<label for="viewcnt">조회수</label>
			<input class="form-control" id="viewcnt" value="${vo.viewcnt}" readonly="readonly">
		</div>
		
		<div class="form-group">
			<label for="title">제목</label>
			<input class="form-control" id="title" value="${vo.title}" readonly="readonly">
		</div>
		
		<div class="form-group">
			<label for="writer">작성자</label>
			<input class="form-control" id="writer" value="${vo.writer}" readonly="readonly">
		</div>
		
		<div class="form-group">
			<label for="content">내용</label>
			<textarea class="form-control" id="content" readonly="readonly">${vo.content}</textarea>
		</div>
		
		<div class="form-group">
			<button class="btn btn-warning modify">수정</button>
			<button class="btn btn-danger del">삭제</button>
			<button class="btn btn-info list">목록</button>
		</div>
	</div>
	
	<script type="text/javascript">
		$(document).ready(function(){
			var $form = $("form");
			$(".modify").click(function(){
				$form.attr("action", "/board/modify?bno=${vo.bno}");
				$form.attr("method", "get");
				$form.submit();
			});
			
			$(".del").click(function(){
				$form.attr("action", "/board/del?bno=${vo.bno}");
				$form.attr("method", "post");
				$form.submit();
			});
			
			$(".list").click(function(){
				$form.attr("action", "/board/list");
				$form.attr("method", "get");
				$form.submit();
			});
		});
	</script>
</body>
</html>