package frontend;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import backend.EmployeeRole;
import backend.Product;

public class ViewProduct extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
	}

	/**
	 * Create the frame.
	 */
	EmployeeRole emp;
	EmployeeRoleWin empWin;
	public ViewProduct(EmployeeRole e ,EmployeeRoleWin eWin) {
		setEmployee(e);
		setEmployeeWin(eWin);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				close();
				open();
			}
		});
		setTitle("View Product");
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
				"Product ID", "Product Name", "Manufacturer Name", "Supplier Name", "Quantity", "Price"
			}
		)
			);
		String[] col = {"Product ID", "Product Name", "Manufacturer Name", "Supplier Name", "Quantity","Price"} ;
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setMinWidth(31);
		table.getColumnModel().getColumn(5).setPreferredWidth(100);
		Product[] prod =  emp.getListOfProducts();
		String[][] p = new String[prod.length][5];
		for(int i = 0 ; i < prod.length  ; i++) {
				p[i] = prod[i].lineRepresentation().split(",");
		}
		table.setModel(new DefaultTableModel(p,col) {
			@Override
			public boolean isCellEditable(int row , int column) {
				return false;
			}
		});
		
		
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
