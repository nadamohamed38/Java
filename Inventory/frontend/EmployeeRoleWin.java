package frontend;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import backend.EmployeeRole;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class EmployeeRoleWin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeRoleWin frame = new EmployeeRoleWin();
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
	EmployeeRole employee = new EmployeeRole();
	public EmployeeRoleWin() {
		setTitle("Employee Role");
		setDefaultCloseOperation(JFrame.DEFAULT_CURSOR);
		setBounds(100, 100, 450, 650);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		setResizable(false);
		
		JButton btnNewButton = new JButton("Add Product");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Sitka Text", Font.PLAIN, 30));
		btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddProductWin add = new AddProductWin();
				close();
				add.setEmployee(employee);
				add.setEmployeeWin(get());
				add.setVisible(true);
				
			}
		});
			
		
		JButton btnNewButton_1 = new JButton("View Product");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(0, 0, 0));
		btnNewButton_1.setFont(new Font("Sitka Text", Font.PLAIN, 30));
		btnNewButton_1.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewProduct vp = new ViewProduct(employee,get());
				close();
				
				vp.setVisible(true);
			}
		});
		
		JButton btnNewButton_2 = new JButton("Purchase Product");
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(0, 0, 0));
		btnNewButton_2.setFont(new Font("Sitka Text", Font.PLAIN, 30));
		btnNewButton_2.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PurchaseProd pp = new PurchaseProd();
				close();
				pp.setEmployee(employee);
				pp.setEmployeeWin(get());
				pp.setVisible(true);
			}
		});
		
		JButton btnNewButton_3 = new JButton("View Purchase Product");
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		btnNewButton_3.setBackground(new Color(0, 0, 0));
		btnNewButton_3.setFont(new Font("Sitka Text", Font.PLAIN, 30));
		btnNewButton_3.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewPurchase vpp = new ViewPurchase(employee,get());
				close();
				vpp.setVisible(true);
				
			}
		});
		
		JButton btnNewButton_4 = new JButton("Return Product");
		btnNewButton_4.setForeground(new Color(255, 255, 255));
		btnNewButton_4.setBackground(new Color(0, 0, 0));
		btnNewButton_4.setFont(new Font("Sitka Text", Font.PLAIN, 30));
		btnNewButton_4.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReturnProd rp = new ReturnProd();
				close();
				rp.setEmployee(employee);
				rp.setEmployeeWin(get());
				rp.setVisible(true);
			}
		});
		
		JButton btnNewButton_5 = new JButton("Logout");
		btnNewButton_5.setForeground(new Color(255, 255, 255));
		btnNewButton_5.setBackground(new Color(0, 0, 0));
		btnNewButton_5.setFont(new Font("Sitka Text", Font.PLAIN, 30));
		btnNewButton_5.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				employee.logout();
				close();
				new EmpLogin().setVisible(true);
			}
		});
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnNewButton_2, GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnNewButton_3, GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNewButton_5, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
								.addComponent(btnNewButton_4, GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE))))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(30)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addGap(37)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
					.addGap(39)
					.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
					.addGap(43)
					.addComponent(btnNewButton_3, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
					.addGap(36)
					.addComponent(btnNewButton_4, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addGap(32)
					.addComponent(btnNewButton_5, GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
	public void close() {
		this.setVisible(false);
	}
	
	public EmployeeRoleWin get() {
		return this;
	}
}
