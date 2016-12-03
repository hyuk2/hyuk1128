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
<h2>이수 구분별 학점 조회</h2>
<h4>(2017년도 1학기 예비 수강 신청 포함)</h4>

<table>
  <tr>
    <c:forEach var="sectionList" items="${sectionList}">
      <td><c:out value="${sectionList}"></c:out>
    </c:forEach>
    
    <td>총학점
  </tr>
  <tr>
    <c:forEach var="sectionCredit" items="${sectionCredit}">
      <td><c:out value="${sectionCredit}"></c:out>
    </c:forEach>
    <td><c:out value="${sum}"></c:out>
    
  </tr>


</table>

	<a href="${pageContext.request.contextPath}">go to main page</a>
	
</body>
</html>