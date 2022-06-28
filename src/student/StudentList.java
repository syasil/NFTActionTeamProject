package student;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import swing.*;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class StudentList extends JFrame {

	private JPanel contentPane;
	private CTextField txtKeyword;
	private CButton btnSearch;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentList frame = new StudentList();
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
	public StudentList() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 575);
		contentPane = new CPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		CLabel lblNewLabel = new CLabel("학생 리스트");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 10, 410, 30);
		contentPane.add(lblNewLabel);
		
		CLabel lblNewLabel_1 = new CLabel("검색");
		lblNewLabel_1.setBounds(33, 63, 57, 30);
		contentPane.add(lblNewLabel_1);
		
		txtKeyword = new CTextField();
		txtKeyword.setBounds(166, 68, 197, 32);
		contentPane.add(txtKeyword);
		txtKeyword.setColumns(10);
		
		btnSearch = new CButton("검색");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSearch.setBounds(148, 110, 215, 30);
		contentPane.add(btnSearch);
		
		table = new JTable();
		table.setBounds(208, 197, -149, 125);
		contentPane.add(table);
	}
}
