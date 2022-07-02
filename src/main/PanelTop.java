package main;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import db.DB;
import functions.ResizeImage;
import functions.SlidingAnimate;
import swing.CButton;
import swing.CImageButton;

public class PanelTop extends JPanel {
	public CButton btnLogin;
	public CButton btnJoin;
	public CButton btnLogout;
	public CImageButton btnProfile;
	
	public PanelTop() {
		setLayout(null);
		setBackground(new Color(26, 26, 37));
		setBounds(0, 0, 600, 70);

		btnLogin = new CButton("로그인");
		btnLogin.setBounds(330, 20, 120, 30);
		btnLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.pnlOpaque.setVisible(true);
				Main.pnlJoin.setVisible(false);
				Main.pnlPassword.setVisible(false);

				if (Main.pnlLogin.isVisible() != true) { 
					new SlidingAnimate(Main.pnlLogin, "DOWN").start();
				}
			}
		});
		add(btnLogin);
		
		btnJoin = new CButton("회원가입", "DARK");
		btnJoin.setBounds(460, 20, 120, 30);
		btnJoin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.pnlOpaque.setVisible(true);
				Main.pnlLogin.setVisible(false);
				Main.pnlPassword.setVisible(false);
				
				if (Main.pnlJoin.isVisible() != true) { 
					new SlidingAnimate(Main.pnlJoin, "DOWN").start();
				}
			}
		});
		add(btnJoin);

		btnProfile = new CImageButton(ResizeImage.resize("images/profile.jpg", 50, 50), 50);
		btnProfile.setBounds(20, 10, 50, 50);
		btnProfile.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				if (!Main.USER_ID.equals("")) {
					Connection conn = null;
					PreparedStatement psmt = null;
					ResultSet rs = null;

					try {
						conn = DB.get();
						psmt = conn.prepareStatement("select * from t_user where user_id = ? ");
						psmt.setString(1, Main.USER_ID);
						rs = psmt.executeQuery();
						
						if (rs.next()) {
							Blob blob = rs.getBlob("user_icon");
							BufferedImage imgByte = ImageIO.read(blob.getBinaryStream(1, blob.length()));
							btnProfile.setImage(ResizeImage.resize(imgByte, 50, 50));
						}
						
						rs.close(); 
						psmt.close();
						conn.close();
					} catch (Exception err) {
						err.printStackTrace();
					}
				}
				
			}
		});
		add(btnProfile);
		
		btnLogout = new CButton("로그아웃", "DARK");
		btnLogout.setBounds(460, 20, 120, 30);
		btnLogout.setVisible(false);
		
		btnLogout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Main.USER_ID = "";
				Main.USER_NICKNAME = "";
				
				// 상단 버튼 바꾸기
				Main.pnlTop.btnLogin.setVisible(true);
				Main.pnlTop.btnJoin.setVisible(true);
				Main.pnlTop.btnLogout.setVisible(false);

				Main.btnAddProduct.setVisible(false);
			}
		});
		
		add(btnLogout);
	}
}
