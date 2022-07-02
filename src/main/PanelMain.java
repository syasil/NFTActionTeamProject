package main;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import functions.ResizeImage;
import swing.CLabel;
import swing.CPanel;

public class PanelMain  extends CPanel {
	
	private CLabel lblRemainText;
	private CLabel lblRemainTime;
	
	// 카운트 다운 시계
	//private Countdown cd;
	
	public PanelMain() {
		super("images/bg.jpg");
		initComponents();
	}
	
	private void initComponents() {
		setLayout(null);
		setBounds(0, 0, 600, 900);
	
		CLabel lblTitle = new CLabel("라이브 아트");
		lblTitle.setBounds(10, 10, 500, 50);
		lblTitle.setFont(new Font("맑은 고딕", Font.BOLD, 36));

		CLabel lblAuthor = new CLabel("Team#3");
		lblAuthor.setBounds(15, 60, 500, 20);
		lblAuthor.setForeground(Color.LIGHT_GRAY);
		
		ImageIcon img = ResizeImage.resize("images/sample2.jpg", 500, 500);
		CPanel pnlAuction = new CPanel(img, 20);
		pnlAuction.setLayout(null);
		pnlAuction.setBounds(50, 120, 500, 500);
		
		pnlAuction.add(lblTitle);
		pnlAuction.add(lblAuthor);
		
		lblRemainText = new CLabel("Auction end in");
		lblRemainText.setBounds(50, 630, 500, 30);
		lblRemainText.setHorizontalAlignment(JLabel.RIGHT);
		
		lblRemainTime = new CLabel("0h 0m 0s");
		lblRemainTime.setBounds(50, 660, 500, 30);
		lblRemainTime.setFont(new Font("Helvetica", Font.BOLD, 32));
		lblRemainTime.setForeground(new Color(197, 38, 157));
		lblRemainTime.setHorizontalAlignment(JLabel.RIGHT);
		
		add(pnlAuction);
		add(lblRemainText);
		add(lblRemainTime);
		/*
		if(cd != null) cd.stopCountdown();
		cd = new Countdown(lblRemainTime, 500); // 쓰레드객체생성
		cd.start(); // 쓰레드실행
		*/
	}
}
