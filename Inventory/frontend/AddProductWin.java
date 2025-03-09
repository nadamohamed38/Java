package frontend;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import backend.AdminRole;
import backend.EmployeeRole;
import backend.EmployeeUser;
import backend.Product;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

public class AddProductWin extends JFrame {

	private JPanel contentPane;
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
					AddProductWin frame = new AddProductWin();
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
	EmployeeRole emp;
	EmployeeRoleWin empWin;
	private JTextField textField_5;
	public AddProductWin() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				close();
				empWin.setVisible(true);
			}
		});
		setTitle("Add Product");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 600);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Product ID");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(0, 255, 0));
		lblNewLabel.setFont(new Font("Sitka Text", Font.PLAIN, 19));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("Product Name");
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBackground(new Color(0, 255, 0));
		lblNewLabel_1.setFont(new Font("Sitka Text", Font.PLAIN, 19));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		JLabel lblNewLabel_2 = new JLabel("Manufacturer Name");
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setBackground(new Color(0, 255, 0));
		lblNewLabel_2.setFont(new Font("Sitka Text", Font.PLAIN, 19));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_3 = new JLabel("Supplier Name");
		lblNewLabel_3.setOpaque(true);
		lblNewLabel_3.setBackground(new Color(0, 255, 0));
		lblNewLabel_3.setFont(new Font("Sitka Text", Font.PLAIN, 19));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		JLabel lblNewLabel_4 = new JLabel("Quantity");
		lblNewLabel_4.setOpaque(true);
		lblNewLabel_4.setBackground(new Color(0, 255, 0));
		lblNewLabel_4.setFont(new Font("Sitka Text", Font.PLAIN, 19));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		
		textField = new JTextField();
		textField.setBackground(new Color(255, 255, 255));
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBackground(new Color(255, 255, 255));
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBackground(new Color(255, 255, 255));
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBackground(new Color(255, 255, 255));
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBackground(new Color(255, 255, 255));
		textField_4.setColumns(10);
		
		
		JLabel lblNewLabel_5 = new JLabel("Price");
		lblNewLabel_5.setOpaque(true);
		lblNewLabel_5.setBackground(new Color(0, 255, 0));
		lblNewLabel_5.setFont(new Font("Sitka Text", Font.PLAIN, 19));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		textField_5 = new JTextField();
		textField_5.setBackground(new Color(255, 255, 255));
		textField_5.setColumns(10);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setFont(new Font("Sitka Text", Font.PLAIN, 19));
		btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				    String id = textField.getText();
	                String name = textField_1.getText();
	                String manName = textField_2.getText();
	                String supName = textField_3.getText();
	                String quantity = textField_4.getText();
	                String price = textField_5.getText();
	                if(id.isEmpty() == true || name.isEmpty() == true || manName.isEmpty()  == true ||supName.isEmpty() == true || price.isEmpty() == true || quantity.isEmpty() == true ){
	                    JOptionPane.showMessageDialog(null,"some fields are empty");
	                }
	                else if(new Scanner(quantity).hasNextInt() == false)

	                {
	                    JOptionPane.showMessageDialog(null,"you should enter a numeric value in quantity field");

	                }
	                close();
                    int c = 0;
                    Product[] p=emp.getListOfProducts();
                    for(int i=0;i<p.length;i++)
                    {
                        if(p[i].getProductID().equals(id))
                        {JOptionPane.showMessageDialog(null,"The Product with id ="+id+"is already exist");
                            c++;
                            open();

                        }
                        else if(c==0)
                        {
                            emp.addProduct(id,name,manName,supName,Integer.parseInt(quantity),Float.parseFloat(price));
                            JOptionPane.showMessageDialog(null,"The Product with id="+id+"has been added successfully");
                             open();

                        }
                    }
				
		}});
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(187)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_5, GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(lblNewLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblNewLabel_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblNewLabel_4, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
										.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGap(39)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_5, GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
								.addComponent(textField_4, GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
								.addComponent(textField_3, GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
								.addComponent(textField_2, 145, 145, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
									.addComponent(textField_1, Alignment.TRAILING)
									.addComponent(textField, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)))
							.addGap(18))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(25)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
					.addGap(36)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_5, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
	public void open() {
		empWin.setVisible(true);
	}
	public void close() {
		this.setVisible(false);
	}
	public void setEmployee(EmployeeRole e) {
		emp = e;
	}
	public void setEmployeeWin(EmployeeRoleWin e) {
		empWin = e;
	}
}
