package employee;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import db.DB;
import swing.CButton;
import swing.CScrollPane;
import swing.CTextField;

public class List extends JFrame {

	private JPanel contentPane;
	private CTextField txtKeyword;

	private DefaultTableModel model;
	private JTable tblEmployee;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					List frame = new List();
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
	public List() {
		initComponents();
		getList();
	}
	
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 360, 598);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(Color.decode("#1A1A25"));
		contentPane.setLayout(null);
		
		
		JLabel lblKeyword = new JLabel("직원 관리");
		lblKeyword.setBounds(12, 10, 320, 30);
		lblKeyword.setHorizontalAlignment(SwingConstants.CENTER);
		lblKeyword.setForeground(Color.WHITE);
		lblKeyword.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		contentPane.add(lblKeyword);
		
		txtKeyword = new CTextField();
		txtKeyword.setBounds(12, 60, 188, 32);
		contentPane.add(txtKeyword);
		
		JLabel lblWordList = new JLabel("직원 목록");
		lblWordList.setBounds(12, 100, 188, 30);
		lblWordList.setForeground(Color.WHITE);
		lblWordList.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		contentPane.add(lblWordList);
		
		CButton btnSearch = new CButton("검색하기");
		btnSearch.setBounds(212, 60, 120, 30);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getList();
			}
		});
		contentPane.add(btnSearch);
		
		//JButton btnAddWord = new JButton("신규등록");
		CButton btnAddWord = new CButton("신규등록");
		btnAddWord.setBounds(12, 519, 320, 30);
		btnAddWord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Insert frame = new Insert();
				frame.setVisible(true);
			}
		});
		contentPane.add(btnAddWord);
		

		model = new DefaultTableModel(new String[] {"번호", "이름", "직무", "입사일"}, 0);
		tblEmployee = new JTable(model);
		tblEmployee.setEnabled(false);
		tblEmployee.setAutoCreateRowSorter(true);
		tblEmployee.setRowHeight(30);

		//JScrollPane scrollPane = new JScrollPane(tblEmployee);
		CScrollPane scrollPane = new CScrollPane(tblEmployee);
		scrollPane.setBounds(12, 140, 320, 369);
		
		contentPane.add(scrollPane);
	}

	private void getList() {
		Connection conn = null; 
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		// 기존 데이타 다 지워주고 다시 넣어주려고
		model.setRowCount(0);

		try {
			String sql = "";
			String keyword = txtKeyword.getText().toUpperCase(); // 대문자로 들어가 있어서 대문자로 검색

			sql = "select empno, ename, job, hiredate from emp1 ";

			if (!keyword.equals("")) {
				sql += " where ename like '%" + keyword + "%' ";
			}
			
			sql += " order by hiredate desc"; 

			conn = DB.get();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				String empno = rs.getString(1);
				String ename = rs.getString(2);
				String job = rs.getString("JOB");
				String hiredate = rs.getString("hiredate");
				
				String[] strRow = {empno, ename, job, hiredate};
				model.addRow(strRow);
			}
			
			rs.close();
			psmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
