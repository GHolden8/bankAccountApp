package Final;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Login implements ActionListener {

	protected String User = "";
	protected String Pass = "";
	JFrame frame;
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
		
		button.addMouseListener(new MouseAdapter() {
			//@Override
			public void mouseClicked(MouseEvent e) {
				Customer.login(User,  Pass);
				frame.dispose();
			}
		});;
		
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
	
	protected static void setup(Login window) {
		Customer.connection();
	}
	public static void main(String[] args) {
		Login window = new Login();
		setup(window);
	}
	public void actionPerformed(ActionEvent e) {
		User = user.getText();
		Pass = pass.getText();
	}

}
