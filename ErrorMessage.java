package Final;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;

public class ErrorMessage {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ErrorMessage window = new ErrorMessage();
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
	public ErrorMessage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 411, 189);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblError = new JLabel("");
		lblError.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		lblError.setBounds(10, 11, 379, 81);
		frame.getContentPane().add(lblError);
		lblError.setText(Customer.getErrorInfo());
		
		JButton btnClose = new JButton("Close");
		btnClose.setBounds(150, 120, 89, 23);
		frame.getContentPane().add(btnClose);
	}

}
