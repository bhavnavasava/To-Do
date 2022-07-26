package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.TaskBean;
import com.bean.UserBean;
import com.dao.TaskDao;
import com.dao.UserDao;

public class UpdateTaskController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		TaskBean task = new TaskBean();
		task.setTask(request.getParameter("task"));
		task.setTaskId(Integer.parseInt(request.getParameter("taskid")));
		task.setDescription(request.getParameter("description"));
		task.setDate(request.getParameter("date"));
		task.setPriority(Integer.parseInt(request.getParameter("priority")));
		task.setStatus(request.getParameter("status"));

		TaskDao taskDao = new TaskDao();
		if (taskDao.updateTask(task)) {
			request.setAttribute("message", "Updated Successfully");
		} else {
			request.setAttribute("message", "<font color='blue'>Some error occured");
		}
		request.getRequestDispatcher("ListTaskController").forward(request, response);

	}
}
