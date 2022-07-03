package bMyPage;

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

import bUser.*;
import swing.*;

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

	public Mypage() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("마이페이지");
		APanel panel=new APanel();
		String []head=new String[] {"상품코드","경매번호","낙찰가"};
		String [][]data1 =Join.getData();
		panel.setLayout(null);
		JTable tab=new JTable(data1,head);
		tab.setPreferredScrollableViewportSize(new Dimension(300,300));
		tab.setFillsViewportHeight(true);
		AScrollPane scrollPane = new AScrollPane(tab);
//		scrollPane.setBounds(31, 230, 387, 205);
		scrollPane.setBounds(50, 230, 460, 200);
		panel.add(scrollPane);
		
		
		String []header=new String[] {"상품코드","등록일","가격"};
		String [][]data2 =Mysell.getData();
		JTable table=new JTable(data2,header);
		table.setPreferredScrollableViewportSize(new Dimension(300,300));
		table.setFillsViewportHeight(true);
		AScrollPane scrollPane_1 = new AScrollPane(table);
		scrollPane_1.setBounds(50, 540, 460, 200);
		panel.add(scrollPane_1);
		
		frame.getContentPane().add(panel);
		
		ALabel lblNewLabel = new ALabel("마이 페이지");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		lblNewLabel.setBounds(181, 60, 205, 64);
		panel.add(lblNewLabel);
		
		ALabel lblNewLabel_1 = new ALabel("참여한 경매내역");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		lblNewLabel_1.setBounds(50, 175, 172, 44);
		panel.add(lblNewLabel_1);
		
		ALabel lblNewLabel_1_1 = new ALabel("등록한 물품");
		lblNewLabel_1_1.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		lblNewLabel_1_1.setBounds(50, 485, 172, 44);
		panel.add(lblNewLabel_1_1);
		
		AButton Outbtn = new AButton("닫기");
		Outbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		Outbtn.setBounds(440, 23, 80, 25);
		panel.add(Outbtn);
		
//		JLabel lblNewLabel_2 = new JLabel(userId);
//		lblNewLabel_2.setBounds(31, 24, 148, 125);
//		panel.add(lblNewLabel_2);
		
		frame.setVisible(true);
		frame.setSize(600,800);
		frame.setLocationRelativeTo(null);//화면 가운데
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}