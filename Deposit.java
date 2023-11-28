package Final;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Deposit {

	JFrame frmDeposit;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Deposit window = new Deposit();
					window.frmDeposit.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Deposit() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDeposit = new JFrame();
		frmDeposit.setTitle("Deposit");
		frmDeposit.setBounds(100, 100, 332, 248);
		frmDeposit.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDeposit.getContentPane().setLayout(null);
		
		String account[]={"Checking","Savings"}; 
		JComboBox comboBox = new JComboBox(account);
		comboBox.setBounds(135, 39, 155, 36);
		frmDeposit.getContentPane().add(comboBox);
		
		JTextArea txt = new JTextArea();
		txt.setBackground(SystemColor.control);
		txt.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txt.setEditable(false);
		txt.setWrapStyleWord(true);
		txt.setText("Choose account\r\nto deposit into");
		txt.setBounds(28, 39, 97, 36);
		frmDeposit.getContentPane().add(txt);
		
		JLabel lblAmount = new JLabel("Enter Amount");
		lblAmount.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAmount.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAmount.setBounds(28, 94, 97, 36);
		frmDeposit.getContentPane().add(lblAmount);
		
		JButton btnDeposit = new JButton("Deposit");
		btnDeposit.setBounds(107, 151, 108, 41);
		frmDeposit.getContentPane().add(btnDeposit);
		btnDeposit.addMouseListener(new MouseAdapter() {
			//@Override
			public void mouseClicked(MouseEvent e) {
				String account = (String) comboBox.getItemAt(comboBox.getSelectedIndex());
				Customer.deposit(Customer.getCurrentUser(), account, Integer.parseInt(textField.getText()));
				frmDeposit.dispose();
				Account window = new Account();
				window.frame.setVisible(true);
			}
		});;
		
		textField = new JTextField();
		textField.setBounds(135, 94, 155, 36);
		frmDeposit.getContentPane().add(textField);
		textField.setColumns(10);
	}
}
