package frontend;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import backend.AdminRole;
import backend.EmployeeUser;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

public class AdminRoleWin extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminRoleWin frame = new AdminRoleWin();
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
	AdminRole admin = new AdminRole();
	public AdminRoleWin() {
		setTitle("Admin Role");
		setDefaultCloseOperation(JFrame.DEFAULT_CURSOR);
		setBounds(100, 100, 450, 606);
		JPanel contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		setResizable(false);
		JButton btnNewButton = new JButton("Add Employee");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Sitka Text", Font.PLAIN, 30));
		btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddEmp e1 = new AddEmp();
				close();
				e1.setAdmin(admin);
				e1.setAdminWin(get());
				e1.setVisible(true);
			}
		});
		
		JButton btnNewButton_1 = new JButton("View Employees");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(0, 0, 0));
		btnNewButton_1.setFont(new Font("Sitka Text", Font.PLAIN, 30));
		btnNewButton_1.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewEmp ve = new ViewEmp(admin,get());
				close();
				ve.setVisible(true);
			}
		});
		
		JButton btnNewButton_2 = new JButton("Remove Employee");
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(0, 0, 0));
		btnNewButton_2.setFont(new Font("Sitka Text", Font.PLAIN, 30));
		btnNewButton_2.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteEmp de = new DeleteEmp();
				close();
				de.setAdmin(admin);
				de.setAdminWin(get());
				de.setVisible(true);
			}
		});
		
		JButton btnNewButton_3 = new JButton("Logout");
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		btnNewButton_3.setBackground(new Color(0, 0, 0));
		btnNewButton_3.setFont(new Font("Sitka Text", Font.PLAIN, 30));
		btnNewButton_3.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				admin.logout();
				close();
				new AdminLogin() .setVisible(true);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnNewButton_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
						.addComponent(btnNewButton_2, GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
						.addComponent(btnNewButton_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE))
					.addGap(46))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(81)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
					.addGap(36)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
					.addGap(29)
					.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
					.addGap(34)
					.addComponent(btnNewButton_3, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(102, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	public void close() {
		this.setVisible(false);
	}
	
	public AdminRoleWin get() {
		return this;
	}
}