package login;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*; 

public class Login implements ActionListener extends FinalProject{

	protected String User = "";
	protected String Pass = "";
	private JFrame frame;
	private JPanel panel;
	private JButton button;
	JLabel username;
	JLabel password;
	JTextField user;
	JTextField pass;
	
	public Login() {
		frame = new JFrame();
		panel = new JPanel();
		button = new JButton("Login");
		button.addActionListener(this);
		
		
		username = new JLabel("Username: ");
		password = new JLabel("Password: ");
		user = new JTextField(20);
		pass = new JTextField(20);
		

		
		
		panel.setBorder(BorderFactory.createEmptyBorder(80,80,80,80));
		panel.setLayout(new GridLayout(0,1));
		panel.add(username);
		panel.add(user);
		panel.add(password);
		panel.add(pass);
		panel.add(button);
		
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Bank Login");
		frame.pack();
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		new Login();
		FinalProject.connection();


	}
	public void actionPerformed(ActionEvent e) {
		User = user.getText();
		Pass = pass.getText();
		FinalProject.login(User, Pass); 
	}

}
