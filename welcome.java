package Final;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Welcome {

	private JFrame frame;
	private JPanel left;
	private JPanel right;
	private JButton create;
	private JButton returning;
	
	public Welcome() {
		frame = new JFrame();
		left = new JPanel();
		right = new JPanel();
		create = new JButton("Create New User");
		returning = new JButton("Returning User");
		
		returning.addActionListener(new returning());
		create.addActionListener(new create());
		
		left.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		right.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		
		left.add(create);
		right.add(returning);
		
		frame.add(left, BorderLayout.WEST);
		frame.add(right, BorderLayout.EAST);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("WELCOME TO OUR ONLINE BANKING APPLICATION");
		frame.pack();
		frame.setVisible(true);

	}
	private class create implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
			new NewAccountID(); 
		}
		
	}
	private class returning implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
              frame.dispose(); 
              new Login(); 
              
		}
		
	}
	public static void main(String[] args) {
          new Welcome();
	}


}
