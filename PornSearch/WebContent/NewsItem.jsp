<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NewsItem</title>
<style>
body {
	background-image: linear-gradient(rgba(0, 0, 0, 0.7), rgba(0, 0, 0, 0.7)),
		url(home.jpg);
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-position: center;
	background-size: cover;
	padding-left: 8%;
	padding-right: 8%;
	box-sizing: border-box;
}

</style>
</head>
<body>
	<%
		String[][] orderList = (String[][]) request.getAttribute("query");
	for (int i = 1; i < orderList.length; i++) {
		if (orderList[i][1] != null) {
	%>
	<a href='http://www.google.com<%=orderList[i][1]%>'><%=orderList[i][0]%></a>
	<br>
	<h1 style="font-size: 5px;"><%=orderList[i][1]%></h1>
	<br>
	<br>
	<%
		}
	}
	%>
</body>
</html>