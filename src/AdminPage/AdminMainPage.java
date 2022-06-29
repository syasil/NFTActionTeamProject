package AdminPage;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.sql.SQLException;

import javax.swing.JFrame;

import DBConnection.GetDataTest;
import swing.AButton;
import swing.ALabel;

public class AdminMainPage extends JFrame {
	
	//데이터 가져오기 테스트
	GetDataTest gdt = new GetDataTest();
	String s1 = gdt.todayAuc;
	
	// 관리자 로그인 후 보여지는 화면
	AdminMainPage() {
		Container c = getContentPane();
		c.setLayout(null);
		c.setBackground(new Color(252, 250, 255));

		//타이틀 텍스트 영역
		AButton btn_logout = new AButton("로그아웃");
		btn_logout.setBounds(400, 35, 120, 25);
		c.add(btn_logout);
		
		ALabel jlTitel = new ALabel("관리자로 로그인 되었습니다");
		jlTitel.setBounds(310, 70, 400, 20);
		c.add(jlTitel);
		
		
		//데이터 가져오기 테스트
		GetDataTest getData = new GetDataTest();
		String auctionCnt = getData.todayAuc;
				
		//불러온 텍스트 영역
		ALabel jlTest = new ALabel("오늘 실행된 경매 건수는 총 "+ auctionCnt + "건 입니다.");
		jlTest.setBounds(180, 120, 400, 20);
		c.add(jlTest);
		
		//데이터 가져오기 테스트
		
		
		//상품관리 버튼+텍스트
		ALabel jlPdNotice = new ALabel("등록된 상품을 관리합니다");
		jlPdNotice.setBounds(145, 550, 400, 20);
		c.add(jlPdNotice);
		
		AButton btn_listPd = new AButton("상품관리");
		btn_listPd.setBounds(400, 550, 120, 25);
		c.add(btn_listPd);
		
		//상품관리 버튼 이벤트
		btn_listPd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ListPd();
			}
		});
		
		//회원관리 버튼+텍스트
		ALabel jlUserNotice = new ALabel("회원 목록을 조회하고 관리합니다");
		jlUserNotice.setBounds(145, 600, 400, 20);
		c.add(jlUserNotice);
		
		//회원관리 버튼 이벤트
		AButton btn_listUser = new AButton("회원관리");
		btn_listUser.setBounds(400, 600, 120, 25);
		c.add(btn_listUser);
		
		btn_listUser.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ListUser();
			}
		});
		
				
		//main panel setting
		setLocation(200, 100);
		setSize(600, 800);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//선 그리기
	//https://m.blog.naver.com/beronicasun/90155622047
    public void paint(Graphics g) {
        super.paint(g);  // fixes the immediate problem.
        Graphics2D g2 = (Graphics2D) g;
        Line2D lin1 = new Line2D.Float(20, 125, 580, 125);
        g2.draw(lin1);
        Line2D lin2 = new Line2D.Float(20, 550, 580, 550);
        g2.draw(lin2);
    }
	
	public static void main(String[] args) throws SQLException {
		new AdminMainPage();
	}
}
