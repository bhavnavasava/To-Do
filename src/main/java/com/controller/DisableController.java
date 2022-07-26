package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;

public class DisableController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		int userId = (int) session.getAttribute("userid");

		UserDao userdao = new UserDao();
				
		int records = userdao.disableUser(userId);
		RequestDispatcher rd = null;
		if (records == 1) {
			request.setAttribute("message", "Successfully Disable");
			session.invalidate();
			rd = request.getRequestDispatcher("Login.jsp");
		} else {
			request.setAttribute("message", "SomeThing went Wrong");
			session.invalidate();
			rd = request.getRequestDispatcher("Home.jsp");
		}
		rd.forward(request, response);
	}
}
