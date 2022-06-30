package wook;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Mypage {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mypage window = new Mypage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Mypage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		JPanel panel=new JPanel();
		panel.setBackground(Color.WHITE);
		String []head=new String[] {"상품명","참여일","금액"};
		String [][]data1 =Test.getData();
		panel.setLayout(null);
		JTable tab=new JTable(data1,head);
		tab.setPreferredScrollableViewportSize(new Dimension(300,300));
		tab.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(tab);
		scrollPane.setBounds(38, 315, 333, 158);
		panel.add(scrollPane);
		
//		frame.getContentPane().add(panel);
		
		String []header=new String[] {"상품명","등록일","낙찰여부"};
		String [][]data2 =Test.getData();
		JTable table=new JTable(data2,header);
		table.setPreferredScrollableViewportSize(new Dimension(300,300));
		table.setFillsViewportHeight(true);
		JScrollPane scrollPane_1 = new JScrollPane(table);
		scrollPane_1.setBounds(38, 524, 333, 158);
		panel.add(scrollPane_1);
		
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("마이 페이지");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		lblNewLabel.setBounds(381, 167, 205, 64);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("참여한 경매내역");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		lblNewLabel_1.setBounds(38, 261, 172, 44);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("등록한 물품");
		lblNewLabel_1_1.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		lblNewLabel_1_1.setBounds(38, 483, 172, 44);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNft = new JLabel("NFT 경매 시스템");
		lblNft.setHorizontalAlignment(SwingConstants.CENTER);
		lblNft.setFont(new Font("맑은 고딕", Font.BOLD, 35));
		lblNft.setBounds(6, 24, 293, 64);
		panel.add(lblNft);
		
		JButton Outbtn = new JButton("로그 아웃");
		Outbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Outbtn.setBounds(466, 148, 96, 23);
		panel.add(Outbtn);
		
		frame.setVisible(true);
		frame.setSize(600,800);
		frame.setLocationRelativeTo(null);//화면 가운데
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
