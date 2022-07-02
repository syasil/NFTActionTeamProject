package admin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import db.DB;
import functions.ResizeImage;
import swing.CButton;
import swing.CImageButton;
import swing.CLabel;
import swing.CPanel;
import swing.CScrollPane;
import swing.CTextField;

public class ProductList extends JFrame {
	private final int FRAME_WIDTH = 600;
	private final int FRAME_HEIGHT = 400;
	private JPanel contentPane;
	private CTextField txtKeyword;
	private CPanel pnlList;

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
		getRootPane().setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(Color.decode("#1A1A25"));
		contentPane.setLayout(null);
		
		////////////////////////
		// 제목
		////////////////////////
		CLabel lblTitle = new CLabel("상품 목록", 22);
		lblTitle.setBounds(12, 23, 165, 30);
		contentPane.add(lblTitle);

		
		////////////////////////
		// 검색어
		////////////////////////
		txtKeyword = new CTextField();
		txtKeyword.setBounds(321, 25, 130, 30);
		txtKeyword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getList();
			}
		});
		contentPane.add(txtKeyword);

		
		////////////////////////
		// 검색 버튼
		////////////////////////
		CButton btnSearch = new CButton("검색하기");
		btnSearch.setBounds(463, 25, 120, 30);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getList();
			}
		});
		contentPane.add(btnSearch);
		
		pnlList = new CPanel();
		pnlList.setBorder(null);
		pnlList.setLayout(new BoxLayout(pnlList, BoxLayout.Y_AXIS));

		
		////////////////////////
		// 스크롤 패널로 감싸기
		////////////////////////
		CScrollPane scrollPane = new CScrollPane(pnlList);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(0, 70, FRAME_WIDTH, FRAME_HEIGHT - 70);
		scrollPane.getVerticalScrollBar().setUnitIncrement(20);

		contentPane.add(scrollPane);
	}

	private void getList() {
		pnlList.removeAll();
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

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

			Dimension dimMax = new Dimension(FRAME_WIDTH - 10, 90);
			Dimension dimPrefer = new Dimension(FRAME_WIDTH - 10, 90);
			
			while (rs.next()) {
				CPanel pnlItem = new CPanel();
				pnlItem.setLayout(null);
				pnlItem.setPreferredSize(dimPrefer);
				pnlItem.setMaximumSize(dimMax);

				CImageButton btnImage;
				Blob blob = rs.getBlob("pro_img");
				if (blob != null) {
					BufferedImage bfImg = ImageIO.read(blob.getBinaryStream(1, blob.length()));
					btnImage = new CImageButton(ResizeImage.resize(bfImg, 80, 80), 10);
				} else {
					btnImage = new CImageButton(ResizeImage.resize("images/profile.jpg", 80, 80), 10);
				}
				btnImage.setBounds(10, 10, 80, 80);

				CLabel lbl1 = new CLabel("제목: " + rs.getString("pro_name"));
				lbl1.setBounds(100, 15, FRAME_WIDTH - 100, 20);

				CLabel lbl2 = new CLabel("설명: " + rs.getString("pro_exp"), 14);
				lbl2.setBounds(100, 37, FRAME_WIDTH - 100, 20);
				lbl2.setForeground(Color.LIGHT_GRAY);
				
				pnlItem.add(btnImage);
				pnlItem.add(lbl1);
				pnlItem.add(lbl2);
				
				pnlList.add(pnlItem);
			}
			
			rs.close();
			psmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		pnlList.revalidate();
		pnlList.repaint();
	}
}
