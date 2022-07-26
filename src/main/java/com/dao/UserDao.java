package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bean.UserBean;
import com.util.DbConnection;

public class UserDao {
	public void insertUser(UserBean userBean) {

		try {
			Connection con = DbConnection.getConnection();

			PreparedStatement pstmt = con.prepareStatement(
					"insert into users (firstname,lastname,email,password,gender,usertype,question,qAnswer,isactive) values (?,?,?,?,?,?,?,?,?)");
System.out.println("insertmethod");
			pstmt.setString(1, userBean.getFirstName());
			pstmt.setString(2, userBean.getLastName());
			pstmt.setString(3, userBean.getEmail());
			pstmt.setString(4, userBean.getPassword());
			pstmt.setString(5, userBean.getGender());
			pstmt.setString(6, userBean.getUserType());
			pstmt.setInt(7, userBean.getQuestion());
			pstmt.setString(8, userBean.getqAnswer());
			pstmt.setInt(9, userBean.getIsActive());

			int records = pstmt.executeUpdate();

			System.out.println(records + " inserted...........");
		} catch (Exception e) {
			System.out.println("SMW in insertUser() ");
			e.printStackTrace();
		}

	}

	public UserBean login(String email, String password) {
		UserBean user = null;
		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from users where email = ? and password = ? ");
			pstmt.setString(1, email);
			pstmt.setString(2, password);

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				user = new UserBean();
				user.setUserId(rs.getInt("userid"));
				user.setFirstName(rs.getString("firstname"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setUserType(rs.getString("usertype"));
				user.setIsActive(rs.getInt("isactive"));

			}

		} catch (Exception e) {
			System.out.println("SMW in login Dao ");
			e.printStackTrace();
		}

		return user;
	}

	public UserBean forgot(String email, int question, String qAnswer, String userType) {
		UserBean user = null;
		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con
					.prepareStatement("select * from users where email = ?  and question = ? and qanswer=?");
			pstmt.setString(1, email);
			pstmt.setInt(2, question);
			// pstmt.setString(4, userType);
			pstmt.setString(3, qAnswer);

			System.out.println(pstmt);

			ResultSet rs = pstmt.executeQuery(); // read data on db.

			if (rs.next()) {
				user = new UserBean();
				user.setUserId(rs.getInt("userid"));
				user.setEmail(rs.getString("email"));
				user.setQuestion(rs.getInt("question"));
				user.setqAnswer(rs.getString("qanswer"));
				user.setUserType(rs.getString("usertype"));
			}
		} catch (Exception e) {
			System.out.println("smw in fogot dao");
		}
		return user;

	}

	public boolean updatePassword(UserBean user) {
		boolean flag = false;
		try (Connection con = DbConnection.getConnection();
				PreparedStatement psmt = con.prepareStatement("update users set password=? where email=?");) {

			psmt.setString(1, user.getPassword());
			psmt.setString(2, user.getEmail());
			int updateCount = psmt.executeUpdate();
			if (updateCount == 1) {
				flag = true;
			}
		}

		catch (Exception e) {
			e.printStackTrace(); // TODO: handle exception
		}
		return flag;
	}

	public UserBean getUserByEmail(String email) {
		UserBean user = null;
		try (Connection con = DbConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement("select * from users where email=?");

		) {
			pstmt.setString(1, email);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				user = new UserBean();
				user.setEmail(email);
				user.setPassword(rs.getString("password"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	public int disableUser(int userId) {
		try (Connection con = DbConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement("update users set isactive = ? where userid=?");) {
			pstmt.setInt(1, 0);
			pstmt.setInt(2, userId);
			int records = pstmt.executeUpdate();
			return records;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public boolean checkGmailDuplication(String email) {
		//UserBean user = null;
		try {
			System.out.println(email);
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt=con.prepareStatement("select * from users where email=?");
			pstmt.setString(1, email);
			System.out.println("duplicate method");
			ResultSet rs=pstmt.executeQuery();
			if(rs.next())
			{		
				
				System.out.println("check email duplicate method");
				return true;
			}			
		} catch (Exception e) {
			System.out.println("SBM in checkGmailDuplication");
			e.printStackTrace();
		}
		return false;
	}
}
/*
 * UserBean user = null; try (Connection con = DbConnection.getConnection();
 * PreparedStatement pstmt =
 * con.prepareStatement("select * from users where email=?");
 * 
 * ) { pstmt.setString(1, email); ResultSet rs = pstmt.executeQuery();
 * 
 * while (rs.next()) { user = new UserBean(); user.setEmail(email);
 * user.setPassword(rs.getString("password")); }		
 * 
 * } catch (Exception e) { e.printStackTrace(); } return user;
 * 
 * }
 */
