<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/check_input.js"></script>
<link rel="stylesheet" href="style/styles.css">
<link rel="stylesheet" href="style/advanced_search.css">
<title>Homepage</title>
</head>
<body>
	<%@ include file="header.jsp"%>

	<div class="main">
		<form class="search_form" action="advanced_search" method="get">
			<div>
				<div>Agency:</div>
				<input type="text" id="agency" name="agency" placeholder="search for agency">
			</div>
			<div>
				<div>Headline:</div>
				<input type="text" id="headline" name="headline" placeholder="search for headline">
			</div>
			<div>
				<div>Date:</div>
				<input type="text" id="date" name="date" placeholder="search for date (example: 2012-10-20)">
			</div>
			<div>
				<div>City:</div>
				<input type="text" id="city" name="city" placeholder="search for city">
			</div>
			<div>
				<div>Content:</div>
				<input id="content_seasrch" type="text" name="content" placeholder="search for content">
				<select name="selection">
				  <option value="keyword">Keyword</option>
				  <option value="people">People</option>
				  <option value="organization">Organization</option>
				  <option value="location">Location</option>
				</select>
			</div>
			<div>
				<div class="adcanced_search_button"><input type="submit" value="Search" onclick="return isEveryInputEmpty();"></div>
			</div>
		</form>
	</div>

	<%@ include file="footer.jsp"%>
</body>
</html>