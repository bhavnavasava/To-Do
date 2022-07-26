<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.bean.TaskBean"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Tasks</title>
</head>
<body>
<jsp:include page="UserMenu.jsp"></jsp:include>
	<%
	ArrayList<TaskBean> tasks = (ArrayList<TaskBean>) request.getAttribute("tasks");
	
	%>
	<table class="display" id="task" border="1">
		<thead class="thead-dark">
		
			<tr>
				<th scope="col">Task</th>
				<th scope="col">Description</th>
				<th scope="col">Date</th>
				<th scope="col">Status</th>
				<th scope="col">Priority</th>
				<th scope="col">Action</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (TaskBean task : tasks) {
			%>
			<tr>
				<td><%=task.getTask()%></td>
				<td><%=task.getDescription()%></td>
				<td><%=task.getDate()%></td>
				<td><%=task.getStatus()%></td>
				<td><%=task.getPriority()%></td>
				<td><a href="DeleteController?taskid=<%=task.getTaskId()%>">Delete</a>
					<a href="UpdateTaskFormController?taskid=<%=task.getTaskId()%>">Update</a>
				</td>
				<%
				}
				%>
			</tr>
		</tbody>

	</table>
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-3.5.1.js"></script>
	<script type="text/javascript"
		src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#task').DataTable();
		});
	</script>
   

</body>
</html>