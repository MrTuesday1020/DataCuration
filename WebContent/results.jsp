<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="style/styles.css">
<link rel="stylesheet" href="style/results.css">
<title>Results</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="main">
		<div class="content">
		<c:if test="${results.size() > 0}">
			<c:forEach items="${results}" var="result">
				<div class="headline"><a href="result_details?index=${result.index}"><c:out value="${result.headline}"></c:out></a></div>
			</c:forEach>
		</c:if>
		<c:if test="${results.size() == 0}">
			<div class="noresults">
				Sorry, no matching datasets found!
			</div>
		</c:if>
		</div>
		
		<c:if test="${results.size() != 0}">
		<div class="page">
		<a href="search?keyword=${keyword}&firstIndex=${firstIndex}&lastIndex=${lastIndex}&type=prev">previous</a>
		<a href="search?keyword=${keyword}&firstIndex=${firstIndex}&lastIndex=${lastIndex}&type=next">next</a>
		</div>
		</c:if>
		
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>