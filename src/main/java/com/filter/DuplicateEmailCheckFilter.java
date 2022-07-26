package com.filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.bean.UserBean;
import com.dao.UserDao;

public class DuplicateEmailCheckFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		String qanswer=request.getParameter("qanswer");
		int question=Integer.parseInt(request.getParameter("question"));
		String usertype = request.getParameter("usertype");
		String isactive=request.getParameter("isactive");
		//String gmail=request.getParameter("email");
		UserDao userDao=new UserDao();
		
		Boolean d1=userDao.checkGmailDuplication(email);
		if(d1==true)
		{
			System.out.println("duplicate email true");
			request.setAttribute("email", "Duplicate email not valid");
			request.getRequestDispatcher("Signup.jsp").forward(request, response);
		}
		else {
			
			System.out.println("duplicate email false");
			
			UserBean userBean = new UserBean();
			userBean.setFirstName(firstName);
			userBean.setLastName(lastName);
			userBean.setEmail(email);
			userBean.setPassword(password);
			userBean.setQuestion(question);
			userBean.setGender(gender);
			userBean.setqAnswer(qanswer);
			userBean.setUserType("customer");
			userBean.setIsActive(1);
			
			
			//userDao.withoutDuplicateGmailInsert(userBean);
			userDao.insertUser(userBean);
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

}
