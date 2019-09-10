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
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<h1>게시글 목록</h1>
			<hr>
			<a href="/board/create">글쓰기</a>
			
			<table class="table table-hover">
				<thead>
					<tr>
						<th>글번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일</th>
						<th>조회수</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${to.list}" var="vo">
						<tr>
							<td>${vo.bno}</td>
							<td><a href="/board/read?bno=${vo.bno}">${vo.title}</a></td>
							<td>${vo.writer}</td>
							<td>${vo.updatedate}</td>
							<td>${vo.viewcnt}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		
		<div class="row text-center">
			<ul class="pagination">
				<c:if test="${to.curPage>1}">
					<li><a href="/board/list?curPage=${to.curPage-1}">&laquo;</a></li>
				</c:if>
				<c:forEach begin="${to.bpn}" end="${to.spn}" var="idx">
					<li class="${to.curPage==idx?'active':''}"><a href="/board/list?curPage=${idx}">${idx}</a></li>
				</c:forEach>
				
				<c:if test="${to.curPage<to.totalPage}">
					<li><a href="/board/list?curPage=${to.curPage+1}">&raquo;</a></li>
				</c:if>
			</ul>
		</div>
	</div>
</body>
</html>