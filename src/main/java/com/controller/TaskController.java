package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.TaskBean;
import com.dao.TaskDao;

public class TaskController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		TaskDao taskDao = new TaskDao();

		HttpSession session = request.getSession();
		int userId = (Integer) session.getAttribute("userid");
		ArrayList<TaskBean> tasks = taskDao.getAllTasks(userId);
		request.setAttribute("tasks", tasks);
		//response.sendRedirect("ListTasks.jsp");
		  RequestDispatcher rd = request.getRequestDispatcher("ListTasks.jsp");
		  rd.forward(request, response);
		  		 
	}

}
