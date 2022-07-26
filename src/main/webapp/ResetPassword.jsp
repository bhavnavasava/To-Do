<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reset Password</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


<style type="text/css">
body {
	background-image:
		url(http://www.joburgchiropractor.co.za/images/background.jpg);
}
</style>

</head>
<body>
	<!-- if you want to create login page and register page together in one page ...you have to only chnage his name...that's it...                 -->
	<div class="container" style="margin-top: 5%;">
		<div class="row">
			<div class="col-sm-4"></div>
			<div class="col-md-4">

				<h1 class="text-center text-success">Reset Password</h1>
				<br />

				<div class="col-sm-12">
					<br/>
					<div class="tab-content">
						<div id="home" class="tab-pane fade in active">

							<form action="ResetPasswordController" method="post">

								<div class="form-group">
									<label for="email">Email address:</label> <input type="email"
										class="form-control" id="email" placeholder="email" name="email">
								</div>

								<div class="form-group">
									<label for="pwd">Create New Password:</label> <input type="password"
										class="form-control" id="pwd" placeholder="password" name="newpassword">
								</div>
								<div class="form-group">
									<label for="pwd">Confirm Password:</label> <input type="password"
										class="form-control" id="pwd" placeholder="password" name="confirmpassword">
								</div>
								
								<button type="submit" class="btn btn-default btn-danger"
									value="login">Submit</button>

							</form>
							<br /> <a href="Login.jsp 	"
								class="pull-right btn btn-block btn-primary">Back To Login </a> <span class="text-danger">${errorMsg}</span>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>