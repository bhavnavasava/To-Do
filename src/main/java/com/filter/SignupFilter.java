package com.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.bean.UserBean;
import com.dao.UserDao;

public class SignupFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("doFilter From SignupFilter");
		boolean isError = false;
		String firstName = request.getParameter("firstName");
		String lastName =request.getParameter("lastName");
		int question=Integer.parseInt(request.getParameter("question"));
		String qAnswer=request.getParameter("qanswer");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		//int isActive=Integer.parseInt(request.getParameter("isactive"));
		
		if (firstName == null || firstName.trim().length() == 0) {
			isError = true;
			request.setAttribute("firstNameError", "Please enter FirstName");
		}
		if (lastName == null || lastName.trim().length() == 0) {
			isError = true;
			request.setAttribute("lastNameError", "Please enter lastName");
		}
		if (email == null || email.trim().length() == 0) {
			isError = true;
			request.setAttribute("emailError", "Please enter email");
		}
		if (password == null || password.trim().length() == 0) {
			isError = true;
			request.setAttribute("passwordError", "Please enter password");
		}
		if (gender == null || gender.trim().length() == 0) {
			isError = true;
			request.setAttribute("genderError", "Please enter gender ");
		}
		if (question == 0 ) {
			isError = true;
			request.setAttribute("questionError", "Please enter question ");
		}
		
		  if (qAnswer == null || qAnswer.trim().length() == 0) {
		   isError = true;
		  request.setAttribute("qAnswerError", "Please enter question Answer "); }
		 
		 RequestDispatcher rd = null;

		 if (isError) { 
			  request.getRequestDispatcher("Signup.jsp").forward(request, response);
			  
			  } else {
			  
			  UserDao userDao = new UserDao();		  
			  UserBean userBean = new UserBean();		  
			  userBean.setFirstName(firstName); 
			  userBean.setLastName(lastName);
			  userBean.setEmail(email); 
			  userBean.setPassword(password);
			  userBean.setGender(gender);
			  userBean.setUserType("customer");
			  userBean.setQuestion(question);
			  userBean.setqAnswer(qAnswer);
			  userBean.setIsActive(1);
			  			  
			  userDao.insertUser(userBean); 
			  rd = request.getRequestDispatcher("Login.jsp");
			  rd.forward(request, response);
			  } 
			 
		if (isError) {
			request.getRequestDispatcher("Signup.jsp").forward(request, response);
		} else {

			chain.doFilter(request, response); 
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

}
