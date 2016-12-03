<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="kr.ac.hansung.dao.CseSubjectDAO" %>
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
<h2>2017년도 1학기 예비 수강 신청 조회</h2>

<table>
  <tr>
     <td>연도</td>  <td>학기</td>  <td>학점</td>  <td>과목</td> <td>구분</td>
     
  </tr>
  <c:forEach var="RegisteredList" items="${RegisteredList}">
  <tr>
     <td>
     <c:out value="${RegisteredList.year}"></c:out>
     </td>
     <td>
     <c:out value="${RegisteredList.semester}"></c:out>
     </td>
     <td>
     <c:out value="${RegisteredList.credit}"></c:out>
     </td>
     <td>
     <c:out value="${RegisteredList.subject}"></c:out>
     </td>
     <td>
     <c:out value="${RegisteredList.section}"></c:out>
     </td>
  </tr>
  </c:forEach>
  
</table>
	<a href="${pageContext.request.contextPath}">go to main page</a>
	


</body>
</html>