package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.UserBean;
import com.dao.UserDao;

public class ForgotPasswordController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		int question = Integer.parseInt(request.getParameter("question"));
		String qAnswer = request.getParameter("qanswer");
		String userType=request.getParameter("usertype");
		System.out.println(email);
		System.out.println(question);

		UserDao userDao = new UserDao();
		UserBean user = userDao.forgot(email, question, qAnswer,userType);
		System.out.println(user);

		RequestDispatcher rd = null;

		if (user == null) {
			request.setAttribute("errormsg", "Invalid valid data");
			rd = request.getRequestDispatcher("ForgotPassword.jsp");
		} else {
			if (user.getUserType().equals("customer")) {
				request.setAttribute("email", email);
				request.setAttribute("qAnswer", qAnswer);
				request.setAttribute("question", question);
				rd = request.getRequestDispatcher("ResetPassword.jsp");

			} else {
				rd = request.getRequestDispatcher("404.jsp");
			}

		}
		rd.forward(request, response);

	}

}
