<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Forget Password</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<style type="text/css">
.error {
	color: red;
}

body {
	background-color: #eee;
}

*[role="form"] {
	max-width: 530px;
	padding: 15px;
	margin: 0 auto;
	background-color: #fff;
	border-radius: 0.3em;
}

*[role="form"] h2 {
	margin-left: 5em;
	margin-bottom: 1em;
}
</style>


</head>
<body>
	<%
		String emailError = (String) request.getAttribute("emailError");
			%>
	<div class="container">
		<form class="form-horizontal" role="form" action="ForgotPasswordController"
			method="post">
			<h2>Forget Password</h2>
			
			<div class="form-group">
				<label for="email" class="col-sm-3 control-label">Email</label>
				<div class="col-sm-9">
					<input type="email" id="email" name="email" placeholder="Email"
						class="form-control" value="${email}"><%=emailError == null ? "" : emailError%>
				</div>
			</div>
			<div class="form-group">
				<label for="password" class="col-sm-3 control-label">Security
					Question</label>
				<div class="col-sm-9">
					<select name="question"><br>
						<option name="question" value="1">What was your first
							car?</option>
						<option name="question" value="2">What is the name of
							your first pet?</option>
						<option name="question" value="3">What elementary
							school did you attend?</option>
						<option name="question" value="4">What is the name of
							the town where you were born?</option>
					</select><br><span class="help-block">${questionError}</span>
				</div>
			</div>
			<div class="form-group">
				<label for="qAnswer" class="col-sm-3 control-label">Security
					Answer</label>
				<div class="col-sm-9">
					<input type="text" id="qAnswer" placeholder="qAnswer"
						class="form-control" name="qanswer" autofocus
						value=""> <span class="help-block">${qAnswerError}</span>
				</div>
			</div>
			
			
			<div class="form-group">
				<div class="col-sm-9 col-sm-offset-3">
					<button type="submit" value="SignUp"
						class="btn btn-primary btn-block">Submit</button>
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-9 col-sm-offset-3">
					<a href="Login.jsp 	" class="pull-right btn btn-block btn-danger">Back To Login </a>
				</div>
			</div>
		</form>
	</div>
</body>
</html>