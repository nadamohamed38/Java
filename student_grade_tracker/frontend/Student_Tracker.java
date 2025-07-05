package frontend;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import backend.Student;
import backend.Subject;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Student_Tracker extends JFrame {
	
	private ArrayList<Student> students = new ArrayList<Student>();

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student_Tracker frame = new Student_Tracker();
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
	public Student_Tracker() {
		setTitle("Students Grade Tracker System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 100, 1150, 600);
		getContentPane().setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 1100, 450);
		getContentPane().add(scrollPane);
		String[] col = {"ID","Name","Subject1","Grade","Subject2","Grade","Subject3","Grade","Subject4","Grade","Subject5","Grade","Subject6","Grade","Average"};
		Object[][] row = {};
		DefaultTableModel model = new DefaultTableModel(row,col);
		JTable table = new JTable(model);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Add Student");
	btnNewButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        JTextField id = new JTextField();
        id.setPreferredSize(new Dimension(100, 20));
        JTextField name = new JTextField(10);
        name.setPreferredSize(new Dimension(100, 20));
        JTextField sub1 = new JTextField(10);
        JTextField score1 = new JTextField(10);
        JTextField sub2 = new JTextField(10);
        JTextField score2 = new JTextField(10);
        JTextField sub3 = new JTextField(10);
        JTextField score3 = new JTextField(10);
        JTextField sub4 = new JTextField(10);
        JTextField score4 = new JTextField(10);
        JTextField sub5 = new JTextField(10);
        JTextField score5 = new JTextField(10);
        JTextField sub6 = new JTextField(10);
        JTextField score6 = new JTextField(10);
        
        JPanel panel = new JPanel(new GridLayout(8, 2, 5, 5));
        panel.add(new JLabel("ID:")); panel.add(id);
        panel.add(new JLabel("Name:")); panel.add(name);
        panel.add(new JLabel("Subject 1:")); panel.add(sub1);
        panel.add(new JLabel("Score:")); panel.add(score1);
        panel.add(new JLabel("Subject 2:")); panel.add(sub2);
        panel.add(new JLabel("Score:")); panel.add(score2);
        panel.add(new JLabel("Subject3:")); panel.add(sub3);
        panel.add(new JLabel("Score:")); panel.add(score3);
        panel.add(new JLabel("Subject 4:")); panel.add(sub4);
        panel.add(new JLabel("Score:")); panel.add(score4);
        panel.add(new JLabel("Subject 5:")); panel.add(sub5);
        panel.add(new JLabel("Score:")); panel.add(score5);
        panel.add(new JLabel("Subject 6:")); panel.add(sub6);
        panel.add(new JLabel("Score:")); panel.add(score6);

        int result = JOptionPane.showConfirmDialog(null, panel, "Enter Student Data", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
        	ArrayList<Subject> subs = new ArrayList<Subject>();
        	Subject subj1 = new Subject(sub1.getText(),Integer.parseInt(score1.getText()));
        	subs.add(subj1);
        	Subject subj2 = new Subject(sub2.getText(),Integer.parseInt(score2.getText()));
        	subs.add(subj2);
        	Subject subj3 = new Subject(sub3.getText(),Integer.parseInt(score3.getText()));
        	subs.add(subj3);
        	Subject subj4 = new Subject(sub4.getText(),Integer.parseInt(score4.getText()));
        	subs.add(subj4);
        	Subject subj5 = new Subject(sub5.getText(),Integer.parseInt(score5.getText()));
        	subs.add(subj5);
        	Subject subj6 = new Subject(sub6.getText(),Integer.parseInt(score6.getText()));
        	subs.add(subj6);
        	Student s = new Student(Integer.parseInt(id.getText()), name.getText(), subs);
        	students.add(s);
        	
            // Add row to the table model
            model.addRow(new Object[]{
                id.getText(),
                name.getText(),
                sub1.getText(),
                s.getSubjects().get(0).getGarde(),
                sub2.getText(),
                s.getSubjects().get(1).getGarde(),
                sub3.getText(),
                s.getSubjects().get(2).getGarde(),
                sub4.getText(),
                s.getSubjects().get(3).getGarde(),
                sub5.getText(),
                s.getSubjects().get(4).getGarde(),
                sub6.getText(),
                s.getSubjects().get(5).getGarde(),
                s.getAvg(),
                s.getHighest().getScore(),
                s.getLowest().getScore()
            });
        }
    }
});

		btnNewButton.setBounds(1000, 500, 105, 21);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton2 = new JButton("Summary");
		btnNewButton2.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
	        
	        
	        JPanel panel = new JPanel(new BorderLayout());
	        panel.setPreferredSize(new Dimension(600, 600));
	        String[] col = {"ID","Name"};
			Object[][] row = {};
			DefaultTableModel model = new DefaultTableModel(row,col);
			float sum = 0;
			for(int i = 0 ; i < students.size();i++) {
				sum+=students.get(i).getAvg();
				 model.addRow(new Object[]{
						 students.get(i).getStudent_ID(),
						 students.get(i).getStudentName()
			            });
			}
			JTable table = new JTable(model);
			JScrollPane scrollPane = new JScrollPane(table);
			scrollPane.setPreferredSize(new Dimension(400, 200));
			panel.add(scrollPane);
			 panel.add(scrollPane, BorderLayout.CENTER);
		        panel.add(new JLabel("Average score: " + ( sum / students.size())), BorderLayout.SOUTH);

	        int result = JOptionPane.showConfirmDialog(null, panel, "Summary", JOptionPane.OK_CANCEL_OPTION);
	    }
	});

			btnNewButton2.setBounds(870, 500, 105, 21);
			getContentPane().add(btnNewButton2);

	}
}
