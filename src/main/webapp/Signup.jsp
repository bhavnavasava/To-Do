<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign up</title>
</head>
<body>
<form action="SignupController" method="post">
		FirstName: <input type="text" name="firstName"><br>${firstNameError}<br><br> 		
		LastName: <input type="text" name="lastName"><br>${lastNameError}<br><br> 		
		Email: <input type="text" name="email"><br>${emailError}<br><br>
		Password:<input type="password" name="password"><br>${passwordError}<br><br>
		Gender:<input type="radio" name="gender" value="Male">Male
				<input type="radio" name="gender" value="Female">Female
				${genderError}<br><br>
		<input type="submit" value="signup">
	</form>

</body>
</html> --%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SignUp</title>
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
	String genderError = (String) request.getAttribute("genderError");
	String genderValue = (String) request.getAttribute("genderValue");
	%>

	<div class="container">
		<form class="form-horizontal" role="form" action="SignupController"
			method="post">
			<h2>SignUp Form</h2>
			<div class="form-group">
				<label for="firstName" class="col-sm-3 control-label">First
					Name</label>
				<div class="col-sm-9">
					<input type="text" id="firstName" placeholder="FirstName"
						class="form-control" name="firstName" autofocus
						value="${firstNameValue}"> <span class="help-block">
						${firstNameError}</span>
				</div>
			</div>
			<div class="form-group">
				<label for="firstName" class="col-sm-3 control-label">Last
					Name</label>
				<div class="col-sm-9">
					<input type="text" id="lastName" placeholder="LastName"
						class="form-control" name="lastName" autofocus
						value="${lastNameValue}"> <span class="help-block">${lastNameError}</span>
				</div>
			</div>
			<div class="form-group">
				<label for="email" class="col-sm-3 control-label">Email</label>
				<div class="col-sm-9">
					<input type="email" id="email" name="email" placeholder="Email"
						class="form-control" value="${emailValue}"><%=emailError == null ? "" : emailError%>
				</div>
			</div>
			<div class="form-group">
				<label for="password" class="col-sm-3 control-label">Password</label>
				<div class="col-sm-9">
					<input type="password" id="password" placeholder="Password"
						name="password" class="form-control" value="${passwordValue}">
					<span class="help-block">${passwordError}</span>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-3">Gender</label>
				<div class="col-sm-6">
					<div class="row">
						<div class="col-sm-4">
							<label class="radio-inline"> <input type="radio"
								id="femaleRadio" value="Female" name="gender"
								<%=genderValue != null && genderValue.equals("female") ? "checked" : ""%>>Female
							</label>
						</div>
						<div class="col-sm-4">
							<label class="radio-inline"> <input type="radio"
								id="maleRadio" value="Male" name="gender"
								<%=genderValue != null && genderValue.equals("male") ? "checked" : ""%>>Male
							</label>
						</div>

					</div>
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
					<button type="submit" value="signup"
						class="btn btn-primary btn-block">Register</button>
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-9 col-sm-offset-3">
					<a href="Login.jsp 	" class="pull-right btn btn-block btn-danger">Already
						Registered ?? </a>
				</div>
			</div>${email}

		</form>
	</div>
</body>
</html>