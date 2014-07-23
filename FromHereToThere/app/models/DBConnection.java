package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	static String url = "jdbc:mysql://localhost:3306/travel_management";
	static String user = "user";
	static String pass = "pass";
	private static Connection connection;

	public static Connection getConnection() {
		if (connection == null) {
			try {
				return connection = DriverManager
						.getConnection(url, user, pass);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return connection;

	}

}
