package frontend;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import constant.LoginCredentials;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class EmpLogin extends JFrame implements LoginCredentials {

	private JPanel contentPane;
	private JTextField textField_1;
	private JPasswordField passwordField_1;
	private JButton btnNewButton;

	/*
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmpLogin frame = new EmpLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EmpLogin() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				close();
				new Inventory().setVisible(true);
			}
		});
		setTitle("Employee Login");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		this.setResizable(false);
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Serif", Font.PLAIN, 20));
		lblNewLabel.setToolTipText("");
		lblNewLabel.setBackground(new Color(127, 255, 0));
		lblNewLabel.setOpaque(true);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBackground(new Color(127, 255, 0));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Serif", Font.PLAIN, 20));
		lblNewLabel_1.setOpaque(true);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		passwordField_1 = new JPasswordField();
		
		btnNewButton = new JButton("Login");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Serif", Font.PLAIN, 20));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(60)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
								.addComponent(passwordField_1, 121, 121, 121)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(161)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)))
					.addGap(161))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(textField_1)
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(passwordField_1)
						.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE))
					.addGap(40)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addGap(40))
		);
		
		   btnNewButton.addActionListener(new ActionListener() {
				
	        	 @Override
				
	        	 public void actionPerformed(ActionEvent e) {	
					
	        		 String userName = textField_1.getText();
	        		 @SuppressWarnings("deprecation")
					String password = passwordField_1.getText();
	        		 if( userName.equals(LoginCredentials.EMPLOYEE_USERNAME) && password.equals(LoginCredentials.EMPLOYEE_PASSWORD)) {
	        			 EmployeeRoleWin emp = new EmployeeRoleWin();
	        			 close();
	        			 emp.setVisible(true);
	        			 
	        		 }
	        		 
	        		 else
	        			 JOptionPane.showMessageDialog(null, "Wrong Username or Password");
	        		 
				}
			});
		contentPane.setLayout(gl_contentPane);
	}
	public void close() {
		this.setVisible(false);
	}
	

}