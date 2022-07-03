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

import swing.CButton;

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
		frame.setTitle("마이페이지");
		JPanel panel=new JPanel();
		panel.setBackground(Color.WHITE);
		String []head=new String[] {"상품코드","경매번호","낙찰가"};
		String [][]data1 =Join.getData();
		panel.setLayout(null);
		JTable tab=new JTable(data1,head);
		tab.setPreferredScrollableViewportSize(new Dimension(300,300));
		tab.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(tab);
		scrollPane.setBounds(31, 230, 387, 205);
		panel.add(scrollPane);
		
		
		String []header=new String[] {"상품코드","등록일","가격"};
		String [][]data2 =Mysell.getData();
		JTable table=new JTable(data2,header);
		table.setPreferredScrollableViewportSize(new Dimension(300,300));
		table.setFillsViewportHeight(true);
		JScrollPane scrollPane_1 = new JScrollPane(table);
		scrollPane_1.setBounds(31, 529, 387, 221);
		panel.add(scrollPane_1);
		
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("마이 페이지");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		lblNewLabel.setBounds(181, 24, 205, 64);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("참여한 경매내역");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		lblNewLabel_1.setBounds(31, 176, 172, 44);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("등록한 물품");
		lblNewLabel_1_1.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		lblNewLabel_1_1.setBounds(31, 488, 172, 44);
		panel.add(lblNewLabel_1_1);
		
		CButton Outbtn = new CButton("로그 아웃");
		Outbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
//				
			}
		});
		Outbtn.setBounds(449, 24, 111, 33);
		panel.add(Outbtn);
		
		JLabel lblNewLabel_2 = new JLabel("Basic.userIcon");
		lblNewLabel_2.setBounds(31, 24, 148, 125);
		panel.add(lblNewLabel_2);
		
		frame.setVisible(true);
		frame.setSize(600,900);
		frame.setLocationRelativeTo(null);//화면 가운데
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
