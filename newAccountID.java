package Final;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JButton;

public class NewAccountID extends ConfirmUser {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewAccountID window = new NewAccountID();
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
	public NewAccountID() {
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
		
		JLabel lblAccountID = new JLabel("Your account ID is:");
		lblAccountID.setBounds(139, 78, 129, 16);
		frame.getContentPane().add(lblAccountID);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(139, 106, 118, 16);
		frame.getContentPane().add(textPane);
		
		JButton btnNewButton = new JButton("Exit");
		btnNewButton.setBounds(208, 172, 118, 29);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnGoToAccount = new JButton("Go to Account");
		btnGoToAccount.setBounds(85, 172, 118, 29);
		frame.getContentPane().add(btnGoToAccount);
	}
}
