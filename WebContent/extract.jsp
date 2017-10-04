<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="style/styles.css">
<link rel="stylesheet" href="style/results.css">
<title>Results</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="main">
		<div class="content">
			<div class="extract_head">Extract Results</div>
			<c:if test="${results != null}">
			<c:forEach items="${results}" var="result">
				<div class="extract_content">
				<c:out value="${result}"></c:out>
				</div>
			</c:forEach>
			</c:if>
			<c:if test="${results == null}">
				<div class="extract_content">
					No results!
				</div>
			</c:if>
		</div>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>