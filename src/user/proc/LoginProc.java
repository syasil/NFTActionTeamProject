package user.proc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import db.DB;
import functions.ResizeImage;
import functions.SlidingAnimate;
import main.Main;
import user.UserJoin;
import user.UserLogin;

public class LoginProc implements ActionListener {
	private UserLogin pnl;
	
	public LoginProc(UserLogin pnl) {
		this.pnl =  pnl;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		//////////////////////////////////
		// 입력값 체크
		//////////////////////////////////
		if (pnl.txtUserID.getText().equals("")) {
			JOptionPane.showMessageDialog(pnl.getParent(), "아이디를 입력해 주세요.");
			pnl.txtUserID.requestFocus();
			return;
		}
		
		String userPW = new String(pnl.txtUserPW.getPassword());
		if (userPW.equals("")) {
			JOptionPane.showMessageDialog(pnl.getParent(), "비밀번호를 입력해 주세요.");
			pnl.txtUserPW.requestFocus();
			return;
		}


		//////////////////////////////////
		// 회원 로그인
		//////////////////////////////////
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select user_id, user_pass, user_nick from users where user_id = ? ";

			conn = DB.get(); // DB연결
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, pnl.txtUserID.getText());
			rs = psmt.executeQuery();
			
			if (rs.next()) {
				String strUserID = rs.getString("user_id");
				String strUserPW = rs.getString("user_pass");
				String strUserNick = rs.getString("user_nick");
				
				if (!strUserPW.equals(new String(pnl.txtUserPW.getPassword()))) {
					JOptionPane.showMessageDialog(pnl.getParent(), "비밀번호를 확인해 주세요.");
				} else {
					// 로그인 성공
					Main.USER_ID = strUserID;
					Main.USER_NICKNAME = strUserNick;
					pnl.setVisible(false);
					
					pnl.txtUserID.setText("");
					pnl.txtUserPW.setText("");
				}

			} else {
				JOptionPane.showMessageDialog(pnl.getParent(), "아이디를 확인해 주세요.");
				pnl.txtUserID.requestFocus();
			}
			
			psmt.close();
			rs.close();
			conn.close();
		} catch (Exception err) {
			err.printStackTrace();
			JOptionPane.showMessageDialog(pnl.getParent(), "로그인에 실패했습니다.");
		}
	}
}
