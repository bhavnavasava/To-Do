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

public class UpdateTaskFormController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	int taskid=Integer.parseInt(request.getParameter("taskid"));
	TaskDao taskDao=new TaskDao();
	TaskBean task=taskDao.getTaskById(taskid);
	
	request.setAttribute("task", task);
	request.getRequestDispatcher("UpdateTask.jsp").forward(request, response);
	}

}