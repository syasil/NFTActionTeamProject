package wook;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import dbBasic.Db;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField Nametxtf;
	private JTextField Datetxtf;
	private JTextField txtf_img;
	public static FileInputStream fis=null;
	public static File file=null;
	private JButton Selectbtn;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Register() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("상품명");
		lblNewLabel.setBounds(90, 75, 50, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("등록일시");
		lblNewLabel_1.setBounds(90, 111, 50, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel img_lbl = new JLabel("");
		img_lbl.setBounds(182, 218, 161, 122);
		contentPane.add(img_lbl);
		
		Nametxtf = new JTextField();
		Nametxtf.setBounds(182, 72, 96, 21);
		contentPane.add(Nametxtf);
		Nametxtf.setColumns(10);
		
		Datetxtf = new JTextField(10);
		Datetxtf.setColumns(10);
		Datetxtf.setBounds(182, 108, 96, 21);
		contentPane.add(Datetxtf);
		
		JButton Filebtn = new JButton("파일");
		Filebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {	JFileChooser jfc = new JFileChooser();		
				jfc.setFileFilter(new FileNameExtensionFilter("jpg", "png"));	// 파일 필터
				jfc.setMultiSelectionEnabled(false);//다중 선택 불가
				jfc.showOpenDialog(null);				//선택옵션
				
				File f=jfc.getSelectedFile();			//선택한파일 f에 삽입
				String filename=f.getAbsolutePath();	//파일 위치(디렉토리) 가져온다
				txtf_img.setText(filename); 		//텍스트에 저장경로 삽입
				Image getAbsolutePath =null;		//디렉토리 비우기
				ImageIcon icon= new ImageIcon(filename); 	//ImageIcon에 이미지 파일넣기(크기조절위해)
				Image image = icon.getImage().getScaledInstance(130,130 ,Image.SCALE_SMOOTH);		//크기조절 후 이미지에 넣기	  	
				ImageIcon icon2= new ImageIcon(image);		//ImageIcon에 조절된 이지 넣기
				img_lbl.setIcon(icon2);	  	//레이블에 이미지 넣기
				file=new File(txtf_img.getText());
				fis=new FileInputStream(file);
				}catch(Exception e1) {e1.getStackTrace();}
			}
		});
		Filebtn.setBounds(56, 214, 91, 23);
		contentPane.add(Filebtn);
		
		
		
		txtf_img = new JTextField();
		txtf_img.setBounds(56, 256, 96, 21);
		contentPane.add(txtf_img);
		txtf_img.setColumns(10);
		txtf_img.setVisible(false);
		Selectbtn = new JButton("확인");
		Selectbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String url = "jdbc:oracle:thin:@localhost:1521/xe";
			String que = "insert into mysell(pro_no,pro_regday,resurt,sell_icon)values(?,?,'no',?)";
			// ? : 주기적 변경해서 입력할 값
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con = DriverManager.getConnection
						(url, "system", "rhdkfk1351");
				
				pstmt = con.prepareStatement(que);
				pstmt.setString(1, Nametxtf.getText());
				pstmt.setString(2, Datetxtf.getText());
				pstmt.setBinaryStream(3, fis, (int) file.length());
				int n = pstmt.executeUpdate();
				System.out.println(n > 0 ? "성공" : "실패");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			String resultStr = null;
			}
			class Mysell {
				public String[][] getData() {
					Connection conn = null; // DB와 연결하는 인터페이스
					PreparedStatement psmt = null; // sql문 객체
					ResultSet rs = null; // sql에 대한 반환(쿼리 실행에 대한 결과값 저장)
					try {
						conn = Db.get();
//					   String que="select * from sp";
//					   conn=Db.get(); //DB연결
//					   psmt=conn.prepareStatement(que);
//					   rs=psmt.executeQuery();
						CallableStatement cs = conn.prepareCall("begin T_PROC_AUCTION_JOIN(?); end;");
						cs.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
						cs.execute();
						rs = (ResultSet) cs.getObject(1);

						ArrayList<String[]> ar = new ArrayList<>();
						while (rs.next()) {
							ar.add(new String[] { rs.getString(1), rs.getString(2), rs.getString(3) });
						}
						System.out.println("성공");
						return ar.toArray(new String[ar.size()][3]);
//					   String[][] arr = new String[ar.size()][3];
//					   return ar.toArray(arr);
					} catch (Exception e) {
						e.printStackTrace();
						System.out.println("실패");
						return null;
					}
//					rs.close();
//					psmt.close();
//					conn.close();
				}
			}
			
			
		});
		Selectbtn.setBounds(148, 358, 91, 23);
		contentPane.add(Selectbtn);
		setSize(500,600);
		setLocationRelativeTo(null);//화면 가운데
	}
}
