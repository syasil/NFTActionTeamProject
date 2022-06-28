package AdminPage;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;


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
/*
 * PRODUCT_B 테이블 
  PRODUCT_NUMBER NUMBER(*, 0) NOT NULL PK
, PRODUCT_NAME VARCHAR2(20 BYTE) NOT NULL 
, PRODUCT_DESCRIPTION VARCHAR2(100 BYTE) NOT NULL 
, PRODUCT_PRICE NUMBER 
, PRODUCT_REGISTER_USER NUMBER(*, 0) 
, PRODUCT_REGISTER_DATE DATE NOT NULL 
 */
public class AdminMainPage extends JFrame {
	
	// 관리자 로그인 후 보여지는 화면
	AdminMainPage() throws SQLException{
		Container c = getContentPane();
		c.setLayout(null);

		//타이틀 텍스트 영역
		JLabel jlTitel = new JLabel("관리자로 로그인 되었습니다.");
		jlTitel.setBounds(20, 20, 400, 20);
		c.add(jlTitel);
		
		JButton btn_logout = new JButton("로그아웃");
		btn_logout.setBounds(300, 20, 100, 20);
		c.add(btn_logout);
		
		//상품관리 버튼+텍스트
		JLabel jlPdNotice = new JLabel("등록된 상품을 관리합니다");
		jlPdNotice.setBounds(100, 100, 400, 20);
		c.add(jlPdNotice);
		
		JButton btn_listPd = new JButton("상품관리");
		btn_listPd.setBounds(300, 100, 100, 20);
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
		JLabel jlUserNotice = new JLabel("회원 목록을 조회하고 관리합니다.");
		jlUserNotice.setBounds(100, 130, 400, 20);
		c.add(jlUserNotice);
		
		JButton btn_listUser = new JButton("회원관리");
		btn_listUser.setBounds(300, 130, 100, 20);
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
