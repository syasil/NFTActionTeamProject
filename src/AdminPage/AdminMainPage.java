package AdminPage;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
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
	AdminMainPage(){
		//부모 컨테이너 생성, 컨테이너 레이아웃 설정
		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		//타이틀 텍스트 영역
		JLabel jlTitel = new JLabel("관리자로 로그인 되었습니다.");
		
		//보여줄 목록 생성
		ListPanel list1 = new ListPanel("상품목록");
		ListPanel list2 = new ListPanel("회원목록");
		

		//여백설정
		Border emptyBorder = BorderFactory.createEmptyBorder(30,50,30,50);
		jlTitel.setBorder(emptyBorder);
		list1.setBorder(emptyBorder);
		list2.setBorder(emptyBorder);
		
		//add panel
		c.add(jlTitel);
		c.add(list1);
		c.add(list2);
				
		//main panel setting		
		setLocation(400, 200);
		setSize(520, 600);       
		setVisible(true);
//		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new AdminMainPage();
	}
}
