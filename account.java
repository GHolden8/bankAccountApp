package Final;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*; 

public class Account{

	JFrame frame;
	private JPanel panelTop;
	private JPanel panelL;
	private JPanel panelR;
	private JTextField display;
	
	private JTextField checking;
	private JTextField savings; 
	private JButton deposit;
	private JButton withdraw;
	private JButton transfer;
	private JLabel whoLogged;
	private JButton logOut;
	
	/**
	 * Constructor creates GUI 
	 */
	public Account() {
		//whoLogged needs get username from database and just put it in () below
		whoLogged = new JLabel("Need to put user from base here");
			
		frame = new JFrame();
		panelTop = new JPanel();
		panelL = new JPanel();
		panelR = new JPanel();
		deposit = new JButton("Deposit");
		withdraw = new JButton("Withdraw");
		transfer = new JButton("Transfer");
		logOut = new JButton("Logout");
		
		deposit.addActionListener(new deposit());
		withdraw.addActionListener(new withdraw());
		transfer.addActionListener(new transfer());
		logOut.addActionListener(new logout());
		
		
		checking = new JTextField(20);
		String checkingAmount = "" + Customer.getChecking(Customer.getCurrentUser());
		checking.setText(checkingAmount);
		savings = new JTextField(20);
		String savingsAmount = "" + Customer.getSavings(Customer.getCurrentUser());
		savings.setText(savingsAmount);

		display = new JTextField(20);
		display.setEditable(false);
		
		panelTop.setBorder(BorderFactory.createEmptyBorder(6, 6, 30, 6));
		panelL.setBorder(BorderFactory.createEmptyBorder(6,6,6,6));
		panelR.setBorder(BorderFactory.createEmptyBorder(6,6,6,6));


		panelTop.setLayout(new GridLayout(0,1));
		panelTop.add(whoLogged); 
		panelTop.add(display);
		
		panelL.setLayout(new GridLayout(0,1));
		panelR.setLayout(new GridLayout(0,1));

		
		panelL.add(deposit);
		panelR.add(checking);
		panelL.add(withdraw);
		panelR.add(savings);
		panelL.add(transfer);
		panelR.add(logOut);
		
		
		
		frame.add(panelTop, BorderLayout.NORTH);
		frame.add(panelR, BorderLayout.EAST);
		frame.add(panelL, BorderLayout.WEST);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Account Information");
		frame.pack();
		frame.setVisible(true);

	}
	
	private class logout implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
              frame.dispose();
              new Welcome();
		}
	}
	
	/**
	 * 
	 * class allows deposit button to work
	 *
	 */
	private class deposit implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
			Deposit window = new Deposit();
			window.frmDeposit.setVisible(true);
		}
	}
	
	/**
	 * 
	 * provides functionality to withdraw button
	 *
	 */
	private class withdraw implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
			Withdraw window = new Withdraw();
			window.frmWithdraw.setVisible(true);
		}
	}
	
	/**
	 * 
	 * provides functionality to view button
	 *
	 */
	private class transfer implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
			Transfer window = new Transfer();
			window.frmTransfer.setVisible(true);
		}
	}
	
	public static void main(String[] args) {
       new Account();
	}
}
