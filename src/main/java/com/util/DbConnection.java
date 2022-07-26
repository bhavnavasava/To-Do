package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	static String driver = "org.postgresql.Driver";
	static String url = "jdbc:postgresql://localhost:5432/task-project";
	static String userName = "postgres";
	static String password = "12345678";

	public static Connection getConnection() {
		// object

		try {
			// driver load
			Class.forName(driver);

			Connection con = DriverManager.getConnection(url, userName, password);

			if (con != null) {
			}
			return con;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
