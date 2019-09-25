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
			<c:if test="${not empty err_login}">
				<p style="color: red;">${err_login}</p>
			</c:if>
			<form name="info" action="/user/loginpost" method="post" onsubmit="return check();">
				<div class="form-group">
					<label id="id">아이디: </label>
					<input name="id" id="id" class="form-control"/>
				</div>
				<div class="form-group">
					<label id="pw">비밀번호: </label>
					<input name="pw" id="pw" class="form-control"/>
				</div>
				
				<div class="checkbox">
					<label>
						<input name="useCookie" type="checkbox" value="true"/>자동 로그인
					</label>
				</div>
				
				<div class="form-group">
					<input value="로그인" type="submit" class="form-control btn btn-primary"/>
				</div>
			</form>
		</div>
	</div>

	<script type="text/javascript">
		function check() {
			if (info.id.value == "") {
				alert("ID를 입력해 주세요.");
				info.id.focus();
				return false;
			} else if (info.pw.value == "") {
				alert("PW를 입력해 주세요.");
				info.pw.focus();
				return false;
			} else if (info.name.value == "") {
				alert("이름을 입력해 주세요.");
				info.name.focus();
				return false;
			} else
				return true;
		}
	</script>
</body>
</html>