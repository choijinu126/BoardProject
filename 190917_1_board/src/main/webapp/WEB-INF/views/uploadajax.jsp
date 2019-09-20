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
<style type="text/css">
	.fileDrop{
		width: 100px;
		height: 100px;
		border: 1px dotted red;
	}
</style>

</head>
<body>
	<div class="fileDrop"></div>
	<div class="uploadedList"></div>
	
	<script type="text/javascript">
		$(document).ready(function(){
			$(".fileDrop").on("dragenter dragover", function(event){
				event.preventDefault();
			});
			$(".fileDrop").on("drop", function(event){
				event.preventDefault();
				
				var arr = event.originalEvent.dataTransfer.files;
				
				for(var idx=0; idx<arr.length;idx++){
					var file = arr[idx];
					
					var formData = new FormData();
					formData.append("file", file);
				
					$.ajax({
						type: 'post',
						url: '/uploadajax',
						data: formData,
						dataType: 'text',
						contentType: false,
						processData: false,
						success: function(data){
							var str = '';
							
							if(checkImageType(data)){
								str += "<img alt='일반파일 썸네일입니다.' src='displayfile?filename="+data+"'/>"
							}else{
								str += "<img alt='일반파일 썸네일입니다.' src='/resources/test.png'/>"
							}
							
							$(".uploadedList").append(str);
						}
					});
				}
			});
		});
		
		function checkImageType(data) {
			var pattern = /jpg|png|jpeg|gif/i;
			return data.match(pattern);
		}
	</script>
</body>
</html>