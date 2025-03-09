package frontend;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.text.TabExpander;
import javax.swing.text.TabableView;

import backend.AdminRole;
import backend.EmployeeUser;

import javax.swing.UIManager;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ViewEmp extends JFrame {
	private JTable table;

	/*
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
	}

	/**
	 * Create the frame.
	 */
	
	AdminRoleWin adminWin;
	AdminRole admin  ;
	public ViewEmp(AdminRole admn , AdminRoleWin win ) {
		setAdmin(admn);
		setAdminWin(win);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				close();
				open();
			}
		});
		setTitle("View Employees");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 750, 400);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 716, 231);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Employee ID", "Name", "Email", "Address", "Phone Number"
			})
		);
		
		String[] col = {"Employee ID", "Name", "Email", "Address", "Phone Number"} ;
		table.getColumnModel().getColumn(0).setPreferredWidth(130);
		table.getColumnModel().getColumn(1).setPreferredWidth(128);
		table.getColumnModel().getColumn(2).setPreferredWidth(128);
		table.getColumnModel().getColumn(3).setPreferredWidth(128);
		table.getColumnModel().getColumn(4).setPreferredWidth(128);
		table.getColumnModel().getColumn(4).setMinWidth(31);
		
		EmployeeUser[] e1 = admin.getListOfEmployees();
		String[][] e2 = new String[e1.length][5];
		for(int i = 0 ; i < e1.length  ; i++) {
				e2[i] = e1[i].lineRepresentation().split(",");
		}
		table.setModel(new DefaultTableModel(e2,col) {
			@Override
			public boolean isCellEditable(int row , int column) {
				return false;
			}
		});
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