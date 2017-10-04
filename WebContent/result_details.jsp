<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="style/styles.css">
<link rel="stylesheet" href="style/results.css">
<title>Results</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="main">
		<div class="content">
			<div class="headline">
				<span class="name"><b>Headline</b></span><span>${result.headline}</span>
			</div>
			<div class="headline">
				<span class="name"><b>Agency</b></span><span>${result.agency}</span>
			</div>
			<div class="headline">
				<span class="name"><b>Date</b></span><span>${result.date}</span>
			</div>
			<div class="headline">
				<span class="name"><b>City</b></span><span>${result.city}</span>
			</div>
			<div class="headline">
				<span class="name"><b>Content</b></span><div class="info">${result.content}</div>
			</div>
			
				<div class="extract">
					<a class="extract_button" href="extract?type=keyword&index=${result.index}">Extract Keywords</a>
					<a class="extract_button" href="extract?type=people&index=${result.index}">Extract People</a>
				</div>
				<div class="extract">
					<a class="extract_button" href="extract?type=organization&index=${result.index}">Extract Organizations</a>
					<a class="extract_button" href="extract?type=location&index=${result.index}">Extract Locations</a>
				</div>
		</div>
		
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>