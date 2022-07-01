package admin;

import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import db.DB;
import swing.CButton;
import swing.CScrollPane;
import swing.CTextField;

public class UserList extends JFrame {

	private JPanel contentPane;
	private CTextField txtKeyword;

	private DefaultTableModel model;
	private JTable tblUser;
	private DefaultTableCellRenderer cellRenderer;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserList frame = new UserList();
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
	public UserList() {
		initComponents();
		getList();
	}

	private void initComponents() {
		setTitle("회원 관리");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 360);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(Color.decode("#1A1A25"));
		contentPane.setLayout(null);

		JLabel lblKeyword = new JLabel("회원 목록");
		lblKeyword.setBounds(12, 23, 165, 30);
		lblKeyword.setForeground(Color.WHITE);
		lblKeyword.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		contentPane.add(lblKeyword);

		txtKeyword = new CTextField();
		txtKeyword.setBounds(310, 25, 130, 30);
		contentPane.add(txtKeyword);

		CButton btnSearch = new CButton("검색하기");
		btnSearch.setBounds(452, 25, 120, 30);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getList();
			}
		});
		contentPane.add(btnSearch);

		model = new DefaultTableModel(new String[] { "번호", "아이디", "닉네임", "가입일" }, 0);

		tblUser = new JTable(model);
		tblUser.setEnabled(false);
		tblUser.getTableHeader().setPreferredSize(new Dimension(0, 30));
		tblUser.setAutoCreateRowSorter(true);
		tblUser.setRowHeight(30);
		tblUser.getColumnModel().getColumn(0).setPreferredWidth(30);
		tblUser.getColumnModel().getColumn(1).setPreferredWidth(200);
		tblUser.getColumnModel().getColumn(2).setPreferredWidth(150);

		cellRenderer = new DefaultTableCellRenderer();
		cellRenderer.setHorizontalAlignment(JLabel.CENTER);
		tblUser.getColumnModel().getColumn(0).setCellRenderer(cellRenderer);

		CScrollPane scrollPane = new CScrollPane(tblUser);
		scrollPane.setSize(584, 245);
		scrollPane.setLocation(0, 76);
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

			sql = "select user_no, user_id, userNick, user_creday from user_t ";

			if (!keyword.equals("")) {
				sql += " where ename like '%" + keyword + "%' ";
			}

			sql += " order by hiredate desc";

			conn = DB.get();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				String empno = rs.getString(1);
				String ename = rs.getString(2);
				String job = rs.getString("JOB");
				String hiredate = rs.getString("hiredate");

				String[] strRow = { empno, ename, job, hiredate };
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
