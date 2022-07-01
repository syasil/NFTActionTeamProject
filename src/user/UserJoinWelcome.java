package user;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.imageio.ImageIO;
import javax.swing.*;

import db.DB;
import functions.ResizeImage;
import functions.SlidingAnimate;
import main.Main;
import swing.*;

public class UserJoinWelcome extends CPanel {
	private CPanel instance;
	
	private CImageButton pnlProfileImg;
	private CLabel lblNick;

	public UserJoinWelcome() {
		super(30);
		this.instance = this;
		initComponents();
		getUserInfo();
	}

	private void initComponents() {

		/////////////////////////
		// 패널 기본 설정
		/////////////////////////
		setLayout(null);
		setBackground(Color.decode("#1A1A25"));
		setBounds(100, (900 - 355) / 2, 400, 355);

		//////////////////////////////////
		// 패널 닫기
		//////////////////////////////////
		CLabel lblClose = new CLabel("×", 40);
		lblClose.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblClose.setBounds(358, 12, 30, 30);
		lblClose.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				instance.setVisible(false);
			}
		});
		add(lblClose);

		//////////////////////////////////
		// 타이틀
		//////////////////////////////////
		CLabel lblTitle = new CLabel("가입완료", 28);
		lblTitle.setBounds(25, 26, 321, 50);
		add(lblTitle);

		//////////////////////////////////
		// 프로필 이미지
		//////////////////////////////////
		ImageIcon img = ResizeImage.resize("images/profile.jpg", 150, 150);
		pnlProfileImg = new CImageButton(img, 150);
		pnlProfileImg.setBounds(128, 86, 150, 150);
		add(pnlProfileImg);

		//////////////////////////////////
		// 환영 메시지
		//////////////////////////////////
		lblNick = new CLabel("님 환영합니다.");
		lblNick.setHorizontalAlignment(SwingConstants.CENTER);
		lblNick.setBounds(25, 268, 352, 30);
		add(lblNick);

		CLabel lblMsg = new CLabel("회원가입이 완료되었습니다.");
		lblMsg.setHorizontalAlignment(SwingConstants.CENTER);
		lblMsg.setBounds(25, 296, 352, 30);
		add(lblMsg);
	}

	private void getUserInfo() {
		//////////////////////////////////
		// 회원 로그인
		//////////////////////////////////
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {
			conn = DB.get();
			psmt = conn.prepareStatement("select user_nick, user_icon from users where user_id = ? ");
			psmt.setString(1, Main.USER_ID);
			rs = psmt.executeQuery();
			
			if (rs.next()) {
				String strUserNick = rs.getString("user_nick");
				lblNick.setText(strUserNick + "님 환영합니다.");

				Blob blob = rs.getBlob("user_icon");
				if (blob != null) {
					BufferedImage imgByte = ImageIO.read(blob.getBinaryStream(1, blob.length()));
					pnlProfileImg.setImage(ResizeImage.resize(imgByte, 150, 150));
				}
			}
			
			psmt.close();
			rs.close();
			conn.close();
		} catch (Exception err) {
			err.printStackTrace();
		}
	}

	public static void main(String args[]) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Main().setVisible(true);
			}
		});
	}
}
