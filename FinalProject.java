package Final;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class FinalProject {
	
	public static Connection connection;

	public static void main(String args[]) {
		connection();
		login("wiseai", "password!");	
	}
	
	public static void connection() {
		
		String url = "jdbc:mysql://localhost:3306/finalproject";
		String username = "root";
		String password = "Redvader09!";

		try {
			connection = DriverManager.getConnection(url, username, password);
			System.out.println("Connected");
		}catch(Exception e) {
			System.out.println("Could not connect");
			System.out.println("Exception " + e.getMessage());
		}
	}
	
	public static void login(String username, String password) {
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery("select password from bank_accounts where username = \"" + username + "\"");
			System.out.println("select password from bank_accounts where username = \"" + username + "\"");

			while(result.next()) {
				if (result.getString("password").equals(password)) {
					System.out.println("Login successful");
				}
				else {
					System.out.println("Incorrect Password");
				}
			}

		}catch(Exception e) {
			System.out.println("Exception " + e.getMessage());
		}
	}
}