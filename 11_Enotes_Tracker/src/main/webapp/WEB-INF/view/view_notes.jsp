<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Notes Page</title>
<%@include file="/WEB-INF/resources/component/all_link.jsp"%>
</head>
<body>
	<%@include file="/WEB-INF/resources/component/navbar.jsp"%>
	<div class="container-fluid p-2">
		<h4 class="text-center">View All Notes</h4>
		<c:if test="${not empty msg }">
			<p class="fs-5 fw-bold text-success text-center">${msg }</p>
			<c:remove var="msg" />
		</c:if>
		<div class="row">
			<c:forEach items="${list }" var="n">
				<div class="col-md-10 offset-md-1 mt-2">
					<div class="card">
						<div class="card-body">
							<div class="text-center">
								<img alt="Notes_Images2"
									src="<c:url value="/resources/img/noteImages.png" />"
									width="100px" height="100px">
							</div>
							<h5>Title</h5>
							<p>${n.title }</p>
							<h5>Description</h5>
							<p>${n.description }</p>
							<p>Publish Date : ${n.date }</p>
							<div class="text-center">
								<a href="editNotes?id=${n.id }" class="btn btn-primary btn-sm">Edit</a>
								<a href="deleteNotes?id=${n.id }" class="btn btn-danger btn-sm">Delete</a>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
			<%-- <div class="col-md-10 offset-md-1 mt-2">
				<div class="card">
					<div class="card-body">
						<div class="text-center">
							<img alt="Notes_Images2"
								src="<c:url value="/resources/img/noteImages.png" />"
								width="100px" height="100px">
						</div>
						<p>What is Python</p>
						<p>Python is a Programming Language</p>
						<p>Publish Date : 2023-06-18</p>
						<div class="text-center">
							<a href="editNotes" class="btn btn-primary btn-sm">Edit</a> <a
								href="deleteNotes" class="btn btn-danger btn-sm">Delete</a>
						</div>
					</div>
				</div>
			</div> --%>
		</div>
	</div>

</body>
</html>