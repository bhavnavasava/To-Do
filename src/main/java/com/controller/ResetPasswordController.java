package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserBean;
import com.dao.UserDao;

public class ResetPasswordController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserBean user = new UserBean();
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("newpassword"));
		//user.setUserId(Integer.parseInt(request.getParameter("userId")));

		UserDao userDao = new UserDao();
		if (userDao.updatePassword(user)) {
			request.setAttribute("message", "Updated Successfully");
		} else {
			request.setAttribute("message", "<font color='blue'>Some error occured");
		}
		request.getRequestDispatcher("LoginController").forward(request, response);
	}

}
