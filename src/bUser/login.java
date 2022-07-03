package bUser;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import swing.*;

public class login {
	
//	JLabel lblImg;
	private JFrame frameAfter;
	private int point;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					logIn window = new logIn();
					// window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public logIn() {
		initialize();
		// getUserInfo();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frameAfter = new JFrame();

		frameAfter.setSize(600, 900);

		APanel pnlAfter = new APanel();

		AButton bntlogOut = new AButton("로그아웃");
		ALabel lblTitle = new ALabel("NFT 경매 시스템");
		ALabel lblWelcome = new ALabel("환영합니다");
		ALabel lblUserID = new ALabel(Basic.userNick + " 님");
		ALabel lblPoint = new ALabel("포인트");
		ALabel lblPoint_1 = new ALabel(Basic.userPoint + "");
		JLabel lblImg = new JLabel(Basic.userIcon);
		frameAfter.setVisible(false);

		pnlAfter.setLayout(null);

		// ***********좌표 설정***************

		lblWelcome.setBounds(450, 10, 110, 22);
		lblUserID.setBounds(450, 32, 110, 22);
		lblImg.setBounds(345, 27, 100, 100);
		bntlogOut.setBounds(450, 107, 110, 20);
		lblTitle.setBounds(12, -10, 336, 155);
		lblPoint.setBounds(450, 54, 110, 22);
		lblPoint_1.setBounds(450, 76, 110, 22);
		// *************폰트*********************
		Font font = new Font("맑은 고딕", Font.ITALIC, 40);
		bntlogOut.setBackground(Color.LIGHT_GRAY);
		lblTitle.setFont(new Font("맑은 고딕", Font.ITALIC, 40));

		// ***********add*******************
		frameAfter.getContentPane().add(pnlAfter);
		pnlAfter.add(lblTitle);
		pnlAfter.add(bntlogOut);
		pnlAfter.add(lblWelcome);
		pnlAfter.add(lblUserID);
		pnlAfter.add(lblImg);
		pnlAfter.add(lblPoint);
		pnlAfter.add(lblPoint_1);

		// ************기능********************
		bntlogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frameAfter.setVisible(false);
				Basic.userNo = "";
				Basic.userID = "";
				Basic.userNick = "";
				Basic.userPoint = 0;
				Basic.userIcon = null;
				Basic.userBirth = "";
				Basic.userPw = "";
				new Basic().setVisible(true);
			}
		});

	}

	public void setVisible(boolean b) {
		frameAfter.setVisible(b);
	}

}
