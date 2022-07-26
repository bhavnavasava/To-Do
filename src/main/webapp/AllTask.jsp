<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>All Tasks</title>
</head>
<body>
	<table class="display" id="tasks">
		<thead class="thead-dark">
			<tr>
				<th scope="col">UserId</th>
				<th scope="col">Task</th>
				<th scope="col">Description</th>
				<th scope="col">Date</th>
				<th scope="col">Status</th>
				<th scope="col">Priority</th>
				<th scope="col">Action</th>
			</tr>
		</thead>
		<tbody>
		
			<c:forEach items="${tasks}" var="task">
				<tr>
					<td><%=task.getUserid()%></td>
					<td><%=task.getTask()%></td>
					<td><%=task.getDescription()%></td>
					<td><%=task.getDate()%></td>
					<td><%=task.getStatus()%></td>
					<td><%=task.getPriority()%></td>
					<td><a href="DeleteController?taskid=<%=task.getTaskId()%>">Delete</a>
						<a href="UpdateTaskFormController?taskid=<%=task.getTaskId()%>">Update</a></td>

					
				</tr>
				</c:forEach>
		</tbody>

	</table>

	

</body>
</html>