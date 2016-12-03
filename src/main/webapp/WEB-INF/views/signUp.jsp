<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
     href="${pageContext.request.contextPath}/resources/css/main.css">
<title>Insert title here</title>
</head>
<body>
<h1>2017년도 1학기 예비 수강 신청</h1>
<h3>이것은 진짜 수강 신청이 아니므로 과목명만 정확하게 입력하시고 다른 부분의 입력값은 잘못입력해도 상관 없습니다.

</h3>



<form method="get" action="${pageContext.request.contextPath}/doResister">
	
		<table class="formtable" type="text/css">
			<tr>
				<td class="lable">Year:</td>
				<td><input class="control" name="year" type="text" /></td>
			</tr>
			<tr>
				<td class="lable">Semester:</td>
				<td><input class="control" name="semester" type="text" /></td>
			</tr>
			<tr>
				<td class="lable">Code:</td>
				<td><input class="control" name="code" type="text" /></td>
			</tr>
			<tr>
				<td class="lable">Subject:</td>
				<td><input class="control" name="subject" type="text" /></td>
			</tr>
			<tr>
				<td class="lable">Section:</td>
				<td><input class="control" name="section" type="text" /></td>
			</tr>
			<tr>
				<td class="lable">Credit:</td>
				<td><input class="control" name="credit" type="text" /></td>
			</tr>
			<tr>
				<td class="lable"></td>
				<td><input class="control" value="Register" type="submit" /></td>
			</tr>
		</table>
	</form>
		<a href="${pageContext.request.contextPath}">go to main page</a>
	
</body>
</html>