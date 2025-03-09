package frontend;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import constant.LoginCredentials;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.Rectangle;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Point;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AdminLogin extends JFrame implements LoginCredentials{
	private JPasswordField passwordField;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin frame = new AdminLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/*
	 * Create the frame.
	 */
	
	public AdminLogin() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				close();
				 new Inventory().setVisible(true);
			}
		});
		setTitle("Admin Login");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.setResizable(false);
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBackground(new Color(127, 255, 0));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setFont(new Font("Serif", Font.PLAIN, 20));
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Serif", Font.PLAIN, 20));
		lblNewLabel_1.setBackground(new Color(127, 255, 0));
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setForeground(SystemColor.textHighlightText);
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton.setFont(new Font("Serif", Font.PLAIN, 19));
		
		passwordField = new JPasswordField();
		
		textField = new JTextField();
		textField.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(147)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(60)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblNewLabel_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField))))
					.addContainerGap(66, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(textField)
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(passwordField)
						.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE))
					.addGap(31)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addGap(18))
		);
         btnNewButton.addActionListener(new ActionListener() {
			
        	 @Override
			
        	 public void actionPerformed(ActionEvent e) {	
				
        		 String userName = textField.getText();
        		 @SuppressWarnings("deprecation")
				String password = passwordField.getText();
        		 if( userName.equals(LoginCredentials.ADMIN_USERNAME) && password.equals(LoginCredentials.ADMIN_PASSWORD)) {

        			 AdminRoleWin ar = new AdminRoleWin();
        			 close();
        			 ar.setVisible(true);
        		 }
        		 
        		 else
        			 JOptionPane.showMessageDialog(null, "Wrong Username or Password");
        		 
			}
		});
         
		getContentPane().setLayout(groupLayout);
	}
	
	public void close() {
		this.setVisible(false);
	}
	
}