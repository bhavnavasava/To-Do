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

public class ForgotPasswordFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		boolean isError = false;

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		int question = Integer.parseInt(request.getParameter("question"));
		String qAnswer = request.getParameter("qanswer");

		System.out.println(email);

		if (email == null || email.trim().length() == 0) {
			isError = true;
			request.setAttribute("emailError", "<font color='red'>Please Enter email</font>");
		} else {
			request.setAttribute("emailValue", email);
		}
		if (question == 0) {
			isError = true;
			request.setAttribute("questionError", "Please enter question ");
		}

		if (qAnswer == null || qAnswer.trim().length() == 0) {
			isError = true;
			request.setAttribute("qAnswerError", "Please enter question Answer ");
		}

		RequestDispatcher rd = null;
		if (isError == true) {
			rd = request.getRequestDispatcher("ForgotPassword.jsp");

		} else {

			chain.doFilter(request, response);
		}
		rd.forward(request, response);

	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

}
