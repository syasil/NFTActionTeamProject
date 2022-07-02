package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import swing.CButton;

public class PanelBottom extends JPanel {
	private CButton btnAddProduct;

	public PanelBottom() {
		setLayout(null);
		setBackground(new Color(26, 26, 37, 0));
		setBounds(530, 830, 70, 70);

		CButton btnAddProduct = new CButton("+", "DARK");
		btnAddProduct.setFont(new Font("Arial", Font.BOLD, 32));
		btnAddProduct.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		btnAddProduct.setBounds(0, 0, 65, 65);
		add(btnAddProduct);
	}
}
