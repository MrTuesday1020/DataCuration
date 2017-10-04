<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="style/styles.css">
<link rel="stylesheet" href="style/home.css">
<title>Homepage</title>
</head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<body>
	<%@ include file="header.jsp"%>

	<div class="main">
		<div class="content">
			<div class="head">You may like these...</div>
			<c:forEach items="${results}" var="result">

				<div class="headline">
					<a href="result_details?index=${result.index}"><c:out value="${result.headline}"></c:out></a>
				</div>
			</c:forEach>
			<div class="numberOfresults">
				<form action="home" method="get">
					<input type="text" name="numberOfresults" placeholder="more pages..."></input>
					<input type="submit" value="show"></input>
				</form>
			</div>
		</div>
		
	</div>

	<%@ include file="footer.jsp"%>
</body>
</html>