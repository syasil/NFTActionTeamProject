package AdminPage;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;

import swing.CButton;
import swing.CLabel;

/**
 * 관리자 로그인 후 보여지는 화면
 * 	1. 관리자로그인, 로그아웃 버튼 생략 (회원 로그인 작업과 동일)
 * 		- 관리자 id로 로그인 시 접근 가능
 * 		- 로그아웃 시 프로젝트 메인 화면으로 이동됨
 * 	2. 등록된 NFT(상품) 목록 출력
 * 		- no, 상품 이름, 상품 설명, 낙찰가(기본값 null), 등록인(int), 등록일시
 * 
 * 
 * @author harteh
 *
 */

public class AdminMainPage extends JFrame {
	
	// 관리자 로그인 후 보여지는 화면
	AdminMainPage() throws SQLException{
		Container c = getContentPane();
		c.setLayout(null);
		c.setBackground(new Color(26, 26, 37));

		//타이틀 텍스트 영역
		CLabel jlTitel = new CLabel("관리자로 로그인 되었습니다");
		jlTitel.setBounds(210, 63, 400, 20);
		c.add(jlTitel);
		
		CButton btn_logout = new CButton("로그아웃");
		btn_logout.setBounds(300, 35, 120, 25);
		c.add(btn_logout);
		
		//상품관리 버튼+텍스트
		CLabel jlPdNotice = new CLabel("등록된 상품을 관리합니다");
		jlPdNotice.setBounds(45, 150, 400, 20);
		c.add(jlPdNotice);
		
		CButton btn_listPd = new CButton("상품관리");
		btn_listPd.setBounds(300, 150, 120, 25);
		c.add(btn_listPd);
		
		//보여줄 목록 생성 -> 버튼으로 대체. 새창으로 띄우기
		btn_listPd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//상품관리 버튼 클릭 시 ListPd 호출 -
				new ListPd();
			}
		});
		
		//회원관리 버튼+텍스트
		CLabel jlUserNotice = new CLabel("회원 목록을 조회하고 관리합니다");
		jlUserNotice.setBounds(45, 190, 400, 20);
		c.add(jlUserNotice);
		
		CButton btn_listUser = new CButton("회원관리");
		btn_listUser.setBounds(300, 190, 120, 25);
		c.add(btn_listUser);
		
		//보여줄 목록 생성 -> 버튼으로 대체. 새창으로 띄우기
		btn_listUser.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ListPd();
			}
		});
		
		
				
		//main panel setting
		
		setLocation(200, 100);
		setSize(450, 500);
		setVisible(true);
//		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) throws SQLException {
		new AdminMainPage();
	}
}
