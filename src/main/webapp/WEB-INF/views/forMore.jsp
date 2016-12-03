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
<table>
  <tr>
     <td>year</td>
      <td>semester</td>  
      <td>subject</td>  
      <td>credit</td>  
      <td>section</td>  
  </tr>
   <c:forEach var="subjectList" items="${subjectList}">
  <tr>
     
     
      <td><c:out value="${subjectList.year}"></c:out></td>
        <td><c:out value="${subjectList.semester}"></c:out></td>
          <td><c:out value="${subjectList.subject}"></c:out></td>
            <td><c:out value="${subjectList.credit}"></c:out></td>
             <td><c:out value="${subjectList.section}"></c:out></td>
      
     
    
  </tr>
  </c:forEach>

</table>

	<p><a href="${pageContext.request.contextPath}">go main page</a></p>
	<p><a href="${pageContext.request.contextPath}/termCredit">학기별 이수 학점 조회로 돌아가기</a></p>
	
	

</body>
</html>