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
import javax.swing.DefaultComboBoxModel;

public class Transfer {

	static JFrame frmTransfer;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Transfer window = new Transfer();
					window.frmTransfer.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Transfer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTransfer = new JFrame();
		frmTransfer.setTitle("Deposit");
		frmTransfer.setBounds(100, 100, 350, 350);
		frmTransfer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTransfer.getContentPane().setLayout(null);
		
		String accountFrom[]={"Checking","Savings"}; 
		JComboBox comboBoxFrom = new JComboBox(accountFrom);
		comboBoxFrom.setBounds(135, 39, 155, 36);
		frmTransfer.getContentPane().add(comboBoxFrom);
		
		JTextArea txtTransferFrom = new JTextArea();
		txtTransferFrom.setBackground(SystemColor.control);
		txtTransferFrom.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtTransferFrom.setEditable(false);
		txtTransferFrom.setWrapStyleWord(true);
		txtTransferFrom.setText("Choose account\r\nto transfer from");
		txtTransferFrom.setBounds(28, 39, 97, 36);
		frmTransfer.getContentPane().add(txtTransferFrom);
		
		JLabel lblAmount = new JLabel("Enter Amount");
		lblAmount.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAmount.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAmount.setBounds(28, 167, 97, 36);
		frmTransfer.getContentPane().add(lblAmount);
		
		textField = new JTextField();
		textField.setBounds(135, 168, 155, 36);
		frmTransfer.getContentPane().add(textField);
		textField.setColumns(10);
		
		String accountInto[]={"Checking","Savings"}; 
		JComboBox comboBoxInto = new JComboBox(accountInto);
		comboBoxInto.setBounds(135, 103, 155, 36);
		frmTransfer.getContentPane().add(comboBoxInto);
		
		JTextArea txtTransferInto = new JTextArea();
		txtTransferInto.setWrapStyleWord(true);
		txtTransferInto.setText("Choose account\r\nto transfer into");
		txtTransferInto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtTransferInto.setEditable(false);
		txtTransferInto.setBackground(SystemColor.control);
		txtTransferInto.setBounds(28, 103, 97, 36);
		frmTransfer.getContentPane().add(txtTransferInto);
		
		JButton btnTransfer = new JButton("Transfer");
		btnTransfer.setBounds(109, 238, 108, 41);
		frmTransfer.getContentPane().add(btnTransfer);
		btnTransfer.addMouseListener(new MouseAdapter() {
			//@Override
			public void mouseClicked(MouseEvent e) {
				String from = (String) comboBoxFrom.getItemAt(comboBoxFrom.getSelectedIndex());
				String into = (String) comboBoxFrom.getItemAt(comboBoxInto.getSelectedIndex());
				Customer.transfer(Customer.getCurrentUser(), from, into, Integer.parseInt(textField.getText()));
			}
		});;
	}
}

