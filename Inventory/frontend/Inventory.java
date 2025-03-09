package frontend;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import constant.LoginCredentials;

import java.awt.FlowLayout;
import java.awt.Window.Type;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Point;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.Insets;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class Inventory extends JFrame {

	private JPanel contentPane;
	private JButton btnNewButton;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inventory frame = new Inventory();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Inventory() {
		setTitle("Inventory System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 474);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("Employee Role");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setMargin(new Insets(40, 70, 40, 70));
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				EmpLogin e1 = new EmpLogin();
				close();
				e1.setVisible(true);
			}
		});
		
		JButton btnNewButton_1 = new JButton("Admin Role");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setLocation(new Point(10000, 0));
		btnNewButton_1.setIconTextGap(80);
		btnNewButton_1.setFont(new Font("Sitka Text", Font.PLAIN, 30));
		btnNewButton_1.setMargin(new Insets(40, 100, 40, 100));
		btnNewButton_1.setBackground(SystemColor.textText);
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				close();
				AdminLogin a1 = new AdminLogin(); 
				a1.setVisible(true);
			}
		});
		btnNewButton.setIconTextGap(80);
		btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton.setFont(new Font("Sitka Text", Font.PLAIN, 30));
		btnNewButton.setBackground(SystemColor.inactiveCaptionText);
		btnNewButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnNewButton.setSelected(true);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnNewButton, Alignment.TRAILING, 0, 0, Short.MAX_VALUE)
						.addComponent(btnNewButton_1, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 399, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(65)
					.addComponent(btnNewButton_1)
					.addGap(59)
					.addComponent(btnNewButton)
					.addGap(33))
		);
		contentPane.setLayout(gl_contentPane);
		
	}
	public void close() {
		this.setVisible(false);
	}
	

}