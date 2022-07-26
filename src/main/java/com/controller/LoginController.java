package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.UserBean;
import com.dao.UserDao;

public class LoginController extends HttpServlet {
	@Override
	public void init(ServletConfig config) {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.sendRedirect("Home.jsp");

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		UserDao userDao = new UserDao();
		UserBean users = userDao.login(email, password);

		RequestDispatcher rd = null;
		if (users == null) {
			request.setAttribute("errorMsg", "Invalid credentials");
			rd = request.getRequestDispatcher("Login.jsp");

		} else {

			/*
			 * HttpSession session = request.getSession(); session.setAttribute("userid",
			 * users.getUserId()); rd = request.getRequestDispatcher("Home.jsp");
			 */
			/*
			 * if (users.getUserType().equals("customer")) { rd =
			 * request.getRequestDispatcher("Home.jsp"); } else if
			 * (users.getUserType().equals("admin")) { rd =
			 * request.getRequestDispatcher("Dashboard.jsp"); } else { rd =
			 * request.getRequestDispatcher("404.jsp"); }
			 */
			if (users.getIsActive()==(1)) {
				HttpSession session = request.getSession(true);
				session.setAttribute("userid", users.getUserId());
				rd = request.getRequestDispatcher("Home.jsp");
			}else if(users.getIsActive()==0) {
				request.setAttribute("error", "You Have Disable your account ");
				rd = request.getRequestDispatcher("Login.jsp");
			}else {
				request.setAttribute("error", "SomeThing Went Wrong ");
				rd = request.getRequestDispatcher("Login.jsp");
			}			
		}
		rd.forward(request, response);
	}
	@Override
	public void destroy() {

	}

}
