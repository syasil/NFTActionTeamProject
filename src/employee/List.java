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
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import db.DB;
import swing.CButton;
import swing.CLabel;
import swing.CScrollPane;
import swing.CTextField;

public class List extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
		
		CLabel lblWordList = new CLabel("회원 목록");
		lblWordList.setBounds(12, 100, 188, 30);
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
				Insert insertFrame = new Insert();
				insertFrame.setLocationRelativeTo(btnAddWord.getTopLevelAncestor());
				insertFrame.setVisible(true);
			}
		});
		contentPane.add(btnAddWord);
		
		model = new DefaultTableModel(new String[] {"ID", "생일", "별명", "가입일"}, 0);
		tblEmployee = new JTable(model);
		tblEmployee.setEnabled(false);
		tblEmployee.setAutoCreateRowSorter(true);
		tblEmployee.setRowHeight(30);

		//JScrollPane scrollPane = new JScrollPane(tblEmployee);
		CScrollPane scrollPane = new CScrollPane(tblEmployee);
		scrollPane.setBounds(12, 140, 320, 357);
		
		contentPane.add(scrollPane);
	}

	private void getList() {
		Connection conn = null; 
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		// 기존 데이터 다 지워주고 다시 넣어주려고
		model.setRowCount(0);

		try {
			String sql = "";
			String keyword = txtKeyword.getText();

			sql = "select USER_ID, USER_BIR, USER_NICK, USER_CREDAY from USER_T";

			if (!keyword.equals("")) {
				sql += " where USER_ID like '%" + keyword + "%' ";
			}
			
			sql += " order by 1"; 

			conn = DB.get();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				String user_id = rs.getString(1);
				String user_bir = rs.getString(2);
				String user_nick = rs.getString(3);
				String user_creday = rs.getString(4);
				
				String[] strRow = {user_id, user_bir, user_nick, user_creday};
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
