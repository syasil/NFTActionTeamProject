package sample;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import functions.ResizeImage;
import swing.CLabel;
import swing.CPanel;
import swing.CScrollPane;

public class PanelList extends JFrame {


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelList frame = new PanelList();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PanelList() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		getRootPane().setPreferredSize(new Dimension(360, 400));
		pack();
		setLocationRelativeTo(null);

		CPanel panel = new CPanel();
		panel.setBorder(null);

		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		for (int i = 0; i < 10; i++) {
			CPanel pnlProduct = new CPanel();
			pnlProduct.setLayout(null);
			pnlProduct.setPreferredSize(new Dimension(panel.getWidth(), 60));

			String imageFile = "";
			switch(i % 3) {
				case 1 : imageFile = "images/sample1.jpg"; break;
				case 2 : imageFile = "images/sample2.jpg"; break;
				default :  imageFile = "images/sample3.png";
			}
			 
			ImageIcon img = ResizeImage.resize(imageFile, 50, 50);
			CPanel pnlImage = new CPanel(img, 10);
			pnlImage.setBounds(10, 10, 50, 50);
			CLabel lbl1 = new CLabel("안녕하세요" + i);
			CLabel lbl2 = new CLabel("반가워요.. 제목을 넣어요" + i);
			lbl2.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
			lbl2.setForeground(Color.LIGHT_GRAY);
			lbl1.setBounds(70, 15, 200, 20);
			lbl2.setBounds(70, 37, 200, 20);
			
			pnlProduct.add(pnlImage);
			pnlProduct.add(lbl1);
			pnlProduct.add(lbl2);
			
			panel.add(pnlProduct);
		}

		CScrollPane scrollPane = new CScrollPane(panel);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(0, 0, 434, 261);
		scrollPane.getVerticalScrollBar().setUnitIncrement(20);
		
		
		add(scrollPane);
	}
}
