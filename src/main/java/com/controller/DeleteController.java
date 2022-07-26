package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.TaskDao;

public class DeleteController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int taskId = Integer.parseInt(request.getParameter("taskid"));
		TaskDao taskDao = new TaskDao();

		if (taskDao.deleteTask(taskId)) {
			request.setAttribute("message", "deleted succecfully");

		} else {
			request.setAttribute("message", "some error occurs");
		}

		request.getRequestDispatcher("ListTaskController").forward(request, response);
	}

}
