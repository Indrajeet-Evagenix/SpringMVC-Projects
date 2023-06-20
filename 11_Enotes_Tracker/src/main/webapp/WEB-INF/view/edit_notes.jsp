<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Notes</title>
<%@include file="/WEB-INF/resources/component/all_link.jsp"%>
</head>
<body style="background-color: #f0f0f0;">
	<%@include file="/WEB-INF/resources/component/navbar.jsp"%>
	<div class="container mt-5">
		<div class="row">
			<div class="col-md-10 offset-md-1">
				<div class="card">
					<div class="card-header text-center">
						<h3>Edit Your Notes</h3>
					</div>
					<div class="card-body">
						<form action="updateNotes" method="post">
							<div class="mb-3">
								<label>Enter Title</label> <input type="text"
									value="${notes.title }" name="title" class="form-control">
							</div>
							<div class="mb-3">
								<label>Enter Description</label>
								<textarea rows="6" cols="" name="description"
									class="form-control">${notes.description }</textarea>
							</div>

							<input type="hidden" name="id" value="${notes.id }">
							<button class="btn btn-primary mt-3">Update</button>

						</form>
					</div>
				</div>
			</div>
		</div>
	</div>


</body>
</html>