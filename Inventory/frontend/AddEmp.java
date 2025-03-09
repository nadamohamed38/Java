package frontend;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import backend.AdminRole;
import backend.EmployeeUser;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AddEmp extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddEmp frame = new AddEmp();
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

	AdminRole admin;
	AdminRoleWin adminWin;
	public AddEmp() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				close();
				adminWin.setVisible(true);
			}
		});
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		setResizable(false);
		setTitle("Add Employee");
		JLabel lblNewLabel = new JLabel("EmployeeID");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(0, 255, 0));
		lblNewLabel.setFont(new Font("Sitka Text", Font.PLAIN, 19));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBackground(new Color(0, 255, 0));
		lblNewLabel_1.setFont(new Font("Sitka Text", Font.PLAIN, 19));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		JLabel lblNewLabel_2 = new JLabel("Email");
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setBackground(new Color(0, 255, 0));
		lblNewLabel_2.setFont(new Font("Sitka Text", Font.PLAIN, 19));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_3 = new JLabel("Address");
		lblNewLabel_3.setOpaque(true);
		lblNewLabel_3.setBackground(new Color(0, 255, 0));
		lblNewLabel_3.setFont(new Font("Sitka Text", Font.PLAIN, 19));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_4 = new JLabel("Phone Number");
		lblNewLabel_4.setOpaque(true);
		lblNewLabel_4.setBackground(new Color(0, 255, 0));
		lblNewLabel_4.setFont(new Font("Sitka Text", Font.PLAIN, 19));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		
		textField = new JTextField();
		textField.setBackground(new Color(255, 255, 255));
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setFont(new Font("Sitka Text", Font.PLAIN, 19));
		btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = textField.getText();
				String name = textField_1.getText();
				String email = textField_2.getText();
				String address = textField_3.getText();
				String phoneNum = textField_4.getText();

				if(id.isEmpty() || name.isEmpty() || email.isEmpty() || address.isEmpty() || phoneNum.isEmpty())
					 JOptionPane.showMessageDialog(null, "some fields are empty");
				else {
					close();
					int c = 0;
					EmployeeUser[] e1 = admin.getListOfEmployees();
					for(int i = 0 ; i < e1.length ; i++ ) {
						if(e1[i].getEmployeeId().equals(id)) {
							JOptionPane.showMessageDialog(null, "The Employee with id = "+ id + " is already exist");
							c++;
							open();
							}
					}
					if( c == 0) {
						admin.addEmployee(id, name, email, address, phoneNum);
						JOptionPane.showMessageDialog(null, "The Employee with id = "+ id +" has been added successfully");
						open();
					}
				}
			}
		});
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
								.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
								.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_4, GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
								.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_3, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
								.addComponent(textField_2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
								.addComponent(textField, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)))
						.addComponent(textField_4, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE))
					.addGap(70))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(186)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(193, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(35)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addGap(27))
		);
		getContentPane().setLayout(groupLayout);
	}
	public void open() {
		adminWin.setVisible(true);
	}
	public void close() {
		this.setVisible(false);
	}
	public void setAdmin(AdminRole a) {
		admin = a;
	}
	public void setAdminWin(AdminRoleWin a) {
		adminWin = a;
	}
	
}