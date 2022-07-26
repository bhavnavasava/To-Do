package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bean.TaskBean;
import com.bean.UserBean;
import com.util.DbConnection;

public class TaskDao {

	public void insertTasks(TaskBean taskBean) {

		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement(
					"insert into tasks (task,description,date,status,priority,userid) values (?,?,?,?,?,?)");

			pstmt.setString(1, taskBean.getTask());
			pstmt.setString(2, taskBean.getDescription());
			pstmt.setString(3, taskBean.getDate());
			pstmt.setString(4, taskBean.getStatus());
			pstmt.setInt(5, taskBean.getPriority());
			pstmt.setInt(6, taskBean.getUserid());

			int records = pstmt.executeUpdate();

			System.out.println(records + " inserted...........");
		} catch (Exception e) {
			System.out.println("SMW in insertTask() ");
			e.printStackTrace();
		}
	}

	public ArrayList<TaskBean> getAllTasks(int userId) {

		ArrayList<TaskBean> tasks = new ArrayList<TaskBean>();
		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from tasks where userid=?");
			pstmt.setInt(1, userId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int taskId = rs.getInt("taskid");
				String task = rs.getString("task");
				String description = rs.getString("description");
				String date = rs.getString("date");
				String status = rs.getString("status");
				int priority = rs.getInt("priority");

				TaskBean task1 = new TaskBean();
				task1.setTaskId(taskId);
				task1.setTask(task);
				task1.setDescription(description);
				task1.setDate(date);
				task1.setPriority(priority);
				task1.setStatus(status);
				tasks.add(task1);
			}

		} catch (Exception e) {
			System.out.println("SMW in UserDAO::getAllTasks()");
			e.printStackTrace();
		}
		return tasks;

	}

	public void addToTask(TaskBean task) {
		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement(
					"insert into tasks(task,description,date,priority,status,userid) values(?,?,?,?,?,?)");
			pstmt.setString(1, task.getTask());
			pstmt.setString(2, task.getDescription());
			pstmt.setString(3, task.getDate());
			pstmt.setInt(4, task.getPriority());
			pstmt.setString(5, task.getStatus());
			pstmt.setInt(6, task.getUserid());

			int records = pstmt.executeUpdate();

			System.out.println(records + " inserted...........");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean deleteTask(int taskId) {
		boolean flag = false;
		try (Connection con = DbConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement("delete from tasks where taskid=?");) {
			pstmt.setInt(1, taskId);
			int deleteRows = pstmt.executeUpdate();

			if (deleteRows == 1) {
				flag = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
	}

	public boolean updateTask(TaskBean task) {
		boolean flag = false;
		try (Connection con = DbConnection.getConnection();
				PreparedStatement psmt = con.prepareStatement(
						"update tasks set task = ?, description=?,date=?,priority=? ,status=? where taskid=?");) {
			psmt.setString(1, task.getTask());
			psmt.setString(2, task.getDescription());
			psmt.setString(3, task.getDate());
			psmt.setInt(4, task.getPriority());
			psmt.setString(5, task.getStatus());
			psmt.setInt(6, task.getTaskId());

			int updateCount = psmt.executeUpdate();
			if (updateCount == 1) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
	}

	public TaskBean getTaskById(int taskId) {
		TaskBean task = null;
		try (Connection con = DbConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement("select * from tasks where taskid=?");

		) {
			pstmt.setInt(1, taskId);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				task = new TaskBean();
				task.setTask(rs.getString("task"));
				task.setDescription(rs.getString("description"));
				task.setPriority(rs.getInt("priority"));
				task.setStatus(rs.getString("status"));

				task.setTaskId(taskId);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return task;
	}

	public ArrayList<TaskBean> taskList(int userId) {

		return null;
	}
}
