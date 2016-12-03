<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
table, tr, td {
	border: solid 1px gray;
	
}

tr {
	text-align: center;
}
</style>
</head>
<body>
	<h2>학기별 이수 학점 조회</h2>
	<h4>2017년도 1학기 예비 수강 신청한 학점도 포함되어 있습니다.</h4>
	
	  

			<!--<c:out value="${cseSubject}"></c:out>-->
			<table>
			<tr>
			 <td>연도</td>  <td>학기</td>  <td>이수 학점</td>   <td>For more...</td>
			</tr>
			<c:forEach var="term" items="${termCredit}">
			  <tr> 
			   <td><c:out value="${term.year}"></c:out></td> 
			   <td><c:out value="${term.semester}"></c:out></td>
			    <td><c:out value="${term.sumOfCredit}"></c:out></td>
			   <td>
			   <a href="${pageContext.request.contextPath}/termCredit/forMore?year=${term.year}&semester=${term.semester}">
			   Subject List</a>
			   </td>
			  </tr>
			  </c:forEach>
			  
			</table>
			
			<a href="${pageContext.request.contextPath}">go to main page</a>
	
	
</body>
</html>