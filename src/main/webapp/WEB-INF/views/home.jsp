<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<p><a href="${pageContext.request.contextPath}/termCredit">1.학기별 이수 학점 조회</a>
<p><a href="${pageContext.request.contextPath}/categoryCredit">2.이수 구분별 학점 조회</a>
<p><a href="${pageContext.request.contextPath}/signUp">3.수강 신청</a>
<p><a href="${pageContext.request.contextPath}/checkSignUpResult">4.수강 신청 조회 </a>
</body>
</html>
