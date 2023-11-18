package Final;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ConfirmUser extends AddUser {

	private JFrame frame;
	private JTextField txtCheck;
	private JTextField txtEnterSavings;
	private JButton btnConfirm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfirmUser window = new ConfirmUser();
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
	public ConfirmUser() {
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
		
		JLabel lblConfirm = new JLabel("Confirm");
		lblConfirm.setBounds(6, 6, 61, 16);
		frame.getContentPane().add(lblConfirm);
		
		txtCheck = new JTextField();
		txtCheck.setText("Enter Checkings Amount");
		txtCheck.setColumns(10);
		txtCheck.setBounds(118, 80, 175, 26);
		frame.getContentPane().add(txtCheck);
		
		txtEnterSavings = new JTextField();
		txtEnterSavings.setText("Enter Savings Amount");
		txtEnterSavings.setColumns(10);
		txtEnterSavings.setBounds(118, 118, 175, 26);
		frame.getContentPane().add(txtEnterSavings);
		
		btnConfirm = new JButton("OK");
		btnConfirm.setBounds(176, 156, 117, 29);
		frame.getContentPane().add(btnConfirm);
		btnConfirm.addMouseListener(new MouseAdapter() {
			//@Override
			public void mouseClicked(MouseEvent e) {
				Customer.setChecking("therock", Integer.parseInt(txtCheck.getText()));
				Customer.setSavings("therock", Integer.parseInt(txtEnterSavings.getText()));
			}
		});;
	}

}