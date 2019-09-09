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
	<h1>회원가입</h1>
	<form action="/member/insert" method="post">
		id: <input name="id"><button>id 중복체크</button>
		<p id="result"></p>
		name: <input name="name"><br>
		age: <input type="number" name="age"><br>
		<input type="submit">
	</form>
	
	<script type="text/javascript">
		$(document).ready(function(){
			$("button").click(function(event){
				event.preventDefault()
				var id = $("input[name='id']").val();
				$.ajax({
					type: 'post',
					url: '/member/idcheck',
					data: {
						id: id
					},
					dataType: 'text',
					success: function(result){
						$('p').text(result);
					}
				});
			});
		});
	</script>
</body>
</html>