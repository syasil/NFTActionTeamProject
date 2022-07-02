package main;

import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import admin.AdminMain;
import server.ServerMain;
import swing.CButton;

public class Launcher {

	private JFrame frame;
	private ServerMain serverMain;
	private AdminMain adminMain;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Launcher window = new Launcher();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Launcher() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setTitle("런처");
		frame.setBounds(50, 50, 210, 175);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = frame.getContentPane();
		c.setLayout(null);
		c.setBackground(Color.decode("#1A1A25"));


		/////////////////////////
		// 관리자 버튼
		/////////////////////////
		CButton btnADmin = new CButton("Admin", "DARK");
		btnADmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (adminMain == null) {
					adminMain = new AdminMain();
				}
				
				adminMain.setVisible(true);
			}
		});
		btnADmin.setBounds(12, 10, 170, 51);
		c.add(btnADmin);
		

		/////////////////////////
		// 사용자 버튼
		/////////////////////////
		CButton btnClient = new CButton("Client", "DARK");
		btnClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 클라이언트는 여러번 새창 가능
				new Main().setVisible(true);
			}
		});
		btnClient.setBounds(12, 71, 170, 51);
		c.add(btnClient);
	}
}
