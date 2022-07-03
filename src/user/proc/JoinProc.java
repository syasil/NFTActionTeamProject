package user.proc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import Database.DatabaseLinker;
import db.DB;
import functions.ResizeImage;
import functions.SlidingAnimate;
import main.Main;
import user.UserJoin;
import user.UserJoinWelcome;

public class JoinProc implements ActionListener {
	private UserJoin pnl;
	
	public JoinProc(UserJoin pnl) {
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
		
		String userPW_Re = new String(pnl.txtUserPW_Re.getPassword());
		if (!userPW.equals(userPW_Re)) {
			JOptionPane.showMessageDialog(pnl.getParent(), "비밀번호를 확인해 주세요.");
			pnl.txtUserPW_Re.requestFocus();
			return;
		}

		if (pnl.txtUserBirth.getText().equals("")) {
			JOptionPane.showMessageDialog(pnl.getParent(), "생년월일을 입력해 주세요.");
			pnl.txtUserBirth.requestFocus();
			return;
		}

		if (pnl.txtUserNickname.getText().equals("")) {
			JOptionPane.showMessageDialog(pnl.getParent(), "닉네임을 입력해 주세요.");
			pnl.txtUserNickname.requestFocus();
			return;
		}
		
		if (pnl.txtUserWallet.getText().equals("")) {
			JOptionPane.showMessageDialog(pnl.getParent(), "전자지갑 번호를 입력해 주세요.");
			pnl.txtUserWallet.requestFocus();
			return;
		}
		
		ExecuteUpdate();
	}
	
	private void ExecuteUpdate() {

		//////////////////////////////////
		// 쿼리 실행
		//////////////////////////////////
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			String sql = "INSERT INTO T_USER (USER_NO, USER_ID, USER_PASS, USER_BIR, USER_NICK, USER_WALLET, USER_ICON, USER_CREDAY)"
				+ " VALUES (SEQ_T_USER_NO.NEXTVAL, ?, ?, ?, ?, ?, ?, SYSDATE)";

			//conn = DB.get(); // DB연결
			conn = DatabaseLinker.getInstance().connectDB();
			
			
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, pnl.txtUserID.getText());
			psmt.setString(2, new String(pnl.txtUserPW.getPassword()));
			psmt.setString(3, pnl.txtUserBirth.getText());
			psmt.setString(4, pnl.txtUserNickname.getText());
			psmt.setString(5, pnl.txtUserWallet.getText());

			if (pnl.selectedFile != null) {
				FileInputStream fis = new FileInputStream(pnl.selectedFile);
				psmt.setBinaryStream(6, fis, (int)pnl.selectedFile.length());
			} else {
				psmt.setBinaryStream(6, null);
			}
			
			int result = psmt.executeUpdate();
			
			if(result > 0){
				// 회원가입 성공 로그인 처리
				pnl.setVisible(false);
				Main.USER_ID = pnl.txtUserID.getText();
				Main.USER_NICKNAME = pnl.txtUserNickname.getText();
				
				// 상단 버튼 바꾸기
				Main.pnlTop.btnLogin.setVisible(false);
				Main.pnlTop.btnJoin.setVisible(false);
				Main.pnlTop.btnLogout.setVisible(true);

				Main.btnAddProduct.setVisible(true);

				pnl.txtUserID.setText("");
				pnl.txtUserPW.setText("");
				pnl.txtUserPW_Re.setText("");
				pnl.txtUserNickname.setText("");
				pnl.txtUserWallet.setText("");
				pnl.btnProfile.setImage(ResizeImage.resize("images/profile.jpg", 130, 130));
				
				UserJoinWelcome pnlWelcome = new UserJoinWelcome();
				Main.pane.add(pnlWelcome, new Integer(40));
				new SlidingAnimate(pnlWelcome, "DOWN").start();
				
			}else
			{
				JOptionPane.showMessageDialog(pnl.getParent(), "회원가입에 실패했습니다.");
			}
			
			psmt.close();
			conn.close();
		} catch (Exception err) {
			err.printStackTrace();
			JOptionPane.showMessageDialog(pnl.getParent(), "회원가입에 실패했습니다.");
		}
	}

}
