package Final;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;

public class Customer extends User {
	
	public static Connection connection;
	
	public String name;
	public int checking;
	public int savings;
	
	public Customer(String name, int checking, int savings) {
		this.name = name;
		this.checking = checking;
		this.savings = savings;
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