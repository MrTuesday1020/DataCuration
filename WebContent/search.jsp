<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="style/styles.css">
<link rel="stylesheet" href="style/search.css">
<title>Search</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="main">
		<form class="search_form" action="search" method="get">
			<div class="basic_search">
					<input type="text" name="keyword" placeholder="agency, headline, date, city or content etc." required>
				<div class="search_button">
					<input type="submit" value="Search">
					<a class="advanced_search" href="advanced_search.jsp">Advanced Search</a>
				</div>
			</div>
		</form>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>