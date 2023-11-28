package Final;

import java.sql.*;

public class Customer {
	
	public static Connection connection;
	public static String user;
	public static String errorInfo;
	
	public static void  setCurrentUser(String username) {
		user = username;
	}
	
	public static String getCurrentUser() {
		return user;
	}
	
	public static String getErrorInfo() {
		return errorInfo;
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
					setCurrentUser(username);
					Account window = new Account();
					window.frame.setVisible(true);
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
	
	public static int getChecking(String username) {
		
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
	
	public static int getSavings(String username) {
		
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
	
	public static void deposit(String username, String account, int amount) {
		
		int newAmount;
		
		if(account.equals("Checking"))
			newAmount = getChecking(username) + amount;
		else
			newAmount = getSavings(username) + amount;
				
		try {
			Statement statement = connection.createStatement();	
			System.out.println("update bank_accounts set " + account + " = " + newAmount + " where username = \"" + username + "\"");
			statement.executeUpdate("update bank_accounts set " + account + " = " + newAmount + " where username = \"" + username + "\"");

		}catch(Exception e) {
			System.out.println("Exception " + e.getMessage());
		}
	}
	
	public static void withdraw(String username, String account, int amount) {
		
		int newAmount;
		
		if(account.equals("Checking")) {
			if(amount > getChecking(username)) {
				errorInfo = "Unable to withdraw amount from checking account";
				Withdraw.frmWithdraw.dispose(); 
	            ErrorMessage window = new ErrorMessage();
	            Customer.connection();
	  			window.frame.setVisible(true);  
			}
			newAmount = getChecking(username) - amount;
		}
		else {
			if(amount > getSavings(username))
				errorInfo = "Unable to withdraw amount from savings account";
			newAmount = getSavings(username) - amount;
		}
		
		
		try {
			Statement statement = connection.createStatement();	
			System.out.println("update bank_accounts set " + account + " = " + newAmount + " where username = \"" + username + "\"");
			statement.executeUpdate("update bank_accounts set " + account + " = " + newAmount + " where username = \"" + username + "\"");

		}catch(Exception e) {
			System.out.println("Exception " + e.getMessage());
		}
	}
}
