package frontend;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import backend.EmployeeRole;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;


public class PurchaseProd extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PurchaseProd frame = new PurchaseProd();
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
	private JTextField textField;
	private JTextField textField_1;
	public PurchaseProd() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				close();
				open();
			}
		});
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 550, 300);
		setResizable(false);
		setTitle("Purchased Product");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("CustomerSSN");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(0, 255, 0));
		lblNewLabel.setFont(new Font("Sitka Text", Font.PLAIN, 19));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("Product ID");
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBackground(new Color(0, 255, 0));
		lblNewLabel_1.setFont(new Font("Sitka Text", Font.PLAIN, 19));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_2 = new JLabel("Purchase Date");
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setBackground(new Color(0, 255, 0));
		lblNewLabel_2.setFont(new Font("Sitka Text", Font.PLAIN, 19));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JDateChooser dateChooser = new JDateChooser();
		
		JButton btnNewButton = new JButton("Purchase");
		btnNewButton.setFont(new Font("Sitka Text", Font.PLAIN, 19));
		btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 0, 0));
        btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String customerSSN = textField.getText();
				String prodID = textField_1.getText();
				Date purchase = dateChooser.getDate(); 
				if(customerSSN.isEmpty()==true || prodID.isEmpty()==true || purchase == null ) {
					JOptionPane.showMessageDialog(null,"some feilds are empty");
				}
				LocalDate localPurchase = purchase.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				
				 if(emp.purchaseProduct(customerSSN, prodID, localPurchase) == false) {
					JOptionPane.showInternalMessageDialog(null, "All items of the product with id = "+prodID+"have been finished and no item is left for the customer");
				    close();
				    open();
				}
				 else {
					 JOptionPane.showMessageDialog(null,"the customer with SSN = "+customerSSN+" has successfully Purchased the product with id "+prodID);
					 close();
					 open();
				 }
			}
		});
				
		
		GroupLayout groupLayout = new GroupLayout(contentPane);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(19)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
						.addComponent(lblNewLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
						.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(dateChooser, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(textField_1, 138, 138, Short.MAX_VALUE)
						.addComponent(textField, GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE))
					.addGap(65)
					.addComponent(btnNewButton)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(44)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(dateChooser, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
						.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
					.addGap(49))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(87)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(120, Short.MAX_VALUE))
		);
		contentPane.setLayout(groupLayout);
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
