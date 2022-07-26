package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.TaskBean;
import com.dao.TaskDao;



public class ListTaskController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =request.getSession();
		int userId=(Integer) session.getAttribute("userid");
		System.out.println("userId"+ userId);
		TaskDao taskDao=new TaskDao();
		ArrayList<TaskBean> tasks=taskDao.getAllTasks(userId);
		request.setAttribute("tasks",tasks);
		System.out.println("inserted from task controller"+ tasks);

		request.getRequestDispatcher("TaskController").forward(request, response);
//response.sendRedirect("ListTasks.jsp");
	}

}
