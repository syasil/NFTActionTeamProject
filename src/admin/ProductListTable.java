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

import javax.swing.BorderFactory;
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

public class ProductListTable extends JFrame {

	private JPanel contentPane;
	private CTextField txtKeyword;

	private DefaultTableModel model;
	private JTable tblProduct;
	private DefaultTableCellRenderer cellRenderer;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductListTable frame = new ProductListTable();
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
	public ProductListTable() {
		initComponents();
		getList();
	}

	private void initComponents() {
		setTitle("상품 관리");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 450);
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
		txtKeyword.setBounds(510, 23, 130, 30);
		contentPane.add(txtKeyword);

		CButton btnSearch = new CButton("검색하기");
		btnSearch.setBounds(652, 23, 120, 30);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getList();
			}
		});
		contentPane.add(btnSearch);

		String[] header = { "상품번호", "닉네임", "상품명", "가격", "설명", "등록일" };
		model = new DefaultTableModel(header, 0);

		tblProduct = new JTable(model);
		tblProduct.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		tblProduct.setEnabled(false);
		tblProduct.getTableHeader().setPreferredSize(new Dimension(0, 30));
		tblProduct.getTableHeader().setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		tblProduct.setAutoCreateRowSorter(true);
		tblProduct.setRowHeight(30);
		tblProduct.setIntercellSpacing(new Dimension(20, 1));
		tblProduct.getColumnModel().getColumn(0).setPreferredWidth(30);
		tblProduct.getColumnModel().getColumn(1).setPreferredWidth(40);
		tblProduct.getColumnModel().getColumn(2).setPreferredWidth(200);
		tblProduct.getColumnModel().getColumn(3).setPreferredWidth(10);
		tblProduct.getColumnModel().getColumn(4).setPreferredWidth(100);

		cellRenderer = new DefaultTableCellRenderer();
		cellRenderer.setHorizontalAlignment(JLabel.CENTER);
		tblProduct.getColumnModel().getColumn(0).setCellRenderer(cellRenderer);
		tblProduct.getColumnModel().getColumn(1).setCellRenderer(cellRenderer);

		CScrollPane scrollPane = new CScrollPane(tblProduct);
		scrollPane.setSize(784, 335);
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

			sql = "select * from t_product ";

			if (!keyword.equals("")) {
				sql += " where upper(pro_name) like '%" + keyword + "%' ";
			}

			sql += " order by pro_regday desc";

			conn = DB.get();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				String[] strRow = {
					"#" + rs.getString("pro_no"),
					rs.getString("user_no"),
					rs.getString("pro_name"),
					"$" + rs.getString("pro_price"),
					rs.getString("pro_exp"),
					rs.getString("pro_regday")
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
