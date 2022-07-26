package com.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.TaskBean;
import com.dao.TaskDao;

public class AddTaskController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	
		  HttpSession session = request.getSession(); 
		  int userId = (Integer)session.getAttribute("userid");
		 /*  
		 /* TaskBean task = new TaskBean(); task.setUserid(userId);
		 * 
		 * TaskDao taskDao = new TaskDao(); taskDao.addToTask(task);
		 * 
		 * RequestDispatcher rd = request.getRequestDispatcher("Task.jsp");
		 * 
		 * rd.forward(request, response);
		 */
		String task=request.getParameter("task");
		String description=request.getParameter("description");
		String date=request.getParameter("date");
		int priority= Integer.parseInt( request.getParameter("priority"));
		String status=request.getParameter("status");
		//int userId=Integer.parseInt(request.getParameter("userid"));

		TaskDao taskDao = new TaskDao();
			
			TaskBean taskBean = new TaskBean();
			taskBean.setTask(task);
			taskBean.setDate(date);
			taskBean.setDescription(description);
			taskBean.setStatus(status);
			taskBean.setPriority(priority);
			taskBean.setUserid(userId);
			
			System.out.println(taskBean);
			System.out.println("inserted.form addcontroller");
			taskDao.addToTask(taskBean);			
			response.sendRedirect("TaskController");
	}
	//rd.forward(request, response);
	
	}

