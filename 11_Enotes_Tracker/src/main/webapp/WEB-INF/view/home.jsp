<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
<%@include file="/WEB-INF/resources/component/all_link.jsp"%>
</head>
<body>
	<%@include file="/WEB-INF/resources/component/navbar.jsp"%>
	<div class="container-fluid p-0 m-0">
		<img alt="Notes_Images"
			src="<c:url value="/resources/img/note.jpg" />" width="100%"
			height="800px">
	</div>

</body>
</html>