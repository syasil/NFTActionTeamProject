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
import swing.CLabel;
import swing.CScrollPane;
import swing.CTextField;

public class ProductList extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
					ProductList frame = new ProductList();
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
	public ProductList() {
		initComponents();
		getList();
	}

	private void initComponents() {
		setTitle("상품 관리");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 360);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(Color.decode("#1A1A25"));
		contentPane.setLayout(null);

		CLabel lblKeyword = new CLabel("상품 목록", 22);
		lblKeyword.setBounds(12, 23, 165, 30);
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

		model = new DefaultTableModel(new String[] { "번호", "상품이름", "가격", "설명", "등록일" }, 0);

		tblUser = new JTable(model);
		tblUser.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		tblUser.setEnabled(false);
		tblUser.getTableHeader().setPreferredSize(new Dimension(0, 30));
		tblUser.getTableHeader().setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		tblUser.setAutoCreateRowSorter(true);
		tblUser.setRowHeight(30);
		tblUser.setIntercellSpacing(new Dimension(20, 1));
		tblUser.getColumnModel().getColumn(0).setPreferredWidth(20);
		tblUser.getColumnModel().getColumn(1).setPreferredWidth(100);
		tblUser.getColumnModel().getColumn(2).setPreferredWidth(80);
		tblUser.getColumnModel().getColumn(3).setPreferredWidth(50);
		tblUser.getColumnModel().getColumn(4).setPreferredWidth(100);

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
			String keyword = txtKeyword.getText();

			sql = "select pro_no, pro_name, pro_price, pro_exp, pro_regday from t_product";

			if (!keyword.equals("")) {
				sql += " where pro_name like '%" + keyword + "%' ";
			}

			sql += " order by pro_regday desc";

			conn = DB.get();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				String[] strRow = { 
					rs.getString("pro_no"), rs.getString("pro_name"), rs.getString("pro_price"), rs.getString("pro_exp"), rs.getString("pro_regday")

				};
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
