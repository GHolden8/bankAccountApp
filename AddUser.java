package Final;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddUser{

	JFrame frame;
	private JTextField txt;
	private JTextField txtNewPassword;
	private JTextField txtEnterLastName;
	private JTextField txtEnterFirstName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddUser window = new AddUser();
					Customer.connection();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AddUser() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAddUser = new JLabel("Add User");
		lblAddUser.setBounds(6, 6, 61, 16);
		frame.getContentPane().add(lblAddUser);
		
		txt = new JTextField();
		txt.setText("Enter new username");
		txt.setBounds(119, 146, 175, 26);
		frame.getContentPane().add(txt);
		txt.setColumns(10);
		
		txtNewPassword = new JTextField();
		txtNewPassword.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		txtNewPassword.setText("Enter new password");
		txtNewPassword.setColumns(10);
		txtNewPassword.setBounds(119, 184, 175, 26);
		frame.getContentPane().add(txtNewPassword);
		
		txtEnterLastName = new JTextField();
		txtEnterLastName.setText("Enter last name");
		txtEnterLastName.setColumns(10);
		txtEnterLastName.setBounds(119, 108, 175, 26);
		frame.getContentPane().add(txtEnterLastName);
		
		txtEnterFirstName = new JTextField();
		txtEnterFirstName.setText("Enter first name");
		txtEnterFirstName.setColumns(10);
		txtEnterFirstName.setBounds(119, 70, 175, 26);
		frame.getContentPane().add(txtEnterFirstName);
		
		JButton btnConfirm = new JButton("OK");
		btnConfirm.setBounds(177, 222, 117, 29);
		frame.getContentPane().add(btnConfirm);
		btnConfirm.addMouseListener(new MouseAdapter() {
			//@Override
			public void mouseClicked(MouseEvent e) {
				Customer.add(txtEnterFirstName.getText(), txtEnterLastName.getText(), txt.getText(), txtNewPassword.getText());
			}
		});;
	}
}
