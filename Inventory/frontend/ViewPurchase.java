package frontend;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import backend.CustomerProduct;
import backend.EmployeeRole;
import backend.Product;

import javax.swing.JTable;

public class ViewPurchase extends JFrame {

	private JPanel contentPane;

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
	private JTable table;
	public ViewPurchase(EmployeeRole e ,EmployeeRoleWin eWin) {
		setEmployee(e);
		setEmployeeWin(eWin);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				close();
				open();
			}
		});
		setTitle("View Purchsed Product");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 640, 400);
		 getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 600, 231);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"CustomerSSN","Product ID", "Purchased Date"
				}
			)
				);
		table.getColumnModel().getColumn(0).setPreferredWidth(200);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		table.getColumnModel().getColumn(2).setPreferredWidth(200);
		String[] col = {"CustomerSSN","Product ID", "Purchased Date"};
		
		CustomerProduct[] purchProd =  emp.getListOfPurchasingOperations();
		String[][] p = new String[purchProd.length][5];
		for(int i = 0 ; i < purchProd.length  ; i++) {
				p[i] = purchProd[i].lineRepresentation().split(",");
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
