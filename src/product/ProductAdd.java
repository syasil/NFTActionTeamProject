package product;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import functions.ResizeImage;
import main.Main;
import swing.CButton;
import swing.CImageButton;
import swing.CLabel;
import swing.CPanel;
import swing.CPasswordField;
import swing.CTextField;
import user.proc.JoinProc;

public class ProductAdd extends CPanel {
	private ProductAdd instance;
	
	public CTextField txtUserID;
	public CPasswordField txtUserPW;
	public CTextField txtUserBirth;
	public File selectedFile;
	public CImageButton btnProfile;

	public ProductAdd() {
		super(30);
		this.instance = this;
		initComponents();
	}
	
	private void initComponents() {

		/////////////////////////
		// 패널 기본 설정
		/////////////////////////
		setBounds(100, 0, 400, 662);
		setVisible(false);

		
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

		
		/////////////////////////
		// 타이틀
		/////////////////////////
		CLabel lblTitle = new CLabel("상품등록", 28);
		lblTitle.setBounds(25, 26, 174, 50);
		add(lblTitle);


		/////////////////////////
		// 아이디
		/////////////////////////
		CLabel lblID = new CLabel("아이디 (이메일)");
		lblID.setText("상품명");
		lblID.setBounds(25, 325, 347, 30);
		add(lblID);
		
		txtUserID = new CTextField();
		txtUserID.setBounds(25, 361, 347, 40);
		add(txtUserID);


		/////////////////////////
		// 비밀번호, 비밀번호 확인
		/////////////////////////
		CLabel lblPW = new CLabel("비밀번호");
		lblPW.setText("상품 가격");
		lblPW.setBounds(25, 411, 174, 30);
		add(lblPW);
		
		txtUserPW = new CPasswordField();
		txtUserPW.setBounds(25, 441, 347, 40);
		add(txtUserPW);

		
		/////////////////////////
		// 생년월일
		/////////////////////////
		CLabel lblBirthday = new CLabel("생년월일");
		lblBirthday.setText("상품 설명");
		lblBirthday.setBounds(25, 491, 92, 30);
		add(lblBirthday);
		
		txtUserBirth = new CTextField();
		txtUserBirth.setBounds(25, 531, 347, 40);
		add(txtUserBirth);

		
		//////////////////////////////////
		// 프로필 사진
		//////////////////////////////////
		CLabel lblProfilePic = new CLabel("프로필 사진");
		lblProfilePic.setText("상품 이미지");
		lblProfilePic.setBounds(153, 306, 92, 30);
		add(lblProfilePic);
		
		btnProfile = new CImageButton(ResizeImage.resize("images/profile.jpg", 130, 130), 130);
		btnProfile.setBounds(95, 86, 210, 210);
		
		btnProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser fileChooser = new JFileChooser();
				FileFilter imageFilter = new FileNameExtensionFilter("이미지 파일", ImageIO.getReaderFileSuffixes());
				fileChooser.setFileFilter(imageFilter);
				fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				int result = fileChooser.showOpenDialog(getParent());
				
				if (result == JFileChooser.APPROVE_OPTION) {
					//선택한 파일의 경로 반환
					selectedFile = fileChooser.getSelectedFile();
					
					ImageIcon imgFile = ResizeImage.resize(selectedFile.toString(), 130, 130); 
					btnProfile.setImage(imgFile);
				}
			}
		});
		add(btnProfile);

		
		//////////////////////////////////
		// 가입하기 버튼
		//////////////////////////////////
		CButton btnJoin = new CButton("가입하기");
		btnJoin.setText("등록하기");
		btnJoin.setBounds(25, 594, 347, 40);
		//btnJoin.addActionListener(new JoinProc(instance));
		add(btnJoin);
	}
	
	public static void main(String args[]) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Main().setVisible(true);
			}
		});
	}
}
