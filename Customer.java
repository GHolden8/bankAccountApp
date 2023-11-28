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
		}catch(Exception e) {
			
		}
	}
	
	public static void login(String username, String password) {
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery("select password from bank_accounts where username = \"" + username + "\"");

			while(result.next()) {
				if (result.getString("password").equals(password)) {
					setCurrentUser(username);
					Account window = new Account();
					window.frame.setVisible(true);
				}
				else {
					errorInfo = "Unable to login";
					LoginError window = new LoginError();
		  			window.frame.setVisible(true);  
				}
			}

		}catch(Exception e) {
			errorInfo = "Unable to login";
			LoginError window = new LoginError();
  			window.frame.setVisible(true);
		}
	}
	
	public static void add(String firstName, String lastName, String username, String password) {
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate("insert into bank_accounts (firstName, lastName, username, password, checking, savings) "
					+ "values ( '" + firstName + "', '" + lastName + "', '" + username + "', '" + password + "', " + 0 + ", " + 0 + ")");
			
		}catch(Exception e) {
			System.out.println("Exception " + e.getMessage());
		}
	}
	
	public static int getChecking(String username) {
		
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery("select checking from bank_accounts where username = \"" + username + "\"");

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
	            AccountError window = new AccountError();
	  			window.frame.setVisible(true);  
			}
			else {
				newAmount = getChecking(username) - amount;
			
				try {
					Statement statement = connection.createStatement();	
					statement.executeUpdate("update bank_accounts set " + account + " = " + newAmount + " where username = \"" + username + "\"");
					Withdraw.frmWithdraw.dispose();
					Account window = new Account();
					window.frame.setVisible(true);

				}catch(Exception e) {
					System.out.println("Exception " + e.getMessage());
				}
			}
		}
		else {
			if(amount > getSavings(username)) {
				errorInfo = "Unable to withdraw amount from savings account";
				Withdraw.frmWithdraw.dispose(); 
	            AccountError window = new AccountError();
	  			window.frame.setVisible(true);  
			}
			else {
				newAmount = getSavings(username) - amount;
			
				try {
					Statement statement = connection.createStatement();	
					statement.executeUpdate("update bank_accounts set " + account + " = " + newAmount + " where username = \"" + username + "\"");
					Withdraw.frmWithdraw.dispose();
					Account window = new Account();
					window.frame.setVisible(true);

				}catch(Exception e) {
					System.out.println("Exception " + e.getMessage());
				}
			}
		}
		
	}
	
	public static void transfer(String username, String from, String into, int amount) {
		
		int newAmount1;
		int	newAmount2;
		
		if(from.equals("Checking") && into.equals("Savings")) {
			if(amount > getChecking(username)) {
				errorInfo = "Unable to transfer amount from checking account";
				Transfer.frmTransfer.dispose(); 
	            AccountError window = new AccountError();
	  			window.frame.setVisible(true);  
			}
			else {
				newAmount1 = getChecking(username) - amount;
				newAmount2 = getSavings(username) + amount;
			
				try {
					Statement statement = connection.createStatement();	
					statement.executeUpdate("update bank_accounts set " + from + " = " + newAmount1 + " where username = \"" + username + "\"");
					statement.executeUpdate("update bank_accounts set " + into + " = " + newAmount2 + " where username = \"" + username + "\"");
					Transfer.frmTransfer.dispose();
					Account window = new Account();
					window.frame.setVisible(true);

				}catch(Exception e) {
					System.out.println("Exception " + e.getMessage());
				}
			}
		}
		else if (from.equals("Savings") && into.equals("Checking")){
			if(amount > getSavings(username)) {
				errorInfo = "Unable to transfer amount from savings account";
				Transfer.frmTransfer.dispose(); 
	            AccountError window = new AccountError();
	  			window.frame.setVisible(true);  
			}
			else {
				newAmount1 = getSavings(username) - amount;
				newAmount2 = getChecking(username) + amount;
			
				try {
					Statement statement = connection.createStatement();	
					statement.executeUpdate("update bank_accounts set " + from + " = " + newAmount1 + " where username = \"" + username + "\"");
					statement.executeUpdate("update bank_accounts set " + into + " = " + newAmount2 + " where username = \"" + username + "\"");
					Transfer.frmTransfer.dispose();
					Account window = new Account();
					window.frame.setVisible(true);

				}catch(Exception e) {
					System.out.println("Exception " + e.getMessage());
				}
			}
		}
		else {
			Transfer.frmTransfer.dispose();
			Account window = new Account();
			window.frame.setVisible(true);
		}
	}
}
