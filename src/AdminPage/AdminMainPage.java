package AdminPage;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Line2D;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DBConnection.GetData;
import DBConnection.JdbcUtil;
import swing.AButton;
import swing.ALabel;
import swing.APanel;
import swing.AScrollPane;
import swing.ATable;
import swing.ATextField;

public class AdminMainPage extends JFrame {

	static JdbcUtil dbConn = new JdbcUtil();
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	
	// 데이터 가져오기
	GetData getData = new GetData();
	String inUserId = null;

	// 관리자 로그인 후 보여지는 화면
	public AdminMainPage() {
		Container c = getContentPane();
		c.setLayout(null);
		c.setBackground(new Color(252, 250, 255));

		// 타이틀 텍스트 영역
		AButton btn_logout = new AButton("로그아웃");
		btn_logout.setBounds(400, 35, 120, 25);
		c.add(btn_logout);

		ALabel jlTitel = new ALabel("관리자로 로그인 되었습니다");
		jlTitel.setBounds(310, 70, 400, 20);
		c.add(jlTitel);
		
		// 로그아웃 버튼 이벤트 설정
		btn_logout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});		

		String todayAucCnt = getData.getTodayAUC();
		String todayAucPrice = getData.getTodayAucPrice();

		// 1.오늘 진행된 경매 건수 데이터
		ALabel jlAucCnt = new ALabel("오늘 진행된 경매 : " + todayAucCnt + "건");
		jlAucCnt.setBounds(50, 130, 200, 20);
		jlAucCnt.setCursor(new Cursor(Cursor.HAND_CURSOR));
		c.add(jlAucCnt);
		// 경매 금액 표시
		ALabel jlAucPrice = new ALabel("오늘 거래금액 : " + todayAucPrice + "원");
		jlAucPrice.setBounds(290, 130, 220, 20);
		c.add(jlAucPrice);
		
		// 화면 중간 데이터 보여주는 영역
		// 1.경매건수 - 경매내역 리스트
		JPanel jPAucCnt = new JPanel();
		jPAucCnt.setBounds(50, 200, 470, 320);
		jPAucCnt.setVisible(true);
		c.add(jPAucCnt);

		// 테이블 생성 1
		//1.경매건수 - 오늘 진행된 경매 리스트 출력 
		DefaultTableModel modelAuc = new DefaultTableModel(new String[] { "경매번호", "그림번호", "그림명", "낙찰자id" }, 0);
		ATable aucListTable = new ATable(modelAuc);
		
		// 각 셀 사이즈 설정
		aucListTable.getColumn("경매번호").setPreferredWidth(60);
		aucListTable.getColumn("그림번호").setPreferredWidth(60);
		aucListTable.getColumn("그림명").setPreferredWidth(200);
		aucListTable.getColumn("낙찰자id").setPreferredWidth(150);

		AScrollPane scrollPaneAuc = new AScrollPane(aucListTable);
		scrollPaneAuc.setPreferredSize(new Dimension(470, 310));
		jPAucCnt.add(scrollPaneAuc);

		try {
			String que = "SELECT A.AUC_NO, A.PRO_NO, P.PRO_NAME, U.USER_ID "
					+ "FROM T_AUCTION A, T_USER U, T_PRODUCT P "
					+ "WHERE A.USER_NO = U.USER_NO  AND A.PRO_NO = P.PRO_NO";

			conn = dbConn.getConnection();
			psmt = conn.prepareStatement(que);
			rs = psmt.executeQuery();

			while (rs.next()) {
				String aucNo = rs.getString(1);
				String proNo = rs.getString(2);
				String proName = rs.getString(3);
				String userId = rs.getString(4);

				String[] auclist = { aucNo, proNo, proName, userId};
				modelAuc.addRow(auclist);
			}
			rs.close(); psmt.close(); conn.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		// 테이블 생성 1 끝
		
		
		// 2.사용자 경매내역 검색 영역
		ALabel jlUserAuc = new ALabel("회원의 경매내역검색 : ");
		ATextField jtUserAuc = new ATextField();
		AButton jbUserAuc = new AButton("검색");
		
		jlUserAuc.setBounds(50, 165, 170, 20);
		jtUserAuc.setBounds(240, 163, 150, 28);
		jbUserAuc.setBounds(410, 165, 90, 25);
		jbUserAuc.setCursor(new Cursor(Cursor.HAND_CURSOR));
		c.add(jlUserAuc);
		c.add(jtUserAuc);
		c.add(jbUserAuc);

		// 2.회원별 경매내역 - 아이디 검색으로 그 사람의 경매내역을 불러옴
		JPanel jPAucPrice = new JPanel();
		jPAucPrice.setBounds(50, 200, 470, 320);
		jPAucPrice.setVisible(false);
		c.add(jPAucPrice);
		
		
		
		DefaultTableModel modelUserAuc = new DefaultTableModel(
				new String[] { "NO.", "낙찰회원ID", "그림명", "낙찰가격", "경매종료시간"}, 0);
		ATable userAucTable = new ATable(modelUserAuc);
		// 각 셀 사이즈 설정
		userAucTable.getColumn("NO.").setPreferredWidth(30);
		userAucTable.getColumn("낙찰회원ID").setPreferredWidth(80);
		userAucTable.getColumn("그림명").setPreferredWidth(200);
		userAucTable.getColumn("낙찰가격").setPreferredWidth(60);
		userAucTable.getColumn("경매종료시간").setPreferredWidth(100);

		AScrollPane scrollPaneUserAuc = new AScrollPane(userAucTable);
		scrollPaneUserAuc.setPreferredSize(new Dimension(470, 310));
		jPAucPrice.add(scrollPaneUserAuc);
		
		
		// 경매[검색] 버튼 이벤트
		jbUserAuc.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				inUserId = jtUserAuc.getText();
				
				modelUserAuc.setNumRows(0);
						
				//테이블2 생성부분 이동
				// 테이블 생성 2 - 회원별 경매내역 검색 출력
				//2. 회원아이디로 검색 -> 프로시저 PRO_USER_AUC_LIST 호출
				//경매번호, p.그림명, 낙찰가, 경매종료시간
				try {

					//db연결
					conn = dbConn.getConnection();
					//프로시저 호출
					CallableStatement cs = conn.prepareCall("begin pro_user_auc_list(?,?); end;");
					
					//입력 파라메터
					cs.setString(2, "%"+inUserId+"%");
					// 출력 파라메터
					cs.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
					
					// 실행
					cs.execute();
					rs = (ResultSet)cs.getObject(1);

					while (rs.next()) {
						String aucNo = rs.getString(1);
						String userID = rs.getString(2);
						String proName = rs.getString(3);
						String auc_LPrice = rs.getString(4);
						String endDate = rs.getString(5);

						String[] userAuclist = { aucNo, userID, proName, auc_LPrice, endDate};
						
						modelUserAuc.addRow(userAuclist);
					}
					rs.close(); psmt.close(); conn.close();

				} catch (Exception e1) {
					System.out.println(e1.getMessage());
				}
				// 테이블 생성 2 끝
				
			}
		});
		jbUserAuc.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				jPAucCnt.setVisible(false);
				jPAucPrice.setVisible(true);
			}
		});
		c.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				jPAucCnt.setVisible(true);
				jPAucPrice.setVisible(false);
			}
		});

		// 상품관리 버튼+텍스트
		ALabel jlPdNotice = new ALabel("등록된 상품을 관리합니다");
		jlPdNotice.setBounds(110, 585, 400, 20);
		c.add(jlPdNotice);

		AButton btn_listPd = new AButton("상품관리");
		btn_listPd.setBounds(400, 585, 120, 25);
		c.add(btn_listPd);

		// 상품관리 버튼 이벤트
		btn_listPd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ListPd();
			}
		});

		// 회원관리 버튼+텍스트
		ALabel jlUserNotice = new ALabel("회원 목록을 조회하고 관리합니다");
		jlUserNotice.setBounds(110, 630, 400, 20);
		c.add(jlUserNotice);

		// 회원관리 버튼 이벤트
		AButton btn_listUser = new AButton("회원관리");
		btn_listUser.setBounds(400, 630, 120, 25);
		c.add(btn_listUser);

		btn_listUser.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ListUser();
			}
		});
		
		
		// 전자지갑관리 버튼+텍스트
		ALabel jlWalletNotice = new ALabel("전자지갑 로그을 조회하고 관리합니다");
		jlWalletNotice.setBounds(110, 675, 400, 20);
		c.add(jlWalletNotice);

		// 회원관리 버튼 이벤트
		AButton btn_listWallet = new AButton("지갑관리");
		btn_listWallet.setBounds(400, 675, 120, 25);
		c.add(btn_listWallet);

		btn_listWallet.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//지갑관리 버튼 클릭 시 발생이벤트 추가 영역
			}
		});
		
		

		// main panel setting
		setLocation(150, 80);
		setSize(600, 800);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	// 선 그리기
	// https://m.blog.naver.com/beronicasun/90155622047
	public void paint(Graphics g) {
		super.paint(g); // fixes the immediate problem.
		Graphics2D g2 = (Graphics2D) g;
		Line2D lin1 = new Line2D.Float(20, 125, 580, 125);
		g2.draw(lin1);
		Line2D lin2 = new Line2D.Float(20, 590, 580, 590);
		g2.draw(lin2);
	}

	public static void main(String[] args) throws SQLException {
		new AdminMainPage();
	}
}
