package Final;

public class Customer extends User {
	
	public int checking;
	public int savings;
	
	public Customer(String name, int checking, int savings) {
		this.name = name;
		this.checking = checking;
		this.savings = savings;
	}
	
	public int getChecking() {
		return this.checking;
		
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery("select checking from bank_accounts where username = \"" + username + "\"");
			System.out.println("select checking from bank_accounts where username = \"" + username + "\"");

			while(result.next()) {
				return result;
			}

		}catch(Exception e) {
			System.out.println("Exception " + e.getMessage());
		}
	}
	
	public int getSavings() {
		return this.savings;
		
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery("select savings from bank_accounts where username = \"" + username + "\"");
			System.out.println("select savings from bank_accounts where username = \"" + username + "\"");

			while(result.next()) {
				return result;
			}

		}catch(Exception e) {
			System.out.println("Exception " + e.getMessage());
		}
	}
	
	

}
