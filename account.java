package Final;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*; 

public class account{

	private JFrame frame;
	private JPanel panelTop;
	private JPanel panelL;
	private JPanel panelR;
	private JTextField display;
	
	private JTextField depo;
	private JTextField with; 
	private JButton deposit;
	private JButton withdraw;
	private JButton view;
	private JLabel blank;
	
	/**
	 * Constructor creates GUI 
	 */
	public account() {
		blank = new JLabel();
		frame = new JFrame();
		panelTop = new JPanel();
		panelL = new JPanel();
		panelR = new JPanel();
		deposit = new JButton("Deposit");
		withdraw = new JButton("Withdraw");
		view = new JButton("View");
		
		deposit.addActionListener(new deposit());
		withdraw.addActionListener(new withdraw());
		view.addActionListener(new view());
		
		
		depo = new JTextField(20);
		with = new JTextField(20);

		display = new JTextField(20);
		display.setEditable(false);
		
		panelTop.setBorder(BorderFactory.createEmptyBorder(6, 6, 30, 6));
		panelL.setBorder(BorderFactory.createEmptyBorder(6,6,6,6));
		panelR.setBorder(BorderFactory.createEmptyBorder(6,6,6,6));


		panelTop.setLayout(new GridLayout(0,1));
		panelTop.add(display);
		
		panelL.setLayout(new GridLayout(0,1));
		panelR.setLayout(new GridLayout(0,1));

		
		panelL.add(deposit);
		panelR.add(depo);
		panelL.add(withdraw);
		panelR.add(with);
		panelL.add(view);
		panelR.add(blank);
		
		frame.add(panelTop, BorderLayout.NORTH);
		frame.add(panelR, BorderLayout.EAST);
		frame.add(panelL, BorderLayout.WEST);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Account Information");
		frame.pack();
		frame.setVisible(true);

	}
	
	/**
	 * 
	 * class allows deposit button to work
	 *
	 */
	private class deposit implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			double moneyIn = Double.parseDouble(depo.getText());
			display.setText(Double.toString(moneyIn) + " has been depositied");
			//Needs to deposit into database here 
			
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
			
			double moneyOut = Double.parseDouble(with.getText());
			//needs to get current money and make sure they have enough to withdraw
			
			display.setText(Double.toString(moneyOut) + " has been withdrawn");
			//needs to withdrawal from database here
			
		}
		
	}
	/**
	 * 
	 * provides functionality to view button
	 *
	 */
	private class view implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			//Gets account total from database and prints to display
		}
		
	}
	
	public static void main(String[] args) {
       new account();
	}

}
