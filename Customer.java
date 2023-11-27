package Final;

import java.sql.*;

public class Customer {
	
	public static Connection connection;
	
	public String name;
	public int checking;
	public int savings;
	
	public Customer(String name, int checking, int savings) {
		this.name = name;
		this.checking = checking;
		this.savings = savings;
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
	
	public static void add(String firstName, String lastName, String username, String password) {
		try {
			Statement statement = connection.createStatement();
			System.out.println("insert into bank_accounts (firstName, lastName, username, password, checking, savings) "
					+ "values ( '" + firstName + "', '" + lastName + "', '" + username + "', '" + password + "', " + 0 + ", " + 0 + ")");
			statement.executeUpdate("insert into bank_accounts (firstName, lastName, username, password, checking, savings) "
					+ "values ( '" + firstName + "', '" + lastName + "', '" + username + "', '" + password + "', " + 0 + ", " + 0 + ")");
			System.out.println("User Created");
			
		}catch(Exception e) {
			System.out.println("Exception " + e.getMessage());
		}
	}
	
	public static void setChecking(String username, int amount) {
		
		try {
			Statement statement = connection.createStatement();	
			System.out.println("update bank_accounts set checking = " + amount + " where username = \"" + username + "\"");
			statement.executeUpdate("update bank_accounts set checking = " + amount + " where username = \"" + username + "\"");

		}catch(Exception e) {
			System.out.println("Exception " + e.getMessage());
		}
	}	

	public static void setSavings(String username, int amount) {
	
		try {
			Statement statement = connection.createStatement();		
			System.out.println("update bank_accounts set savings = " + amount + " where username = \"" + username + "\"");
			statement.executeUpdate("update bank_accounts set savings = " + amount + " where username = \"" + username + "\"");

		}catch(Exception e) {
			System.out.println("Exception " + e.getMessage());
		}
	}	
	
	public int getChecking(String username) {
		
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery("select checking from bank_accounts where username = \"" + username + "\"");
			System.out.println("select checking from bank_accounts where username = \"" + username + "\"");

			while(result.next()) {
				return result.getInt("checking");
			}

		}catch(Exception e) {
			System.out.println("Exception " + e.getMessage());
		}
		
		return 0;
	}
	
	public int getSavings(String username) {
		
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery("select savings from bank_accounts where username = \"" + username + "\"");
			System.out.println("select savings from bank_accounts where username = \"" + username + "\"");

			while(result.next()) {
				return result.getInt("savings");
			}

		}catch(Exception e) {
			System.out.println("Exception " + e.getMessage());
		}
		
		return 0;
	}
	
	

}
