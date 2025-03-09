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
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

public class ReturnProd extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReturnProd frame = new ReturnProd();
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
	public ReturnProd() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				close();
				open();
			}
		});
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 550, 400);
		setResizable(false);
		setTitle("Return Product");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("CustomerSSN");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(0, 255, 0));
		lblNewLabel.setFont(new Font("Sitka Text", Font.PLAIN, 19));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Product ID");
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBackground(new Color(0, 255, 0));
		lblNewLabel_1.setFont(new Font("Sitka Text", Font.PLAIN, 19));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		
		
		JLabel lblNewLabel_2 = new JLabel("Purchase Date");
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setBackground(new Color(0, 255, 0));
		lblNewLabel_2.setFont(new Font("Sitka Text", Font.PLAIN, 19));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_3 = new JLabel("Return Date");
		lblNewLabel_3.setOpaque(true);
		lblNewLabel_3.setBackground(new Color(0, 255, 0));
		lblNewLabel_3.setFont(new Font("Sitka Text", Font.PLAIN, 19));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		
		JDateChooser dateChooser = new JDateChooser();
		
		JDateChooser dateChooser_1 = new JDateChooser();
		JButton btnNewButton = new JButton("Return");
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
				Date returnDate = dateChooser_1.getDate();
				if(customerSSN.isEmpty()==true || prodID.isEmpty()==true || purchase == null || returnDate == null) {
					JOptionPane.showMessageDialog(null,"some feilds are empty");
				}
				LocalDate localPurchase = purchase.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				LocalDate localReturn = returnDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				 if(emp.returnProduct(customerSSN, prodID, localPurchase, localReturn) == -1) {
					JOptionPane.showInternalMessageDialog(null, "can't this return product");
				    close();
				    open();
				}
				 else {
					 JOptionPane.showMessageDialog(null,"the customer with SSN = "+customerSSN+" should be paid a return price for the returned product");
					 close();
					 open();
				 }
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
									.addGap(9)
									.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE))
								.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
									.addContainerGap()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(dateChooser_1, GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
										.addComponent(dateChooser, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
							.addGap(44)
							.addComponent(btnNewButton)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(34)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(textField)
								.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE))
							.addGap(22)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(textField_1)
								.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE))
							.addGap(27)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(dateChooser, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
							.addGap(26)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(dateChooser_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(144)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(21, Short.MAX_VALUE))
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
