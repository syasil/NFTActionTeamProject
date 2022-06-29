package AdminPage;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;

import DBConnection.GetDataTest;
import swing.CButton;
import swing.CLabel;

public class AdminMainPage extends JFrame {
	
	//데이터 가져오기 테스트
	GetDataTest gdt = new GetDataTest();
	String s1 = gdt.todayAuc;
	
	// 관리자 로그인 후 보여지는 화면
	AdminMainPage() throws SQLException{
		Container c = getContentPane();
		c.setLayout(null);
		c.setBackground(new Color(26, 26, 37));

		//타이틀 텍스트 영역
		CButton btn_logout = new CButton("로그아웃");
		btn_logout.setBounds(400, 35, 120, 25);
		c.add(btn_logout);
		
		CLabel jlTitel = new CLabel("관리자로 로그인 되었습니다");
		jlTitel.setBounds(310, 70, 400, 20);
		c.add(jlTitel);
		
		
		//데이터 가져오기 테스트
		GetDataTest getData = new GetDataTest();
		String auctionCnt = getData.todayAuc;
				
		//불러온 텍스트 영역
		CLabel jlTest = new CLabel("오늘 실행된 경매 건수는 총 "+ auctionCnt + "건 입니다.");
		jlTest.setBounds(180, 120, 400, 20);
		c.add(jlTest);
		
		//데이터 가져오기 테스트
		
		
		
		
		
		
		//상품관리 버튼+텍스트
		CLabel jlPdNotice = new CLabel("등록된 상품을 관리합니다");
		jlPdNotice.setBounds(145, 300, 400, 20);
		c.add(jlPdNotice);
		
		CButton btn_listPd = new CButton("상품관리");
		btn_listPd.setBounds(400, 300, 120, 25);
		c.add(btn_listPd);
		
		//상품관리 버튼 이벤트
		btn_listPd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ListPd();
			}
		});
		
		//회원관리 버튼+텍스트
		CLabel jlUserNotice = new CLabel("회원 목록을 조회하고 관리합니다");
		jlUserNotice.setBounds(145, 340, 400, 20);
		c.add(jlUserNotice);
		
		//회원관리 버튼 이벤트
		CButton btn_listUser = new CButton("회원관리");
		btn_listUser.setBounds(400, 340, 120, 25);
		c.add(btn_listUser);
		
		btn_listUser.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ListUser();
			}
		});
		
		
		
				
		//main panel setting
		setLocation(200, 100);
//		setSize(450, 500);
		setSize(600, 900);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) throws SQLException {
		new AdminMainPage();
	}
}
