<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<link id="vendorsbundle" rel="stylesheet" media="screen, print"
	href="css/vendors.bundle.css">
<meta charset="ISO-8859-1">
<title>Add task</title>
</head>
<body>


	<form class="form-horizontal" role="form" action="AddTaskController"
		method="post">
		<h2>Add Task</h2>
		<div class="container-fluid">
			<div class="form-group">
				<div class="col-sm-4"></div>


				<div class="form-group">
					<label for="firstName" class="col-sm-3 control-label">Task</label>
					<div class="col-sm-4">
						<input type="text" id="Task" placeholder="Task"
							class="form-control" name="task" autofocus> <span
							class="help-block"> ${firstNameError}</span>
					</div>
				</div>

				<div class="form-group">
					<label for="firstName" class="col-sm-3 control-label">Date</label>
					<div class="col-sm-4">
						<input type="date" id="Date" placeholder="Date"
							class="form-control" name="date" autofocus> <span
							class="help-block"></span>
					</div>
				</div>
				<div class="form-group">
					<label for="firstName" class="col-sm-3 control-label">Description</label>
					<div class="col-sm-4">
						<input type="text" id="Date" placeholder="Decription"
							class="form-control" name="description" autofocus> <span
							class="help-block"></span>
					</div>
				</div>
				<div class="form-group">
					<label for="Status" class="col-sm-3 control-label">Status</label>
					<div class="col-sm-4">
						<select name="status"><br>
							<option name="status" value="pending">Pending</option>
							<option name="status" value="completed">Completed</option>
						</select><br> <span class="help-block">${statusError}</span>
					</div>
				</div>
				<div class="form-group">
					<label for="email" class="col-sm-3 control-label">Priority</label>
					<div class="col-sm-5	">
						<select name="priority">
							<option value="1">high</option>
							<option value="2">medium</option>
							<option value="3">low</option>

						</select><br> <span class="help-block">${statusError}</span>
					</div>
				</div>
				<!-- Example single danger button -->


				<button type="submit" class="btn btn-default btn-success">Submit</button>
			</div>
		</div>
	</form>
	<script type="text/javascript">
		$('#myCollapse').on('shown.bs.collapse', function(e) {
			// Action to execute once the collapsible area is expanded
		})
	</script>


</body>
</html>